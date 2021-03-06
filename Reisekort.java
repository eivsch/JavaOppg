/*

Programmering h�st 2013
Obligatorsik Oppgave 4
Oppgave 1a

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

a) Fullf�r definisjonen av Reisekort ved � erstatte all pseudo-kode med java-instruksjoner.
*/

import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
  private Calendar utl�pstidspunkt; // Blir tildelt verdi n�r kortet valideres

  private int kortNr;		// et unikt nummer som identifiserer hvert enkelt reisekort >
  private int pris;			// hva kortet koster i hele kroner >
  private int teller = 1; 	// hjelpevariabel for � generere et unikt kortNr

	// konstrukt�r som mottar prisen som parameter og som tildeler reisekortet et unikt kortNr
  public Reisekort( int pris)
  {
		this.pris = pris;
		kortNr = teller++;
  }



	public void setUtl�pstidspunkt( Calendar tidspunkt )
	{
		utl�pstidspunkt = tidspunkt;
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