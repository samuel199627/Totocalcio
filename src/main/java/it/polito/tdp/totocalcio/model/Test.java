package it.polito.tdp.totocalcio.model;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//vogliamo partire da un pronostico e fornire tutti i risultati possibili
		//tipo pronostico = [ "2X", "1", "1X2", "12" ]
		
		//dentro il pronostico su piu' partite ci sono i pronostici sulle singole partite,
		//che vengono decomposti nei singoli risultati che compongono il pronostico
		Pronostico pronostico= new Pronostico();
		pronostico.add(new PronosticoPartita("2X"));
		pronostico.add(new PronosticoPartita("1"));
		pronostico.add(new PronosticoPartita("1X2"));
		pronostico.add(new PronosticoPartita("12"));
		
		//questa qui sotto stampa
		//[X2, 1, X12, 12] e li stampa non con l'ordine dei singoli caratteri per 
		//questioni dei set in quanto la stringa del singolo pronostico la andiamo
		//a decomporre per poter produrre i possibili risultati vincenti, ma 
		//quello che conta e' solo che i simboli in ogni posizione siano giusti
		System.out.println("PRONOSTICO INSERITO:"); 
		System.out.println(pronostico); 
		
		//quello da fare ora e' implementare una classe che avra' in esso un metodo che dato
		//un pronostico permette di restituire una lista di risultati associati al pronostioco
		//globale su piu' partite che passiamo come parametro
		
		Ricerca r = new Ricerca();
		List<Risultato> risultati=r.cerca(pronostico);
		System.out.println("\nRISULTATI:"); 
		for(Risultato ris:risultati) {
			System.out.println(ris);
		}
		
		

	}

}
