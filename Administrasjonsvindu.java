/*

Programmering høst 2013
Obligatorsik Oppgave 4
Oppgave 4

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)


a) Programmer vindusklassen Administrasjonsvindu, slik at vinduet blir seende ut
   som på bildet. Klassen skal være sin egen lytteklasse og programmeres slik at
   når du klikker på knappen "Salgsinformasjon" blir den informasjonen som
   returneres fra inntjeningsInfo()-metoden i klassen ReisekortSystem vist i tekstområdet.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Administrasjonsvindu extends JFrame implements ActionListener
{
	private JButton salgsInfo;
	private JTextArea adm;


	public Administrasjonsvindu()
	{
		super("ADMINISTRASJON");
		salgsInfo = new JButton("Salgsinformasjon");
		adm = new JTextArea(7,45);
		adm.setEditable(false);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(salgsInfo);
		c.add(adm);

		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


  public void actionPerformed( ActionEvent e )
  {
    if (e.getSource() == salgsInfo)
    {
			ReisekortSystem r = new ReisekortSystem();
			adm.setText("");
			adm.setText( r.inntjeningsInfo() );
		}
	}

}	// end of class Administrasjonsvindu