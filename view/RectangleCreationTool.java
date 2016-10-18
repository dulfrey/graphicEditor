/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.App;
import java.awt.Color;
import model.FigureFactory;
import model.Rectangle;

/**
 *
 * @author Dulfrey
 */
public class RectangleCreationTool extends Tool {
    
    @Override
    protected void processMouseReleased() {
        //crear la figura 
        Rectangle l = (Rectangle) FigureFactory.getFigure(Rectangle.class.getName());
        l.setBoundBox(new BoundBox(ptPressed.x, ptPressed.y, ptReleased.x - ptPressed.x ,ptReleased.y - ptPressed.y));
        l.setColor(Color.BLACK);
        // agregar al dibujo
       App.getInstance().add(l);
               
    }
}
