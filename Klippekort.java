/*

Programmering høst 2013
Obligatorsik Oppgave 4
Oppgave 1b-c

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

b) Programmer klassens konstruktør og alle get-metodene
c) Programmer metodene public boolean gyldig() og public void ladOpp( int beløp )
*/

import java.util.Calendar;

public class Klippekort extends Reisekort
{
  public static final int PRIS_PER_REISE = 28;
  private int saldo;    // beløpet som til enhver tid er igjen på klippekortet

  private static int antallSolgte = 0;      // Det totale antall solgte klippekort
  private static int sumAlleKlippekort = 0; // Den totale summen som er satt inn
                                            // på alle klippekortene til sammen.
	/*
  < Konstruktør som mottar det beløpet som skal settes inn på kortet
    ved opprettelsen av det. Foruten å sørge for å initialisere klassens
    datafelt, skal den også sørge for å oppdatere antall solgte klippekort
    og ikke minst summen det er solgt klippekort for så langt.
  */
  public Klippekort( int beløp )
  {
		super( PRIS_PER_REISE );
		antallSolgte++;
		saldo = beløp;
  	    sumAlleKlippekort += beløp;
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
      Kortet er gyldig hvis det brukes innen utløpstidspunktet. (Det er gyldig
      i en time etter at man har betalt.) Hvis kortet brukes etter
      utløpstidspunktet, skal metoden sjekke om det er nok penger på kortet
      til å foreta reisen. I så fall er kortet også gyldig og nytt
      utløpstidspunkt må settes i tillegg til at saldoen reduserer.
      Returverdien skal angi utfallet av valideringen.  >
    */
    Calendar nå = Calendar.getInstance();
    if( nå.before( getUtløpstidspunkt() ))
    	return true;
    else if( saldo >= PRIS_PER_REISE )
		{
			nå.add(Calendar.HOUR_OF_DAY, 1);
			setUtløpstidspunkt( nå );
			saldo -= PRIS_PER_REISE;
			return true;
		}

		return false;
  }



  public void ladOpp( int beløp )
  {
    /*
    Metoden over skal øke saldoen på kortet med det beløpet som
    parameteren angir og oppdatere datafeltet sumAlleKlippekort.
    */

    saldo += beløp;
    sumAlleKlippekort += beløp;

  }

}  // end of class Klippekort