 /*

 Programmering h�st 2013
 Obligatorsik Oppgave 4
 Oppgave 4

 Gruppemedlemer:
 Eivind Schulstad	(s198752)
 Gretar �varsson		(s198586)
 Sigurd H�lleland	(s198597)

 a) Programmer metoden public void kontrollerReisekort()
*/




< import-setninger >

public class Kontrollvindu < ... >
{
  private JTextField kortIdFelt;
  private JTextArea display;
  private JButton kontroll;
  private ReisekortSystem kortsystem;

  public Kontrollvindu(ReisekortSystem r)
  {
    < kaller superklassens konstrukt�r >

    kortsystem = r;

    < oppretter lytteobjekt og knytter knappen til det. >
    < setter opp brukergrensesnittet >
  }

  public void kontrollerReisekort()
  {
    < Metoden m� lese inn kortets nummer og sjekke om det finnes
      blandt de registrerte kortene. Hvis det finnes og det er gyldig,
      skal f�lgende gj�re:

      - Hvis det er et klippekort, skal prisen for en reise trekkes fra
      saldoen p� kortet. Deretter skal det skrives ut i tekstomr�de hva
      reisen koster, hva som er saldoen etter at reisen er betalt og hvor
      lenge billetten varer.

      - Hvis det er et dagskort eller et m�nedskort skal det kun skrives ut
      hvor lenge billetten varer.

      Hvis kortet er ugyldig, skal dette skrives i tekstomr�det.
      For klippekort skal i tillegg saldoen skrives ut.

      Hvis kortet er ukjent, skal dette skrives i tekstomr�det.>
  }

  < privat lytteklasse >

}  // end of class Kontrollvindu