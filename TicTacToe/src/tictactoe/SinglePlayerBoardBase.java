package tictactoe;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class SinglePlayerBoardBase extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final ImageView imageView;
    protected final Group group;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final Text text;
    protected final Text playerOneName;
    protected final Text playerTwoName;
    protected  Button playerOneScoreBtn;
    protected  Button playerTwoScoreBtn;
    protected final Group group0;
    protected final ImageView imageView0;
    protected final Group group1;
    protected final ImageView imageView1;
    protected final GridPane gridPane1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints6;
    protected final RowConstraints rowConstraints7;
    protected final RowConstraints rowConstraints8;
    protected final RowConstraints rowConstraints9;
    protected final GridPane gridPane2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints10;
    protected final ImageView historyIcon;
    protected final ImageView imageView2;
    protected final GridPane gridPane3;
    protected final ColumnConstraints columnConstraints5;
    protected final ColumnConstraints columnConstraints6;
    protected final ColumnConstraints columnConstraints7;
    protected final RowConstraints rowConstraints11;
    protected final RowConstraints rowConstraints12;
    protected final RowConstraints rowConstraints13;
    protected  Button btn11;
    protected  Button button;
    protected  Button button0;
    protected  Button btn12;
    protected  Button btn13;
    protected  Button btn21;
    protected  Button btn22;
    protected  Button btn23;
    protected  Button btn31;
    protected  Button btn32;
    protected  Button btn33;
    protected final GridPane gridPane4;
    protected final ColumnConstraints columnConstraints8;
    protected final ColumnConstraints columnConstraints9;
    protected final RowConstraints rowConstraints14;
    protected final Button homeButton;
    protected final Button exitButton;
    protected boolean isGameEnds ;
    protected int XOCounter=0;
    protected int firstPlayerScore=0;
    protected int secondPlayerScore=0;
    protected String winner;
    

    public SinglePlayerBoardBase() {
        
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        imageView = new ImageView();
        group = new Group();
        gridPane0 = new GridPane();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        text = new Text();
        playerOneName = new Text();
        playerTwoName = new Text();
        playerOneScoreBtn = new Button();
        playerTwoScoreBtn = new Button();
        group0 = new Group();
        imageView0 = new ImageView();
        group1 = new Group();
        imageView1 = new ImageView();
        gridPane1 = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints6 = new RowConstraints();
        rowConstraints7 = new RowConstraints();
        rowConstraints8 = new RowConstraints();
        rowConstraints9 = new RowConstraints();
        gridPane2 = new GridPane();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        rowConstraints10 = new RowConstraints();
        historyIcon = new ImageView();
        imageView2 = new ImageView();
        gridPane3 = new GridPane();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();
        rowConstraints11 = new RowConstraints();
        rowConstraints12 = new RowConstraints();
        rowConstraints13 = new RowConstraints();
        btn11 = new Button();
        button = new Button();
        button0 = new Button();
        btn12 = new Button();
        btn13 = new Button();
        btn21 = new Button();
        btn22 = new Button();
        btn23 = new Button();
        btn31 = new Button();
        btn32 = new Button();
        btn33 = new Button();
        gridPane4 = new GridPane();
        columnConstraints8 = new ColumnConstraints();
        columnConstraints9 = new ColumnConstraints();
        rowConstraints14 = new RowConstraints();
        homeButton = new Button();
        exitButton = new Button();

        setId("AnchorPane");
        setPrefHeight(861.0);
        setPrefWidth(1200.0);

        gridPane.setPrefHeight(861.0);
        gridPane.setPrefWidth(1200.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(592.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(521.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(937.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(679.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        imageView.setFitHeight(861.0);
        imageView.setFitWidth(523.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../Resources/images/backgroundInGame.png").toExternalForm()));

        gridPane0.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
        gridPane0.setLayoutY(449.0);
        gridPane0.setPrefHeight(861.0);
        gridPane0.setPrefWidth(523.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints0.setMaxHeight(450.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(450.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(137.0);
        rowConstraints1.setMinHeight(0.0);
        rowConstraints1.setPrefHeight(59.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(40.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(40.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(120.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(100.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(40.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(40.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(150.0);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(150.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(text, 1);
        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setStyle("-fx-text-alignment: CENTER;");
        text.setText("Score");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setTranslateX(211.0);
        text.setFont(new Font("Book Antiqua Bold", 40.0));

        GridPane.setRowIndex(playerOneName, 2);
        playerOneName.setFill(javafx.scene.paint.Color.WHITE);
        playerOneName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerOneName.setStrokeWidth(0.0);
        playerOneName.setText("Player1");
        playerOneName.setFont(new Font("Book Antiqua", 30.0));
        GridPane.setMargin(playerOneName, new Insets(0.0, 0.0, 0.0, 80.0));

        GridPane.setRowIndex(playerTwoName, 4);
        playerTwoName.setFill(javafx.scene.paint.Color.WHITE);
        playerTwoName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTwoName.setStrokeWidth(0.0);
        playerTwoName.setText("PC");
        playerTwoName.setFont(new Font("Book Antiqua", 30.0));
        GridPane.setMargin(playerTwoName, new Insets(0.0, 0.0, 0.0, 80.0));

        GridPane.setRowIndex(playerOneScoreBtn, 3);
        playerOneScoreBtn.setMnemonicParsing(false);
        playerOneScoreBtn.setPrefHeight(80.0);
        playerOneScoreBtn.setPrefWidth(423.0);
        playerOneScoreBtn.setStyle("-fx-background-radius: 100; -fx-background-color: #ffffff; -fx-border-radius: 100;");
        playerOneScoreBtn.setText("0");
        playerOneScoreBtn.setTextFill(javafx.scene.paint.Color.valueOf("#500b4d"));
        playerOneScoreBtn.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(playerOneScoreBtn, new Insets(0.0, 50.0, 0.0, 50.0));

        GridPane.setRowIndex(playerTwoScoreBtn, 5);
        playerTwoScoreBtn.setMnemonicParsing(false);
        playerTwoScoreBtn.setPrefHeight(80.0);
        playerTwoScoreBtn.setPrefWidth(423.0);
        playerTwoScoreBtn.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 100; -fx-border-radius: 100;");
        playerTwoScoreBtn.setText("0");
        playerTwoScoreBtn.setTextFill(javafx.scene.paint.Color.valueOf("#500b4d"));
        playerTwoScoreBtn.setTranslateY(-20.0);
        GridPane.setMargin(playerTwoScoreBtn, new Insets(0.0, 50.0, 0.0, 50.0));
        playerTwoScoreBtn.setFont(new Font("Book Antiqua Bold", 30.0));

        GridPane.setRowIndex(group0, 3);

        imageView0.setFitHeight(100.0);
        imageView0.setFitWidth(100.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../Resources/images/boardGameImg2Players.png").toExternalForm()));
        GridPane.setMargin(group0, new Insets(0.0, 0.0, 0.0, 50.0));

        GridPane.setRowIndex(group1, 5);
        group1.setTranslateY(-20.0);

        imageView1.setFitHeight(100.0);
        imageView1.setFitWidth(100.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setTranslateY(-20.0);
        imageView1.setImage(new Image(getClass().getResource("../Resources/images/IconPlayer2.png").toExternalForm()));
        GridPane.setMargin(group1, new Insets(0.0, 0.0, 0.0, 50.0));

        GridPane.setColumnIndex(gridPane1, 1);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        rowConstraints6.setMaxHeight(80.0);
        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(80.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMaxHeight(200.0);
        rowConstraints7.setMinHeight(10.0);
        rowConstraints7.setPrefHeight(200.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints8.setMaxHeight(450.0);
        rowConstraints8.setMinHeight(10.0);
        rowConstraints8.setPrefHeight(450.0);
        rowConstraints8.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints9.setMaxHeight(150.0);
        rowConstraints9.setMinHeight(10.0);
        rowConstraints9.setPrefHeight(150.0);
        rowConstraints9.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(100.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(100.0);

        rowConstraints10.setMinHeight(10.0);
        rowConstraints10.setPrefHeight(30.0);
        rowConstraints10.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(historyIcon, 1);
        historyIcon.setFitHeight(30.0);
        historyIcon.setFitWidth(100.0);
        historyIcon.setTranslateX(220.0);
        historyIcon.setImage(new Image(getClass().getResource("../Resources/images/history.png").toExternalForm()));
        GridPane.setMargin(historyIcon, new Insets(0.0, 30.0, 0.0, 0.0));

        GridPane.setRowIndex(imageView2, 1);
        imageView2.setFitHeight(130.0);
        imageView2.setFitWidth(130.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setTranslateX(270.0);
        imageView2.setImage(new Image(getClass().getResource("../Resources/images/boardGameImg2Players.png").toExternalForm()));

        GridPane.setRowIndex(gridPane3, 2);
        gridPane3.setPrefHeight(500.0);
        gridPane3.setPrefWidth(500.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(100.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(100.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPrefWidth(100.0);

        rowConstraints11.setMinHeight(10.0);
        rowConstraints11.setPrefHeight(30.0);
        rowConstraints11.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints12.setMinHeight(10.0);
        rowConstraints12.setPrefHeight(30.0);
        rowConstraints12.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints13.setMinHeight(10.0);
        rowConstraints13.setPrefHeight(30.0);
        rowConstraints13.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        GridPane.setMargin(gridPane3, new Insets(50.0, 150.0, 50.0, 150.0));

        btn11.setMaxHeight(150.0);
        btn11.setMaxWidth(150.0);
        btn11.setMnemonicParsing(false);
        btn11.setPrefHeight(150.0);
        btn11.setPrefWidth(150.0);
        btn11.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn11.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        GridPane.setMargin(btn11, new Insets(5.0));
        btn11.setFont(new Font("Book Antiqua Bold", 30.0));
        btn11.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn11.getText().equals("")){
                if(XOCounter%2==0){
                    btn11.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                    System.out.println("soha");
                }else{
                
                    btn11.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });

        GridPane.setColumnIndex(button, 1);
        GridPane.setRowIndex(button, 1);
        button.setMnemonicParsing(false);
        button.setText("Button");

        GridPane.setColumnIndex(button0, 2);
        GridPane.setRowIndex(button0, 2);
        button0.setMnemonicParsing(false);
        button0.setText("Button");

        GridPane.setColumnIndex(btn12, 1);
        btn12.setMaxHeight(150.0);
        btn12.setMaxWidth(150.0);
        btn12.setMnemonicParsing(false);
        btn12.setPrefHeight(150.0);
        btn12.setPrefWidth(150.0);
        btn12.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn12.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        btn12.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(btn12, new Insets(5.0));
        btn12.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn12.getText().equals("")){
                if(XOCounter%2==0){
                    btn12.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                }else{
                
                    btn12.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });


        GridPane.setColumnIndex(btn13, 2);
        btn13.setMaxHeight(150.0);
        btn13.setMaxWidth(150.0);
        btn13.setMnemonicParsing(false);
        btn13.setPrefHeight(150.0);
        btn13.setPrefWidth(150.0);
        btn13.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn13.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        btn13.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(btn13, new Insets(5.0));
        btn13.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn13.getText().equals("")){
                if(XOCounter%2==0){
                    btn13.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                }else{
                
                    btn13.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });


        GridPane.setRowIndex(btn21, 1);
        btn21.setMaxHeight(150.0);
        btn21.setMaxWidth(150.0);
        btn21.setMnemonicParsing(false);
        btn21.setPrefHeight(150.0);
        btn21.setPrefWidth(150.0);
        btn21.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn21.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        btn21.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(btn21, new Insets(5.0));
        btn21.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn21.getText().equals("")){
                if(XOCounter%2==0){
                    btn21.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                }else{
                
                    btn21.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });


        GridPane.setColumnIndex(btn22, 1);
        GridPane.setRowIndex(btn22, 1);
        btn22.setMaxHeight(150.0);
        btn22.setMaxWidth(150.0);
        btn22.setMnemonicParsing(false);
        btn22.setPrefHeight(150.0);
        btn22.setPrefWidth(150.0);
        btn22.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn22.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        btn22.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(btn22, new Insets(5.0));
        btn22.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn22.getText().equals("")){
                if(XOCounter%2==0){
                    btn22.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                }else{
                
                    btn22.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });


        GridPane.setColumnIndex(btn23, 2);
        GridPane.setRowIndex(btn23, 1);
        btn23.setMaxHeight(150.0);
        btn23.setMaxWidth(150.0);
        btn23.setMnemonicParsing(false);
        btn23.setPrefHeight(150.0);
        btn23.setPrefWidth(150.0);
        btn23.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn23.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        btn23.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(btn23, new Insets(5.0));
        btn23.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn23.getText().equals("")){
                if(XOCounter%2==0){
                    btn23.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                }else{
                
                    btn23.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });


        GridPane.setRowIndex(btn31, 2);
        btn31.setMaxHeight(150.0);
        btn31.setMaxWidth(150.0);
        btn31.setMnemonicParsing(false);
        btn31.setPrefHeight(150.0);
        btn31.setPrefWidth(150.0);
        btn31.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn31.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        btn31.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(btn31, new Insets(5.0));
        btn31.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn31.getText().equals("")){
                if(XOCounter%2==0){
                    btn31.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                }else{
                
                    btn31.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });


        GridPane.setColumnIndex(btn32, 1);
        GridPane.setRowIndex(btn32, 2);
        btn32.setMaxHeight(150.0);
        btn32.setMaxWidth(150.0);
        btn32.setMnemonicParsing(false);
        btn32.setPrefHeight(150.0);
        btn32.setPrefWidth(150.0);
        btn32.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn32.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        btn32.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(btn32, new Insets(5.0));
        btn32.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn32.getText().equals("")){
                if(XOCounter%2==0){
                    btn32.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                }else{
                
                    btn32.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });


        GridPane.setColumnIndex(btn33, 2);
        GridPane.setRowIndex(btn33, 2);
        btn33.setMaxHeight(150.0);
        btn33.setMaxWidth(150.0);
        btn33.setMnemonicParsing(false);
        btn33.setPrefHeight(150.0);
        btn33.setPrefWidth(150.0);
        btn33.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 15; -fx-border-radius: 15;");
        btn33.setTextFill(javafx.scene.paint.Color.valueOf("#ff925b"));
        btn33.setFont(new Font("Book Antiqua Bold", 30.0));
        GridPane.setMargin(btn33, new Insets(5.0));
        btn33.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            if(btn33.getText().equals("")){
                if(XOCounter%2==0){
                    btn33.setText("X");
                    XOCounter+=1;
                    checkIfGameEnds();
                }else{
                
                    btn33.setText("O");
                    XOCounter+=1;
                    checkIfGameEnds();
                }
            }
        });


        GridPane.setRowIndex(gridPane4, 3);

        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMinWidth(10.0);
        columnConstraints8.setPrefWidth(100.0);

        columnConstraints9.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints9.setMinWidth(10.0);
        columnConstraints9.setPrefWidth(100.0);

        rowConstraints14.setMinHeight(10.0);
        rowConstraints14.setPrefHeight(30.0);
        rowConstraints14.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        homeButton.setMnemonicParsing(false);
        homeButton.setOnAction(this::homeButton);
        homeButton.setPrefHeight(50.0);
        homeButton.setPrefWidth(200.0);
        homeButton.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 100; -fx-border-radius: 100;");
        homeButton.setText("Home");
        homeButton.setTextFill(javafx.scene.paint.Color.WHITE);
        homeButton.setTranslateY(-30.0);
        homeButton.setFont(new Font("Book Antiqua", 30.0));
        GridPane.setMargin(homeButton, new Insets(0.0, 70.0, 0.0, 70.0));

        GridPane.setColumnIndex(exitButton, 1);
        exitButton.setMnemonicParsing(false);
        exitButton.setOnAction(this::exitButton);
        exitButton.setPrefHeight(50.0);
        exitButton.setPrefWidth(200.0);
        exitButton.setStyle("-fx-background-color: #500B4D; -fx-background-radius: 100; -fx-border-radius: 100;");
        exitButton.setText("Exit");
        exitButton.setTextFill(javafx.scene.paint.Color.WHITE);
        exitButton.setTranslateY(-30.0);
        exitButton.setFont(new Font("Book Antiqua", 30.0));
        GridPane.setMargin(exitButton, new Insets(0.0, 70.0, 0.0, 70.0));

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(imageView);
        gridPane0.getColumnConstraints().add(columnConstraints1);
        gridPane0.getRowConstraints().add(rowConstraints0);
        gridPane0.getRowConstraints().add(rowConstraints1);
        gridPane0.getRowConstraints().add(rowConstraints2);
        gridPane0.getRowConstraints().add(rowConstraints3);
        gridPane0.getRowConstraints().add(rowConstraints4);
        gridPane0.getRowConstraints().add(rowConstraints5);
        gridPane0.getChildren().add(text);
        gridPane0.getChildren().add(playerOneName);
        gridPane0.getChildren().add(playerTwoName);
        gridPane0.getChildren().add(playerOneScoreBtn);
        gridPane0.getChildren().add(playerTwoScoreBtn);
        group0.getChildren().add(imageView0);
        gridPane0.getChildren().add(group0);
        group1.getChildren().add(imageView1);
        gridPane0.getChildren().add(group1);
        group.getChildren().add(gridPane0);
        gridPane.getChildren().add(group);
        gridPane1.getColumnConstraints().add(columnConstraints2);
        gridPane1.getRowConstraints().add(rowConstraints6);
        gridPane1.getRowConstraints().add(rowConstraints7);
        gridPane1.getRowConstraints().add(rowConstraints8);
        gridPane1.getRowConstraints().add(rowConstraints9);
        gridPane2.getColumnConstraints().add(columnConstraints3);
        gridPane2.getColumnConstraints().add(columnConstraints4);
        gridPane2.getRowConstraints().add(rowConstraints10);
        gridPane2.getChildren().add(historyIcon);
        gridPane1.getChildren().add(gridPane2);
        gridPane1.getChildren().add(imageView2);
        gridPane3.getColumnConstraints().add(columnConstraints5);
        gridPane3.getColumnConstraints().add(columnConstraints6);
        gridPane3.getColumnConstraints().add(columnConstraints7);
        gridPane3.getRowConstraints().add(rowConstraints11);
        gridPane3.getRowConstraints().add(rowConstraints12);
        gridPane3.getRowConstraints().add(rowConstraints13);
        gridPane3.getChildren().add(btn11);
        gridPane3.getChildren().add(button);
        gridPane3.getChildren().add(button0);
        gridPane3.getChildren().add(btn12);
        gridPane3.getChildren().add(btn13);
        gridPane3.getChildren().add(btn21);
        gridPane3.getChildren().add(btn22);
        gridPane3.getChildren().add(btn23);
        gridPane3.getChildren().add(btn31);
        gridPane3.getChildren().add(btn32);
        gridPane3.getChildren().add(btn33);
        gridPane1.getChildren().add(gridPane3);
        gridPane4.getColumnConstraints().add(columnConstraints8);
        gridPane4.getColumnConstraints().add(columnConstraints9);
        gridPane4.getRowConstraints().add(rowConstraints14);
        gridPane4.getChildren().add(homeButton);
        gridPane4.getChildren().add(exitButton);
        gridPane1.getChildren().add(gridPane4);
        gridPane.getChildren().add(gridPane1);
        getChildren().add(gridPane);

    }

    protected abstract void homeButton(javafx.event.ActionEvent actionEvent);

    protected abstract void exitButton(javafx.event.ActionEvent actionEvent);
    private void checkIfGameEnds() {
            
        String t11 = btn11.getText();
        String t12 = btn12.getText();
        String t13 = btn13.getText();
        String t21 = btn21.getText();
        String t22 = btn22.getText();
        String t23 = btn23.getText();
        String t31=  btn31.getText();
        String t32 = btn32.getText();
        String t33 = btn33.getText();
  
        if (t11.equals(t12) && t11.equals(t13) && !t11.equals("")) {
            isGameEnds = true;
            if(t11.equals("X")){
                winner="X";
            }else{
                winner="O";
            }
            changeColor(btn11, btn12, btn13);
        }
 
        if (t21.equals(t22) && t21.equals(t23) && !t21.equals("")) {
            isGameEnds = true;
            if(t21.equals("X")){
                winner="X";
            }else{
                winner="O";
            }
            changeColor(btn21, btn22, btn23);
        }
 
        if (t31.equals(t32) && t31.equals(t33) && !t31.equals("")) {
            isGameEnds = true;
            if(t31.equals("X")){
                winner="X";
            }else{
                winner="O";
            }
            changeColor(btn31, btn32, btn33);
        }
 
        if (t11.equals(t21) && t11.equals(t31) && !t11.equals("")) {
            isGameEnds = true;
            if(t11.equals("X")){
                winner="X";
            }else{
                winner="O";
            }
            changeColor(btn11, btn21, btn31);
        }
 
        if (t12.equals(t22) && t12.equals(t32) && !t12.equals("")) {
            isGameEnds = true;
            if(t12.equals("X")){
                winner="X";
            }else{
                winner="O";
            }
            changeColor(btn12, btn22, btn32);
        }
 
        if (t13.equals(t23) && t13.equals(t33) && !t13.equals("")) {
            isGameEnds = true;
            if(t13.equals("X")){
                winner="X";
            }else{
                winner="O";
            }
            changeColor(btn13, btn23, btn33);
        }
 
        if (t11.equals(t22) && t11.equals(t33) && !t11.equals("")) {
            isGameEnds = true;
            if(t11.equals("X")){
                winner="X";
            }else{
                winner="O";
            }
            changeColor(btn11, btn22, btn33);
        }
 
        if (t13.equals(t22) && t13.equals(t31) && !t13.equals("")) {
            isGameEnds = true;
            if(t13.equals("X")){
                winner="X";
            }else{
                winner="O";
            }
            changeColor(btn13, btn22, btn31);
        }
        
        if( XOCounter >= 9)
        {
            isGameEnds = true;
            XOCounter = 0;
        }
        
        if(isGameEnds == true)
        {
            if(winner.equals("X")){
                firstPlayerScore+=1;
                playerOneScoreBtn.setText(""+firstPlayerScore);
            }else if(winner.equals("O")){
                secondPlayerScore+=1;
                playerTwoScoreBtn.setText(""+secondPlayerScore);
        }
        }
        
    }
    private void changeColor(Button b1, Button b2, Button b3)
    {
        b1.setStyle("-fx-background-color: #FF925B;");
        b2.setStyle("-fx-background-color: #FF925B;");
        b3.setStyle("-fx-background-color: #FF925B;");
    }

}
