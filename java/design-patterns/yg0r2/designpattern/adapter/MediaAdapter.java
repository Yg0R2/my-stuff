/**
 * 
 */
package yg0r2.designpattern.adapter;

/**
 * @author Yg0R2
 */
public class MediaAdapter implements MediaPlayer {

	private AdvancedMediaPlayer advancedMediaPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equals("mp4")) {
			advancedMediaPlayer = new Mp4Player();
		} else if (audioType.equals("vlc")) {
			advancedMediaPlayer = new VlcPlayer();
		}
	}

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.adapter.MediaPlayer#play(java.lang.String, java.lang.String)
	 */
	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equals("mp4")) {
			advancedMediaPlayer.playMp4(fileName);
		} else if (audioType.equals("vlc")) {
			advancedMediaPlayer.playVlc(fileName);
		}
	}

}