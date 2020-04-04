package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;

import java.util.List;

/*
 ## Traccia

	Definiamo alcune classi con cui lavorare:


	Risultato`: contiene una sequenza di `N` valori di tipo `RisultatoPartita`
	
	N che sono il numero di partite
 
 */

/**
 * Rappresenta il risultato di una singola partita (un valore per ciascuna
 * partita)
 * 
 * @author Fulvio
 *
 */
public class Risultato {

	private List<RisultatoPartita> risultati = new ArrayList<>();

	//costruttore
	public Risultato(String colonna) {
		for (int i = 0; i < colonna.length(); i++) {
			risultati.add(RisultatoPartita.valueOf(colonna.charAt(i)));
		}
	}
	
	public String toString() {
		return this.risultati.toString() ;
	}

}
