/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Authentifier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author haida
 */
@Local
public interface AuthentifierFacadeLocal {

    void create(Authentifier authentifier);

    void edit(Authentifier authentifier);

    void remove(Authentifier authentifier);

    Authentifier find(Object id);

    List<Authentifier> findAll();

    List<Authentifier> findRange(int[] range);

    int count();

    public Authentifier findByEmailPassword(Authentifier utilisateur);
    
}
