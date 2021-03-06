/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
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
		}
		else if (audioType.equals("vlc")) {
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
		}
		else if (audioType.equals("vlc")) {
			advancedMediaPlayer.playVlc(fileName);
		}
	}

}
