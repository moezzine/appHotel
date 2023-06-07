package tn.essat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.essat.model.Livre;
import tn.essat.service.LivreService;

import java.io.IOException;
import java.util.List;

public class LivreServlet extends HttpServlet {
    private LivreService livreService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livre> livres = livreService.afficherLivres();
        request.setAttribute("livres", livres);
        request.getRequestDispatcher("livres.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("ajouter".equals(action)) {
            Livre livre = new Livre();
            livre.setTitre(request.getParameter("titre"));
            livre.setQuantite(Integer.parseInt(request.getParameter("quantite")));
            livre.setPrix(Double.parseDouble(request.getParameter("prix")));
            livreService.ajouterLivre(livre);
        } else if ("supprimer".equals(action)) {
            Long livreId = Long.parseLong(request.getParameter("livreId"));
            livreService.supprimerLivre(livreId);
        } else if ("modifier".equals(action)) {
            Long livreId = Long.parseLong(request.getParameter("livreId"));
            Livre livre = livreService.rechercherLivreParId(livreId);
            livre.setTitre(request.getParameter("titre"));
            livre.setQuantite(Integer.parseInt(request.getParameter("quantite")));
            livre.setPrix(Double.parseDouble(request.getParameter("prix")));
            livreService.modifierLivre(livre);
        }
        response.sendRedirect(request.getContextPath() + "/livres");
    }
}
