package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private JFXTextField word_target;

    @FXML
    private JFXTextField word_explain;

    @FXML
    void keyPressed(KeyEvent key) {
        if (key.getCode() == KeyCode.ENTER) {
            word_explain.setText(word_target.getText());
        }
    }

}
