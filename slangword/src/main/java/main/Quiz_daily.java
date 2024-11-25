package main;

import java.util.List;
import java.util.Vector;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

class Quiz_daily extends TabPane{
    public Quiz_daily(Dictionary_Slang<String, List<String>> dict){
        //TAB 1
        super.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        Tab tab_1 = new Tab("Slang Today");
        String random_slang = dict.get_random_slang(-1);
        String[] split = random_slang.split("`");
        Label label_1 = new Label(split[1]);
        Label label_2 = new Label(split[2]);
        GridPane pane_1 = new GridPane();
        pane_1.setPadding(new Insets(30, 30, 30, 30));

        pane_1.setVgap(5);
        
        label_1.setAlignment(Pos.CENTER);
        label_1.setFont(new Font("Arial", 24));

        label_2.setAlignment(Pos.CENTER);
        label_2.setFont(new Font("Arial", 20));

        pane_1.add(label_1, 0, 0);
        pane_1.add(label_2, 0, 1);
        pane_1.setAlignment(Pos.TOP_CENTER);
        
        tab_1.setContent(pane_1);
        
        // System.out.println(dict.get_random_slang());
        //TAB 2

        Tab tab_2 = new Tab("Quiz Slang");
        // // GridPane defi_search = new GridPane();

        

        GridPane pane_2 = new GridPane();

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);

        pane_2.getColumnConstraints().add(column1);
        pane_2.getColumnConstraints().add(column1);

        pane_2.setPadding(new Insets(30, 30, 30, 30));

        pane_2.setVgap(10);

        String random_slang_main = dict.get_random_slang(-1);
        String[] split_2 = random_slang.split("`");
        Vector<String[]> split_2_3 = new Vector<String[]>();
        for (int i = 0; i < 3; i++){
            String random_slang_rand = dict.get_random_slang(Integer.parseInt(split_2[0]));
            String[] split_temp = random_slang_rand.split("`");
            split_2_3.add(split_temp);
        }
        Label label_main_1 = new Label(split_2[1]);

        pane_2.add(label_main_1, 0, 0, 2, 1);
        
        
        pane_2.setAlignment(Pos.TOP_CENTER);

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
