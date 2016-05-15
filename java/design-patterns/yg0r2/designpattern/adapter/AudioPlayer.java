/**
 * 
 */
package yg0r2.designpattern.adapter;

/**
 * @author Yg0R2
 */
public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;

	/* (non-Javadoc)
	 * @see yg0r2.designpattern.adapter.MediaPlayer#play(java.lang.String, java.lang.String)
	 */
	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equals("mp3")) {
			System.out.println("Playing mp3 file. Name: " + fileName);
		} else if (audioType.equals("mp4") || audioType.equals("vlc")) {
			mediaAdapter = new MediaAdapter(audioType);

			mediaAdapter.play(audioType, fileName);
		} else {
			System.out.println("Invalid media. " + audioType + " format not supported.");
		}
	}

}