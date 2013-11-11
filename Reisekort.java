/*

Programmering h�st 2013
Obligatorsik Oppgave 4
Oppgave 1a

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/

import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
  private Calendar utl�pstidspunkt; // Blir tildelt verdi n�r kortet valideres

  private int kortNr;		// et unikt nummer som identifiserer hvert enkelt reisekort >
  private int pris;			// hva kortet koster i hele kroner >
  private int teller; 	// hjelpevariabel for � generere et unikt kortNr

  public Reisekort( int pris, int kortNr )
  {
		this.pris = pris;
		this.kortNr = kortNr;
	}



	public void setUtl�pstidspunkt( Calendar tidpunkt )
	{
		utl�pstidspunkt = tidpunkt;
	}



	public int getKortNr()
	{
		return kortNr;
	}



	public int getPris()
	{
		return pris;
	}



	public Calendar getUtl�pstidspunkt()
	{
		return utl�pstidspunkt;
	}



  public String gyldigTil()
  {
     if ( utl�pstidspunkt == null )
       return null;

     DateFormat tf = DateFormat.getDateTimeInstance
                  ( DateFormat.LONG, DateFormat.MEDIUM );

     return tf.format(utl�pstidspunkt.getTime());
  }



  public boolean gyldig() // Metoden vil bli redefinert av subklassene
  {
     Calendar n� = Calendar.getInstance();
     return n�.before( utl�pstidspunkt );
  }

}  // end of class Reisekort