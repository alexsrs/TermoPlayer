package br.com.creapix.termoplayer.view;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import serial.SerialComLeitura;

public class PainelController {
	private MediaPlayer player;
	private Media media;
	String url;

	@FXML
	private MediaView video;

	@FXML
	private Label lblLabel;

	@FXML
	private void initialize() {

	}

	public void executarFuncao() {

		executaVideo("file:/Users/Alex/workspace/TermoPlayer-master/src/videoteste.mp4");
		System.out.println("Aguardando primeira leitura");
		url = "file:/Users/Alex/workspace/TermoPlayer-master/src/videoteste.mp4";

		while (SerialComLeitura.getPeso() == null) {
			verificaSerial();
			temporizador(3000);
		}
	}

	private void executaVideo(String caminho) {

		this.media = new Media(caminho);
		this.player = new MediaPlayer(this.media);
		this.video.setMediaPlayer(this.player);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		this.player.play();
	}

	private void verificaSerial() {

		SerialComLeitura leitura = new SerialComLeitura("COM5", 9600, 0);

		leitura.HabilitarLeitura();

		leitura.ObterIdDaPorta();

		leitura.AbrirPorta();

		leitura.LerDados();

		// Controle de tempo da leitura aberta na serial

		try {

			Thread.sleep(1000);

		} catch (InterruptedException ex) {

			System.out.println("Erro na Thread: " + ex);

		}
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				lblLabel.setText(SerialComLeitura.getPeso());
			}
		});

		trocaVideo();
		leitura.FecharCom();
	}

	public void temporizador(int milSec) {

		// chama o método a cada 3 segundos
		// Object timer
		// ****INICIA A TAREFA ****//
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				long TEMPO = (milSec * 3);
				Timer timer = null;

				if (timer == null) {
					timer = new Timer();
					TimerTask tarefa = new TimerTask() {
						@Override
						public void run() {
							try {
								verificaSerial();
								// lblLabel.setText(String.valueOf(SerialComLeitura.getPeso()));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					};
					timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
				}
			}
		});
	}

	public void trocaVideo() {

		if (SerialComLeitura.getPeso() != lblLabel.getText()) {
			String tempSensor = String.valueOf(SerialComLeitura.getPeso());

			// tempSensor = tempSensor.replace("\"", "");

			int tempAtual = Integer.parseInt(tempSensor.trim());

			if (tempAtual >= 28 & tempAtual <= 30) {
				if (url != "file:/Users/Alex/workspace/TermoPlayer-master/src/video01.mp4") {
					this.player.stop();

					url = "file:/Users/Alex/workspace/TermoPlayer-master/src/video01.mp4";
					executaVideo(url);
					System.out.println("video 1");
				}
			}
			if (tempAtual >= 25 & tempAtual <= 27) {
				if (url != "file:/Users/Alex/workspace/TermoPlayer-master/src/video02.mp4") {
					this.player.stop();

					url = "file:/Users/Alex/workspace/TermoPlayer-master/src/video02.mp4";
					executaVideo(url);
					System.out.println("video 2");
				}
			}

		} else {
			if (url != "file:/Users/Alex/workspace/TermoPlayer-master/src/videoteste.mp4") {
				this.player.stop();
				url = "file:/Users/Alex/workspace/TermoPlayer-master/src/videoteste.mp4";
				executaVideo(url);
				System.out.println("video Default");

			}
		}
	}
}
