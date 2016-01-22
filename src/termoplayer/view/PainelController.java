package termoplayer.view;

import java.util.function.ToIntFunction;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import serial.SerialCom;
import serial.SerialComLeitura;
import serial.TestaSerial;
import termoplayer.Gerenciador;

public class PainelController {
	private MediaPlayer player;
	private Media media;

	@FXML
	private MediaView video;

	@FXML
	private Label lblLabel;

	@FXML
	private void initialize() {

	}

	public void executarFuncao() {

		// String caminhoVideo = "file:" + Gerenciador.getUsers() +
		// System.getProperty("User.dir") + "/src/videoteste.mp4";
		// String replace = caminhoVideo.replace(" ","%20").replace("\\","/");

		// this.media = new Media(replace);
		// String workingDir = System.getProperty("User.dir");
		// File f = new File(workingDir, "src\\videoteste.mp4");

		String caminho = "file:/Users/Alex/workspace/TermoPlayer-master/src/videoteste.mp4";

		// this.media = new Media(replace);
		this.media = new Media(caminho);
		this.player = new MediaPlayer(this.media);
		this.video.setMediaPlayer(this.player);
		player.setCycleCount(MediaPlayer.INDEFINITE);
		this.player.play();
		while (SerialComLeitura.getPeso() == null) {
			verificaSerial();
		}
		// colocar aqui um timer com uma nova chamada verificaSerial dentro para
		// atualizar a temperatura de tempo em tempo.

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
		lblLabel.setText(String.valueOf(SerialComLeitura.getPeso()));
		leitura.FecharCom();

	}

}
