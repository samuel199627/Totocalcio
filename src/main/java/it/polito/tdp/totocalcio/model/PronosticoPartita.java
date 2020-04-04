package it.polito.tdp.totocalcio.model;

import java.util.HashSet;

//pronostico e' la classe piu' alta e la prima che viene chiamata e in cui inseriamo il pronostico
//e quella da cui bisogna chiamare il metodo che genera tutti i possibili risultati

/*
 
 
 ## Traccia

	Definiamo alcune classi con cui lavorare:

	PronosticoPartita`: contiene un singolo pronostico, che è un `Set` di `RisultatoPartita` (es. `{ 1, X }`)

 	cioe' a lei arriva in ingresso una singola stringa con il pronostico per una partita
 	e noi dobbiamo spezzarla nei vari possibili risultati che attribuiscono a quel pronostico
 	la vittoria e li salviamo dentro risultati.
 
 */
import java.util.Set;

public class PronosticoPartita {
	
	//dentro a questo vettore ci sono i risultati enum e non piu' i numeri che vengono
	//richiamati nel momento della stampa
	private Set<RisultatoPartita> risultati = new HashSet<>();
	
	public PronosticoPartita(String giocata) {
		for(int i=0; i<giocata.length(); i++) {
			risultati.add(RisultatoPartita.valueOf(giocata.charAt(i))) ;
		}
		
	}

	public String toString() {
		String r = "" ;
		for(RisultatoPartita pp: this.risultati) {
			r += pp.toString() ;
		}
		return r ;
	}
	
	public Set<RisultatoPartita> getRisultati() {
		return this.risultati ;
	}
}
