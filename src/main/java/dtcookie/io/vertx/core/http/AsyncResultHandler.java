package dtcookie.io.vertx.core.http;

import com.ning.http.client.AsyncHandler;
import com.ning.http.client.HttpResponseHeaders;
import com.ning.http.client.HttpResponseStatus;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.web.client.HttpResponse;

public final class AsyncResultHandler<T> implements Handler<AsyncResult<HttpResponse<T>>>, AsyncHandler {
	
	private Handler<AsyncResult<HttpResponse<T>>> handler = null;
	
	public static <X> Handler<AsyncResult<HttpResponse<X>>> decorate(Handler<AsyncResult<HttpResponse<X>>> handler) {
		if (handler == null) {
			return null;
		}
		if (handler instanceof AsyncResultHandler) {
			return handler;
		}
		return new AsyncResultHandler<X>(handler);
	}
	
	public AsyncResultHandler(Handler<AsyncResult<HttpResponse<T>>> handler) {
		this.handler = dtcookie.io.vertx.core.Handler.decorate(handler);
	}
	
	public void set(Handler<AsyncResult<HttpResponse<T>>> handler) {
		if (handler instanceof AsyncResultHandler) {
			AsyncResultHandler<T> inner = (AsyncResultHandler<T>)handler;
			set(inner.handler);
			return;
		}
		this.handler = dtcookie.io.vertx.core.Handler.decorate(handler);
	}
	
	public Handler<AsyncResult<HttpResponse<T>>> get() {
		return handler;
	}

	@Override
	public void handle(AsyncResult<HttpResponse<T>> event) {
		try {
			if (event != null) {
				if (event.succeeded()) {
					HttpResponse<T> result = event.result();
					if (result != null) {
						onStatusReceived(new HttpResponseStatus(result.statusCode()));
						onHeadersReceived(new HttpResponseHeaders(result.headers()));
					}
				} else {
					Throwable cause = event.cause();
					if (cause != null) {
						onThrowable(cause);						
					}
				}
			}	
			
		} finally {
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
