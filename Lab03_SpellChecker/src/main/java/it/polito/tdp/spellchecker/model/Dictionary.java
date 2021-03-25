package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.spellchecker.RichWord;

public class Dictionary { //MODELLO
	
	ArrayList<String> dictionary = new ArrayList<String>();
	
	public void loadDictionary(String language) {
		//lettura del dizionario richiesto
		try {		
			FileReader fr;
			BufferedReader br;
			
			if(language.equals("Italian")) {
				 fr = new FileReader("src/main/resources/Italian.txt");	
				 br = new BufferedReader(fr);
			}
			else{
				 fr = new FileReader("src/main/resources/English.txt");	
				 br = new BufferedReader(fr);
			}
			
			String riga;
			
			while((riga = br.readLine()) != null) {
				dictionary.add(riga);
			}
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		List <RichWord> richWordList = new ArrayList();
		RichWord rw;
		
		for(String s: inputTextList) {
			if(this.dictionary.contains(s))
				 rw = new RichWord(s, true);
			else
				rw = new RichWord(s, false);
			richWordList.add(rw);
		}
		return richWordList;
	}
	
	
}
