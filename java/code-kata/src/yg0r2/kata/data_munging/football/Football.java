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
package yg0r2.kata.data_munging.football;

/**
 * @author Yg0R2
 */
public class Football {

	private int _against;
	private int _from;
	private String _teamName;

	public Football() {
	}

	/**
	 * @return the against
	 */
	public int getAgainst() {
		return _against;
	}

	public int getDiffAgainstAndFrom() {
		return _from - _against;
	}

	/**
	 * @return the From
	 */
	public int getFrom() {
		return _from;
	}

	/**
	 * @return the TeamName
	 */
	public String getTeamName() {
		return _teamName;
	}

	/**
	 * @param against the against to set
	 */
	public void setAgainst(int against) {
		_against = against;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(int from) {
		_from = from;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		_teamName = teamName;
	}

}
