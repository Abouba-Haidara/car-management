/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Soustype;
import entities.Type;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author haida
 */
@Stateless
public class SoustypeFacade extends AbstractFacade<Soustype> implements SoustypeFacadeLocal {
    @PersistenceContext(unitName = "ProjetLocationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoustypeFacade() {
        super(Soustype.class);
    }

    @Override
    public Soustype findByCetteMarque(Type type) {
      return em.createQuery("SELECT st FROM Type t JOIN t.idtype t WHERE t.id=:idtype", Soustype.class).setParameter("idtype", type.getId()).getSingleResult();
              
              
    }
    
}
