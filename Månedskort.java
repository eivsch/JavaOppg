/*

Programmering h�st 2013
Obligatorsik Oppgave 4
Oppgave 1

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/
import java.util.Calendar;

public class M�nedskort extends Reisekort
{
  public final static int M�NEDSPRIS = 1040;
  private static int sumAlleM�nedskort;
  private static int antallSolgte;

  public M�nedskort(int pris, int kortNr)
  {
	  super(pris, kortNr);
	  sumAlleM�nedskort += pris;
      antallSolgte++;
  }

  public static int getSumAlleM�nedskort()
  {
	  return sumAlleM�nedskort;
  }

  public static int getAntallSolgte()
  {
	  return antallSolgte;
  }

  public boolean gyldig()
  {
	  Calendar n� = Calendar.getInstance();
	  if(n�.before(getUtl�pstidspunkt() ) )
	    return true;

	  return false;
  }

}  // end of class M�nedskort