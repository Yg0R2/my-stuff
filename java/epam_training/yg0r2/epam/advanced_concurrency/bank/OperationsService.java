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
package yg0r2.epam.advanced_concurrency.bank;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yg0R2
 */
public class OperationsService {

	private static Logger _logger = LoggerFactory.getLogger(OperationsService.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Account a = new Account(1000);
		final Account b = new Account(2000);

		ExecutorService service = Executors.newFixedThreadPool(3);
		Random rnd = new Random();

		for (int i = 0; i < 10; i++) {
			Transfer transfer = new Transfer(a, b, rnd.nextInt(400));
			Future<Boolean> future = service.submit(transfer);

			try {
				future.get();
			}
			catch (InterruptedException | ExecutionException e) {
				_logger.error(e.getMessage(), e);

				break;
			}
		}

		// service.invokeAll(tasks)

		service.shutdown();
	}

}
