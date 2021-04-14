package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	// N è il numero di righe e colonne della scacchiera
	//   (righe e colonne numerate da 0 a N-1)
	// ad ogni livello posizioniamo una regina in una nuova riga
	
	// soluzione parziale: lista delle colonne in cui mettere le regine (prime righe)
	// 		List<Integer>
	// livello = quante righe sono già piene
	// livello = 0 => nessuna riga piena (devo mettere la regina nella riga 0)
	// livello = 3 => 3 righe piene (0, 1, 2), devo mettere la regina nella riga 3
	// [0]
	//     [0, 2]
	//            [0, 2, 1]
	
	private int N;
	
	public List<Integer> risolvi(int N){
		this.N=N;
		List<Integer> parziale= new ArrayList<Integer>(); //NO LINKED LIST PERCHè FACCIAMO GET sotto
		cerca(parziale,0);
		return null;
		
	}
	
	private void cerca(List<Integer>parziale, int livello) { //[0,6,4,7]
		if(livello==N) {
			// caso terminale
			System.out.println(parziale);
		} else {
			for(int colonna=0; colonna<N; colonna++) {
				// if la possa nella casella [livello][colonna] è valida
				// se sì, aggiungi a parziale e fai ricorsione
				
				if (posValida(parziale,colonna)) {
					parziale.add(colonna); //aggiungo numero al fondo della lista[0,6,4,7,1 o 5 xxx]
					cerca(parziale,livello+1);//RICORSIONE
					parziale.remove(parziale.size()-1); //BACKTRACKING tolgo dalla lista quello che ho appena provato
				}
			}
		}
	}

	private boolean posValida(List<Integer> parziale, int colonna) {
		int livello=parziale.size();
		//controlla  se viene mangiata in verticale
		if(parziale.contains(colonna))
			return false;
		
		//controllo per diagonale:confronta posizione livello, colonna con (r,c) delle regine esistenti
		//riga + colonna = costante e riga-colonna=k
		
		for(int r=0;r<livello;r++) {
			int c=parziale.get(r);
			
			if(r+c==livello+colonna || r-c==livello-colonna) {
				return false;
			}
		}
		return true;
	}
	
	
	
}
