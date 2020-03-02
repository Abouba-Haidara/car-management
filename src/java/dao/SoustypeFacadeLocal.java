/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Soustype;
import entities.Type;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author haida
 */
@Local
public interface SoustypeFacadeLocal {

    void create(Soustype soustype);

    void edit(Soustype soustype);

    void remove(Soustype soustype);

    Soustype find(Object id);

    List<Soustype> findAll();

    List<Soustype> findRange(int[] range);

    int count();

    public Soustype findByCetteMarque(Type type);
    
}
