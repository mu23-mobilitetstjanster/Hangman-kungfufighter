import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.lang.reflect.InvocationTargetException;

public class Hangman extends Application {
    private int incorrectGuesses = 0;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Figure draw = new Figure();
        PlayerList playerList = new PlayerList();
        playerList.addPlayer("Yves", "Tomte");
        playerList.addPlayer("Rudolf", "Julgran");
        playerList.addPlayer("Nicolaus", "Lussekatt");
        playerList.addPlayer("Grinchen", "Pepparkaka");

        primaryStage.setTitle("Awesome Hangman v0.1");
        Button buttonStartGame = new Button("Start a new game"); //Is not in use at the moment
        GridPane grid = new GridPane();
        Pane hangmanPane = new Pane();
        grid.add(hangmanPane, 0, 0);
        TextField textFieldGuess1 = new TextField();
        TextField textFieldGuess2 = new TextField();
        TextField textFieldGuess3 = new TextField();
        TextField textFieldGuess4 = new TextField();
        textFieldGuess1.setPrefWidth(100);
        textFieldGuess2.setPrefWidth(100);
        textFieldGuess3.setPrefWidth(100);
        textFieldGuess4.setPrefWidth(100);
        Button buttonGuess1 = new Button("Gissa");
        Button buttonGuess2 = new Button("Gissa");
        Button buttonGuess3 = new Button("Gissa");
        Button buttonGuess4 = new Button("Gissa");
        BorderPane borderPane = new BorderPane();
        String player1 = playerList.get(0).getName();
        String player2 = playerList.get(1).getName();
        String player3 = playerList.get(2).getName();
        String player4 = playerList.get(3).getName();
        Pane hangmanPane1 = new Pane();
        Pane hangmanPane2 = new Pane();
        Pane hangmanPane3 = new Pane();
        Pane hangmanPane4 = new Pane();

        VBox playerArea1 = new VBox();
        VBox playerArea2 = new VBox();
        VBox playerArea3 = new VBox();
        VBox playerArea4 = new VBox();

        playerArea1.getChildren().addAll(new Label(player1), textFieldGuess1, buttonGuess1, hangmanPane1);
        playerArea2.getChildren().addAll(new Label(player2), textFieldGuess2, buttonGuess2, hangmanPane2);
        playerArea3.getChildren().addAll(new Label(player3), textFieldGuess3, buttonGuess3, hangmanPane3);
        playerArea4.getChildren().addAll(new Label(player4), textFieldGuess4, buttonGuess4, hangmanPane4);

        HBox topBox = new HBox();
        topBox.getChildren().addAll(playerArea1, playerArea2);
        HBox bottomBox = new HBox();
        bottomBox.getChildren().addAll(playerArea3, playerArea4);
        HBox.setHgrow(playerArea1, Priority.ALWAYS);
        HBox.setHgrow(playerArea2, Priority.ALWAYS);
        HBox.setHgrow(playerArea3, Priority.ALWAYS);
        HBox.setHgrow(playerArea4, Priority.ALWAYS);
        VBox.setVgrow(topBox, Priority.ALWAYS);
        VBox.setVgrow(bottomBox, Priority.ALWAYS);
        hangmanPane1.setPrefSize(200, 200);
        hangmanPane2.setPrefSize(200, 200);
        hangmanPane3.setPrefSize(200, 200);
        hangmanPane4.setPrefSize(200, 200);
        VBox root = new VBox();
        root.getChildren().addAll(topBox, bottomBox);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        buttonGuess1.setOnAction(event -> {

            incorrectGuesses++;
            draw.updateHangmanFigure(incorrectGuesses, 100, 100, hangmanPane1);

            if(playerList.get(0).getGuessedWord().equals(textFieldGuess1)){
                //kod för att visa att spelaren är ute
            }
            if(playerList.get(0).getGuessedWord().contains(textFieldGuess1.getText())){
                //kod för att sätta ut bokstaven på rätt plats i ordet
            }
            if(!playerList.get(0).getGuessedWord().contains(textFieldGuess1.getText())){
                playerList.get(0).setScorePoints(playerList.get(0).getScorePoints()+1);
                draw.updateHangmanFigure(playerList.get(0).getScorePoints(), 100, 100, hangmanPane1);
            }

        });

        buttonGuess2.setOnAction(event -> {

            incorrectGuesses++;
            draw.updateHangmanFigure(incorrectGuesses, 100, 100, hangmanPane2);

            if(playerList.get(1).getGuessedWord().equals(textFieldGuess2)){
                //kod för att visa att spelaren är ute
            }
            if(playerList.get(1).getGuessedWord().contains(textFieldGuess2.getText())){
                //kod för att sätta ut bokstaven på rätt plats i ordet
            }
            if(!playerList.get(1).getGuessedWord().contains(textFieldGuess2.getText())){
                playerList.get(1).setScorePoints(playerList.get(1).getScorePoints()+1);
                draw.updateHangmanFigure(playerList.get(1).getScorePoints(), 100, 100, hangmanPane2);
            }

        });

        buttonGuess3.setOnAction(event -> {

            incorrectGuesses++;
            draw.updateHangmanFigure(incorrectGuesses, 100, 100, hangmanPane3);

            if(playerList.get(2).getGuessedWord().equals(textFieldGuess3)){
                //kod för att visa att spelaren är ute
            }
            if(playerList.get(0).getGuessedWord().contains(textFieldGuess3.getText())){
                //kod för att sätta ut bokstaven på rätt plats i ordet
            }
            if(!playerList.get(2).getGuessedWord().contains(textFieldGuess3.getText())){
                playerList.get(2).setScorePoints(playerList.get(2).getScorePoints()+1);
                draw.updateHangmanFigure(playerList.get(2).getScorePoints(), 100, 100, hangmanPane3);
            }

        });

        buttonGuess4.setOnAction(event -> {

            incorrectGuesses++;
            draw.updateHangmanFigure(incorrectGuesses, 100, 100, hangmanPane4);

            if(playerList.get(3).getGuessedWord().equals(textFieldGuess4)){
                //kod för att visa att spelaren är ute
            }
            if(playerList.get(3).getGuessedWord().contains(textFieldGuess4.getText())){
                //kod för att sätta ut bokstaven på rätt plats i ordet
            }
            if(!playerList.get(3).getGuessedWord().contains(textFieldGuess4.getText())){
                playerList.get(3).setScorePoints(playerList.get(3).getScorePoints()+1);
                draw.updateHangmanFigure(playerList.get(3).getScorePoints(), 100, 100, hangmanPane4);
            }

        });
    }
}