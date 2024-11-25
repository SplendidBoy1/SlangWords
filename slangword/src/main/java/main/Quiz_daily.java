package main;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;

class Quiz_daily extends TabPane{
    public Quiz_daily(Dictionary_Slang<String, List<String>> dict){
        //TAB 1
        super.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        Tab tab_1 = new Tab("Slang Today");

        GridPane pane_1 = new GridPane();
        pane_1.setPadding(new Insets(30, 30, 30, 30));

        pane_1.setVgap(10);

        tab_1.setContent(pane_1);
        
        //TAB 2

        Tab tab_2 = new Tab("Quiz Slang");
        // // GridPane defi_search = new GridPane();

        GridPane pane_2 = new GridPane();
        pane_2.setPadding(new Insets(30, 30, 30, 30));

        pane_2.setVgap(10);

        tab_2.setContent(pane_2);

        //TAB 3

        Tab tab_3 = new Tab("Quiz Definition");
        
        // // GridPane defi_search = new GridPane();



        GridPane pane_3 = new GridPane();

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
