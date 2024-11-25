package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;;

class Edit_feature extends TabPane{

    public void _Add_feature (Tab tab, GridPane Menu, Dictionary_Slang<String, String> dict) {
        GridPane Add_pane = new GridPane();
        Label label_1 = new Label("MENU ADD FEATURE");
        label_1.setFont(new Font("Arial", 24));
        label_1.setStyle("-fx-font-weight: bold");
        
    }

    public Edit_feature(Dictionary_Slang<String, String> dict){
        Tab tab_1 = new Tab("Edit dictionary");
        super.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        GridPane pane_1 = new GridPane();
        
        Label label_1 = new Label("MENU EDIT");
        label_1.setFont(new Font("Arial", 24));
        label_1.setStyle("-fx-font-weight: bold");
        Button add_slang = new Button("Add slang word");
        Button edit_slang = new Button("Edit slang word");
        Button delete_slang = new Button("Delete slang word");
        Button reset_slang = new Button("Reset dcitionary");

        pane_1.setPadding(new Insets(30, 30, 30, 30));
        pane_1.setVgap(20);
        pane_1.setAlignment(Pos.TOP_CENTER);

        pane_1.add(label_1, 1, 0);
        pane_1.add(add_slang, 1, 1);
        pane_1.add(edit_slang, 1, 2);
        pane_1.add(delete_slang, 1, 3);
        pane_1.add(reset_slang, 1, 4);

        tab_1.setContent(pane_1);
        super.getTabs().add(tab_1); 
    }

    // public void edit_UI(Stage stage, Scene scene_root) {
    //     GridPane edit_feature = new GridPane();
    //     Button add_slang = new Button("Add slang word");
    //     Button edit_slang = new Button("Edit slang word");
    //     Button delete_slang = new Button("Delete slang word");
    //     Button reset_slang = new Button("Reset dcitionary");
    //     Button back_menu = new Button("Back to menu");

    //     edit_feature.setPadding(new Insets(30, 30, 30, 30)); 
    //     edit_feature.setVgap(20); 

    //     edit_feature.setAlignment(Pos.TOP_CENTER);
    //     edit_feature.add(add_slang, 1, 0);
    //     edit_feature.add(edit_slang, 1, 1);
    //     edit_feature.add(delete_slang, 1, 2);
    //     edit_feature.add(reset_slang, 1, 3);
    //     edit_feature.add(back_menu, 1, 4);
    //     // System.out.println("asdfasdfsadf");


    //     Scene search_scene = new Scene(edit_feature, 400, 300);

    //     back_menu.setOnAction(new EventHandler<ActionEvent>() {
    //         @Override
    //         public void handle(ActionEvent event){
    //             stage.setScene(scene_root);
    //         }
    //     });

    //     stage.setScene(search_scene);

    // }
}
