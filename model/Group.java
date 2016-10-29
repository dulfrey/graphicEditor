/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;
import view.BoundBox;

/**
 *
 * @author Dulfrey
 */

public class Group extends Figure {

	public Group( final List<Figure> children ) {
		
		this.children = children;
               
	}

	@Override
	protected void doPaint( final Graphics2D g ) {
		for ( Figure f : children ) {
			f.paint( g );
		}
	}

	@Override
	protected boolean  doEditProperties() {
		// TODO
                return true;
	}
        //16. Iterator 
	public Iterator<Figure> getChildren() {
		return children.iterator();
	}

	
	
	private List<Figure> children;
}