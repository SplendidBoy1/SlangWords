package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
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
        Label label_1 = new Label("asdfafffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        root.setPadding(new Insets(30, 30, 30, 10)); 
        root.setVgap(20); 
        root.setHgap(20);
        GridPane pane_1 = new GridPane();
        pane_1.setGridLinesVisible( true );
        pane_1.setPadding(new Insets(30, 30, 30, 30));
        // root.setGridLinesVisible( true );
        root.getColumnConstraints();
        pane_1.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
        Pane pane_2 = new Pane();
        pane_2.getChildren().add(btn_edit);
        // root.setAlignment(Pos.TOP_CENTER);
        pane_2.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));

        Pane pane_3 = new Pane();
        ColumnConstraints column1 = new ColumnConstraints();
        pane_3.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
        pane_3.getChildren().add(label_1);
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        row1.setPercentHeight(70);
        row2.setPercentHeight(30);
        column1.setPercentWidth(50);
        root.getColumnConstraints().add(column1);
        root.getColumnConstraints().add(column1);
        root.getRowConstraints().add(row1);
        root.getRowConstraints().add(row2);
        // root.getColumnConstraints().add(column1);
        pane_1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ColumnConstraints col_max = new ColumnConstraints();
        col_max.setPercentWidth(100);
        pane_1.getColumnConstraints().add(col_max);
        TextField text_search = new TextField();    
        text_search.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        pane_1.setVgap(20);

        pane_1.add(text_search, 0, 0);
        pane_1.add(btn_search, 0, 1);
        // pane_1.add(text_search, 0, 2);



        root.add(pane_1, 0, 0);
        root.add(pane_2, 1, 0);
        root.add(pane_3, 0, 1, 2, 1);
        // root.setColumnSpan(pane_1, 1);
        pane_3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // pane_2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // btn_learn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
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