/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Categoryvoiture;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author haida
 */
@Local
public interface CategoryvoitureFacadeLocal {

    void create(Categoryvoiture categoryvoiture);

    void edit(Categoryvoiture categoryvoiture);

    void remove(Categoryvoiture categoryvoiture);

    Categoryvoiture find(Object id);

    List<Categoryvoiture> findAll();

    List<Categoryvoiture> findRange(int[] range);

    int count();
    
}
