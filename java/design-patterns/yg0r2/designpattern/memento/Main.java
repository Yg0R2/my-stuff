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
 * @see http://www.tutorialspoint.com/design_pattern/memento_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();

		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());

		originator.setState("State #4");
		System.out.println("Current State: " + originator.getState());

		originator.getStateFromMemento(careTaker.get(0));
		System.out.println("First saved State: " + originator.getState());
		originator.getStateFromMemento(careTaker.get(1));
		System.out.println("Second saved State: " + originator.getState());
	}

}
