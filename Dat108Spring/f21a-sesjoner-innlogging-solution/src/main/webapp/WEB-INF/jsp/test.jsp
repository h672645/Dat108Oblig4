<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h1>Hei, tast inn informasjon om deltageren:</h1>
	<form:form action="lagreDeltager" method="post" modelAttribute="deltager">
		<form:label path="fornavn">Fornavn:</form:label>
		<form:input path="fornavn"/><br>
		<form:errors path="fornavn"></form:errors><br>
		
		<form:label path="etternavn">Etternavn:</form:label>
		<form:input path="etternavn"/><br>
		<form:errors path="etternavn"></form:errors><br>
		
		<form:label path="mobil" type="number">Mobil:</form:label>
		<form:input path="mobil"/><br>
		<form:errors path="mobil"></form:errors><br>
		
		<form:label path="passord">Passord:</form:label>
		<form:input path="passord"/><br>
		<form:errors path="passord"></form:errors><br>
		
		<form:label path="kjonn">Kjonn:</form:label>
		<form:input path="kjonn"/><br>
		<form:errors path="kjonn"></form:errors><br>
		
		<input type="submit" value="Lagre"/>
	</form:form>
</body>
</html>