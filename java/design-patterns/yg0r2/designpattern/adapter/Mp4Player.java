/**
 * 
 */
package yg0r2.designpattern.adapter;

/**
 * @author Yg0R2
 */
public class Mp4Player implements AdvancedMediaPlayer {

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.adapter.AdvancedMediaPlayer#playMp4(java.lang.String)
	 */
	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: " + fileName);
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.adapter.AdvancedMediaPlayer#playVlc(java.lang.String)
	 */
	@Override
	public void playVlc(String fileName) {
	}

}