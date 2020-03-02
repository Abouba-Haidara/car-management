/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Retourvoiture;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author haida
 */
@Stateless
public class RetourvoitureFacade extends AbstractFacade<Retourvoiture> implements RetourvoitureFacadeLocal {
    @PersistenceContext(unitName = "ProjetLocationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RetourvoitureFacade() {
        super(Retourvoiture.class);
    }

    @Override
    public List<Retourvoiture> all() {
      return em.createQuery("SELECT r FROM Retourvoiture r WHERE r.idLocation IS NOT NULL ", Retourvoiture.class).getResultList();
    }

    @Override
    public List<Retourvoiture> isLocation() {
      return em.createQuery("SELECT r FROM Retourvoiture r JOIN r.idLocation l WHERE r.idLocation IS NOT NULL").getResultList();
    }
    
}
