package com.slk.io;

import java.io.IOException;
import java.io.InputStream;

public class ObjectInputStream<T> extends java.io.ObjectInputStream {

	protected ObjectInputStream() throws IOException, SecurityException {
		super();
	}

	public ObjectInputStream(InputStream in) throws IOException {
		super(in);
	}

	@SuppressWarnings("unchecked")
	public T readInstance() throws IOException, ClassNotFoundException {
		Object obj = super.readObject();
		return (T) obj;
	}

}
