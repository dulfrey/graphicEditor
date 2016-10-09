package model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

public abstract class FigureWithThickness extends Figure {

	// Template Method
	protected abstract void doDraw(Graphics2D g);

	private float thickness;
	
	protected float getThickness() {
		return thickness;
	}

	public void setThickness( final float thickness) {
		this.thickness = thickness;
	}

	@Override
	protected void doPaint(Graphics2D g) {
		
		Stroke stroke = new BasicStroke( thickness );
		g.setStroke(stroke);
		
		doDraw( g );
	}
}
