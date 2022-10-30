<%@page import="web.CreditModel"%>
<%
	CreditModel model = (CreditModel)request.getAttribute("creditModel");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<title>Crédit bancaire</title>
		<meta charset="utf-8">
	</head>
	<body>
		<div>
			<form action="calculerMensualite.do" method="post">
			<table class="table" style="width: 50%">
				  <tbody>
				    <tr>
				      <td><label class="col-form-label">Montant:</label></td>
				      <td><input value=<%=model.getMontant()%> type="text" name="montant" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline"><span id="passwordHelpInline" class="form-text">
				      DH.
				    </span></td>
				    </tr>
				    <tr>
				      <td><label class="col-form-label">Taux:</label></td>
				      <td><input value=<%=model.getTaux()%> type="text" name="taux" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline"><span id="passwordHelpInline" class="form-text">
				      %.
				    </span></td>
				    </tr>
				    <tr>
				      <td><label class="col-form-label">Durée:</label></td>
				      <td><input value=<%=model.getDuree()%> type="text" name="duree" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline"><span id="passwordHelpInline" class="form-text">
				      Mois.
				    </span></td>
				    </tr>
				  </tbody>
				</table>																
							<button type="submit" class="btn btn-primary">Calculer</button>	
			</form>
		</div>
		<p></p>
		<div>
			Mensualité  = <%=model.getMensualite()%>
		</div>
		
		
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</body>
</html>