/**
 * 
 */
package yg0r2.designpattern.template;

/**
 * @author Yg0R2
 */
public class Football extends Game {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.template.Game#endPlay()
	 */
	@Override
	public void endPlay() {
		System.out.println("Football Game Finished!");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.template.Game#initialize()
	 */
	@Override
	public void initialize() {
		System.out.println("Football Game Initialized! Game can be started.");
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.template.Game#startPlay()
	 */
	@Override
	public void startPlay() {
		System.out.println("Football Game Started! Enjoy the game!");
	}

}