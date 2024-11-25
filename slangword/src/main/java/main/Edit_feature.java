package main;

import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
;

class Edit_feature extends TabPane{


    public void Submit_Add_feature(Dictionary_Slang<String, List<String>> dict, String slang, String defi){
        // System.out.println(dict.check_exist(slang));
        if (dict.check_exist(slang)){
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("HAS SLANG");
            dialog.setContentText("Your new slang has existed in database! Do you want to overwrite or duplicate to slang \"" + slang + "(1)\"?");
            ButtonType type = new ButtonType("CANCEL", ButtonData.CANCEL_CLOSE);
            ButtonType btn_overwrite = new ButtonType("OVERWRITE", ButtonBar.ButtonData.LEFT);
            ButtonType btn_duplicate = new ButtonType("DUPLICATE", ButtonBar.ButtonData.LEFT);

            dialog.getDialogPane().getButtonTypes().setAll(btn_overwrite, btn_duplicate, type);
            dialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            // dialog.showAndWait();
            Optional<ButtonType> result = dialog.showAndWait();
            //System.out.println(result.get().getText());
            if (result.get() == btn_overwrite){
                // System.out.println("ASDFASDFASDFSADF");
                dict.add_slang(slang, defi);
            }
            else if (result.get() == btn_duplicate) {
                dict.add_slang(slang + "(1)", defi);
            }
        }
        else {
            dict.add_slang(slang, defi);
        }
    }

    public void Submit_Delete_feature(Dictionary_Slang<String, List<String>> dict, String slang){
        // System.out.println(dict.check_exist(slang));
        if (dict.check_exist(slang)){
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("HAS SLANG");
            dialog.setContentText("Do you want to delete this slang?");
            ButtonType type = new ButtonType("CANCEL", ButtonData.CANCEL_CLOSE);
            ButtonType btn_confirm = new ButtonType("CONFIRM", ButtonBar.ButtonData.LEFT);
            // ButtonType btn_duplicate = new ButtonType("DUPLICATE", ButtonBar.ButtonData.LEFT);
            dialog.getDialogPane().getButtonTypes().setAll(btn_confirm, type);
            dialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            // dialog.showAndWait();
            Optional<ButtonType> result = dialog.showAndWait();
            //System.out.println(result.get().getText());
            if (result.get() == btn_confirm){
                // System.out.println("ASDFASDFASDFSADF");
                dict.remove_slang(slang);
            }
        }
        else{
            Dialog<ButtonType> dialog = new Dialog<>();
            //Setting the title
            dialog.setTitle("HAS SLANG");
            dialog.setContentText("This slang does not have in database");
            ButtonType type = new ButtonType("CANCEL", ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().setAll(type);
            dialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            dialog.showAndWait();
        }
    }

    public void _Add_feature (Tab tab, GridPane Menu, Dictionary_Slang<String, List<String>> dict) {
        GridPane Add_pane = new GridPane();
        Add_pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // Add_pane.setBorder(new Border(new BorderStroke(Color.BLACK, 
        //     BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
        // Add_pane.setGridLinesVisible( true );
        Button btn_submit = new Button("Submit your new slang");
        Button btn_cancel = new Button("Cancel");
        Label label_1 = new Label("MENU ADD FEATURE");
        label_1.setFont(new Font("Arial", 24));
        // label_1.setStyle("-fx-font-weight: bold");
        Label slang_label = new Label("New slang");
        Label definition_label = new Label("New definition");

        TextField text_slang = new TextField();    
        text_slang.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        TextField text_defi = new TextField();
        text_defi.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Add_pane.setPadding(new Insets(30, 30, 30, 30));
        Add_pane.setVgap(10);
        Add_pane.setAlignment(Pos.TOP_CENTER);

        GridPane buttn = new GridPane();
        buttn.setHgap(10);
        buttn.add(btn_submit, 0, 0);
        buttn.add(btn_cancel, 1, 0);

        btn_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Submit_Add_feature(dict, text_slang.getText(), text_defi.getText());
            }
        });

        btn_cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                tab.setContent(Menu);
            }
        });
        
        Add_pane.add(label_1, 1, 0);
        Add_pane.add(slang_label, 1, 1);
        Add_pane.add(text_slang, 1, 2);
        Add_pane.add(definition_label, 1, 3);
        Add_pane.add(text_defi, 1, 4);
        Add_pane.add(buttn, 1, 5);
        tab.setContent(Add_pane);
    }

    public void _Update_feature (Tab tab, GridPane Menu, Dictionary_Slang<String, List<String>> dict) {
        GridPane Add_pane = new GridPane();
        Add_pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // Add_pane.setBorder(new Border(new BorderStroke(Color.BLACK, 
        //     BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
        // Add_pane.setGridLinesVisible( true );
        Button btn_submit = new Button("Update your slang");
        Button btn_cancel = new Button("Cancel");
        Label label_1 = new Label("MENU UPDATE FEATURE");
        label_1.setFont(new Font("Arial", 24));
        // label_1.setStyle("-fx-font-weight: bold");
        Label slang_label = new Label("Target slang");
        Label definition_label = new Label("New definition");

        TextField text_slang = new TextField();    
        text_slang.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        TextField text_defi = new TextField();
        text_defi.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Add_pane.setPadding(new Insets(30, 30, 30, 30));
        Add_pane.setVgap(10);
        Add_pane.setAlignment(Pos.TOP_CENTER);

        GridPane buttn = new GridPane();
        buttn.setHgap(10);
        buttn.add(btn_submit, 0, 0);
        buttn.add(btn_cancel, 1, 0);

        btn_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                dict.add_slang(text_slang.getText(), text_defi.getText());
            }
        });

        btn_cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                tab.setContent(Menu);
            }
        });
        
        Add_pane.add(label_1, 1, 0);
        Add_pane.add(slang_label, 1, 1);
        Add_pane.add(text_slang, 1, 2);
        Add_pane.add(definition_label, 1, 3);
        Add_pane.add(text_defi, 1, 4);
        Add_pane.add(buttn, 1, 5);
        tab.setContent(Add_pane);
    }

    public void _Delete_feature (Tab tab, GridPane Menu, Dictionary_Slang<String, List<String>> dict) {
        GridPane Delete_pane = new GridPane();
        Delete_pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // Delete_pane.setBorder(new Border(new BorderStroke(Color.BLACK, 
        //     BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
        // Delete_pane.setGridLinesVisible( true );
        Button btn_submit = new Button("Delete your slang");
        Button btn_cancel = new Button("Cancel");
        Label label_1 = new Label("MENU DELETE FEATURE");
        label_1.setFont(new Font("Arial", 24));
        // label_1.setStyle("-fx-font-weight: bold");
        Label slang_label = new Label("Target slang");

        TextField text_slang = new TextField();    
        text_slang.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Delete_pane.setPadding(new Insets(30, 30, 30, 30));
        Delete_pane.setVgap(10);
        Delete_pane.setAlignment(Pos.TOP_CENTER);

        GridPane buttn = new GridPane();
        buttn.setHgap(10);
        buttn.add(btn_submit, 0, 0);
        buttn.add(btn_cancel, 1, 0);

        btn_submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Submit_Delete_feature(dict, text_slang.getText());
            }
        });

        btn_cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                tab.setContent(Menu);
            }
        });
        
        Delete_pane.add(label_1, 1, 0);
        Delete_pane.add(slang_label, 1, 1);
        Delete_pane.add(text_slang, 1, 2);
        Delete_pane.add(buttn, 1, 3);
        tab.setContent(Delete_pane);
    }

    public Edit_feature(Dictionary_Slang<String, List<String>> dict){
        Tab tab_1 = new Tab("Edit dictionary");
        super.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        GridPane pane_1 = new GridPane();
        
        Label label_1 = new Label("MENU EDIT");
        label_1.setFont(new Font("Arial", 24));
        // label_1.setStyle("-fx-font-weight: bold");
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

        add_slang.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                _Add_feature(tab_1, pane_1, dict);
            }
        });

        edit_slang.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                _Update_feature(tab_1, pane_1, dict);
            }
        });

        delete_slang.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                _Delete_feature(tab_1, pane_1, dict);
            }
        });

        reset_slang.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try{
                    dict.LoadData();
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
            }
        });

        tab_1.setContent(pane_1);
        super.getTabs().add(tab_1); 
    }

}
