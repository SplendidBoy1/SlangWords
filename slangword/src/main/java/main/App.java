package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Dictionary_Slang dict = new Dictionary_Slang();
        dict.LoadData();
        GridPane root = new GridPane();
        Button btn_search = new Button("Search Dictionary");
        Button btn_edit = new Button("Edit dictionary");
        Button btn_learn = new Button("Learn Slang Word");
        Search_feature Search = new Search_feature();
        Edit_feature Edit = new Edit_feature();
        root.setPadding(new Insets(30, 30, 30, 30)); 
        root.setVgap(20); 

        root.setAlignment(Pos.TOP_CENTER);
        root.add(btn_search, 1, 0);
        root.add(btn_edit, 1, 1);
        root.add(btn_learn, 1, 2);
        
        scene = new Scene(root, 400, 300);
        btn_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Search.search_UI(stage, scene);
            }
        });
        btn_edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Edit.edit_UI(stage, scene);
            }
        });
        stage.setTitle("Slang Dictionary");
        stage.setScene(scene);
        stage.show();
        // stage.setScene(scene);
        // stage.show();
    }

    // static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    //     return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

}