package metier;

public interface ICredit {
	
	public abstract double calculerMensualiteCredit(double capital, double taux, int duree);
}
