package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculeMensualité {
	private ICredit metier;

	@Before
	public void setUp() throws Exception {
		metier = new CreditMetierImpl();
	}

	@Test
	public void testCalculerMensualiteCredit() {
		double capitale = 200000;
		int duree = 240;
		double taux = 4.5;
		
		double resultatAttendu = 1265.29875;
		
		double resCalcule = metier.calculerMensualiteCredit(capitale, taux, duree);
		
		assertEquals(resultatAttendu, resCalcule, 0.0001);
		
	}

}
