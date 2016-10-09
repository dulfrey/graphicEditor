/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dulfrey
 */
public class Group extends Figure{
    private List<Figure> children;
    
    public Group(final List<Figure> children){
        this.children = children;
    }
    public Iterator<Figure> getFigures(){
        return children.iterator();
    }
    
    @Override
    protected void doPaint(Graphics2D g) {
        for (Figure f : children) {
            f.paint(g);
            
        }
    }
    
    
}
