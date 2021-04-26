package dtcookie.io.vertx.ext.web.client;

import java.lang.reflect.Field;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;

import dtcookie.io.vertx.core.http.AsyncResultHandler;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.core.streams.ReadStream;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.ext.web.codec.BodyCodec;
import io.vertx.ext.web.multipart.MultipartForm;

public final class HttpRequest<T> implements io.vertx.ext.web.client.HttpRequest<T> {
	
	private final io.vertx.ext.web.client.HttpRequest<T> request;
	private final AsyncResultHandler<T> responseHandler = new AsyncResultHandler<T>(null);
	
	private HttpRequest(io.vertx.ext.web.client.HttpRequest<T> request) {
		this.request = request;
	}
	
	public static <X> io.vertx.ext.web.client.HttpRequest<X> decorate(io.vertx.ext.web.client.HttpRequest<X> request) {
		if (request instanceof HttpRequest) {
			return request;
		}
		return new HttpRequest<X>(request);
	}
	
	public String getMethod() {
		if (request instanceof io.vertx.ext.web.client.impl.HttpRequestImpl) {
			io.vertx.ext.web.client.impl.HttpRequestImpl<?> httpRequest = (io.vertx.ext.web.client.impl.HttpRequestImpl<?>) request;
			io.vertx.core.http.HttpMethod method = getField(httpRequest, "method");
			if (method != null) {
				return method.name();
			}
		}
		return "GET";
	}
	
	public String getUri() {
		if (request instanceof io.vertx.ext.web.client.impl.HttpRequestImpl) {
			io.vertx.ext.web.client.impl.HttpRequestImpl<?> httpRequest = (io.vertx.ext.web.client.impl.HttpRequestImpl<?>) request;
			String host = getField(httpRequest, "host");
			if (host == null) {
				host = "unknownhost";
			}
			Integer iPort = getField(httpRequest, "port");
			if (iPort == null) {
				iPort = new Integer(80);
			}
			int port = iPort.intValue();
			String uri = getField(httpRequest, "uri");
			if (uri == null) {
				uri = "";
			}
			String protocol = getField(httpRequest, "protocol");
			if (protocol == null) {
				if (port == 80) {
					protocol = "http";	
				} else if (port == 443) {
					protocol = "https";
				}				
			}
			String portPart = ":" + port;
			if ("http".equals(protocol) && port == 80) {
				portPart = "";
			}
			if ("https".equals(protocol) && port == 443) {
				portPart = "";
			}
			return protocol + "://" + host + portPart + uri;
		}
		return "http://unknown:80";
	}
	
	@SuppressWarnings("unchecked")
	private static <T> T getField(Object o, String name) {
		try {
			Field f = field(o.getClass(), name);
			try {
				T result =  (T) f.get(o);
				return result;
			} catch (Throwable t) {
				t.printStackTrace(System.err);
				return null;
			}
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			return null;
		}
	}
	
	private static Field field(Class<?> cls, String name) {
		try {
			Field field = cls.getDeclaredField(name);
			field.setAccessible(true);
			return field;
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}
		return null;
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> method(HttpMethod value) {
		return request.method(value);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> port(int value) {
		return request.port(value);
	}

	@Override
	public <U> io.vertx.ext.web.client.HttpRequest<U> as(BodyCodec<U> responseCodec) {
		return request.as(responseCodec);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> host(String value) {
		return request.host(value);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> virtualHost(String value) {
		return request.virtualHost(value);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> uri(String value) {
		return request.uri(value);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> putHeader(String name, String value) {
		return request.putHeader(name, value);
	}

	@Override
	public MultiMap headers() {
		return request.headers();
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> basicAuthentication(String id, String password) {
		return request.basicAuthentication(id, password);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> basicAuthentication(Buffer id, Buffer password) {
		return request.basicAuthentication(id, password);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> bearerTokenAuthentication(String bearerToken) {
		return request.bearerTokenAuthentication(bearerToken);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> ssl(boolean value) {
		return request.ssl(value);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> timeout(long value) {
		return request.timeout(value);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> addQueryParam(String paramName, String paramValue) {
		return request.addQueryParam(paramName, paramValue);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> setQueryParam(String paramName, String paramValue) {
		return request.setQueryParam(paramName, paramValue);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> followRedirects(boolean value) {
		return request.followRedirects(value);
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> expect(ResponsePredicate predicate) {
		return request.expect(predicate);
	}

	@Override
	public MultiMap queryParams() {
		return request.queryParams();
	}

	@Override
	public io.vertx.ext.web.client.HttpRequest<T> copy() {
		return decorate(request.copy());
	}

	@Override
	public void sendStream(ReadStream<Buffer> body, Handler<AsyncResult<HttpResponse<T>>> handler) {
		AsyncHttpClient.handle(Request.of(this), responseHandler);
		request.sendStream(body, setHandler(handler));
	}

	@Override
	public void sendBuffer(Buffer body, Handler<AsyncResult<HttpResponse<T>>> handler) {
		AsyncHttpClient.handle(Request.of(this), responseHandler);				
		request.sendBuffer(body, setHandler(handler));
	}

	@Override
	public void sendJsonObject(JsonObject body, Handler<AsyncResult<HttpResponse<T>>> handler) {
		AsyncHttpClient.handle(Request.of(this), responseHandler);
		request.sendJsonObject(body, setHandler(handler));
	}

	@Override
	public void sendJson(Object body, Handler<AsyncResult<HttpResponse<T>>> handler) {
		AsyncHttpClient.handle(Request.of(this), responseHandler);
		request.sendJson(body, setHandler(handler));
	}

	@Override
	public void sendForm(MultiMap body, Handler<AsyncResult<HttpResponse<T>>> handler) {
		AsyncHttpClient.handle(Request.of(this), responseHandler);
		request.sendForm(body, setHandler(handler));
	}

	@Override
	public void sendMultipartForm(MultipartForm body, Handler<AsyncResult<HttpResponse<T>>> handler) {
		AsyncHttpClient.handle(Request.of(this), responseHandler);
		request.sendMultipartForm(body, setHandler(handler));
	}

	@Override
	public void send(Handler<AsyncResult<HttpResponse<T>>> handler) {
		AsyncHttpClient.handle(Request.of(this), responseHandler);
		request.send(setHandler(handler));
	}
	
	private Handler<AsyncResult<HttpResponse<T>>> setHandler(Handler<AsyncResult<HttpResponse<T>>> handler) {
		this.responseHandler.set(handler);
		return responseHandler;
	}
	
}
