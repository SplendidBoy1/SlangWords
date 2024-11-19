package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Dictionary_Slang dict = new Dictionary_Slang<String, String>();
        dict.LoadData();
        GridPane root = new GridPane();
        Button btn_search = new Button("Search Dictionary");
        Button btn_edit = new Button("Edit dictionary");
        Button btn_learn = new Button("Learn Slang Word");
        Search_feature Search = new Search_feature();
        Edit_feature Edit = new Edit_feature();
        root.setPadding(new Insets(30, 10, 30, 10)); 
        root.setVgap(20); 
        root.setHgap(20);
        Pane pane_1 = new Pane();
        pane_1.getChildren().add(btn_search);
        root.setGridLinesVisible( true );
        // pane_1.setBorder(new Border(new BorderStroke(Color.BLACK, 
        //     BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Pane pane_2 = new Pane();
        pane_2.getChildren().add(btn_edit);
        // root.setAlignment(Pos.TOP_CENTER);
        
        root.add(pane_1, 0, 0, 2, 1);
        root.add(pane_2, 2, 0);
        root.add(btn_learn, 1, 1);
        // root.setColumnSpan(pane_1, 1);
        pane_1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        scene = new Scene(root, 700, 600);
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