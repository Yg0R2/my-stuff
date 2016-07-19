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
package yg0r2.kata.data_munging.weather;

/**
 * @author Yg0R2
 */
public class Weather {

	private int _dayNumber;
	private float _maxTemperature;
	private float _minTemperature;

	public Weather() {
	}

	public int getDay() {
		return _dayNumber;
	}

	/**
	 * @return the maxTemperature
	 */
	public float getMaxTemperature() {
		return _maxTemperature;
	}

	/**
	 * @return the minTemperature
	 */
	public float getMinTemperature() {
		return _minTemperature;
	}

	/**
	 * @return With a counted value (max - min).
	 */
	public float getTemperatureSpread() {
		return _maxTemperature - _minTemperature;
	}

	public void setDay(int dayNumber) {
		_dayNumber = dayNumber;
	}

	/**
	 * @param maxTemperature the maxTemperature to set
	 */
	public void setMaxTemperature(float maxTemperature) {
		_maxTemperature = maxTemperature;
	}

	/**
	 * @param minTemperature the minTemperature to set
	 */
	public void setMinTemperature(float minTemperature) {
		_minTemperature = minTemperature;
	}

}
