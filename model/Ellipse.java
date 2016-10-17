package model;

import java.awt.Color;
import view.BoundBox;
import java.awt.Graphics2D;
/**
 *
 * @author Dulfrey
 */
public class Ellipse extends FigureWithFilling {

    @Override
    protected boolean doEditProperties() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }
private static class Factory extends FigureFactory {

		@Override
		public Figure create() {
			return new Ellipse();
		}
	}

	static {
		FigureFactory.register( 
			Ellipse.class.getName(), new Factory() );
	}
	
	@Override
	protected void drawFilling(Graphics2D g) {

		BoundBox bbox = getBoundBox();
		g.fillOval( bbox.x, bbox.y, bbox.width, bbox.height );
	}

	@Override
	protected void drawBorder(Graphics2D g) {

		BoundBox bbox = getBoundBox();
		g.drawOval( bbox.x, bbox.y, bbox.width, bbox.height );
	}
        
        
        
        
        
}