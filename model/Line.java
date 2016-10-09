package model;

import java.awt.Color;
import view.BoundBox;
import java.awt.Graphics2D;

public class Line extends Figure {
 

	@Override
	public void doPaint( Graphics2D g ) {
		
		BoundBox bbox = getBoundBox();
		g.drawLine( bbox.x, bbox.y, bbox.x + bbox.width, bbox.y + bbox.height );
	}
	
	private static class Factory extends FigureFactory {

		@Override	// factory method
		public Figure create() {

			return new Line();
		}

	}
	
	static {
		FigureFactory.register( 
			Line.class.getName(), new Factory() );
	}
	
}
    