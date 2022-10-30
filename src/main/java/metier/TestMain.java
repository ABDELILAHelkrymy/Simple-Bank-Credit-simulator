package metier;

public class TestMain {

	public static void main(String[] args) {
		ICredit metier = new CreditMetierImpl();
		
		System.out.println(metier.calculerMensualiteCredit(200000, 4.5, 240));

	}

}
