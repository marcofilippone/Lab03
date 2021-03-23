package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	List<String> dizIng;
	List<String> dizIta;
	
	public Model() {
		dizIng = new ArrayList<>();
		dizIta = new ArrayList<>();
	}
	
	public void add(String parola, String lingua) {
		if(lingua.equals("ita"))
			dizIta.add(parola);
		else if(lingua.equals("ing"))
			dizIng.add(parola);
	}
	
	
	public boolean esiste(String parola, String lingua) {
		boolean trovato = false;
		if(lingua.equals("italiano")) {
			for(String si : dizIta) {
				if(si.equals(parola))
					trovato = true;
			}
		}
		else if(lingua.equals("english")) {
			for(String si : dizIng) {
				if(si.equals(parola))
					trovato = true;
			}
		}
		return trovato;
	}
	
	
	public void leggiFile(String nomeFile) {
		try {
			FileReader fr = new FileReader(nomeFile);
			BufferedReader br = new BufferedReader(fr);
			String riga;
			while( (riga = br.readLine()) != null ) {
				if(nomeFile.equals("src/main/resources/Italian.txt")) {
					this.add(riga, "ita");
				}
				else if(nomeFile.equals("src/main/resources/English.txt")) {
					this.add(riga, "ing");
				}
			}
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
