/**
 * 
 */
package yg0r2.designpattern.builder;

/**
 * @author Yg0R2
 */
public class MealBuilder {

	public Meal prepareVeganMeal (){
		Meal meal = new Meal();
		meal.addItem(new VeganBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVeganMeal (){
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}

}