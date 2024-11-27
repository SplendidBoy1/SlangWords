package main;

import java.util.List;
import java.util.Random;
import java.util.Vector;

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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

class Quiz_daily extends TabPane{

    // private String[] quiz_slang_main;
    private Vector<Button> answer_set = new Vector<Button>();
    private String[] quiz_slang_main;

    private Vector<Button> answer_set_2 = new Vector<Button>();
    private String[] quiz_slang_main_2;


    public void Notificate_Right(Dictionary_Slang<String, List<String>> dict, GridPane pane){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("HAS SLANG");
        dialog.setContentText("Your choice is right");
        ButtonType type = new ButtonType("CANCEL", ButtonData.CANCEL_CLOSE);

        dialog.getDialogPane().getButtonTypes().setAll(type);
        dialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        dialog.showAndWait();
        answer_set.clear();

        String random_slang_main = dict.get_random_slang(-1);
        String[] quiz_slang_main = random_slang_main.split("`");
        Vector<String[]> answer_set_data = new Vector<String[]>();
        answer_set_data.add(quiz_slang_main);
        for (int i = 0; i < 3; i++){
            String random_slang_rand = dict.get_random_slang(Integer.parseInt(quiz_slang_main[0]));
            String[] split_temp = random_slang_rand.split("`");
            answer_set_data.add(split_temp);
        }

        Random rd = new Random();
        int randInt = 0;
        //System.out.println(split_2_3.isEmpty());
        while(answer_set_data.isEmpty() == false){
            //System.out.println("aaaaaaaaaaaaaaaa");
            randInt = rd.nextInt(answer_set_data.size());
            Button temp = new Button(answer_set_data.elementAt(randInt)[2]);
            answer_set.add(temp);
            answer_set_data.remove(randInt);
        }


        Label label_main_1 = new Label(quiz_slang_main[1] );
        label_main_1.setFont(new Font("Arial", 24));
        label_main_1.setAlignment(Pos.CENTER);
        label_main_1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        //System.out.println(answer_set.elementAt(0).getText());
        pane.getChildren().clear();
        pane.add(label_main_1, 0, 0, 2, 1);
        pane.add(answer_set.elementAt(0), 0, 1);
        pane.add(answer_set.elementAt(1), 1, 1);
        pane.add(answer_set.elementAt(2), 0, 2);
        pane.add(answer_set.elementAt(3), 1, 2);

        for (int i = 0; i < answer_set.size(); i++){
            //System.err.println("asdfsadf");
            Button temp = answer_set.elementAt(i);
            temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            temp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    if (temp.getText() == quiz_slang_main[2]){
                        Notificate_Right(dict, pane);
                    }
                }
            });
        }

        
    }

    public void Notificate_Right_2(Dictionary_Slang<String, List<String>> dict, GridPane pane){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("HAS SLANG");
        dialog.setContentText("Your choice is right");
        ButtonType type = new ButtonType("CANCEL", ButtonData.CANCEL_CLOSE);

        dialog.getDialogPane().getButtonTypes().setAll(type);
        dialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        dialog.showAndWait();
        answer_set.clear();

        String random_slang_main_2 = dict.get_random_slang(-1);
        quiz_slang_main_2 = random_slang_main_2.split("`");
        Vector<String[]> answer_set_data_2 = new Vector<String[]>();
        answer_set_data_2.add(quiz_slang_main_2);
        for (int i = 0; i < 3; i++){
            String random_slang_rand_2 = dict.get_random_slang(Integer.parseInt(quiz_slang_main_2[0]));
            String[] split_temp = random_slang_rand_2.split("`");
            answer_set_data_2.add(split_temp);
        }
        Label label_main_2 = new Label(quiz_slang_main_2[2] );
        label_main_2.setFont(new Font("Arial", 24));
        label_main_2.setAlignment(Pos.CENTER);
        label_main_2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        answer_set_2.clear();

        Random rd_2 = new Random();
        int randInt_2 = 0;
        //System.out.println(split_2_3.isEmpty());
        while(answer_set_data_2.isEmpty() == false){
            //System.out.println("aaaaaaaaaaaaaaaa");
            randInt_2 = rd_2.nextInt(answer_set_data_2.size());
            Button temp = new Button(answer_set_data_2.elementAt(randInt_2)[1]);
            answer_set_2.add(temp);
            answer_set_data_2.remove(randInt_2);
        }
        //System.out.println(answer_set);
        for (int i = 0; i < answer_set_2.size(); i++){
            //System.err.println("asdfsadf");
            Button temp = answer_set_2.elementAt(i);
            temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            temp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    if (temp.getText() == quiz_slang_main_2[1]){
                        Notificate_Right_2(dict, pane);
                    }
                }
            });
        }

        pane.getChildren().clear();
        pane.setAlignment(Pos.TOP_CENTER);
        pane.add(label_main_2, 0, 0, 2, 1);
        pane.add(answer_set_2.elementAt(0), 0, 1);
        pane.add(answer_set_2.elementAt(1), 1, 1);
        pane.add(answer_set_2.elementAt(2), 0, 2);
        pane.add(answer_set_2.elementAt(3), 1, 2);
        
    }

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
        
        
        label_1.setFont(new Font("Arial", 24));

        
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
        quiz_slang_main = random_slang_main.split("`");
        Vector<String[]> answer_set_data = new Vector<String[]>();
        answer_set_data.add(quiz_slang_main);
        for (int i = 0; i < 3; i++){
            String random_slang_rand = dict.get_random_slang(Integer.parseInt(quiz_slang_main[0]));
            String[] split_temp = random_slang_rand.split("`");
            answer_set_data.add(split_temp);
        }
        Label label_main_1 = new Label(quiz_slang_main[1] );
        label_main_1.setFont(new Font("Arial", 24));
        label_main_1.setAlignment(Pos.CENTER);
        label_main_1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Vector<Button> btn_choice_1 = new Vector<Button>();
        Random rd = new Random();
        int randInt = 0;
        //System.out.println(split_2_3.isEmpty());
        while(answer_set_data.isEmpty() == false){
            //System.out.println("aaaaaaaaaaaaaaaa");
            randInt = rd.nextInt(answer_set_data.size());
            Button temp = new Button(answer_set_data.elementAt(randInt)[2]);
            answer_set.add(temp);
            answer_set_data.remove(randInt);
        }
        //System.out.println(answer_set);
        for (int i = 0; i < answer_set.size(); i++){
            //System.err.println("asdfsadf");
            Button temp = answer_set.elementAt(i);
            temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            temp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    if (temp.getText() == quiz_slang_main[2]){
                        Notificate_Right(dict, pane_2);
                    }
                }
            });
        }

        
        // btn_choice_1.elementAt(1).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // btn_choice_1.elementAt(2).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // btn_choice_1.elementAt(3).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // for (int i = 0; i < 4; i++){
        //     System.out.println(btn_choice_1.elementAt(i).toString());
        //     //btn_choice_1.elementAt(i).toString();
        // }

        pane_2.setAlignment(Pos.TOP_CENTER);
        pane_2.add(label_main_1, 0, 0, 2, 1);
        pane_2.add(answer_set.elementAt(0), 0, 1);
        pane_2.add(answer_set.elementAt(1), 1, 1);
        pane_2.add(answer_set.elementAt(2), 0, 2);
        pane_2.add(answer_set.elementAt(3), 1, 2);

        

        tab_2.setContent(pane_2);

        //TAB 3

        Tab tab_3 = new Tab("Quiz Definition");
        
        // // GridPane defi_search = new GridPane();



        GridPane pane_3 = new GridPane();

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);

        pane_3.getColumnConstraints().add(column1);
        pane_3.getColumnConstraints().add(column1);

        pane_3.setPadding(new Insets(30, 30, 30, 30));

        pane_3.setVgap(10);

        String random_slang_main_2 = dict.get_random_slang(-1);
        quiz_slang_main_2 = random_slang_main_2.split("`");
        Vector<String[]> answer_set_data_2 = new Vector<String[]>();
        answer_set_data_2.add(quiz_slang_main_2);
        for (int i = 0; i < 3; i++){
            String random_slang_rand_2 = dict.get_random_slang(Integer.parseInt(quiz_slang_main_2[0]));
            String[] split_temp = random_slang_rand_2.split("`");
            answer_set_data_2.add(split_temp);
        }
        Label label_main_2 = new Label(quiz_slang_main_2[2] );
        label_main_2.setFont(new Font("Arial", 24));
        label_main_2.setAlignment(Pos.CENTER);
        label_main_2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Random rd_2 = new Random();
        int randInt_2 = 0;
        //System.out.println(split_2_3.isEmpty());
        while(answer_set_data_2.isEmpty() == false){
            //System.out.println("aaaaaaaaaaaaaaaa");
            randInt_2 = rd_2.nextInt(answer_set_data_2.size());
            Button temp = new Button(answer_set_data_2.elementAt(randInt_2)[1]);
            answer_set_2.add(temp);
            answer_set_data_2.remove(randInt_2);
        }
        //System.out.println(answer_set);
        for (int i = 0; i < answer_set_2.size(); i++){
            //System.err.println("asdfsadf");
            Button temp = answer_set_2.elementAt(i);
            temp.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            temp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    if (temp.getText() == quiz_slang_main_2[1]){
                        Notificate_Right_2(dict, pane_3);
                    }
                }
            });
        }

        pane_3.setAlignment(Pos.TOP_CENTER);
        pane_3.add(label_main_2, 0, 0, 2, 1);
        pane_3.add(answer_set_2.elementAt(0), 0, 1);
        pane_3.add(answer_set_2.elementAt(1), 1, 1);
        pane_3.add(answer_set_2.elementAt(2), 0, 2);
        pane_3.add(answer_set_2.elementAt(3), 1, 2);

        // pane_3.setPadding(new Insets(30, 30, 30, 30));

        // pane_3.setVgap(10);

        tab_3.setContent(pane_3);

        ///////////////////////
        super.getTabs().add(tab_1); 
        super.getTabs().add(tab_2);
        super.getTabs().add(tab_3); 
        // super.setBorder(new Border(new BorderStroke(Color.BLACK, 
        //     BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));
    };

}
