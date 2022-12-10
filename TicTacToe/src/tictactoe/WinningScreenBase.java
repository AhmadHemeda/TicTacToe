package tictactoe;

import java.io.File;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class WinningScreenBase extends AnchorPane {

    protected final ImageView imageView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final MediaView playingVedio;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final Button resetBtn;
    protected final Button exitBtn;
    protected final AnchorPane anchorPane;
    protected final Text winnerName;
    protected final Text text;
    private File file;
    private MediaPlayer mediaplayer;
    private Media media;

    public WinningScreenBase() {

        imageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        playingVedio = new MediaView();
        gridPane0 = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        resetBtn = new Button();
        exitBtn = new Button();
        anchorPane = new AnchorPane();
        winnerName = new Text();
        text = new Text();
        
        
        
        file=new File("src/");//vedio
        media=new Media(file.toURI().toString());
        mediaplayer=new MediaPlayer(media);
        playingVedio.setMediaPlayer(mediaplayer);
        mediaplayer.play();
        

        setId("AnchorPane");
        setPrefHeight(861.0);
        setPrefWidth(1200.0);

        imageView.setFitHeight(861.0);
        imageView.setFitWidth(1200.0);
        imageView.setImage(new Image(getClass().getResource("../Resources/images/back.PNG").toExternalForm()));

        gridPane.setPrefHeight(861.0);
        gridPane.setPrefWidth(1200.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(724.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(84.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(734.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(600.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(423.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(156.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(playingVedio, 1);
        playingVedio.setFitHeight(600.0);
        playingVedio.setFitWidth(1000.0);
        GridPane.setMargin(playingVedio, new Insets(0.0, 100.0, 0.0, 100.0));

        GridPane.setRowIndex(gridPane0, 2);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        resetBtn.setMnemonicParsing(false);
        resetBtn.setOnAction(this::homeButton);
        resetBtn.setPrefHeight(80.0);
        resetBtn.setPrefWidth(250.0);
        resetBtn.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 100; -fx-border-radius: 100;");
        resetBtn.setText("Reset");
        resetBtn.setTextFill(javafx.scene.paint.Color.valueOf("#92435f"));
        resetBtn.setTranslateX(170.0);
        resetBtn.setFont(new Font("Book Antiqua", 30.0));
        GridPane.setMargin(resetBtn, new Insets(0.0));
        resetBtn.addEventHandler(EventType.ROOT,  (event) -> {
            
        });

        GridPane.setColumnIndex(exitBtn, 1);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setOnAction(this::homeButton);
        exitBtn.setPrefHeight(80.0);
        exitBtn.setPrefWidth(250.0);
        exitBtn.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 100; -fx-border-radius: 100;");
        exitBtn.setText("Exit");
        exitBtn.setTextFill(javafx.scene.paint.Color.valueOf("#92435f"));
        exitBtn.setTranslateX(170.0);
        exitBtn.setFont(new Font("Book Antiqua", 30.0));
        GridPane.setMargin(exitBtn, new Insets(0.0, 100.0, 0.0, 0.0));

        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);
        anchorPane.setStyle("-fx-background-color: #ffffff;");

        winnerName.setFill(javafx.scene.paint.Color.valueOf("#92435f"));
        winnerName.setLayoutX(320.0);
        winnerName.setLayoutY(55.0);
        winnerName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        winnerName.setStrokeWidth(0.0);
        winnerName.setText("Winner");
        winnerName.setFont(new Font("Book Antiqua", 30.0));

        text.setFill(javafx.scene.paint.Color.valueOf("#92435f"));
        text.setLayoutX(103.0);
        text.setLayoutY(53.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Congratulation");
        text.setFont(new Font("Book Antiqua", 30.0));

        getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(playingVedio);
        gridPane0.getColumnConstraints().add(columnConstraints0);
        gridPane0.getColumnConstraints().add(columnConstraints1);
        gridPane0.getRowConstraints().add(rowConstraints2);
        gridPane0.getChildren().add(resetBtn);
        gridPane0.getChildren().add(exitBtn);
        gridPane.getChildren().add(gridPane0);
        anchorPane.getChildren().add(winnerName);
        anchorPane.getChildren().add(text);
        gridPane.getChildren().add(anchorPane);
        getChildren().add(gridPane);

    }

    protected abstract void homeButton(javafx.event.ActionEvent actionEvent);
    


}
