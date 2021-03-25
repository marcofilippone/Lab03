package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
			/*for(String si : dizIta) {
				if(si.equals(parola))
					trovato = true;
			}*/
			if(dizIta.contains(parola))
				trovato=true;
			/*int i = dizIta.size();
			i = (int) dizIta.size()/2;
			List<String> pezzo = dizIta;
			while(i!=0) {
				if(pezzo.get(i).compareTo(parola)==0) {
					trovato=true;
					return trovato;
				}
				else if(pezzo.get(i).compareTo(parola)<0) {
					pezzo = pezzo.subList(i, pezzo.size());
					i = (int) pezzo.size()/2;
				}
				else {
					pezzo = pezzo.subList(0, i+1);
					i = (int) pezzo.size()/2;
				}
			}*/
		}
		else if(lingua.equals("english")) {
			/*for(String si : dizIng) {
				if(si.equals(parola))
					trovato = true;
			}*/
			if(dizIng.contains(parola))
				trovato=true;
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
