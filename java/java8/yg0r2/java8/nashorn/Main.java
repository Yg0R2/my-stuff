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
package yg0r2.java8.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_nashorn_java_script.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

		String name = "Mahesh";

		Integer result = null;

		try {
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");
		}
		catch (ScriptException e) {
			System.out.println("Error executing script: " + e.getMessage());
		}

		System.out.println(result);
	}

}
