package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {

	Clip clip;
	URL soundURL[] = new URL[4];

	public Sounds() {
		soundURL[0] = getClass().getResource("/sound/smb_jump-small.wav");
		soundURL[1] = getClass().getResource("/sound/smb_mariodie.wav");
		soundURL[2] = getClass().getResource("/sound/smb_stage_clear.wav");
		soundURL[3] = getClass().getResource("/sound/theme.wav");
	}

	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {

		}
	}

	public void play() {
		clip.start();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();

	}

}
