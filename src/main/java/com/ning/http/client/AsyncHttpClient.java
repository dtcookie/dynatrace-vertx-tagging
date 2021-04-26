package com.ning.http.client;

public final class AsyncHttpClient implements AsyncHandler {
	
    public static void handle(Request req, AsyncHandler handler) {
    	AsyncHttpClient client = new AsyncHttpClient();
    	client.executeRequest(req, handler);
    }

	private AsyncHttpClient() {
	}
	
    public void executeRequest(Request req, AsyncHandler handler) {
    	// OneAgent will recognize calls to this method as outgoing HTTP call
    }
    
	@Override
	public void onThrowable(Throwable t) {
		// OneAgent will recognize calls to this method as a failure when making the outgoing call
	}

	@Override
	public void onStatusReceived(HttpResponseStatus responseStatus) {
		// OneAgent will recognize calls to this method as the response status being available for the outgoing call
	}

	@Override
	public void onHeadersReceived(HttpResponseHeaders headers) {
		// OneAgent will recognize calls to this method as the http response headers being available for the outgoing call
	}

	@Override
	public void onCompleted() {
		// OneAgent will recognize calls to this method as "http call done"
	}

}