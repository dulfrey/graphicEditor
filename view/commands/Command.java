/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.commands;

import controler.App;
import model.Drawing.Memento;

/**
 *
 * @author Dulfrey
 */

// se extiende clonable para implementar el patrón prototype
public abstract class Command implements Cloneable{
        private  Memento me;
        public abstract void execute();   

    private  void saveToMemento() {
        this.me = App.getInstance().saveToMemento();
    }
    
    public Memento getMemento(){
        return me;
    }
        
        
}
