<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des livres</title>
</head>
<body>
    <h1>Gestion des livres</h1>

    <form action="livres" method="post">
        <input type="hidden" name="action" value="ajouter">
        <label for="titre">Titre :</label>
        <input type="text" name="titre" required>
        <label for="quantite">Quantité :</label>
        <input type="number" name="quantite" required>
        <label for="prix">Prix :</label>
        <input type="number" step="0.01" name="prix" required>
        <input type="submit" value="Ajouter">
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Quantité</th>
            <th>Prix</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${livres}" var="livre">
            <tr>
                <td>${livre.id}</td>
                <td>${livre.titre}</td>
                <td>${livre.quantite}</td>
                <td>${livre.prix}</td>
                <td>
                    <form action="livres" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="supprimer">
                        <input type="hidden" name="livreId" value="${livre.id}">
                        <input type="submit" value="Supprimer">
                    </form>
                    <form action="livres" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="modifier">
                        <input type="hidden" name="livreId" value="${livre.id}">
                        <label for="titre">Titre :</label>
                        <input type="text" name="titre" value="${livre.titre}" required>
                        <label for="quantite">Quantité :</label>
                        <input type="number" name="quantite" value="${livre.quantite}" required>
                        <label for="prix">Prix :</label>
                        <input type="number" step="0.01" name="prix" value="${livre.prix}" required>
                        <input type="submit" value="Modifier">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
