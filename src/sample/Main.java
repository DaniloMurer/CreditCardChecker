package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application implements Constants {

    private String cardNumber_ = "";
    private Controller controller_ = new Controller();
    private Label userInputCaption_ = new Label(USER_INPUT_CAPTION);
    private TextField userInput_ = new TextField();
    private Button checkValidation_ = new Button(BUTTON_CHECK_CARDNUMBER);
    private Label result = new Label(EMPTY_STRING);

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        primaryStage.setTitle("Luhm Algorithm");
        primaryStage.setScene(new Scene(root, 300, 275));
        userInput_.setPromptText(USER_INPUT_PROMPT);
        root.setHgap(20);
        root.setVgap(20);
        root.add(userInputCaption_, 1, 1);
        root.add(userInput_, 1, 2);
        root.add(checkValidation_, 1, 3, 2, 2);
        root.add(result, 1, 4, 2, 5);
        checkValidation_.setOnAction(this::validateCardNumber);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void validateCardNumber(Event event) {
        boolean isCardNumberValid = false;
        cardNumber_ = userInput_.getText();
        if (!userInput_.getText().equals("") || userInput_.getText() != null) {
            isCardNumberValid = controller_.validateCardNumber(cardNumber_);
        }
        result.setText(isCardNumberValid ? CARDNUMBER_VALID : CARDNUMBER_NOT_VALID);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
