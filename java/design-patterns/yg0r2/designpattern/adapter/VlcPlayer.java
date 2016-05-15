/**
 * 
 */
package yg0r2.designpattern.adapter;

/**
 * @author Yg0R2
 */
public class VlcPlayer implements AdvancedMediaPlayer {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.adapter.AdvancedMediaPlayer#playMp4(java.lang.String)
	 */
	@Override
	public void playMp4(String fileName) {
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.adapter.AdvancedMediaPlayer#playVlc(java.lang.String)
	 */
	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: " + fileName);
	}

}