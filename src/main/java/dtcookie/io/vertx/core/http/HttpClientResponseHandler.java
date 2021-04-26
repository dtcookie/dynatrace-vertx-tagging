package dtcookie.io.vertx.core.http;

import com.ning.http.client.AsyncHandler;
import com.ning.http.client.HttpResponseHeaders;
import com.ning.http.client.HttpResponseStatus;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpClientResponse;

public final class HttpClientResponseHandler implements Handler<HttpClientResponse>, AsyncHandler {
	
	private Handler<HttpClientResponse> handler = null;
	
	public static Handler<HttpClientResponse> decorate(Handler<HttpClientResponse> handler) {
		if (handler == null) {
			return null;
		}
		if (handler instanceof HttpClientResponseHandler) {
			return handler;
		}
		return new HttpClientResponseHandler(handler);
	}
	
	public HttpClientResponseHandler(Handler<HttpClientResponse> handler) {
		this.handler = dtcookie.io.vertx.core.Handler.decorate(handler);
	}
	
	public void set(Handler<HttpClientResponse> handler) {
		if (handler instanceof HttpClientResponseHandler) {
			HttpClientResponseHandler inner = (HttpClientResponseHandler)handler;
			set(inner.handler);
			return;
		}
		this.handler = dtcookie.io.vertx.core.Handler.decorate(handler);
	}
	
	public Handler<HttpClientResponse> get() {
		return handler;
	}

	@Override
	public void handle(HttpClientResponse event) {
		if (event != null) {
			onStatusReceived(new HttpResponseStatus(event.statusCode()));
			onHeadersReceived(new HttpResponseHeaders(event.headers()));
			onCompleted();
		}		
		if (handler != null) {
			handler.handle(event);
		}
	}
	
	@Override
	public void onThrowable(Throwable t) {
	}

	@Override
	public void onStatusReceived(HttpResponseStatus responseStatus) {
	}

	@Override
	public void onHeadersReceived(HttpResponseHeaders headers) {
	}

	@Override
	public void onCompleted() {
	}

}
