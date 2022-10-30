package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.CreditMetierImpl;
import metier.ICredit;

@WebServlet(name="cs", urlPatterns = {"/", "/conrcoleur" ,"*.php"})
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICredit metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CreditMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Lire les données de la requete 
		 */
		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree =  Integer.parseInt(request.getParameter("duree"));
		
		/*
		 * Validé les données 
		 */
		
		/*
		 * Stocker les données saisies dans le model 
		 */
		CreditModel model = new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		/*
		 * Faire appel à la couche métier pour effectuer les traitements 
		 */
		double res = metier.calculerMensualiteCredit(montant, taux, duree);
		
		/*
		 * Stocker les resultats dans le model 
		 */
		model.setMensualite(res);

		/*
		 * Stocker le modèle dans l'objet request
		 */	
		
		request.setAttribute("creditModel", model);
		/*
		 * Faire forword vers la JSP
		 */
		
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
		
		
		
	}
	

}
