/*

Programmering høst 2013
Obligatorsik Oppgave 4
Oppgave 1

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/
import java.util.Calendar;

public class Månedskort extends Reisekort
{
  public final static int MÅNEDSPRIS = 1040;
  private static int sumAlleMånedskort;
  private static int antallSolgte;

  public Månedskort(int pris, int kortNr)
  {
	  super(pris, kortNr);
	  sumAlleMånedskort += pris;
      antallSolgte++;
  }

  public static int getSumAlleMånedskort()
  {
	  return sumAlleMånedskort;
  }

  public static int getAntallSolgte()
  {
	  return antallSolgte;
  }

  public boolean gyldig()
  {
	  Calendar nå = Calendar.getInstance();
	  if(nå.before(getUtløpstidspunkt() ) )
	    return true;

	  return false;
  }

}  // end of class Månedskort