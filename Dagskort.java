/*

Programmering høst 2013
Obligatorsik Oppgave 4
Oppgave 1d

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

import java.util.Calendar;

public class Dagskort extends Reisekort
{
  public final static int DAGSPRIS = 75;

  private static int antallSolgte = 0;      // Det totale antall solgte dagskort
  private static int sumAlleDagskort = 0; 	// Den totale summen som er satt inn
                                            // på alle dagskortene til sammen.


  public Dagskort()
  {
		super(DAGSPRIS);
		antallSolgte++;
		sumAlleDagskort += DAGSPRIS;
	}


  public static int getSumAlleDagskort()
  {
		return sumAlleDagskort;
	}


  public static int getAntallSolgte()
  {
		return antallSolgte;
	}


  public boolean gyldig()
  {
    Calendar nå = Calendar.getInstance();
    if( nå.before(getUtløpstidspunkt()) )
    	return true;

		return false;

	}  // redefinert

}  // end of class Dagskort