package dtcookie.io.vertx.ext.web.client;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.RequestOptions;
import io.vertx.ext.web.client.HttpRequest;

public final class WebClient implements io.vertx.ext.web.client.WebClient {
	
	private final io.vertx.ext.web.client.WebClient client;
	
	public static io.vertx.ext.web.client.WebClient decorate(io.vertx.ext.web.client.WebClient client) {
		if (client instanceof WebClient) {
			return client;
		}
		return new WebClient(client);
	}
	
	private WebClient(io.vertx.ext.web.client.WebClient client) {
		this.client = client;
	}

	@Override
	public HttpRequest<Buffer> request(HttpMethod method, int port, String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.request(method, port, host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> request(HttpMethod method, String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.request(method, host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> request(HttpMethod method, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.request(method, requestURI));
	}

	@Override
	public HttpRequest<Buffer> request(HttpMethod method, RequestOptions options) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.request(method, options));
	}

	@Override
	public HttpRequest<Buffer> requestAbs(HttpMethod method, String absoluteURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.requestAbs(method, absoluteURI));
	}

	@Override
	public HttpRequest<Buffer> get(String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.get(requestURI));
	}

	@Override
	public HttpRequest<Buffer> get(int port, String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.get(port, host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> get(String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.get(host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> getAbs(String absoluteURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.getAbs(absoluteURI));
	}

	@Override
	public HttpRequest<Buffer> post(String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.post(requestURI));
	}

	@Override
	public HttpRequest<Buffer> post(int port, String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.post(port, host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> post(String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.post(host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> postAbs(String absoluteURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.postAbs(absoluteURI));
	}

	@Override
	public HttpRequest<Buffer> put(String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.put(requestURI));
	}

	@Override
	public HttpRequest<Buffer> put(int port, String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.put(port, host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> put(String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.put(host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> putAbs(String absoluteURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.putAbs(absoluteURI));
	}

	@Override
	public HttpRequest<Buffer> delete(String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.delete(requestURI));
	}

	@Override
	public HttpRequest<Buffer> delete(int port, String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.delete(port, host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> delete(String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.delete(host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> deleteAbs(String absoluteURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.deleteAbs(absoluteURI));
	}

	@Override
	public HttpRequest<Buffer> patch(String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.patch(requestURI));
	}

	@Override
	public HttpRequest<Buffer> patch(int port, String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.patch(port, host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> patch(String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.patch(host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> patchAbs(String absoluteURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.patchAbs(absoluteURI));
	}

	@Override
	public HttpRequest<Buffer> head(String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.head(requestURI));
	}

	@Override
	public HttpRequest<Buffer> head(int port, String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.head(port, host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> head(String host, String requestURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.head(host, requestURI));
	}

	@Override
	public HttpRequest<Buffer> headAbs(String absoluteURI) {
		return dtcookie.io.vertx.ext.web.client.HttpRequest.decorate(client.headAbs(absoluteURI));
	}

	@Override
	public void close() {
		client.close();
	}

}
