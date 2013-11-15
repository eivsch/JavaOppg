/*

Programmering høst 2013
Obligatorsik Oppgave 4
Oppgave 2

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

a) Programmer klassens konstruktør og metoden public Reisekort finnReisekort(int nr).
b) Programmer metoden public void utvidArray().
c) Programmer metoden public void settInnReisekort(Reisekort k).
d) Programmer metoden public Klippekort ladOppKlippekort( int nr, int beløp ).
e) Programmer metoden public static String inntjeningsInfo().
*/

public class ReisekortSystem
{
  public static final int ANTALL = 100;
  public static final int UTVIDELSE = 10;
  private Reisekort[] reisekortene;

  public ReisekortSystem()
  {
    reisekortene = new Reisekort[ANTALL];
  }

  public Reisekort finnReisekort(int nr)
  {
    /*
    Metoden skal returnere (en referanse/peker til) det reisekortet
    i arrayen som har kortNr lik den innkomne parameteren nr.
    Hvis kortet ikke finnes i arrayen, skal metoden returnere null.>
    */
    for( int i = 0; i < reisekortene.length; i++ )
    {
			if( reisekortene[i] != null )
				if( reisekortene[i].getKortNr() == nr )
					return reisekortene[i];
		}

    return null;
  }


  public void utvidArray()
  {
    /*
    Metoden skal utvide arrayen med så mange elementer som konstanten
    UTVIDELSE angir. Metoden vil bli kalt når det er behov for å utvide
    arrayen i forbindelse med innsetting av et nytt reisekort
    */
    Reisekort[] reisekorteneTEMP = new Reisekort[reisekortene.length];

   	for( int i = 0; i < reisekortene.length; i++ )
			reisekorteneTEMP[i] = reisekortene[i];

		reisekortene = new Reisekort[(reisekortene.length+UTVIDELSE)];

		for( int i = 0; i < reisekorteneTEMP.length; i++ )
			reisekortene[i] = reisekorteneTEMP[i];
  }



  public void settInnReisekort(Reisekort k)
  {
    /*
        Metoden mottar et nytt reisekort som parameter og skal sette dette
		inn på første ledige plass i arrayen, under forutsetning av at det
		ikke finnes et reisekort med samme nr i arrayen fra før.
		Hvis arrayen er full, skal den først utvides med så mange
		elementer som konstanten UTVIDELSE angir, og deretter skal kortet settes inn.
		*/
		boolean full = true;

		for( int i = 0; i < reisekortene.length; i++ )
		{
			if( reisekortene[i] == null )
			{
				full = false;
				break;
			}
		}

		if( full )
		  utvidArray();

		for ( int i = 0; i < reisekortene.length; i++ )
		{
			if( reisekortene[i] == null )
				if( finnReisekort( k.getKortNr() ) == null )
					{
						reisekortene[i] = k;
						break;
					}
		}

	}



  public Klippekort ladOppKlippekort( int nr, int beløp )
  {
    /*Hvis det finnes et klippekort med kortNr lik den innkomne parameteren nr,
      skal metoden øke saldoen på dette kortet med så mye som parameteren
      beløp angir, og deretter returnere (en referanse/peker til) klippekortet.
      Hvis det ikke finnes et slikt klippekort, skal metoden returnere null.
    */

    if( finnReisekort( nr ) != null )
			if( finnReisekort( nr ) instanceof Klippekort )
			{
				Klippekort k = (Klippekort) finnReisekort(nr);
				k.ladOpp(beløp);
				return k;
			}

    return null;
  }



  public static String inntjeningsInfo()
  {
    /*Metoden skal returnere en tekst som inneholder informasjon om hvor mange
      reisekort det er solgt av de forskjellige typene, hvor mye som er tjent inn
      på hver type, og hvor mye som er tjent inn totalt. >
    */

    String utskrift = "";
    int sum, sumKlipp, antKlipp, sumDag, antDag, sumMnd, antMnd;


		Klippekort k = new Klippekort(0);
		antKlipp = k.getAntallSolgte()-1;
		sumKlipp = k.getSumAlleKlippekort();

		Dagskort d = new Dagskort();
		antDag = d.getAntallSolgte()-1;
		sumDag = d.getSumAlleDagskort();

		Månedskort m = new Månedskort();
		antMnd = m.getAntallSolgte()-1;
		sumMnd = m.getSumAlleMånedskort();

		sum = sumKlipp + sumDag + sumMnd;

/*
		for( int i = 0; i < reisekortene.length; i++ )
		{
			if( reisekortene[i] instanceof Klippekort )
			{
				antKlipp = reisekortene[i].getAntallSolgte();
				sumKlipp = reisekortene[i].getSumAlleKlippekort();
				sum += sumKlipp;
				break;
			}
		}

		for( int i = 0; i < reisekortene.length; i++ )
		{
			if( reisekortene[i] instanceof Dagskort )
			{
				antDag = reisekortene[i].getAntallSolgte();
				sumDag = reisekortene[i].getSumAlleKlippekort();
				sum += sumDag;
				break;
			}
		}

		for( int i = 0; i < reisekortene.length; i++ )
		{
			if( reisekortene[i] instanceof Månedskort )
			{
				antMnd = reisekortene[i].getAntallSolgte();
				sumMnd = reisekortene[i].getSumAlleKlippekort();
				sum += sumMnd;
				break;
			}
		}

*/
		utskrift = "Det er solgt kort for kr. " + sum + ".-\n" +
							 "Av disse er det solgt\n" +
							 antKlipp + " klippekort for tilsammen kr. " + sumKlipp + ".-\n" +
							 antDag + " dagskort for tilsammen kr. " + sumDag + ".-\n" +
							 antMnd + " månedskort for tilsammen kr. " + sumMnd + ".-";


		return utskrift;

  }
}  // end of class ReisekortSystem
