package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.*;
import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	Partita p1=new Partita();
	Labirinto l1= new Labirinto();
	Partita p2= new Partita();
	Partita p3= new Partita();
	Partita p4= new Partita();
	Partita p5= new Partita();
	Partita p6= new Partita();
	Partita p7= new Partita();
	Partita p8= new Partita();
	Partita p9=new Partita();
	
	@Before
    public void setUp() {
		    
		    
		    //finita0vinta0cfu0
		    this.p2.getGiocatore().setCfu(0); 

		    //finita0vinta1cfu0
		    this.p3.getGiocatore().setCfu(0);
		    this.p3.setStanzaCorrente(this.l1.getStanzaVincente());
		    
		    //finita0vinta0cfu1 (p9)
		    
		    
		    //finita0vinta1cfu1
		    this.p4.setStanzaCorrente(this.l1.getStanzaVincente());
		    
		    //finita1vinta1cfu1
		    this.p5.setFinita();
		    this.p5.setStanzaCorrente(this.l1.getStanzaVincente());
		    
		    //finita1vinta0cfu1
		    this.p6.setFinita();
		    
		    //finita1vinta0cfu0
		    this.p7.setFinita();
		    this.p7.getGiocatore().setCfu(0);
		    
		    //finita1vinta1cfu0
		    this.p8.setFinita();
		    this.p8.getGiocatore().setCfu(0);
		    
		    }
    
   @Test
   public void IsVinta() {
	      assertEquals(false, p1.vinta());
   }
    
    @Test
    public void testFinita0Vinta0Cfu0() {
     	  assertEquals(true, p2.isFinita());
    }
    
    @Test
    public void testFinita0Vinta0Cfu01() {
    	   assertEquals(false, p9.isFinita());
    }
    
    @Test
    public void testFinita0Vinta1Cfu0() {
    	   assertEquals(true, p3.isFinita());
    }
    
    @Test
    public void testFinita0Vinta1Cfu1() {
    	   assertEquals(false, p4.isFinita());
    }
    
    @Test
    public void testFinita1Vinta0Cfu0() {
    	   assertEquals(true, p7.isFinita());
    }
    
    @Test
    public void testFinita1Vinta1Cfu0() {
    	   assertEquals(true, p8.isFinita());
    }
    
    @Test
    public void testFinita1Vinta0Cfu1(){
    	   assertEquals(true, p6.isFinita());
    }
    
    @Test
    public void testFinita1Vinta1Cfu1() {
    	   assertEquals(true, p5.isFinita());
    }
    
	
}
