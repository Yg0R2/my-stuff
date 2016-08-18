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
package yg0r2.spring.aop.aspectj_based;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Yg0R2
 */
@Aspect
public class Logging {

	/**
	 * This is the method which I would like to execute after a selected method execution.
	 */
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}

	/**
	 * This is the method which I would like to execute when any method returns.
	 */
	@AfterReturning(pointcut = "selectAll()", returning = "retValue")
	public void afterReturningAdvice(Object retValue) {
		System.out.println("Returning: " + retValue.toString());
	}

	/**
	 * This is the method which I would like to execute if there is an exception raised by any method.
	 */
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception: " + ex.toString());
	}

	/**
	 * This is the method which I would like to execute before a selected method execution.
	 */
	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println("Going to setup student profile.");
	}

	/**
	 * Following is the definition for a pointcut to select all the methods available. So advice will be called for all
	 * the methods.
	 */
	@Pointcut("execution(* yg0r2.spring.aop.aspectj_based.*.*(..))")
	private void selectAll() {
	}
}
