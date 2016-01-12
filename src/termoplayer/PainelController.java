package termoplayer;

import java.awt.Label;



import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PainelController {
	private MediaPlayer player;
	private Media media;
	
	@FXML
	private MediaView video;
	@FXML
	private Label lblLabel;
	private String caminhoVideo; 
	
	@FXML
	private void initialize(){
		
	}

	public void executarFuncao() {
		String caminhoVideo = "file:" + Gerenciador.getUsers() + System.getProperty("User.dir") + "/src/videoteste.mp4";
		String replace = this.caminhoVideo.replace(" ","%20").replace("\\","/");
		this.media = new Media(replace);
		this.player = new MediaPlayer(media);
		this.video.setMediaPlayer(player);
		this.player.play();
		
		
	}
}
