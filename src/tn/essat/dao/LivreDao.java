package tn.essat.dao;

import java.util.List;


import tn.essat.model.Livre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
public class LivreDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void ajouterLivre(Livre livre) {
        entityManager.persist(livre);
    }

    public void supprimerLivre(Long livreId) {
        Livre livre = entityManager.find(Livre.class, livreId);
        if (livre != null) {
            entityManager.remove(livre);
        }
    }

    public List<Livre> afficherLivres() {
        String query = "SELECT * FROM livre ";
        return entityManager.createQuery(query, Livre.class).getResultList();
    }

    public void modifierLivre(Livre livre) {
        entityManager.merge(livre);
    }

    public Livre rechercherLivreParId(Long livreId) {
        return entityManager.find(Livre.class, livreId);
    }
}



