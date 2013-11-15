 /*

 Programmering høst 2013
 Obligatorsik Oppgave 4
 Oppgave 4

 Gruppemedlemer:
 Eivind Schulstad	(s198752)
 Gretar Ævarsson		(s198586)
 Sigurd Hølleland	(s198597)

 a) Programmer metoden public void kontrollerReisekort()
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kontrollvindu extends JFrame implements ActionListener
{
  private JTextField kortIdFelt;
  private JTextArea display;
  private JButton kontroll;
  private ReisekortSystem kortsystem;

  public Kontrollvindu(ReisekortSystem r)
  {
    super( "BILLET KONTROLL" );
    kortsystem = r;

		kortIdFelt = new JTextField( 10 );
		display = new JTextArea( 10, 40 );
		display.setEditable(false);
		kontroll = new JButton( "Billet-kontroll" );

    kontroll.addActionListener( this );

    Container c = getContentPane();
    c.setLayout( new FlowLayout() );

    c.add( new JLabel("Reisekortnr: ") );
    c.add( kortIdFelt );
    c.add( kontroll );
    c.add( display );

		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


  public void kontrollerReisekort()
  {
    /*Metoden må lese inn kortets nummer og sjekke om det finnes
      blandt de registrerte kortene. Hvis det finnes og det er gyldig,
      skal følgende gjøre:

      - Hvis det er et klippekort, skal prisen for en reise trekkes fra
      saldoen på kortet. Deretter skal det skrives ut i tekstområde hva
      reisen koster, hva som er saldoen etter at reisen er betalt og hvor
      lenge billetten varer.

      - Hvis det er et dagskort eller et månedskort skal det kun skrives ut
      hvor lenge billetten varer.

      Hvis kortet er ugyldig, skal dette skrives i tekstområdet.
      For klippekort skal i tillegg saldoen skrives ut.

      Hvis kortet er ukjent, skal dette skrives i tekstområdet
    */

        int kortNr = Integer.parseInt(kortIdFelt.getText());
		if( kortsystem.finnReisekort( kortNr ) != null )
		{
			if( ( kortsystem.finnReisekort(kortNr) ).gyldig() )
			{
				if( ( kortsystem.finnReisekort(kortNr )) instanceof Klippekort )
				{
					display.setText("Betalt kr. " + ((Klippekort)(kortsystem.finnReisekort(kortNr) )).PRIS_PER_REISE+".-" );
	                display.append("Saldo: kr. " + ((Klippekort)(kortsystem.finnReisekort(kortNr) )).getSaldo()+".-");
                    display.append("Gyldig til " + ((Klippekort)(kortsystem.finnReisekort(kortNr) )).gyldigTil());
				}
				else
				  display.setText("Gyldig til " + (kortsystem.finnReisekort(kortNr )).gyldigTil());
			}
			else
			{
				if( ( kortsystem.finnReisekort(kortNr )) instanceof Klippekort )
				  display.setText("Kortet er ikke gyldig!\nGjenværende Saldo: " + ((Klippekort)(kortsystem.finnReisekort(kortNr) )).getSaldo() + " kr.");
				else
				  display.setText("Kortet er ikke gyldig!");
			}
	     }
	     else
	       display.setText("Ukjent kort!");
  }


  public void actionPerformed( ActionEvent e )
  {
    if (e.getSource() == kontroll)
    	kontrollerReisekort();
  }

}  // end of class Kontrollvindu