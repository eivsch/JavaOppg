/*

Programmering h�st 2013
Obligatorsik Oppgave 4
Oppgave 3

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)


a) Programmer vindusklassen Administrasjonsvindu, slik at vinduet blir seende ut
   som p� bildet. Klassen skal v�re sin egen lytteklasse og programmeres slik at
   n�r du klikker p� knappen "Salgsinformasjon" blir den informasjonen som
   returneres fra inntjeningsInfo()-metoden i klassen ReisekortSystem vist i tekstomr�det.
*/


import javax.swing.*;
import java.awt.*;

public class Administrasjonsvindu extends JFrame
{
	private JButton salgsInfo;
	private JTextArea adm;

	public Administrasjonsvindu()
	{
		super("ADMINISTRASJON");
		salgsInfo = new JButton("Salgsinformasjon");
		adm = new JTextArea(8,35);
		adm.setEditable(false);

		Container c = getContentPane();
		c.add

	}
}