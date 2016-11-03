/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.commands;

import view.commands.Tool;
import view.commands.Command;
import controler.App;
import view.Canvas;

/**
 *
 * @author Dulfrey
 */
public class SetActiveTool extends Command {
   
    private  int tool;

    @Override
    public void execute() {
        App.getInstance().setActiveTool(tool);
    }
    public SetActiveTool(int thetool){
        this.tool = thetool;
    }
    
}
