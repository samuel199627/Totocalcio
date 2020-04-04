package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {
	
	private Pronostico pronostico;
	private int N;
	List<RisultatoPartita> parziale;
	int livello;
	List<Risultato> soluzione;

	//questo metodo richiama il metodo ricorsivo che e' il metodo in basso
	public List<Risultato> cerca(Pronostico pronostico) {
		// TODO Auto-generated method stub
		
		/*
		 	dato il pronostico che abbiamo
			[ "2X", "1", "1X2", "12" ]
			i risultati che andiamo ad ottenere con questo programma sono:
			RISULTATI:
			[X, 1, X, 1]
			[X, 1, X, 2]
			[X, 1, 1, 1]
			[X, 1, 1, 2]
			[X, 1, 2, 1]
			[X, 1, 2, 2]
			[2, 1, X, 1]
			[2, 1, X, 2]
			[2, 1, 1, 1]
			[2, 1, 1, 2]
			[2, 1, 2, 1]
			[2, 1, 2, 2]
			Come facciamo? Si tratta di costruire una struttura ad albero ramificata e uno alla volta esploriamo tutti i rami
			fino alla fine e poi torniamo indietro al nodo precedente per esplorare se c'erano ancora altre strade altrimenti
			torniamo ancora indietro e cosi' via. Noi vogliamo avere tutte le possibili combinazioni.
			
			Al livello zero di ricorsione estraggo il pronostico della prima partita (che e' in posizione zero). Da questo
			scorriamo i singoli risultatiPartita uno alla volta: aggiungiamo alla soluzione parziale il primo risultato partia
			trovato, in questo caso X e poi aggiorniamo il livello e richiamiamo la funzione ricorsiva che con X impostato come
			risultato vincente della prima partita, va a controllare il pronostico messo della seconda partita e rifa' la stessa
			cosa fino all'ultimo livello che per noi e' il terzo (cioe' con l'analisi della quarta partita). La richiamata 
			successiva e' con il livello impostato a 4 che coincide con N, ovvero il numero di partite totali e quindi in
			quel caso sappiamo che la soluzione parziale e' una soluzione finale e andiamo a caricarla nella soluzione come 
			oggetto risultato perche' come soluzione vogliamo una lista di Risultato.
			
			In pratica il livello 4 di ricorsione e' dove il problema non esiste e dunque andiamo ad inserire il possibile 
			risultato nella soluzione che dovra' essere quella restituita quando tutte le chiamate del metodo finiranno.
			
			Inserito il primo risultato
			[X, 1, X, 1]
			nella soluzione, si chiude quella chiamata ricorsiva e quindi ritorniamo indietro nel for in cui vi e' stata 
			l'ultima chiamata e dobbiamo scorrere quindi al prossimo risultatoPartita che era presente (quindi corrispondente
			alla quarta ed ultima partita in cui avevamo appena analizzato 1 e il prossimo e' il 2 in quanto l'ultimo
			pronostico era "12"). Prima di fare cio' occorre pero' eliminare dalla soluzione parziale l'ultimo oggetto dato 
			che ora andiamo ad inserire un altro PronosticoPartita, ma per la stessa partita e cosi' via. Scorrendo sull'altro
			elemento arriveremo di nuovo ad una soluzione finale che ritornera' indietro, chiudera' il for dell'ultima partita
			in quanto abbiamo scorso su tutti gli elementi e torneremo ulteriormente indietro ad altre possibilita' sulla terza 
			partita, che a sua volta richiamera' di nuovo la quarta ecc.
			
			Il livello della ricorsione indica il numero di partite che sto considerando -1.
			Le partite a livelli precedenti sono gia' state decise e considerate, devo 
			decidere quella a livello corrente e quella a liveli successivi le faro' in 
			problemi ricorsivi successivi.
			
			Termino quando ho i livelli pari al numero di partite.
			
			
		 */
		
		//prepariamo l'ambiente in cui la funzione ricorsiva lavora
		this.pronostico=pronostico;
		this.N=pronostico.size();
		parziale=new ArrayList<>();
		livello=0;
		this.soluzione=new ArrayList<>();
		
		ricorsiva(parziale,livello);
		
		
		return this.soluzione;
	}
	
	//questo e' il metodo ricorsivo con quella struttura che si richiama
	private void ricorsiva(List<RisultatoPartita >parziale,int livello) {
		//il livello parte da zero dove decido la prima partita
		//sono in stato terminale?
		if(livello==N) {
			//la soluzione parziale e' ora una soluzione completa in realta'
			//System.out.println(parziale);
			//cloniamo la soluzione parziale che e' corretto rispetto a passare il riferimento
			//in quanto la soluzione parziale noi la continuiamo a modificare e rischieremmo 
			//ripercussioni sulla soluzione.
			//La cloniamo perche' nel costruttore di risultato andiamo a creare una copia degli 
			//oggetti della lista che sono in 'parziale' che sono enum e che quindi non si 
			//modificano (credo).
			this.soluzione.add(new Risultato(parziale));
			
		}
		else {
			//estraggo il pronostico per la partia
			PronosticoPartita pp=pronostico.get(livello);
			
			//ogni volta per livello analizzo le soluzioni possibili andando in profondita' finche' posso
			for(RisultatoPartita ris: pp.getRisultati()) {
				//metto ris nella soluzione parziale in posizione livello
				parziale.add(ris);
				ricorsiva(parziale,livello+1);
				
				//rimetto a posto togliendo l'ultimo che avevo messo per avere tutto
				//a posto per l'iterazione successiva per questo livello
				parziale.remove(parziale.size()-1);
				
			}
				
		}
		
		//non necessario perche' tanto e' un void
		//return;
		
	}

}
