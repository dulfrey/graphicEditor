package model;

import java.awt.Color;
import view.BoundBox;
import java.awt.Graphics2D;

public class Rectangle extends FigureWithFilling {

	
	@Override
	protected void drawFilling(Graphics2D g) {

		BoundBox bbox = getBoundBox();
		g.fillRect( bbox.x, bbox.y, bbox.width, bbox.height );
	}

	@Override
	protected void drawBorder(Graphics2D g) {
            
		BoundBox bbox = getBoundBox();
		g.drawRect( bbox.x, bbox.y, bbox.width, bbox.height );
	}

    @Override
    protected boolean doEditProperties() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

        
        	private static class Factory extends FigureFactory {

		@Override
		public Figure create() {
			return new Rectangle();
		}
	}

	static {
		FigureFactory.register( 
			Rectangle.class.getName(), new Factory() );
	}

}
