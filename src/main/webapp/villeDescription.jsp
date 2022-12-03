<%--
  Created by IntelliJ IDEA.
  User: menanteaupierre
  Date: 29/11/2022
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Description d'une ville</title>
</head>
<body>
<h1>Affichage des détails de la ville</h1>
<form method="post" action="ville?codeCommuneInsee=${ville.codeCommuneInsee}" >
    <div>
        <input type="text" id="codeCommuneInsee" name="codeCommuneInsee"
               value="${ville.codeCommuneInsee}"
               placeholder="Code INSEE" disabled>
        <label for="codeCommuneInsee">Code commune INSEE</label>
    </div>
    <div >
        <input type="text" id="newNomCommune" name="newNomCommune" value="${ville.nomCommune}">
        <label for="newNomCommune">Nom commune</label>
    </div>
    <div>
        <input type="text" id="newCodePostal" name="newCodePostal" value="${ville.codePostal}">
        <label for="newCodePostal">Code postal</label>
    </div>
    <div>
        <input type="text" id="newLibelle" name="newLibelle" value="${ville.libelleAcheminement}">
        <label for="newLibelle">Libellé acheminement</label>
    </div>
    <div>
        <input type="text"id="newLigne5" name="newLigne5" value="${ville.ligne5}">
        <label for="newLigne5">Ligne 5</label>
    </div>
    <div>
        <input type="text"id="newLatitude" name="newLatitude" value="${ville.latitude}">
        <label for="newLatitude">Latitude</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text"id="newLongitude" name="newLongitude" value="${ville.longitude}">
        <label for="newLongitude">Longitude</label>
    </div>
    <input type="submit" value="Modifier">
</form>
<a href="villes?page=1"><h5>Retour vers la liste des villes</h5></a>
</body>
</html>
