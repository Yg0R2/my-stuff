package yg0r2.core.util;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import jodd.util.ReflectUtil;

/**
 * @author Yg0R2
 */
public class IOUtil {

	public static void close(Closeable closeable) throws IOException {
		closeable.close();
	}

	public static void close(Object obj) throws IOException {
		try {
			ReflectUtil.invoke(obj, "close", new Object[0]);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new IOException(e);
		}
	}

	public static void closeSilently(Closeable closeable) {
		if (closeable == null) {
			return;
		}

		try {
			close(closeable);
		} catch (IOException e) {
		}
	}

	public static void closeSilently(Object obj) {
		try {
			close(obj);
		} catch (IOException e) {
		}
	}

}