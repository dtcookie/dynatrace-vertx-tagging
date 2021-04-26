package dtcookie.io.vertx.core;

import java.util.Objects;
import java.util.concurrent.Executor;

public final class Handler<T> implements io.vertx.core.Handler<T>, Executor, Runnable {
	
	public static <X> io.vertx.core.Handler<X> decorate(io.vertx.core.Handler<X> handler) {
		if (handler == null) {
			return null;
		}
		if (handler instanceof Handler) {
			return handler;
		}
		Handler<X> tagging = new Handler<X>(handler);
		tagging.execute(tagging);
		return tagging;
	}
	
	@Override
	public void run() {
		handler.handle(event);
	}

	@Override
	public void execute(Runnable command) {
		
	}	
	
	@Override
	public void handle(T event) {
		this.event = event;
		run();
	}

	private final io.vertx.core.Handler<T> handler;
	private T event = null;
	
	private Handler(io.vertx.core.Handler<T> handler) {
		Objects.requireNonNull(handler);
		this.handler = handler;
	}
	
}
