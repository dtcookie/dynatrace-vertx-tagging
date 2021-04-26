package dtcookie.io.vertx;

import io.vertx.core.http.HttpClient;
import io.vertx.core.Handler;
import io.vertx.ext.web.client.WebClient;

public final class Dynatrace {
	
	private Dynatrace() {
		// prevent instantiation
	}
	
	public static WebClient decorate(WebClient client) {
		return dtcookie.io.vertx.ext.web.client.WebClient.decorate(client);
	}

	public static <X> Handler<X> decorate(Handler<X> handler) {
		return dtcookie.io.vertx.core.Handler.decorate(handler);
	}	

	public static HttpClient decorate(HttpClient client) {
		return dtcookie.io.vertx.core.http.HttpClient.decorate(client);
	}
	
}
