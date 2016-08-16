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
import java.util.Collections;
import java.util.List;

/**
 * @author Yg0R2
 */
public class Deck {

	private List<Card> _cards;

	public Deck() {
		_cards = new ArrayList<>(CardType.values().length * Suit.values().length);

		for(CardType cardType : CardType.values()) {
			for (Suit suit : Suit.values()) {
				_cards.add(new Card(cardType, suit));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(_cards);
	}

	public List<Card> getCards(int amount) {
		List<Card> result = new ArrayList<>(amount);

		for (int i = 0; i < amount; i++) {
			result.add(_cards.get(0));

			_cards.remove(0);
		}

		return result;
	}

}
