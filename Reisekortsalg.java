/*

Programmering høst 2013
Obligatorsik Oppgave 4
Oppgave 5

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reisekortsalg extends JFrame
{
  private static final int KLIPP = 1, DAG = 2, MÅNED = 3;
  private JTextField kortNrFelt, betalingsFelt, beløpsFelt;
  private JButton klipp, dag, mnd, ladeknapp;
  private JTextArea info;
  private Lytter lytter;
  private ReisekortSystem kortsystem;

  public Reisekortsalg(ReisekortSystem k)
  {
    super("KORTSALG");
    //kortsystem = k;
    lytter =  new Lytter();
    //< oppretter skjermkomponenene >
    kortNrFelt = new JTextField(8);
    betalingsFelt = new JTextField(8);
    beløpsFelt = new JTextField (8);
    betalingsFelt.setEditable(false);

    klipp = new JButton("Klippekort");
    dag = new JButton("Dagskort");
    mnd = new JButton("Månedskort");
    ladeknapp = new JButton("Opplading av klippekort");

    info = new JTextArea(3, 30);
    info.setEditable(false);
		/*
    klipp.addActionListener(lytter);
    dag.addActionListener(lytter);
    mnd.addActionListener(lytter);
    ladeknapp.addActionListener( lytter );
    */
    //< setter opp brukergrensesnittet. >

    Container c = getContentPane();
    c.setLayout( new FlowLayout() );

    c.add( info );
    c.add( klipp );
    c.add( dag );
    c.add( mnd );
    c.add( new JLabel("Beløp: ") );
    c.add( beløpsFelt );
    c.add( ladeknapp );
    c.add( new JLabel("Reisekortnr: ") );
    c.add( kortNrFelt );
    c.add( new JLabel("Betal kr: ") );
    c.add( betalingsFelt );

    setSize( 345, 200 );
    setVisible( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

    kortsystem = k;

  }

  public void nyttReisekort(int type)
  {
    /*
    < Metoden skal foreta et salg av et reisekort av typen parameteren type angir.
      (Se konstantene i skissen av klassen over.) Når kortet er opprettet og satt
      inn i datasystemet, skal metoden skrive ut kortets nummer i tekstfeltet
      kortNrFelt og prisen som skal betales i tekstfeltet betalingsFelt. >
    */

    if(type == 1)
    {
		Klippekort kp = new Klippekort(Integer.parseInt(beløpsFelt.getText()));
		kortsystem.settInnReisekort(kp);
		kortNrFelt.setText("" + kp.getKortNr());
		betalingsFelt.setText("" +kp.getSaldo());
	}
    else if(type == 2)
    {
		Dagskort dk = new Dagskort();
		kortsystem.settInnReisekort(dk);
		kortNrFelt.setText("" + dk.getKortNr());
		betalingsFelt.setText("" + dk.getPris());
	}
    else
    {
		Månedskort mk = new Månedskort();
		kortsystem.settInnReisekort(mk);
		kortNrFelt.setText("" + mk.getKortNr());
		betalingsFelt.setText("" + mk.getPris());
	}
  }

  public void ladOppKlippekort()
  {
    /*
    < Metoden skal lade opp klippekortet med det beløpet som brukeren skriver
      inn, under forutsetning av at kortnummerer som oppgis tilhører et
      klippekort i datasystemet. I så fall  skal den nye saldoen skrives ut
      i et dialogvindu (JOptionPane.showMessageDialog(..)), og prisen som skal
      betales skrives i betalingsfeltet. Hvis kortnummeret er feil skal det
      skrives "error" i betalingsfeltet. >
    */

    int beløp = Integer.parseInt(beløpsFelt.getText());
    if( ( kortsystem.finnReisekort(Integer.parseInt(kortNrFelt.getText())) != null ) && ( kortsystem.finnReisekort(Integer.parseInt(kortNrFelt.getText())) instanceof Klippekort ) )
    {
		((Klippekort)(kortsystem.finnReisekort(Integer.parseInt(kortNrFelt.getText())))).ladOpp(beløp);
	}

   }

  private class Lytter implements ActionListener
  {
	  public void actionPerformed(ActionEvent e)
	  {
	    if(e.getSource () == klipp)
	      nyttReisekort(KLIPP);
	    if(e.getSource() == ladeknapp)
	      ladOppKlippekort();
	  }

  }//end of class Lytter

} // end of class Reisekortsalg