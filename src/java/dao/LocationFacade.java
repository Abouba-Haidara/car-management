/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Location;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author haida
 */
@Stateless
public class LocationFacade extends AbstractFacade<Location> implements LocationFacadeLocal {
    @PersistenceContext(unitName = "ProjetLocationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocationFacade() {
        super(Location.class);
    }

    @Override
    public List<Location> searchByIntValdate(Date datedebut, Date datefin) {
     try{
          return em.createQuery("SELECT l FROM Location l JOIN  l.idvoiture  v JOIN l.idClient c  WHERE ( l.datedebut BETWEEN :d1 AND :d2 ) or ( l.dateretour BETWEEN :d1 AND :d2 )")
                .setParameter("d1", datedebut)
                .setParameter("d2", datefin)
                .getResultList();
        }  catch(Exception e){
            e.getStackTrace();
            return null;
        }  
    }

    @Override
    public List<Location> findAllLists() {
       return  em.createQuery("SELECT l FROM Location l  ORDER BY l.dateLocation DESC", Location.class).getResultList();
    }

    @Override
    public List<Location> findByMoclet(String motclet) {
       return em.createQuery("SELECT l FROM Location l WHERE l.idvoiture.idtype.designation LIKE '%:motclet%'", Location.class).setParameter("motclet", motclet).getResultList();
    }
    
}
