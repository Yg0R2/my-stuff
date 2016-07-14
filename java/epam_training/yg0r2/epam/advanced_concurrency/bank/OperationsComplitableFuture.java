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

import java.util.concurrent.CompletableFuture;

/**
 * @author Yg0R2
 */
public class OperationsComplitableFuture {

	private final Account _acc1 = new Account(1000);
	private final Account _acc2 = new Account(2000);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	public void run() {
		CompletableFuture<Integer> futureAmount = CompletableFuture.supplyAsync(() -> _requestTransferAmount());
		
		CompletableFuture<Void> featureTransfer = CompletableFuture.supplyAsync(() -> _requestDestinationAccount())
			.thenCombineAsync(futureAmount, (acc2, amount) -> _createTransfer(_acc1, acc2, amount))
			.thenApplyAsync(transfer -> transfer.perform())
			.exceptionally(ex -> _processTransferException(ex))
			.thenAcceptAsync(result -> _processTransferResult(result))
			.thenRunAsync(() -> _updateStatistic());
	}

	private int _requestTransferAmount() {
		return 10;
	}

	private Object _updateStatistic() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object _processTransferResult(Boolean result) {
		// TODO Auto-generated method stub
		return null;
	}

	private Boolean _processTransferException(Throwable ex) {
		// TODO Auto-generated method stub
		return null;
	}

	private Account _requestDestinationAccount() {
		return _acc2;
	}

	private Transfer _createTransfer(Account fromAcc, Account toAcc, int amount) {
		return new Transfer(fromAcc, toAcc, amount);
	}

}
