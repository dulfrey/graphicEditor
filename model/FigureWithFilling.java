package model;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class FigureWithFilling extends FigureWithThickness {

	// Template Method
	protected abstract void drawFilling( Graphics2D g );
	protected abstract void drawBorder( Graphics2D g );

	private Color fillColor;
	
	protected Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fill) {
		this.fillColor = fill;
	}

	@Override
	protected void doDraw( final Graphics2D g) {
		
		// 1. check fill color
		if ( fillColor != null ) {
			Color color = g.getColor();
			g.setColor( fillColor );
			
			// 2. paint filled figure
			drawFilling( g );
			g.setColor( color );
		}
		
		// 3. paint border
		drawBorder( g );
	}
}
