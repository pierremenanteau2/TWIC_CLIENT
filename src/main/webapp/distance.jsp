<%@ page import="com.example.client2.beans.Ville" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: menanteaupierre
  Date: 03/12/2022
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Distance entre 2 villes</title>
</head>
<body>
<div>
    <h2> Sélection des villes pour calculer la distance </h2>
    <form method="get" style="display: flex;">
        <select class="form-select" aria-label="Choisir une ville" id="v1" name="v1" style="margin: 0 2vw;">
            <% List<String> nameVille = (List<String>) request.getAttribute("nameVille");
                for (String name:nameVille){
            %>
                <option value="<%=name%>"><%=name%></option><% }%>
        </select>
        <select class="form-select" aria-label="Choisir une ville" id="v2" name="v2" style="margin: 0 2vw;">
            <%for (String name:nameVille){
            %>
            <option value="<%=name%>"><%=name%></option><% }%>
        </select>

        <input type="submit" value="Calculer la distance">
    </form>

</div>
<div>
    <c:if test="${!empty distance}">
        <p> La distance entre ${v1.nomCommune} et ${v2.nomCommune} est de ${distance} km</p>
    </c:if>
</div>

</body>
</html>
