/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.commands;

import controler.App;
import java.awt.Color;
import model.FigureFactory;
import model.Line;
import view.BoundBox;

/**
 *
 * @author Dulfrey
 */

public class LineCreationTool extends Tool {

    @Override
    protected void processMouseReleased() {
        //crear la figura 
        Line l = (Line) FigureFactory.getFigure(Line.class.getName());
        l.setBoundBox(new BoundBox(ptPressed.x, ptPressed.y, ptReleased.x - ptPressed.x ,ptReleased.y - ptPressed.y));
        l.setColor(Color.BLACK);
        // agregar al dibujo
      Command create = new CreateFigure(l);
      create.execute();
               
    }
    
}
