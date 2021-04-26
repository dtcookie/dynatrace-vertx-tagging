package dtcookie.io.vertx.core.http;

import java.util.Objects;
import java.util.function.Function;

import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpConnection;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.RequestOptions;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebsocketVersion;
import io.vertx.core.streams.ReadStream;

@SuppressWarnings("deprecation")
public final class HttpClient implements io.vertx.core.http.HttpClient {
	
	public static io.vertx.core.http.HttpClient decorate(io.vertx.core.http.HttpClient client) {
		if (client == null) {
			return null;
		}
		if (client instanceof HttpClient) {
			return client;
		}
		return new HttpClient(client);		
	}
	
	private io.vertx.core.http.HttpClient client = null;
	
	private HttpClient(io.vertx.core.http.HttpClient client) {
		Objects.requireNonNull(client);
		
		this.client = client;
	}

	@Override
	@Deprecated
	public HttpClientRequest get(String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.get(requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest request(HttpMethod method, RequestOptions options) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.request(method, options));
	}

	@Override
	public HttpClientRequest request(HttpMethod method, int port, String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.request(method, port, host, requestURI));
	}

	@Override
	public HttpClientRequest request(HttpMethod method, String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.request(method, host, requestURI));
	}

	@Override
	public HttpClientRequest request(HttpMethod method, RequestOptions options,	Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.request(method, options, handler), handler);
	}

	@Override
	public HttpClientRequest request(HttpMethod method, int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.request(method, port, host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest request(HttpMethod method, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.request(method, host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest request(HttpMethod method, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.request(method, requestURI));
	}

	@Override
	public HttpClientRequest request(HttpMethod method, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.request(method, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest requestAbs(HttpMethod method, String absoluteURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.requestAbs(method, absoluteURI));
	}

	@Override
	public HttpClientRequest requestAbs(HttpMethod method, String absoluteURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.requestAbs(method, absoluteURI, handler), handler);
	}

	@Override
	public HttpClientRequest get(RequestOptions options) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.get(options));
	}

	@Override
	public HttpClientRequest get(int port, String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.get(port, host, requestURI));
	}

	@Override
	public HttpClientRequest get(String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.get(host, requestURI));
	}

	@Override
	public HttpClientRequest get(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.get(options, handler), handler);
	}

	@Override
	public HttpClientRequest get(int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.get(port, host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest get(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.get(host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest get(String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.get(requestURI));
	}

	@Override
	public HttpClientRequest getAbs(String absoluteURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.getAbs(absoluteURI));
	}

	@Override
	public HttpClientRequest getAbs(String absoluteURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.getAbs(absoluteURI, handler), handler);
	}

	@Override
	public io.vertx.core.http.HttpClient getNow(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		return dtcookie.io.vertx.core.http.HttpClient.decorate(client.getNow(options, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public io.vertx.core.http.HttpClient getNow(int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.getNow(port, host, requestURI, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public io.vertx.core.http.HttpClient getNow(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return decorate(client.getNow(host, requestURI, handler));
	}

	@Override
	public io.vertx.core.http.HttpClient getNow(String requestURI, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.getNow(requestURI, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public HttpClientRequest post(RequestOptions options) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.post(options));
	}

	@Override
	public HttpClientRequest post(int port, String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.post(port, host, requestURI));
	}

	@Override
	public HttpClientRequest post(String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.post(host, requestURI));
	}

	@Override
	public HttpClientRequest post(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.post(options, handler), handler);
	}

	@Override
	public HttpClientRequest post(int port, String host, String requestURI,	Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.post(port, host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest post(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.post(host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest post(String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.post(requestURI));
	}

	@Override
	public HttpClientRequest post(String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.post(requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest postAbs(String absoluteURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.postAbs(absoluteURI));
	}

	@Override
	public HttpClientRequest postAbs(String absoluteURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.postAbs(absoluteURI, handler), handler);
	}

	@Override
	public HttpClientRequest head(RequestOptions options) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.head(options));
	}

	@Override
	public HttpClientRequest head(int port, String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.head(port, host, requestURI));
	}

	@Override
	public HttpClientRequest head(String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.head(host, requestURI));
	}

	@Override
	public HttpClientRequest head(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.head(options, handler), handler);
	}

	@Override
	public HttpClientRequest head(int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.head(port, host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest head(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.head(host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest head(String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.head(requestURI));
	}

	@Override
	public HttpClientRequest head(String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.head(requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest headAbs(String absoluteURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.headAbs(absoluteURI));
	}

	@Override
	public HttpClientRequest headAbs(String absoluteURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.headAbs(absoluteURI, handler), handler);
	}

	@Override
	public io.vertx.core.http.HttpClient headNow(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.headNow(options, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public io.vertx.core.http.HttpClient headNow(int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.headNow(port, host, requestURI, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public io.vertx.core.http.HttpClient headNow(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.headNow(host, requestURI, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public io.vertx.core.http.HttpClient headNow(String requestURI, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.headNow(requestURI, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public HttpClientRequest options(RequestOptions options) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.options(options));
	}

	@Override
	public HttpClientRequest options(int port, String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.options(port, host, requestURI));
	}

	@Override
	public HttpClientRequest options(String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.options(host, requestURI));
	}

	@Override
	public HttpClientRequest options(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.options(options, handler), handler);
	}

	@Override
	public HttpClientRequest options(int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.options(port, host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest options(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.options(host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest options(String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.options( requestURI));
	}

	@Override
	public HttpClientRequest options(String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.options(requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest optionsAbs(String absoluteURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.optionsAbs(absoluteURI));
	}

	@Override
	public HttpClientRequest optionsAbs(String absoluteURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.optionsAbs(absoluteURI, handler), handler);
	}

	@Override
	public io.vertx.core.http.HttpClient optionsNow(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.optionsNow(options, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public io.vertx.core.http.HttpClient optionsNow(int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.optionsNow(port, host, requestURI, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public io.vertx.core.http.HttpClient optionsNow(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.optionsNow(host, requestURI, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public io.vertx.core.http.HttpClient optionsNow(String requestURI, Handler<HttpClientResponse> responseHandler) {
		return decorate(client.optionsNow(requestURI, HttpClientResponseHandler.decorate(responseHandler)));
	}

	@Override
	public HttpClientRequest put(RequestOptions options) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.put(options));
	}

	@Override
	public HttpClientRequest put(int port, String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.put(port, host, requestURI));
	}

	@Override
	public HttpClientRequest put(String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.put(host, requestURI));
	}

	@Override
	public HttpClientRequest put(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.put(options, handler), handler);
	}

	@Override
	public HttpClientRequest put(int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.put(port, host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest put(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.put(host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest put(String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.put(requestURI));
	}

	@Override
	public HttpClientRequest put(String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.put(requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest putAbs(String absoluteURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.putAbs(absoluteURI));
	}

	@Override
	public HttpClientRequest putAbs(String absoluteURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.putAbs(absoluteURI, handler), handler);
	}

	@Override
	public HttpClientRequest delete(RequestOptions options) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.delete(options));
	}

	@Override
	public HttpClientRequest delete(int port, String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.delete(port, host, requestURI));
	}

	@Override
	public HttpClientRequest delete(String host, String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.delete(host, requestURI));
	}

	@Override
	public HttpClientRequest delete(RequestOptions options, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.delete(options, handler), handler);
	}

	@Override
	public HttpClientRequest delete(int port, String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.delete(port, host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest delete(String host, String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.delete(host, requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest delete(String requestURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.delete(requestURI));
	}

	@Override
	public HttpClientRequest delete(String requestURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.delete(requestURI, handler), handler);
	}

	@Override
	public HttpClientRequest deleteAbs(String absoluteURI) {
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.deleteAbs(absoluteURI));
	}

	@Override
	public HttpClientRequest deleteAbs(String absoluteURI, Handler<HttpClientResponse> responseHandler) {
		Handler<HttpClientResponse> handler = HttpClientResponseHandler.decorate(responseHandler);
		return dtcookie.io.vertx.core.http.HttpClientRequest.decorate(client.deleteAbs(absoluteURI, handler), handler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(RequestOptions options, Handler<WebSocket> wsConnect) {
		return client.websocket(options, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(int port, String host, String requestURI, Handler<WebSocket> wsConnect) {
		return client.websocket(port, host, requestURI, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(RequestOptions options, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(options, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(int port, String host, String requestURI, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(port, host, requestURI, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String host, String requestURI, Handler<WebSocket> wsConnect) {
		return client.websocket(host, requestURI, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String host, String requestURI, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(host, requestURI, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(RequestOptions options, MultiMap headers, Handler<WebSocket> wsConnect) {
		return client.websocket(options, headers, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(int port, String host, String requestURI, MultiMap headers, Handler<WebSocket> wsConnect) {
		return client.websocket(port, host, requestURI, headers, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(RequestOptions options, MultiMap headers, Handler<WebSocket> wsConnect,	Handler<Throwable> failureHandler) {
		return client.websocket(options, headers, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(int port, String host, String requestURI, MultiMap headers, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(port, host, requestURI, headers, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String host, String requestURI, MultiMap headers, Handler<WebSocket> wsConnect) {
		return client.websocket(host, requestURI, headers, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String host, String requestURI, MultiMap headers, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(host, requestURI, headers, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(RequestOptions options, MultiMap headers, WebsocketVersion version, Handler<WebSocket> wsConnect) {
		return client.websocket(options, headers, version, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version, Handler<WebSocket> wsConnect) {
		return client.websocket(port, host, requestURI, headers, version, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(RequestOptions options, MultiMap headers, WebsocketVersion version,	Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(options, headers, version, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(port, host, requestURI, headers,version, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String host, String requestURI, MultiMap headers, WebsocketVersion version,	Handler<WebSocket> wsConnect) {
		return client.websocket(host, requestURI, headers,version, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String host, String requestURI, MultiMap headers, WebsocketVersion version,	Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(host, requestURI, headers,version, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(RequestOptions options, MultiMap headers, WebsocketVersion version, String subProtocols, Handler<WebSocket> wsConnect) {
		return client.websocket(options, headers, version, subProtocols, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version, String subProtocols, Handler<WebSocket> wsConnect) {
		return client.websocket(port, host, requestURI, headers, version, subProtocols, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocketAbs(String url, MultiMap headers, WebsocketVersion version, String subProtocols,	Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(url, headers, version, subProtocols, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(RequestOptions options, MultiMap headers, WebsocketVersion version, String subProtocols, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(options, headers, version, subProtocols, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version, String subProtocols, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(port, host, requestURI, headers, version, subProtocols, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String host, String requestURI, MultiMap headers, WebsocketVersion version,	String subProtocols, Handler<WebSocket> wsConnect) {
		return client.websocket(host, requestURI, headers, version, subProtocols, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String host, String requestURI, MultiMap headers, WebsocketVersion version, String subProtocols, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(host, requestURI, headers, version, subProtocols, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String requestURI, Handler<WebSocket> wsConnect) {
		return client.websocket(requestURI, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String requestURI, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(requestURI, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String requestURI, MultiMap headers, Handler<WebSocket> wsConnect) {
		return client.websocket(requestURI, headers, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String requestURI, MultiMap headers, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(requestURI, headers, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String requestURI, MultiMap headers, WebsocketVersion version, Handler<WebSocket> wsConnect) {
		return client.websocket(requestURI, headers, version, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String requestURI, MultiMap headers, WebsocketVersion version, Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(requestURI, headers, version, wsConnect, failureHandler);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String requestURI, MultiMap headers, WebsocketVersion version, String subProtocols, Handler<WebSocket> wsConnect) {
		return client.websocket(requestURI, headers, version, subProtocols, wsConnect);
	}

	@Override
	public io.vertx.core.http.HttpClient websocket(String requestURI, MultiMap headers, WebsocketVersion version, String subProtocols,	Handler<WebSocket> wsConnect, Handler<Throwable> failureHandler) {
		return client.websocket(requestURI, headers, version, subProtocols,	wsConnect, failureHandler);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(RequestOptions options) {
		return client.websocketStream(options);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(int port, String host, String requestURI) {
		return client.websocketStream(port, host, requestURI);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(String host, String requestURI) {
		return client.websocketStream(host, requestURI);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(RequestOptions options, MultiMap headers) {
		return client.websocketStream(options, headers);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(int port, String host, String requestURI, MultiMap headers) {
		return client.websocketStream(port, host, requestURI, headers);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(String host, String requestURI, MultiMap headers) {
		return client.websocketStream(host, requestURI, headers);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(RequestOptions options, MultiMap headers, WebsocketVersion version) {
		return client.websocketStream(options, headers, version);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version) {
		return client.websocketStream(port, host, requestURI, headers, version);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(String host, String requestURI, MultiMap headers, WebsocketVersion version) {
		return client.websocketStream(host, requestURI, headers, version);
	}

	@Override
	public ReadStream<WebSocket> websocketStreamAbs(String url, MultiMap headers, WebsocketVersion version, String subProtocols) {
		return client.websocketStreamAbs(url, headers, version, subProtocols);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(RequestOptions options, MultiMap headers, WebsocketVersion version, String subProtocols) {
		return client.websocketStream(options, headers, version, subProtocols);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(int port, String host, String requestURI, MultiMap headers, WebsocketVersion version, String subProtocols) {
		return client.websocketStream(port, host, requestURI, headers, version, subProtocols);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(String host, String requestURI, MultiMap headers, WebsocketVersion version, String subProtocols) {
		return client.websocketStream(host, requestURI, headers, version, subProtocols);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(String requestURI) {
		return client.websocketStream(requestURI);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(String requestURI, MultiMap headers) {
		return client.websocketStream(requestURI, headers);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(String requestURI, MultiMap headers, WebsocketVersion version) {
		return client.websocketStream(requestURI, headers, version);
	}

	@Override
	public ReadStream<WebSocket> websocketStream(String requestURI, MultiMap headers, WebsocketVersion version, String subProtocols) {
		return client.websocketStream(requestURI, headers, version, subProtocols);
	}

	@Override
	public io.vertx.core.http.HttpClient connectionHandler(Handler<HttpConnection> handler) {
		return client.connectionHandler(handler);
	}

	@Override
	public io.vertx.core.http.HttpClient redirectHandler(Function<HttpClientResponse, Future<HttpClientRequest>> handler) {
		return client.redirectHandler(handler);
	}

	@Override
	public Function<HttpClientResponse, Future<HttpClientRequest>> redirectHandler() {
		return client.redirectHandler();
	}

	@Override
	public void close() {
		client.close();
	}

}
