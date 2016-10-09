package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import model.Shape;

public class BoundBox extends Rectangle implements Shape {
	
	private static final long serialVersionUID = 1L;

	public BoundBox( int x, int y, int w, int h ) {
		super( x, y, w, h );
	}

	public BoundBox(BoundBox boundBox) {
		super(boundBox);
	}

	@Override
	public void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.drawRect(x,y,width,height);
		g.setColor(Color.BLACK);
	}

	public BoundBox normalized() {
		BoundBox nbox = new BoundBox( this );
		return nbox.normalize();
	}

	public BoundBox normalize() {
		if ( width < 0 ) {
			
			width *= -1;
			x -= width;
		}

		if ( height < 0 ) {
			
			height *= -1;
			y -= height;
		}
		return this;
	}
}
