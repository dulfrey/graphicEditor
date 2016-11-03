/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.commands;

import controler.App;

/**
 *
 * @author Dulfrey
 */
public class RedoCommand extends Command{
    
    
     @Override
    public void execute() {
        App.getInstance().undo();
    }
}
