/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Voiture;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author haida
 */
@Stateless
public class VoitureFacade extends AbstractFacade<Voiture> implements VoitureFacadeLocal {
    @PersistenceContext(unitName = "ProjetLocationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VoitureFacade() {
        super(Voiture.class);
    }

    @Override
    public List<Voiture> availables(int st) {
     return em.createNamedQuery("Voiture.findByStatutretour", Voiture.class).setParameter("statutretour", st).getResultList();
    }
    
}
