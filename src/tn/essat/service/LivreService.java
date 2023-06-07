package tn.essat.service;

import java.util.List;

import tn.essat.dao.LivreDao;
import tn.essat.model.Livre;

public class LivreService {
    private LivreDao livreDao;

    public void ajouterLivre(Livre livre) {
        livreDao.ajouterLivre(livre);
    }

    public void supprimerLivre(Long livreId) {
        livreDao.supprimerLivre(livreId);
    }

    public List<Livre> afficherLivres() {
        return livreDao.afficherLivres();
    }

    public void modifierLivre(Livre livre) {
        livreDao.modifierLivre(livre);
    }

    public Livre rechercherLivreParId(Long livreId) {
        return livreDao.rechercherLivreParId(livreId);
    }
}
