/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Penalisation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author haida
 */
@Local
public interface PenalisationFacadeLocal {

    void create(Penalisation penalisation);

    void edit(Penalisation penalisation);

    void remove(Penalisation penalisation);

    Penalisation find(Object id);

    List<Penalisation> findAll();

    List<Penalisation> findRange(int[] range);

    int count();
    
}
