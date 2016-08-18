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
package yg0r2.designpattern.memento;

/**
 * @author Yg0R2
 */
public class Originator {

	private String _state;

	public String getState() {
		return _state;
	}

	public void getStateFromMemento(Memento memento) {
		_state = memento.getState();
	}

	public Memento saveStateToMemento() {
		return new Memento(_state);
	}

	public void setState(String state) {
		_state = state;
	}

}
