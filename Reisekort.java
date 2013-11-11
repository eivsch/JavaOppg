/*

Programmering høst 2013
Obligatorsik Oppgave 4
Oppgave 1a

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
  private Calendar utløpstidspunkt; // Blir tildelt verdi når kortet valideres

  private int kortNr;		// et unikt nummer som identifiserer hvert enkelt reisekort >
  private int pris;			// hva kortet koster i hele kroner >
  private int teller; 	// hjelpevariabel for å generere et unikt kortNr

  public Reisekort( int pris, int kortNr )
  {
		this.pris = pris;
		this.kortNr = kortNr;
	}



	public void setUtløpstidspunkt( Calendar tidpunkt )
	{
		utløpstidspunkt = tidpunkt;
	}



	public int getKortNr()
	{
		return kortNr;
	}



	public int getPris()
	{
		return pris;
	}



	public Calendar getUtløpstidspunkt()
	{
		return utløpstidspunkt;
	}



  public String gyldigTil()
  {
     if ( utløpstidspunkt == null )
       return null;

     DateFormat tf = DateFormat.getDateTimeInstance
                  ( DateFormat.LONG, DateFormat.MEDIUM );

     return tf.format(utløpstidspunkt.getTime());
  }



  public boolean gyldig() // Metoden vil bli redefinert av subklassene
  {
     Calendar nå = Calendar.getInstance();
     return nå.before( utløpstidspunkt );
  }

}  // end of class Reisekort