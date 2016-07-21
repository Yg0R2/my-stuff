/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package yg0r2.kata.bloom_filter;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Yg0R2
 */
public class BloomFilter<T> {

	private int _keySize;
	private MessageDigest messageDigest;
	private boolean[] _set;
	// Store the amount of the stored stuffs
	private int _size;

	public BloomFilter(int capacity, int keySize) {
		_keySize = keySize;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}

		_set = new boolean[capacity];

		_size = 0;
	}

	public void add(T object) {
		int[] setArray = _getSetArray(object);

		for (int i : setArray) {
			_set[i] = true;
		}

		_size++;
	}

	public void clean() {
		_set = new boolean[_set.length];

		_size = 0;
	}

	public boolean maybeContains(T object) {
		int[] setArray = _getSetArray(object);

		for (int i : setArray) {
			if (!_set[i]) {
				return false;
			}
		}

		return true;
	}

	public int getSize() {
		return _size;
	}

	public boolean isEmpty() {
		return _size == 0;
	}

	private final int _getHash(int i) {
		messageDigest.reset();

		byte[] bytes = ByteBuffer.allocate(4).putInt(i).array();

		messageDigest.update(bytes);

		return Math.abs(new BigInteger(1, messageDigest.digest()).intValue()) % (_set.length - 1);
	}

	private int[] _getSetArray(T object) {
		int[] result = new int[_keySize];

		result[0] = _getHash(object.hashCode());
		for (int i = 1; i < _keySize; i++) {
			result[i] = _getHash(result[i - 1]);
		}

		return result;
	}

}
