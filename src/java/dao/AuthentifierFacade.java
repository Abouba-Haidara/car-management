/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Authentifier;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author haida
 */
@Stateless
public class AuthentifierFacade extends AbstractFacade<Authentifier> implements AuthentifierFacadeLocal {
    @PersistenceContext(unitName = "ProjetLocationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthentifierFacade() {
        super(Authentifier.class);
    }

    @Override
    public Authentifier findByEmailPassword(Authentifier utilisateur) {
        try{      
              return em.createQuery("SELECT u FROM Authentifier u WHERE (u.email=:email or u.login=:email) AND u.password=:password", Authentifier.class)
              .setParameter("email", utilisateur.getEmail())
              .setParameter("password", utilisateur.getPassword())
              .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
}
