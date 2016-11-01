/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.commands;

import controler.App;
import model.Figure;

/**
 *
 * @author Dulfrey
 */
public class CreateFigure extends Command{
    private  Figure f;
    @Override
    public void execute() {
         App.getInstance().add(f);
    }
    public CreateFigure(Figure f){
        this.f = f;
       saveToMemento();
    }
    
}
