package sample;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class Controller implements Initializable {

    @FXML
    private JFXListView<wordList> wordFoundBoard;

    @FXML
    private JFXTextField wordTarget;

    @FXML
    private JFXTextArea wordExplain;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<wordList> testwl = FXCollections.observableArrayList();
        testwl.add(new wordList("hello", "chao"));
        testwl.add(new wordList("fun", "vui ve"));
        testwl.add(new wordList("happy", "hanh phuc"));
        testwl.add(new wordList("hope", "hi vong"));
        testwl.add(new wordList("sing", "hat"));
        testwl.add(new wordList("play", "choi"));
        wordFoundBoard.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        wordFoundBoard.setItems(testwl);
        wordFoundBoard.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<wordList>() {
            @Override
            public void changed(ObservableValue<? extends wordList> observable, wordList oldValue, wordList newValue) {
                wordExplain.setText(newValue.wordMeaning);
            }
        });
    }

    class wordList {

        public String wordMeaning;
        public String wordName;

        public wordList (String wordName, String wordMeaning) {
            this.wordName = wordName;
            this.wordMeaning = wordMeaning;
        }

        @Override
        public String toString() {
            return this.wordName;
        }
    }

}
