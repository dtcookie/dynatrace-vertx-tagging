package com.ning.http.client;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.vertx.core.MultiMap;

/**
 * This class acts as an adapter between HTTP Request / Response headers
 * for the way Vert.x sees them and for the way the mocked up NING HTTP client sees them
 * 
 * @author Reinhard.Pilz
 *
 */
public final class HttpResponseHeaders implements Map<String, List<String>> {
	
	private final MultiMap m;
	
	public HttpResponseHeaders(MultiMap m) {
		this.m = m;
	}

	@Override
	public int size() {
		return m.size();
	}

	@Override
	public boolean isEmpty() {
		return m.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return !get0(key).isEmpty();
	}

	@Override
	public boolean containsValue(Object value) {
		return false;
	}
	
	private static List<String> asList(String v) {
		if (v == null) {
			return Collections.emptyList(); 
		}
		return Collections.singletonList(v);
	}
	
	private List<String> get0(Object key) {
		if (key instanceof CharSequence) {
			return asList(m.get((CharSequence) key));
		} else if (key instanceof String) {
			return asList(m.get((String) key));
		}
		return Collections.emptyList(); 
	}

	@Override
	public List<String> get(Object key) {
		return get0(key);
	}

	public List<String> putQuiet(String key, List<String> value) {
		m.add(key, value);
		return null;
	}
	
	@Override
	public List<String> put(String key, List<String> value) {
		m.add(key, value);
		return null;
	}

	@Override
	public List<String> remove(Object key) {
		if (key != null) {
			m.remove(key.toString());
		}
		return null;		
	}

	@Override
	public void putAll(Map<? extends String, ? extends List<String>> m) {
		for (String key : m.keySet()) {
			List<String> list = m.get(key);
			if ((list != null) && !list.isEmpty()) {
				put(key, list);
			}
		}
	}

	@Override
	public void clear() {
		m.clear();
	}

	@Override
	public Set<String> keySet() {
		return m.names();
	}

	@Override
	public Collection<List<String>> values() {
		return Collections.emptyList();
	}

	@Override
	public Set<Entry<String, List<String>>> entrySet() {
		return Collections.emptySet();
	}

    public Map<String, List<String>> getHeaders() {
    	return this;
    }

}
