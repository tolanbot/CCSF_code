package hellofx;
import java.util.Random;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.*;

public class HiLowGuessingGame extends Application {
    private Button start, enter, end, quit, mainMenu, showNum, playAgain;
    private TextField field;
    private Text gameTitle, gamePrompt, guessResult, gameOver, test;
    private Scene scene;
    private VBox v, v2, v3, v4;
    private StackPane pane;
    private int random, guessCount;
    private Random r;
    private boolean low, high, errBool, showNumBool, negBool, posBool, textBool, goodGuess;
    private String onOff;
    private int printCount;
    private String[] lowArr = { "Too Low...", "Still Too Low..." };
    private String[] highArr = { "Too High...", "Still Too High..." };
    private String[] errorArr = { "Please Enter a Numeric Value", "Program Will Only Work With Numeric Value" };
    private String[] negArr = { "Number Must be Greater than 0", "Please Enter a Positive Number Between 1 and 100" };
    private String[] posArr = { "Number Must be 100 or Less", "Please Enter a Positive Number Between 1 and 100" };

    public void start(Stage stage) {
        // initialize buttons
        start = new Button("START GAME");
        start.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 12));
        start.setMinWidth(100);

        field = new TextField();
        field.setMaxWidth(100);

        enter = new Button("GUESS");
        enter.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 12));
        enter.setMinWidth(100);

        end = new Button("MAIN MENU");
        end.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 12));
        end.setMinWidth(100);

        quit = new Button("QUIT");
        quit.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 12));
        quit.setMinWidth(75);

        mainMenu = new Button("MAIN MENU");
        mainMenu.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 12));
        mainMenu.setMinWidth(100);

        playAgain = new Button("PLAY AGAIN");
        playAgain.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 12));
        playAgain.setMinWidth(100);
        playAgain.setMaxWidth(100);

        onOff = "OFF";
        showNum = new Button("SHOW RANDOM NUMBER: " + onOff);
        showNum.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 12));

        // initialize text
        gameTitle = new Text("SEO-LAN'S TRICKY\nGUESSING GAME\n");
        gamePrompt = new Text("GUESS\nTHE COMPUTER'S NUMBER");
        guessResult = new Text();
        gameOver = new Text("GAME OVER");
        test = new Text();

        // format text
        gameTitle.setTextAlignment(TextAlignment.CENTER);
        gameTitle.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 24));
        gamePrompt.setTextAlignment(TextAlignment.CENTER);
        gamePrompt.setLineSpacing(10);
        gamePrompt.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 18));
        guessResult.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 12));
        gameOver.setFont(Font.font("Monospace", FontWeight.EXTRA_BOLD, 18));

        // set Button Actions
        start.setOnAction(this::buttonHandler);
        field.setOnAction(this::buttonHandler);
        enter.setOnAction(this::buttonHandler);
        end.setOnAction(this::buttonHandler);
        quit.setOnAction(this::buttonHandler);
        mainMenu.setOnAction(this::buttonHandler);
        showNum.setOnAction(this::buttonHandler);
        playAgain.setOnAction(this::buttonHandler);

        // initialize & format layout panes
        Rectangle rect = new Rectangle(275, 75);
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(5);
        rect.arcHeightProperty();
        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setTranslateY(-15);

        Rectangle rect2 = new Rectangle(275, 75);
        rect2.setFill(Color.TRANSPARENT);
        rect2.setStroke(Color.gray(.7));
        rect2.setStrokeWidth(5);
        rect2.arcHeightProperty();
        rect2.setArcHeight(10);
        rect2.setArcWidth(10);
        rect2.setTranslateY(-18);
        rect2.setTranslateX(2);

        v = new VBox(start, showNum, quit);
        v.setAlignment(Pos.CENTER);
        v.setSpacing(10);
        v.setPadding(new Insets(40, 0, 0, 0));

        v2 = new VBox(gamePrompt, field, guessResult, enter, end, test);
        v2.setAlignment(Pos.CENTER);
        v2.setSpacing(20);
        v2.setPadding(new Insets(100));

        v3 = new VBox(gameOver, mainMenu);
        v3.setAlignment(Pos.CENTER);
        v3.setSpacing(10);
        v3.setPadding(new Insets(100));

        pane = new StackPane(rect2, rect, gameTitle);
        pane.setPadding(new Insets(100, 0, 0, 0));

        v4 = new VBox(pane, v);

        // set scene
        stage.setTitle("GUESSING GAME");
        showNumBool = false;
        test.setVisible(false);
        r = new Random();

        scene = new Scene(v4, 400, 400, Color.gray(0.8));
        stage.setScene(scene);
        stage.show();
    }

    private void buttonHandler(ActionEvent e) {
        if (e.getSource() == start) {
            play();
        } else if (e.getSource() == enter || e.getSource() == field) {
            checkInput();
        } else if (e.getSource() == end || e.getSource() == mainMenu) {
            scene.setRoot(v4);
        } else if (e.getSource() == quit) {
            Platform.exit();
        } else if (e.getSource() == showNum) {
            if (showNumBool == false) {
                test.setVisible(true);
                showNumBool = true;
            } else {
                test.setVisible(false);
                showNumBool = false;
            }
            onOff = (showNumBool == true) ? " ON" : "OFF";
            showNum.setText("SHOW RANDOM NUMBER: " + onOff);
        } else if (e.getSource() == playAgain) {
            play();
        }
    }

    private boolean isNumeric(String str) {
        char[] charArr = str.toCharArray();
        if (charArr[0] == '-') {
            if(charArr.length==1){
                return false;
            }
            for (int i = 1; i < charArr.length; i++) {
                if (!Character.isDigit(charArr[i])) {
                    return false;
                }
            }
            return true;
        } else {
            for (char c : charArr) {
                if (!Character.isDigit(c))
                    return false;
            }
            return true;
        }
    }

    private void play() {
        random = r.nextInt(1, 101);
        test.setText(String.valueOf(random));
        guessCount = printCount = 0;
        guessResult.setText("");
        errBool = posBool = negBool = textBool = false;
        goodGuess = true;
        if (v2.getChildren().get(3) == playAgain) {
            v2.getChildren().remove(playAgain);
            v2.getChildren().add(3, enter);
        }
        if(field.isDisabled()){
            field.setDisable(false);
        }
        scene.setRoot(v2);
    }

    private void checkInput() {
        String s = "";
        int i;
        if (!field.getText().isEmpty() && isNumeric(field.getText())) {
            i = Integer.parseInt(field.getText());
            if (guessCount == 9) {
                scene.setRoot(v3);
            }
            if (i <=0){
                if (errBool && posBool || textBool || goodGuess && !errBool) {
                    printCount = 0;
                }
                s = negArr[printCount];
                errBool = negBool = true;
                posBool = textBool = goodGuess = false;
            }
            if (i > 100) {
                if (errBool && negBool || textBool || goodGuess && !errBool) {
                    printCount = 0;
                }
                s = posArr[printCount];
                errBool = posBool = true;
                negBool = textBool = goodGuess = false;
            }
            if (i > 0 && i <= 100) {
                if (i < random && i > 0) {
                    if (high == true || errBool == true || textBool == true) {
                        printCount = 0;
                    }
                    s = lowArr[printCount];
                    high = errBool = posBool = negBool = textBool = false;
                    low = goodGuess = true;
                }
                if (i > random && i <= 100) {
                    if (low == true || errBool == true || textBool == true) {
                        printCount = 0;
                    }
                    s = highArr[printCount];
                    low = errBool = posBool = negBool = textBool = false;
                    high = goodGuess = true;
                }
                if (i == random) {
                    s = "Just Right!!! The number was: " + random;
                    field.setDisable(true);
                    v2.getChildren().remove(enter);
                    v2.getChildren().add(3, playAgain);
                    high = low = posBool = negBool = errBool = textBool = false;
                }
                guessCount++;
            }
            field.clear();
        } else {
            if (posBool || negBool || goodGuess && !errBool) {
                printCount = 0;
            }
            errBool = textBool = true;
            posBool = negBool = goodGuess = false;
            s = errorArr[printCount];
            field.clear();
        }
        printCount = (printCount < 1) ? printCount + 1 : 0;
        field.requestFocus();
        guessResult.setText(s);
    }

    public static void main(String[] args) {
        launch();
    }
}
