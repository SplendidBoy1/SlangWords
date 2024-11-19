package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class Edit_feature {
    public void edit_UI(Stage stage, Scene scene_root) {
        GridPane edit_feature = new GridPane();
        Button add_slang = new Button("Add slang word");
        Button edit_slang = new Button("Edit slang word");
        Button delete_slang = new Button("Delete slang word");
        Button reset_slang = new Button("Reset dcitionary");
        Button back_menu = new Button("Back to menu");

        edit_feature.setPadding(new Insets(30, 30, 30, 30)); 
        edit_feature.setVgap(20); 

        edit_feature.setAlignment(Pos.TOP_CENTER);
        edit_feature.add(add_slang, 1, 0);
        edit_feature.add(edit_slang, 1, 1);
        edit_feature.add(delete_slang, 1, 2);
        edit_feature.add(reset_slang, 1, 3);
        edit_feature.add(back_menu, 1, 4);
        // System.out.println("asdfasdfsadf");


        Scene search_scene = new Scene(edit_feature, 400, 300);

        back_menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                stage.setScene(scene_root);
            }
        });

        stage.setScene(search_scene);

    }
}
