package oops;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.*;

/**
 * This is an example program that demonstrates how to play back an audio file
 * using the Clip in Java Sound API.
 * 
 * @author www.codejava.net
 *
 */
public class BackSound implements LineListener {

	/**
	 * this flag indicates whether the playback completes or not.
	 */
	boolean playCompleted;
	private String music;
	private DataLine.Info info;           //데이터의 추가형식 (ex.오디오형식)
	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;           //사운드 stream내에서 데이터 특정의 배열 지정
	private Clip audioClip;               //start,end,loop...
	private String store;                 //음악 저장 경로
	private boolean end=false;            //ending에선 음악 반복 x

	/**
	 * Play a given audio file.
	 * 
	 * @param audioFilePath
	 *            Path of the audio file.
	 */
	public BackSound(String music) {
		this.music = music;

	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public void play(boolean check) {
		if (check) {
			audioFile = new File(store);
		}
		
		try {
			if (check) {
				audioStream = AudioSystem.getAudioInputStream(audioFile);

				format = audioStream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				audioClip = (Clip) AudioSystem.getLine(info);

				audioClip.addLineListener(this);

				audioClip.open(audioStream);
			}

			if (check) {
				 if (!end) {
				 audioClip.loop(100);
				 }
				audioClip.start(); // 노래 나오게 하는 것
			}

			else {
				audioClip.stop(); // 노래 안 나오게 하는 것
				audioClip.close();
			}
		} catch (UnsupportedAudioFileException ex) {
			System.out.println("The specified audio file is not supported.");
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			System.out.println("Audio line for playing back is unavailable.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error playing the audio file.");
			ex.printStackTrace();
		}

	}

	/**
	 * Listens to the START and STOP events of the audio line.
	 */
	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();

		if (type == LineEvent.Type.START) {
			System.out.println("Playback started.");

		} else if (type == LineEvent.Type.STOP) {
			playCompleted = true;
			System.out.println("Playback completed.");
		}

	}

	public void mulist() {

		store = null;
		switch (music) {

		case "game1":
			store = "game1.wav";
			break;
		case "game2":
			store = "game2.wav";
			break;
		case "game3":
			store = "game3.wav";
			break;
		case "main":
			store = "main.wav";
			break;
		case "timesup":
			store = "timesup.wav";
			break;
		case "logout":
			store = "logout.wav";
			break;

		}
		if (store == null) {
			System.out.println("error!");
		}

	}

}

// Borrowed from http://www.codejava.net/coding/how-to-play-back-audio-in-java-with-examples