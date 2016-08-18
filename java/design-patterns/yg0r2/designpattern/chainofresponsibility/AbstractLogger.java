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
package yg0r2.designpattern.chainofresponsibility;

import yg0r2.core.util.Validator;

/**
 * @author Yg0R2
 */
public abstract class AbstractLogger {

	public static int DEBUG = 2;
	public static int ERROR = 3;
	public static int INFO = 1;

	protected int leve;

	// next element in chain or responsibility
	protected AbstractLogger nextLogger;

	public void logMessage(int level, String message) {
		if (this.leve <= level) {
			write(message);
		}

		if (Validator.isNotNull(nextLogger)) {
			nextLogger.logMessage(level, message);
		}
	}

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	protected abstract void write(String message);

}
