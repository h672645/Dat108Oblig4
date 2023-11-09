<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link href="/WEB-INF/jsp/css/simple.css" rel="stylesheet" type="text/css" />
	<script src="/WEB-INF/jsp/js/deltagerDataValidering.js" defer></script>
	<title>Paamelding</title>
</head>

<body>
	<h2>Paamelding</h2>
	<p style="color: red;"><c:out value="${redirectMessage}"/></p>
	<form:form action="lagreDeltager" method="post" modelAttribute="deltager">
		<fieldset>

			<form:label path="fornavn">Fornavn:</form:label>
			<form:input path="fornavn" />
			<form:errors path="fornavn"></form:errors><br>

			<form:label path="etternavn">Etternavn:</form:label>
			<form:input path="etternavn" />
			<form:errors path="etternavn"></form:errors><br>

			<form:label path="mobil" type="number">Mobil:</form:label>
			<form:input path="mobil" />
			<form:errors path="mobil"></form:errors><br>
			
			<form:label path="passord">Passord</form:label> 
			<input type="password" name="passord" value="" /> <label>Passord repetert</label> 
			<input type="password" name="passordRepetert" value="" /> 
			
			<form:label path="kjonn">Kjonn</form:label>
			<input type="radio" name="kjonn" value="mann" />mann 
			<input type="radio" name="kjonn" value="kvinne" />kvinne <br>
			<br>
			<button type="submit">Meld meg paa</button>
		</fieldset>
	</form:form>
</body>
</html>
