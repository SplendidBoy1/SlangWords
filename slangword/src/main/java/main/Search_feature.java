package main;

import java.util.List;
import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class Search_feature extends TabPane{
    private Vector<String> list_slang = new Vector<String>();
    private Vector<String> list_defi = new Vector<String>();
    private Vector<String> list_history = new Vector<String>();

    public Search_feature(Dictionary_Slang<String, List<String>> dict){
        //TAB 1
        Tab tab_1 = new Tab("Search Slang");
        Label label_1 = new Label("Search slang word");
        label_1.setAlignment(Pos.CENTER);
        label_1.setFont(new Font("Arial", 24));
        // GridPane main_search = new GridPane(); "Search Slang"
        super.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        TextField text_search = new TextField();    
        text_search.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Button btn_search = new Button("Search Slang Word");
        // ScrollPane list_dict = new ScrollPane();
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();
        
        // items.addAll("Single Double Suite Family App");
        list.setItems(items);
        // list_dict.setContent(list);

        btn_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                list_slang = dict.vector_search(text_search.getText());
                System.out.println(text_search.getText());
                items.clear();
                for (int i = 0; i < list_slang.size(); i++){
                    // String temp = 
                    System.out.println(list_slang.elementAt(i));
                    if (list_slang.elementAt(i) == null)continue;
                    items.add(list_slang.elementAt(i));
                    list_history.add(text_search.getText().toUpperCase() + "-" + list_slang.elementAt(i));
                }
                
            }
        });

        GridPane pane_1 = new GridPane();
        pane_1.add(label_1, 0, 0);
        pane_1.add(text_search, 0, 1);
        pane_1.add(btn_search, 0, 2);
        pane_1.add(list, 0 ,3);
        pane_1.setPadding(new Insets(30, 30, 30, 30));

        pane_1.setVgap(10);

        tab_1.setContent(pane_1);
        
        //TAB 2

        Tab tab_2 = new Tab("Search Definition");
        // // GridPane defi_search = new GridPane();

        Label label_2 = new Label("Search as definition");
        label_2.setAlignment(Pos.CENTER);
        label_2.setFont(new Font("Arial", 24));

        TextField text_search_2 = new TextField();
        text_search_2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Button btn_search_2 = new Button("Search Slang Word");
        // ScrollPane list_dict_2 = new ScrollPane();
        ListView<String> list_2 = new ListView<String>();
        ObservableList<String> items_2 = FXCollections.observableArrayList();
        
        // // items.addAll("Single Double Suite Family App");
        list_2.setItems(items_2);
        // list_dict_2.setContent(list_2);

        btn_search_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                list_defi = dict.defi_search(text_search_2.getText());
                // System.out.println(text_search.getText());
                items_2.clear();
                for (int i = 0; i < list_defi.size(); i++){
                    // String temp = 
                    if (list_defi.elementAt(i) == null)continue;
                    items_2.add(list_defi.elementAt(i));
                    
                }
                
            }
        });

        GridPane pane_2 = new GridPane();
        pane_2.add(label_2, 0, 0);
        pane_2.add(text_search_2, 0, 1);
        pane_2.add(btn_search_2, 0, 2);
        pane_2.add(list_2, 0 ,3);
        pane_2.setPadding(new Insets(30, 30, 30, 30));

        pane_2.setVgap(10);

        tab_2.setContent(pane_2);

        //TAB 3

        Tab tab_3 = new Tab("Search History");
        
        // // GridPane defi_search = new GridPane();

        Label label_3 = new Label("Search history");
        label_3.setAlignment(Pos.CENTER);
        label_3.setFont(new Font("Arial", 24));

        // ScrollPane list_dict_2 = new ScrollPane();
        ListView<String> list_3 = new ListView<String>();
        ObservableList<String> items_3 = FXCollections.observableArrayList();
        
        tab_3.setOnSelectionChanged (e -> {
            if (tab_3.isSelected()){
                items_3.clear();
                for (int i = 0; i < list_history.size(); i++){
                    items_3.add(list_history.elementAt(i));
                }
            }
        }
        );

        // // items.addAll("Single Double Suite Family App");
        list_3.setItems(items_3);
        // list_dict_2.setContent(list_2);


        GridPane pane_3 = new GridPane();

        pane_3.add(label_3, 0, 0);
        pane_3.add(list_3, 0 ,1);
        pane_3.setPadding(new Insets(30, 30, 30, 30));

        pane_3.setVgap(10);

        tab_3.setContent(pane_3);

        ///////////////////////
        super.getTabs().add(tab_1); 
        super.getTabs().add(tab_2);
        super.getTabs().add(tab_3); 
        // super.setBorder(new Border(new BorderStroke(Color.BLACK, 
        //     BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
    };
}
