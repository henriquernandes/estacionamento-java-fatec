package br.com.fatec.projeton2;

import br.com.fatec.persistencia.Banco;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Menu"));
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setRoot(new AnchorPane());
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        try{          
            Banco.conectar();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        launch();
    }
}