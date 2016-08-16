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
package yg0r2.kata.klondike;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yg0R2
 */
public class Pile {

	private List<Card> _cardsFaceDown = new ArrayList<>();
	private List<Card> _cardsFaceUp = new ArrayList<>();

	public Pile(List<Card> cards) {
		if (cards.isEmpty()) {
			return;
		}

		if (cards.size() > 1) {
			_cardsFaceDown = cards.subList(0, cards.size() - 1);
		}

		_cardsFaceUp = cards.subList(cards.size() - 1, cards.size());
	}

	/**
	 * Move cards to this pile.
	 *
	 * @param movedCards
	 * @return
	 */
	public List<Card> moveCardstoPile(List<Card> movedCards) {
		List<Card> result = new ArrayList<>(_cardsFaceUp);

		_cardsFaceUp = new ArrayList<>();

		if (!_cardsFaceDown.isEmpty()) {
			_cardsFaceUp.add(_cardsFaceDown.get(0));

			_cardsFaceDown.remove(0);
		}

		return result;
	}

}
