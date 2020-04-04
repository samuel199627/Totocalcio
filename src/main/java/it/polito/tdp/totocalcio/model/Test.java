package it.polito.tdp.totocalcio.model;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//vogliamo partire da un pronostico e fornire tutti i risultati possibili
		//tipo pronostico = [ "2X", "1", "1X2", "12" ]
		
		Pronostico pronostico= new Pronostico();
		pronostico.add(new PronosticoPartita("2X"));
		pronostico.add(new PronosticoPartita("1"));
		pronostico.add(new PronosticoPartita("1X2"));
		pronostico.add(new PronosticoPartita("12"));
		
		System.out.println(pronostico);

	}

}
