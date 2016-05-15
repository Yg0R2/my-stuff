/**
 * 
 */
package yg0r2.designpattern.iterator;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/iterator_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NameRepository nameRepository = new NameRepository();

		for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext();) {
			String name = (String) iterator.next();

			System.out.println("Name: " + name);
		}
	}

}