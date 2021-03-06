
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
<title>Olympic medals</title>
</head>
<body>
	<h1>Olympic medals</h1>
	<section>
		<form method="POST" id="medalform" action="/supreme-telegram/MedalServlet">
			<input type="text" placeholder="Country" name="country">
			<input type="text" placeholder="Sport" name="sport">
			<select name="medal" form="medalform">
				<option>Gold</option>
				<option>Silver</option>
				<option>Bronze</option>
			</select>
			<input type="submit" value="submit">
		</form>
	</section>
	
	<table>
	<thead>
		<td>Land</td>
		<td>Aantal medailles</td>
	</thead>
	<tbody>

		<c:forEach var="country" items="${countries}">
			<tr>
			<td>${country.name}</td>
			<td>${country.numberOfMedals}</td>
	</tr>
		</c:forEach>

	</tbody>
	</table>
</body>
</html>