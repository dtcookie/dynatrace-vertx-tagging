package dtcookie.vertx.tagging.sample;

import dtcookie.io.vertx.Dynatrace;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

@SuppressWarnings("deprecation")
public class MainVerticle implements Handler<HttpServerRequest> {
	
	private static final Vertx vertx = Vertx.factory.vertx();
	private static final HttpServer httpServer = vertx.createHttpServer().requestHandler(new MainVerticle());
	
	private static final HttpClient client = Dynatrace.decorate(vertx.createHttpClient());
	private static final WebClient webClient = Dynatrace.decorate(WebClient.create(vertx));

	public static void main(String[] args) throws Exception {
		httpServer.listen(8080);
	}

	@Override
	public void handle(HttpServerRequest request) {
		request.response().bodyEndHandler(MainVerticle::handleInboundRequestBody).end("Hello Vert.x!");			
	}
	
	public static void handleInboundRequestBody(Void event) {
		client.getAbs("https://www.google.at/").handler(MainVerticle::handleOutboundResponse).end();		
	}
	
	public static void handleOutboundResponse(HttpClientResponse response) {
		webClient.getAbs("https://www.google.com/doodles").send(MainVerticle::handleWebClientOutboundResponse);		
	}
	
	public static void handleWebClientOutboundResponse(AsyncResult<HttpResponse<Buffer>> result) {
		System.out.println("done");
	}	

}
