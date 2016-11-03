/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.omg.CORBA.Bounds;
import view.BoundBox;

/**
 *
 * @author Dulfrey
 */
public class AreaVisitor implements Visitor{
    public double area = 0; 
    @Override
    public void visit(Figure f) {
        BoundBox bbox = f.getBoundBox();
        area += bbox.width * bbox.height;
    }
    
    public double getArea(){
        return area;
    }
    
}
