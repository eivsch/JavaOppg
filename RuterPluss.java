public class RuterPluss
{
	public static void main( String[] args )
	{
		ReisekortSystem r = new ReisekortSystem();
		new Reisekortsalg( r );
		new Kontrollvindu( r );
		new Administrasjonsvindu();
	}
}