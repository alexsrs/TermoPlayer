package termoplayer.model;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import termoplayer.view.PainelController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
			FXMLLoader carregar = new FXMLLoader(Main.class.getClassLoader().getResource("termoplayer/view/painel.fxml"));
			AnchorPane tela =  (AnchorPane) carregar.load();
			Scene scene = new Scene(tela);
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true); //coloca o app pra rodar fullscreen
			primaryStage.setTitle("Exibindo Video");
		    PainelController control = carregar.getController(); // define a classe de controle
			
		    primaryStage.show(); // Mostra o palco
			
		    control.executarFuncao();
			
			
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}