/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Voiture;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author haida
 */
@Local
public interface VoitureFacadeLocal {

    void create(Voiture voiture);

    void edit(Voiture voiture);

    void remove(Voiture voiture);

    Voiture find(Object id);

    List<Voiture> findAll();

    List<Voiture> findRange(int[] range);

    int count();

    public List<Voiture> availables(int st);
    
}
