
package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	private Labirinto l1;
	private Stanza stanzaCorrente;
	private boolean finita;
	private Giocatore giocatore;

	public Partita(){
		this.l1=new Labirinto();
		this.finita = false;
		this.stanzaCorrente= this.l1.getStanzaCorrente();
		this.giocatore=new Giocatore();
	}

    
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita 
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.l1.getStanzaVincente();
	}
	

	/**
	 * 
	 * @return restituisce la stanza corrente
	 */
		public Stanza getStanzaCorrente() {
			return this.stanzaCorrente ;
		}
		
		
		public void setStanzaCorrente(Stanza prossimaStanza) {
			this.stanzaCorrente=prossimaStanza;
			
		}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu()== 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/**
	 * 
	 * @return il giocatore
	 */
		public Giocatore getGiocatore(){
			return giocatore;
		}
}
