/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import model.FigureFactory;
import model.Line;

/**
 *
 * @author Dulfrey
 */
public class LineCreationTool extends Tool {

    @Override
    protected void processMouseReleased() {
        //crear la figura 
        Line l = (Line) FigureFactory.getFigure(Line.class.getName());
        l.setBoundBox(new BoundBox(ptPressed.x, ptPressed.y, ptReleased.x,ptReleased.y));
        l.setColor(Color.yellow);
        // agregar al dibujo
        
        
        
    }
    
}
