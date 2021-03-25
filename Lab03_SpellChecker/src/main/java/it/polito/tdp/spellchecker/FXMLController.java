/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;

public class FXMLController {

	    @FXML
	    private MenuButton btnMenu;

	    @FXML
	    private TextArea txtInsert;

	    @FXML
	    private Button btnCheck;

	    @FXML
	    private TextArea txtResults;

	    @FXML
	    private Label lblErrorsNumber;

	    @FXML
	    private Button btnClear;

	    @FXML
	    private Label lblTime;
	    
	    private Dictionary model;
	    
	    @FXML
	    void doClearText(ActionEvent event) {

	    }

	    @FXML
	    void doSpellCheck(ActionEvent event) {
	    	this.model.loadDictionary(this.btnMenu.getText());
	    	List <String> inputTextList= new ArrayList();
	    	
	    	String input = this.txtInsert.getText();
	    	input.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]", "");
	    	input.toLowerCase();
	    	String[] inputText = input.split(" ");
	    	for(String s: inputText) {
	    		inputTextList.add(s);
	    	}
	    	
	    	List <RichWord> textList= new ArrayList(this.model.spellCheckTest(inputTextList));
	    	String ss = "";
	    	for(RichWord rw: textList) {
	    		ss.concat(rw.getParola() + " " + rw.isCorretto() + "\n");
	    	}
	    	this.txtResults.setText(ss);
	    }

	    public void setModel(Dictionary model) {
	    	this.model = model;
	    }
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	  assert btnMenu != null : "fx:id=\"btnMenu\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'Scene.fxml'.";
          assert txtResults != null : "fx:id=\"txtResults\" was not injected: check your FXML file 'Scene.fxml'.";
          assert lblErrorsNumber != null : "fx:id=\"lblErrorsNumber\" was not injected: check your FXML file 'Scene.fxml'.";
          assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
          assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    
}


