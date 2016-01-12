package termoplayer;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader carregar = new FXMLLoader(Main.class.getClassLoader().getResource("painel.fxml"));
			BorderPane tela = (BorderPane) carregar.load();
			Scene scene = new Scene(tela,400,400);
			primaryStage.setScene(scene);
			
			
		    PainelController control = carregar.getController(); // define a classe de controle
			
		    primaryStage.show(); // Mostra o palco
			
		    control.executarFuncao();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
