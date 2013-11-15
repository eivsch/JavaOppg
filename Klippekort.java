/*

Programmering h�st 2013
Obligatorsik Oppgave 4
Oppgave 1b-c

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

b) Programmer klassens konstrukt�r og alle get-metodene
c) Programmer metodene public boolean gyldig() og public void ladOpp( int bel�p )
*/

import java.util.Calendar;

public class Klippekort extends Reisekort
{
  public static final int PRIS_PER_REISE = 28;
  private int saldo;    // bel�pet som til enhver tid er igjen p� klippekortet

  private static int antallSolgte = 0;      // Det totale antall solgte klippekort
  private static int sumAlleKlippekort = 0; // Den totale summen som er satt inn
                                            // p� alle klippekortene til sammen.
	/*
  < Konstrukt�r som mottar det bel�pet som skal settes inn p� kortet
    ved opprettelsen av det. Foruten � s�rge for � initialisere klassens
    datafelt, skal den ogs� s�rge for � oppdatere antall solgte klippekort
    og ikke minst summen det er solgt klippekort for s� langt.
  */
  public Klippekort( int bel�p )
  {
		super( PRIS_PER_REISE );
		antallSolgte++;
		saldo = bel�p;
  	    sumAlleKlippekort += bel�p;
  }


	public int getSaldo()
	{
		return saldo;
	}


	public int getSumAlleKlippekort()
	{
		return sumAlleKlippekort;
	}


	public int getAntallSolgte()
	{
		return antallSolgte;
	}


  public boolean gyldig() // Blir redefinert her!
  {
    /*
    	Metoden kalles hver gang man skal foreta en reise med klippekortet.
      Kortet er gyldig hvis det brukes innen utl�pstidspunktet. (Det er gyldig
      i en time etter at man har betalt.) Hvis kortet brukes etter
      utl�pstidspunktet, skal metoden sjekke om det er nok penger p� kortet
      til � foreta reisen. I s� fall er kortet ogs� gyldig og nytt
      utl�pstidspunkt m� settes i tillegg til at saldoen reduserer.
      Returverdien skal angi utfallet av valideringen.  >
    */
    Calendar n� = Calendar.getInstance();
    if( n�.before( getUtl�pstidspunkt() ))
    	return true;
    else if( saldo >= PRIS_PER_REISE )
		{
			n�.add(Calendar.HOUR_OF_DAY, 1);
			setUtl�pstidspunkt( n� );
			saldo -= PRIS_PER_REISE;
			return true;
		}

		return false;
  }



  public void ladOpp( int bel�p )
  {
    /*
    Metoden over skal �ke saldoen p� kortet med det bel�pet som
    parameteren angir og oppdatere datafeltet sumAlleKlippekort.
    */

    saldo += bel�p;
    sumAlleKlippekort += bel�p;

  }

}  // end of class Klippekort