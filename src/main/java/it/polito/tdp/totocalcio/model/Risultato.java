package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;

import java.util.List;

//pronostico e' la classe piu' alta e la prima che viene chiamata e in cui inseriamo il pronostico
//e quella da cui bisogna chiamare il metodo che genera tutti i possibili risultati

/*
 ## Traccia


	Definiamo alcune classi con cui lavorare:


	Risultato`: contiene una sequenza di `N` valori di tipo `RisultatoPartita`
	
	N che sono il numero di partite
 
 */

/**
 * Rappresenta il risultato di una singola giornata (un valore per ciascuna
 * partita)
 * 
 * @author Fulvio
 *
 */
public class Risultato {
	
	//il risultato accorpa tutti i risultati che vanno bene per una giornata quindi mette
	//insieme tutti i singoli risultati che vanno bene per ogni singola partita.
	//E' una delle possibili combinazioni vincenti.

	private List<RisultatoPartita> risultati = new ArrayList<>();

	//costruttore
	public Risultato(String colonna) {
		for (int i = 0; i < colonna.length(); i++) {
			risultati.add(RisultatoPartita.valueOf(colonna.charAt(i)));
		}
	}
	
	//costruttore che serve per il metodo ricerca
	public Risultato(List<RisultatoPartita> risultatoPartita) {
		risultati.addAll(risultatoPartita);
	}
	
	public String toString() {
		return this.risultati.toString() ;
	}

}
