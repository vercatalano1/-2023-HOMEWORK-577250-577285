package it.uniroma3.diadia;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO
 *         (da un'idea di Michael Kolling and David J. Barnes)
 *
 * @version base
 */


public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	public static IOConsole messaggio;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		
		messaggio.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do
		  istruzione=messaggio.leggiRiga();
		while(!processaIstruzione(istruzione));
		
	}


	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
        if(comandoDaEseguire.getNome()==null)
           return false;
        else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			 this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			 this.posa(comandoDaEseguire.getParametro());
		else
			messaggio.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			messaggio.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}

	// implementazioni dei comandi dell'utente:
    private void prendi(String nomeAttrezzo) {
    	if(nomeAttrezzo!=null) {
    		   if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)==true) {
    	       Attrezzo app=this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo); 
    	       this.partita.getGiocatore().getBorsa().addAttrezzo(app);
    	       messaggio.mostraMessaggio("Attrezzo aggiunto in borsa!");
               this.partita.getStanzaCorrente().removeAttrezzo(app);
    	       messaggio.mostraMessaggio("Attrezzo rimosso correttamente dalla Stanza!");
    	       }
    		   else
    			   messaggio.mostraMessaggio("non esiste questo attrezzo nella stanza");
    	    }
    	else
    		messaggio.mostraMessaggio("attrezzo non esistente!");
    	}
    
    
    private void posa(String nomeAttrezzo) {
    	if(nomeAttrezzo!=null) {
 		   if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)==true) {
 	       Attrezzo app=this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo); 
 	       this.partita.getStanzaCorrente().addAttrezzo(app);
 	       messaggio.mostraMessaggio("Attrezzo aggiunto in stanza!");
            this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
 	       messaggio.mostraMessaggio("Attrezzo rimosso correttamente dalla borsa!");
 	       }
 		   else
 			   messaggio.mostraMessaggio("non esiste questo attrezzo nella borsa");
 	    }
 	else
 		messaggio.mostraMessaggio("attrezzo non esistente!");
 	}
    
    
    
	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++)
			messaggio.mostraMessaggio(elencoComandi[i]+" ");
		messaggio.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			messaggio.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			messaggio.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		messaggio.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/*.
	 * Comando "Fine".
	 */
	private void fine() {
		messaggio.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		messaggio =new IOConsole();
		DiaDia gioco = new DiaDia();
		
		gioco.gioca();
	}
}
