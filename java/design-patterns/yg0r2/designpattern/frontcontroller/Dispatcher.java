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
package yg0r2.designpattern.frontcontroller;

/**
 * @author Yg0R2
 */
public class Dispatcher {

	public static final String HOME = "home";
	public static final String STUDENT = "student";

	private HomeView _homeView;
	private StudentView _studentView;

	public Dispatcher() {
		_homeView = new HomeView();

		_studentView = new StudentView();
	}

	public void dispatch(String request) {
		if (request.equals(STUDENT)) {
			_studentView.show();
		}
		else {
			_homeView.show();
		}
	}

}
