/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Retourvoiture;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author haida
 */
@Local
public interface RetourvoitureFacadeLocal {

    void create(Retourvoiture retourvoiture);

    void edit(Retourvoiture retourvoiture);

    void remove(Retourvoiture retourvoiture);

    Retourvoiture find(Object id);

    List<Retourvoiture> findAll();

    List<Retourvoiture> findRange(int[] range);

    int count();

    public List<Retourvoiture> all();

    public List<Retourvoiture> isLocation();
    
}
