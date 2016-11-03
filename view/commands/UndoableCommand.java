/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.commands;

import controler.App;
import model.Drawing;

/**
 *
 * @author Dulfrey
 */
public class UndoableCommand extends Command {
    private  Drawing.Memento me;
   
    @Override
    public void execute() {
        
    }
    
     protected  void saveToMemento() {
        this.me = App.getInstance().saveToMemento();
    }
    
    public Drawing.Memento getMemento(){
        return me;
    }

    public void unExecute() {
        App.getInstance().undo(this);
    }
    
    
    
}
