/**
 * 
 */
package yg0r2.designpattern.template;

/**
 * @author Yg0R2
 */
public abstract class Game {

	public abstract void endPlay();

	public abstract void initialize();

	public abstract void startPlay();

	public final void play() {
		initialize();

		startPlay();

		endPlay();
	}

}