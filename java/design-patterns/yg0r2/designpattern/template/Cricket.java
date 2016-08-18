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
package yg0r2.designpattern.template;

/**
 * @author Yg0R2
 */
public class Cricket extends Game {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.template.Game#endPlay()
	 */
	@Override
	public void endPlay() {
		System.out.println("Cricket Game Finished!");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.template.Game#initialize()
	 */
	@Override
	public void initialize() {
		System.out.println("Cricket Game Initialized! Game can be started.");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.template.Game#startPlay()
	 */
	@Override
	public void startPlay() {
		System.out.println("Cricket Game Started! Enjoy the game!");
	}

}
