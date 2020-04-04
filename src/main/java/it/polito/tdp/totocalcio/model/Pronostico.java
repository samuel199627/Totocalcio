package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;

import java.util.List;

//e' la classe piu' alta e la prima che viene chiamata e in cui inseriamo il pronostico
//e quella da cui bisogna chiamare il metodo che genera tutti i possibili risultati

/*
 ## Traccia

	Definiamo alcune classi con cui lavorare:

	Pronostico`: contiene una sequenza di `N` oggetti `PronosticoPartita`  
 */

public class Pronostico {
	private List<PronosticoPartita> pronostici = new ArrayList<>() ;
	
	public Pronostico() {
		
	}
	
	public void add(PronosticoPartita pp) {
		this.pronostici.add(pp) ;
	}
	
	public void add(String pp) {
		this.pronostici.add(new PronosticoPartita(pp)) ;
	}

	public String toString() {
		return this.pronostici.toString() ;
	}
	
	public int size() {
		return this.pronostici.size() ;
	}

	public PronosticoPartita get(int i) {
		return this.pronostici.get(i) ;
	}
	
}
