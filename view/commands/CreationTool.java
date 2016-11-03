/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.commands;

import controler.App;
import java.awt.Color;
import model.Figure;
import model.FigureFactory;
import model.Line;
import view.BoundBox;

/**
 *
 * @author Dulfrey
 */
public abstract class CreationTool extends Tool {

    //método abstracto para el template method
    public abstract Figure createFigure();

    @Override
    protected void processMouseReleased() {
        //crear la figura 
        Figure f = createFigure();
        f.setColor( Color.BLACK );
        // agregar al dibujo
        
        App.getInstance().add(f);
        

    }

}
