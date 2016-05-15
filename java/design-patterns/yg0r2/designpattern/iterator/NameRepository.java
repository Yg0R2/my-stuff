/**
 * 
 */
package yg0r2.designpattern.iterator;

/**
 * @author Yg0R2
 */
public class NameRepository implements Container {

	public String names[] = {"Robert", "John", "Julie", "Lora"};

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.iterator.Container#getIterator()
	 */
	@Override
	public Iterator getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		private int _index;

		@Override
		public boolean hasNext() {
			return _index < names.length;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return names[_index++];
			}

			return null;
		}

	}

}