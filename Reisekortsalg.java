/*

Programmering h�st 2013
Obligatorsik Oppgave 4
Oppgave 5

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/

import java.awt.*;
import javax.swing.*;

public class Reisekortsalg extends JFrame
{
  private static final int KLIPP = 1, DAG = 2, M�NED = 3;
  private JTextField kortNrFelt, betalingsFelt, bel�psFelt;
  private JButton klipp, dag, mnd, ladeknapp;
  private JTextArea info;
  private Lytter lytter;
  //private ReisekortSystem kortsystem;

  //public Reisekortsalg(ReisekortSystem k)
  public Reisekortsalg()
  {
    super("KORTSALG");
    //kortsystem = k;
    lytter =  new Lytter();
    //< oppretter skjermkomponenene >
    kortNrFelt = new JTextField(8);
    betalingsFelt = new JTextField(8);
    bel�psFelt = new JTextField (8);
    betalingsFelt.setEditable(false);

    klipp = new JButton("Klippekort");
    dag = new JButton("Dagskort");
    mnd = new JButton("M�nedskort");
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
    c.add( new JLabel("Bel�p: ") );
    c.add( bel�psFelt );
    c.add( ladeknapp );
    c.add( new JLabel("Reisekortnr: ") );
    c.add( kortNrFelt );
    c.add( new JLabel("Betal kr: ") );
    c.add( betalingsFelt );

    setSize( 345, 200 );
    setVisible( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

  }

  public void nyttReisekort(int type)
  {
    /*
    < Metoden skal foreta et salg av et reisekort av typen parameteren type angir.
      (Se konstantene i skissen av klassen over.) N�r kortet er opprettet og satt
      inn i datasystemet, skal metoden skrive ut kortets nummer i tekstfeltet
      kortNrFelt og prisen som skal betales i tekstfeltet betalingsFelt. >
    */
  }

  public void ladOppKlippekort()
  {
    /*
    < Metoden skal lade opp klippekortet med det bel�pet som brukeren skriver
      inn, under forutsetning av at kortnummerer som oppgis tilh�rer et
      klippekort i datasystemet. I s� fall  skal den nye saldoen skrives ut
      i et dialogvindu (JOptionPane.showMessageDialog(..)), og prisen som skal
      betales skrives i betalingsfeltet. Hvis kortnummeret er feil skal det
      skrives "error" i betalingsfeltet. >
    */
  }

  private class Lytter
  {

	}

} // end of class Reisekortsalg