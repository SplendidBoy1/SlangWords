package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class Search_feature {
    public void search_UI(Stage stage, Scene scene_root) {
        GridPane search_feature = new GridPane();
        Button search_slang = new Button("Search slang word");
        Button search_defi = new Button("Search definition");
        Button search_his = new Button("Search history");
        Button back_menu = new Button("Back to menu");

        search_feature.setPadding(new Insets(30, 30, 30, 30)); 
        search_feature.setVgap(20); 

        search_feature.setAlignment(Pos.TOP_CENTER);
        search_feature.add(search_slang, 1, 0);
        search_feature.add(search_defi, 1, 1);
        search_feature.add(search_his, 1, 2);
        search_feature.add(back_menu, 1, 3);
        // System.out.println("asdfasdfsadf");


        Scene search_scene = new Scene(search_feature, 400, 300);

        back_menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                stage.setScene(scene_root);
            }
        });

        stage.setScene(search_scene);

    }
}
