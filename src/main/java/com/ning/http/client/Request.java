package com.ning.http.client;

import java.util.List;
import java.util.Map;

import io.vertx.core.http.HttpClientRequest;
import io.vertx.ext.web.client.HttpRequest;

public final class Request {
	
	private final String url;
	private final Map<String, List<String>> headers;
	private final String method;
	
	public static Request of(HttpClientRequest request) {
		return new Request(request.absoluteURI(), new HttpResponseHeaders(request.headers()), request.method().toString());
	}
	
	public static Request of(HttpRequest<?> request) {
		if (request instanceof dtcookie.io.vertx.ext.web.client.HttpRequest) {
			dtcookie.io.vertx.ext.web.client.HttpRequest<?> httpRequest = (dtcookie.io.vertx.ext.web.client.HttpRequest<?>) request;
			String uri = httpRequest.getUri();
			HttpResponseHeaders headers = new HttpResponseHeaders(request.headers());
			String method = httpRequest.getMethod();
			return new Request(uri, headers, method);			
		}
		return null;
	}

	private Request(String url, Map<String, List<String>> headers, String method) {
		this.url = url;
		this.headers = headers;
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public Map<String, List<String>> getHeaders() {
		return headers;
	}

	public String getMethod() {
		return method;
	}
}
