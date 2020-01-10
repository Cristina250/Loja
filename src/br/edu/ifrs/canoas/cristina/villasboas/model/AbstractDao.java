/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.canoas.cristina.villasboas.model;

import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Cristina S.VilasBoas
 */
public abstract class AbstractDao<T>{
    
    public abstract int delete(T obj);
    
    public abstract int update (T obj);
    
    public abstract int insere (T obj);
    
    public abstract List<T> getAll();
}
