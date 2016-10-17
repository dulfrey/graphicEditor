/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Dulfrey
 */
public abstract class  Tool extends MouseAdapter{
    protected Point ptPressed;
    protected Point ptReleased;
    protected abstract void processMouseReleased();
    
    public void mousePressed(MouseEvent e){
        ptPressed = e.getPoint();
    }
    public void mouseReleased(MouseEvent e){
        ptPressed = e.getPoint();
        processMouseReleased();
    }
}
