package it.polito.tdp.totocalcio.model;

//pronostico e' la classe piu' alta e la prima che viene chiamata e in cui inseriamo il pronostico
//e quella da cui bisogna chiamare il metodo che genera tutti i possibili risultati

/*
## Traccia

	Definiamo alcune classi con cui lavorare:

	`RisultatoPartita`: rappresenta un singolo risultato `1`, `2`, `X`

*/

/*
	Le classi enum di eclipse possono solo contenere i valori che gli diamo all’interno 
	e non necessitano di costruttore
	
	Gli enum si usano perche' fissi e non modificabili
 */
public enum RisultatoPartita {
	UNO, DUE, ICS ;
	
	//quando va a confrontare carattere per carattere
	public static RisultatoPartita valueOf(char c) {
		switch(c) {
		case '1':
			return RisultatoPartita.UNO ;
		case '2':
			return RisultatoPartita.DUE ;
		case 'X':
		case 'x':
			return RisultatoPartita.ICS ;
		default:
			throw new IllegalArgumentException("Illegal character "+c+" in string") ;				
		}
	}

	//quando si stampa converte la parola nel numero in stringa
	public String toString() {
		switch(this) {
		case UNO:
			return "1" ;
		case DUE:
			return "2" ;
		case ICS:
			return "X" ;
		}
		return null ;
	}
	
	
}
