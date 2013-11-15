public class RuterPluss
{
	public static void main( String[] args )
	{
		new Reisekortsalg( new ReisekortSystem() );
		new Kontrollvindu(new ReisekortSystem());
		new Administrasjonsvindu();
	}
}