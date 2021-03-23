package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboLanguage;

    @FXML
    private TextArea txtInput;

    @FXML
    private Button btnCheck;

    @FXML
    private TextArea txtWords;

    @FXML
    private Label lblErrors;

    @FXML
    private Button btnClear;

    @FXML
    private Label lblTime;

    @FXML
    void handleCheck(ActionEvent event) {
    	String lang = comboLanguage.getValue();
    	if(lang==null) {
    		txtWords.setText("Errore! Selezionare una lingua");
    		return;
    	}
    	String input = txtInput.getText().toLowerCase();
    	input.replaceAll("[.,\\/#!$%\\?^&\\*;:{}=\\-_`~()\\[\\]\"]+", "");
    	String[] arr = input.split(" ");
    	for(int i=0; i<arr.length; i++) {
    		if(!this.model.esiste(arr[i], lang)) {
    			txtWords.appendText(arr[i]+"\n");
    		}
    	}
    }

    @FXML
    void handleClear(ActionEvent event) {
    	txtInput.clear();
    	txtWords.clear();
    }

    @FXML
    void initialize() {
        assert comboLanguage != null : "fx:id=\"comboLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWords != null : "fx:id=\"txtWords\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrors != null : "fx:id=\"lblErrors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.model.leggiFile("src/main/resources/Italian.txt");
    	this.model.leggiFile("src/main/resources/English.txt");
    	String[] lang = {"italiano", "english"};
    	comboLanguage.getItems().addAll(lang);
    }
}
