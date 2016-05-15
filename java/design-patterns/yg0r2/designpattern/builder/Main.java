/**
 * 
 */
package yg0r2.designpattern.builder;

/**
 * @author Yg0R2
 * @see http://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();

		Meal veganMeal = mealBuilder.prepareVeganMeal();
		System.out.println("Vegan Meal");
		veganMeal.showItems();
		System.out.println("Total Cost: " + veganMeal.getCost());

		System.out.println();

		Meal nonVeganMeal = mealBuilder.prepareNonVeganMeal();
		System.out.println("Non-Vegan Meal");
		nonVeganMeal.showItems();
		System.out.println("Total Cost: " + nonVeganMeal.getCost());
	}

}