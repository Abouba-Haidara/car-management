/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author haida
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "ProjetLocationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public Client findClientByMatricule(String matricule) {
      Client client = em.createNamedQuery("Client.findByMatricule", Client.class).setParameter("matricule", matricule).getSingleResult();
      if(client==null) return null;
      return client;
    }
    
}
