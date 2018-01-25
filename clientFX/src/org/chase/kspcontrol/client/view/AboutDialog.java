package org.chase.kspcontrol.client.view;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class AboutDialog extends Dialog<ButtonType> {
	Clip clip;

	public AboutDialog() {
		this.setTitle("About");
		this.setHeaderText("About KSPKontrol");
		this.setContentText("Some Text ya know");
		this.getDialogPane().getButtonTypes().add(ButtonType.OK);
	}

	public ButtonType showDialog() {
		AudioInputStream stream;
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("sfx/about.wav");
			stream = AudioSystem.getAudioInputStream(is);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			float range = volume.getMaximum()-volume.getMinimum();
			volume.setValue((range * 0.8f) + volume.getMinimum());
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		this.showAndWait();
		clip.stop();
		return resultProperty().get();
	}

}
