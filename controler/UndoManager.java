/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Stack;
import view.commands.Command;
import view.commands.UndoableCommand;

/**
 *
 * @author Dulfrey
 */
public class UndoManager {
    private Stack<UndoableCommand> undo = new Stack<>();
    private Stack<UndoableCommand> redo = new Stack<>();
    
    public void init(){
        
    }
    
    public void addCommand(UndoableCommand c){
        undo.add(c);
    }
    
    public boolean canRedo(){
        return !redo.empty();
    }
    public boolean canUndo(){
        return !undo.empty();
    }
    
    public void undo() {
        if (canUndo()) {
            //saco de undo y lo pongo en redo
            redo.add(undo.pop());
            App.getInstance().restoreFromMemento(redo.peek().getMemento());
            redo.peek().unExecute();
        }
        
        
    }
    public void redo() {
        if (canRedo()) {
            undo.add(redo.pop());
            undo.peek().unExecute();
        }
        
    }
    
}
