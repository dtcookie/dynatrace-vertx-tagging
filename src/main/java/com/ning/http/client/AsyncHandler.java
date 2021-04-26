package com.ning.http.client;

/**
 * 
 * @author Reinhard.Pilz
 *
 */
public interface AsyncHandler {

    void onThrowable(Throwable t);

    void onStatusReceived(HttpResponseStatus responseStatus);

    void onHeadersReceived(HttpResponseHeaders headers);

    void onCompleted();
}
