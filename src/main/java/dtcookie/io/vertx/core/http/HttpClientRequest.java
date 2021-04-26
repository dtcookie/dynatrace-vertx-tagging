package dtcookie.io.vertx.core.http;

import java.util.Objects;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Request;

import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpConnection;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;
import io.vertx.core.http.StreamPriority;

public class HttpClientRequest implements io.vertx.core.http.HttpClientRequest {

	private io.vertx.core.http.HttpClientRequest request;
	private final HttpClientResponseHandler responseHandler = new HttpClientResponseHandler(null);
	
	public static io.vertx.core.http.HttpClientRequest decorate(io.vertx.core.http.HttpClientRequest request) {
		if (request == null) {
			return null;
		}
		if (request instanceof HttpClientRequest) {
			return request;
		}
		return new HttpClientRequest(request);		
	}

	@SuppressWarnings("deprecation")
	public static io.vertx.core.http.HttpClientRequest decorate(io.vertx.core.http.HttpClientRequest request, io.vertx.core.Handler<HttpClientResponse> responseHandler) {
		Objects.requireNonNull(request);
		if (request instanceof HttpClientRequest) {
			return request.handler(responseHandler);
		}
		return new HttpClientRequest(request).handler(responseHandler);		
	}
	
	
	@SuppressWarnings("deprecation")
	private HttpClientRequest(io.vertx.core.http.HttpClientRequest request) {
		this.request = request;
		this.request.handler(responseHandler);
	}

	@Override
	public void end() {
		AsyncHttpClient.handle(Request.of(request), responseHandler);
		request.end();
	}

	@Override
	@Deprecated
	public HttpClientRequest handler(Handler<HttpClientResponse> handler) {
		responseHandler.set(handler);
		return this;
	}
	
	@Override
	public boolean writeQueueFull() {
		return request.writeQueueFull();
	}

	@Override
	public HttpClientRequest exceptionHandler(Handler<Throwable> handler) {
		this.request = request.exceptionHandler(handler);
		return this;
	}

	@Override
	public HttpClientRequest write(Buffer data) {
		this.request = request.write(data);
		return this;
	}

	@Override
	public HttpClientRequest setWriteQueueMaxSize(int maxSize) {
		this.request = request.setWriteQueueMaxSize(maxSize);
		return this;
	}

	@Override
	public HttpClientRequest drainHandler(Handler<Void> handler) {
		this.request = request.drainHandler(handler);
		return this;
	}

	@Override
	@Deprecated
	public HttpClientRequest pause() {
		this.request = request.pause();
		return this;
	}

	@Override
	@Deprecated
	public HttpClientRequest resume() {
		this.request = request.resume();
		return this;
	}

	@Override
	@Deprecated
	public HttpClientRequest fetch(long amount) {
		this.request = request.fetch(amount);
		return this;
	}

	@Override
	@Deprecated
	public HttpClientRequest endHandler(Handler<Void> endHandler) {
		this.request = request.endHandler(endHandler);
		return this;
	}

	@Override
	public HttpClientRequest setFollowRedirects(boolean followRedirects) {
		this.request = request.setFollowRedirects(followRedirects);
		return this;
	}

	@Override
	public HttpClientRequest setChunked(boolean chunked) {
		this.request = request.setChunked(chunked);
		return this;
	}

	@Override
	public boolean isChunked() {
		return request.isChunked();
	}

	@Override
	public HttpMethod method() {
		return request.method();
	}

	@Override
	public String getRawMethod() {
		return request.getRawMethod();
	}

	@Override
	public HttpClientRequest setRawMethod(String method) {
		request.setRawMethod(method);
		return this;
	}

	@Override
	public String absoluteURI() {
		return request.absoluteURI();
	}

	@Override
	public String uri() {
		return request.uri();
	}

	@Override
	public String path() {
		return request.path();
	}

	@Override
	public String query() {
		return request.query();
	}

	@Override
	public HttpClientRequest setHost(String host) {
		this.request = request.setHost(host);
		return this;
	}

	@Override
	public String getHost() {
		return request.getHost();
	}

	@Override
	public MultiMap headers() {
		return request.headers();
	}

	@Override
	public HttpClientRequest putHeader(String name, String value) {
		this.request = request.putHeader(name, value);
		return this;
	}

	@Override
	public HttpClientRequest putHeader(CharSequence name, CharSequence value) {
		this.request = request.putHeader(name, value);
		return this;
	}

	@Override
	public HttpClientRequest putHeader(String name, Iterable<String> values) {
		this.request = request.putHeader(name, values);
		return this;
	}

	@Override
	public HttpClientRequest putHeader(CharSequence name, Iterable<CharSequence> values) {
		this.request = request.putHeader(name, values);
		return this;
	}

	@Override
	public HttpClientRequest write(String chunk) {
		this.request = request.write(chunk);
		return this;
	}

	@Override
	public HttpClientRequest write(String chunk, String enc) {
		this.request = request.write(chunk, enc);
		return this;
	}

	@Override
	public HttpClientRequest continueHandler(Handler<Void> handler) {
		this.request = request.continueHandler(handler);
		return this;
	}

	@Override
	public HttpClientRequest sendHead() {
		this.request = request.sendHead();
		return this;
	}

	@Override
	public HttpClientRequest sendHead(Handler<HttpVersion> completionHandler) {
		this.request = request.sendHead(completionHandler);
		return this;
	}

	@Override
	public void end(String chunk) {
		request.end(chunk);
	}

	@Override
	public void end(String chunk, String enc) {
		request.end(chunk, enc);
	}

	@Override
	public void end(Buffer chunk) {
		request.end(chunk);
	}

	@Override
	public HttpClientRequest setTimeout(long timeoutMs) {
		this.request = request.setTimeout(timeoutMs);
		return this;
	}

	@Override
	public HttpClientRequest pushHandler(Handler<io.vertx.core.http.HttpClientRequest> handler) {
		this.request = request.pushHandler(handler);
		return this;
	}

	@Override
	public boolean reset(long code) {
		return request.reset(code);
	}

	@Override
	public HttpConnection connection() {
		return request.connection();
	}

	@Override
	public HttpClientRequest connectionHandler(Handler<HttpConnection> handler) {
		this.request = request.connectionHandler(handler);
		return this;
	}

	@Override
	public HttpClientRequest writeCustomFrame(int type, int flags, Buffer payload) {
		this.request = request.writeCustomFrame(type, flags, payload);
		return this;
	}

	@Override
	public StreamPriority getStreamPriority() {
		return request.getStreamPriority();
	}


}