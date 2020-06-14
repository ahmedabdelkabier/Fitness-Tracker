package com.fitnesstracker;

import com.sun.javafx.css.PseudoClassState;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAccumulator;

import static javafx.application.Application.launch;
public class GUI extends Application {

    private int tempTime;

    Label labelF = new Label();

    MenuItem item0= new MenuItem("SWIMMING");
    MenuItem item1= new MenuItem("RUNNING");
    MenuItem item2= new MenuItem("KICK BOXING");
    MenuItem item3= new MenuItem("STRENGTH TRAINING");
    MenuItem item4= new MenuItem("TOTAL RESULTS(CALORIES&HEARTBEAT)");
    MenuItem item5 = new MenuItem("RESULT SORTE");

    MenuButton menu = new MenuButton("SPORTS",null,item0,item1,item2,item3,item4,item5);

    private void tempTimeSetter(int time2){
        if (time2 <= 0){
           labelF.setText("Enter a valid time(1 - ...)MIN");
           menu.setDisable(true);
        }

        else {
            menu.setDisable(false);
            labelF.setText("Accepted time");
            this.tempTime = time2;
        }
    }

    private int tempTimeGetter(){
        return  this.tempTime;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ActivityResult result = new ActivityResult();

        primaryStage.setTitle("Fitness Tracker.App");
        primaryStage.setWidth(400);    primaryStage.setHeight(300);

        VBox parent = new VBox();

        Label label1 = new Label("Enter Time (MINUTES):");

        TextField time = new TextField();
        time.setMaxWidth(140);
        Button enterTime = new Button("Enter Time>>");

        Label label2 = new Label("\nChoose a sport");

        menu.setPrefHeight(30);
        menu.setPrefWidth(100);

        Label label3 = new Label("RESULTS");
        Label sport = new Label("No sport selected");
        Label normalRate = new Label("\n\n\n\n\n NORMAL HERAT RATE~80.0\t\t\t\t  "+"CALORIES BURNT = 0.0");

        normalRate.setStyle("-fx-font-color: white; ");
        Stage results = new Stage();

        results.setTitle("Fitness Tracker Results");
        results.setWidth(600);                     results.setHeight(400);

        VBox res = new VBox(10);
        res.setPadding(new Insets(10,10,10,10));
        TextArea output = new TextArea();

        output.setEditable(false);
        output.setPrefHeight(400);
        output.setPrefWidth(20);
        output.setFont(Font.font(20));

        enterTime.setOnAction(e->{
            time.getText();
            tempTimeSetter(Integer.parseInt(time.getText()));
        });

        item0.setOnAction(e->{
            sport.setText("Sport: Swimming");
            Swimming swim = new Swimming(tempTimeGetter());
            output.appendText(result.swimming((Swimming) swim)+"\n\n");
        });

        item1.setOnAction(e->{
            sport.setText("Sport: Running");
            Running run = new Running(tempTimeGetter());
            output.appendText(result.running(run)+"\n\n");
        });

        item2.setOnAction(e->{
            sport.setText("Sport: Kick Boxing");
            KickBoxing kick = new KickBoxing(tempTimeGetter());
            output.appendText(result.kick((KickBoxing) kick)+"\n\n");
        });

        item3.setOnAction(e->{
            sport.setText("Sport: Strength Training");
            StrengthTraining strength = new StrengthTraining(tempTimeGetter());
            output.appendText(result.srength(strength)+"\n\n");
        });

        item4.setOnAction(e->{
            sport.setText("TOTAL RESULTS:");
            output.appendText(result.totalResult()+"\n\n");
        });

        item5.setOnAction(e->{
            sport.setText("TOTAL RESULTS Sorted:");
            double[] array = result.sortedResult();

            for (int i=0;i<array.length;i++){
                if(array[i] == result.caloriesSw)
                    output.appendText("SWIMMING:\n"+"CaloriesBurnt: "+array[i] +"\nHeartRateIncreae: "+result.heartSw+"beat/min\n\n");

                else if (array[i] == result.caloriesR)
                    output.appendText("RUNNING:\n"+"CaloriesBurnt: "+array[i] +"\nHeartRateIncreae: "+result.heartR+"beat/min\n\n");

                else if (array[i] == result.caloriesK)
                    output.appendText("KICK BOXING:\n"+"CaloriesBurnt: "+array[i] +"\nHeartRateIncreae: "+result.heartK+"beat/min\n\n");

                else if (array[i] == result.caloriesS)
                    output.appendText("STRENGTH TRAINING:\n"+"CaloriesBurnt: "+array[i] +"\nHeartRateIncreae: "+result.heartS+"beat/min\n\n");
            }
        });

        parent.getChildren().addAll(label1,time,enterTime,labelF,label2,menu,sport,normalRate);
        FileInputStream input = new FileInputStream("C:\\Users\\AhmadAbdulkabier\\IdeaProjects\\FitnessTracker\\src\\ooo.JPG");

        // create a image
        Image image = new Image(input);

        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        Background background = new Background(backgroundimage);

        // set background
        parent.setBackground(background);

        res.getChildren().addAll(output);
        Scene scene1 = new Scene(parent);
        primaryStage.setScene(scene1);
        Scene scene2 = new Scene(res);
        results.setScene(scene2);
        results.show();
        primaryStage.show();

    }
}
