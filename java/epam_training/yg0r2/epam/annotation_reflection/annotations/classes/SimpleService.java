/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package yg0r2.epam.annotation_reflection.annotations.classes;

import yg0r2.epam.annotation_reflection.annotations.Note;
import yg0r2.epam.annotation_reflection.annotations.Service;

/**
 * @author Yg0R2
 */
@Note("That is cool!")
@Note("Here am I: :)")
@Service(name = "SimpleService")
public class SimpleService {

	public void initService() {
		System.out.println("Inside of SimpleService.initService()");
	}

}