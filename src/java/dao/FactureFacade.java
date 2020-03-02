/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Facture;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author haida
 */
@Stateless
public class FactureFacade extends AbstractFacade<Facture> implements FactureFacadeLocal {
    @PersistenceContext(unitName = "ProjetLocationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FactureFacade() {
        super(Facture.class);
    }
    
}
