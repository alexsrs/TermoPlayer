package termoplayer.view;

import java.awt.Label;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
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
	@FXML
	private BorderPane tela;
	
	@FXML
	private void initialize(){
		
	}

	public void executarFuncao() {
		
		//String caminhoVideo = "file:" + Gerenciador.getUsers() + System.getProperty("User.dir") + "/src/videoteste.mp4";
		//String replace = this.caminhoVideo.replace(" ","%20").replace("\\","/");
		//this.media = new Media(replace);
		//String workingDir = System.getProperty("User.dir");
		//File f = new File(workingDir, "src\\videoteste.mp4");
		String caminho = "file:/Users/Alex/Documentos/Workspace/TermoPlayer/meuVideo.mp4";
		
		this.media = new Media(caminho);
		this.player = new MediaPlayer(this.media);
		this.video.setMediaPlayer(this.player);
		this.player.play();
		
		
	}
	
	
}