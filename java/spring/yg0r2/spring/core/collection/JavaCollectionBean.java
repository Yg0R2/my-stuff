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
package yg0r2.spring.core.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Yg0R2
 */
public class JavaCollectionBean {

	private List<String> _addressList;
	private Map<String, String> _addressMap;
	private Properties _addressProp;
	private Set<String> _addressSet;

	/**
	 * @return the _addressList
	 */
	public List<String> getAddressList() {
		System.out.println("List Elements: " + _addressList);

		return _addressList;
	}

	/**
	 * @return the _addressMap
	 */
	public Map<String, String> getAddressMap() {
		System.out.println("Map Elements: " + _addressMap);

		return _addressMap;
	}

	/**
	 * @return the addressProp
	 */
	public Properties getAddressProp() {
		System.out.println("Property Elements: " + _addressProp);

		return _addressProp;
	}

	/**
	 * @return the _addressSet
	 */
	public Set<String> getAddressSet() {
		System.out.println("Set Elements: " + _addressSet);

		return _addressSet;
	}

	/**
	 * @param addressList the _addressList to set
	 */
	public void setAddressList(List<String> addressList) {
		_addressList = addressList;
	}

	/**
	 * @param addressMap the _addressMap to set
	 */
	public void setAddressMap(Map<String, String> addressMap) {
		_addressMap = addressMap;
	}

	/**
	 * @param addressProp the _addressProp to set
	 */
	public void setAddressProp(Properties addressProp) {
		_addressProp = addressProp;
	}

	/**
	 * @param addressSet the _addressSet to set
	 */
	public void setAddressSet(Set<String> addressSet) {
		_addressSet = addressSet;
	}

}
