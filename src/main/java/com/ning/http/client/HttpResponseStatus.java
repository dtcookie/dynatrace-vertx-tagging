package com.ning.http.client;

public final class HttpResponseStatus  {
	
	private final int status;
	
	public HttpResponseStatus(int status) {
		this.status = status;
	}

    public int getStatusCode() {
    	return status;
    }

}
