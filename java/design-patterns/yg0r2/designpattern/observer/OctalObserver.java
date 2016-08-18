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
package yg0r2.designpattern.observer;

/**
 * @author Yg0R2
 */
public class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;

		this.subject.attach(this);
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.observer.Observer#update()
	 */
	@Override
	public void update() {
		System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
	}

}
