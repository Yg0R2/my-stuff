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
package yg0r2.minecraft.spring;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Yg0R2
 */
public interface BaseBean {

	/**
	 * @return the URL
	 * @throws MalformedURLException
	 */
	public URL getDownloadURL() throws MalformedURLException;

	/**
	 * @return the fileName
	 */
	public String getFileName();

}
