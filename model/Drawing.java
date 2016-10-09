package model;

import java.awt.Color;
import java.awt.Font;

import java.util.*;
import view.*;


public class Drawing {
    
  public Drawing( final List<Figure> figures ) {
		
		this.figures = figures;
	}
		
	public void init() {
		testFigures();
	}
	
	public void add( final Figure f ) {
		if ( f != null ) {
			figures.add( f );
		}
	}

	private void testFigures() {
		Ellipse ef = (Ellipse)FigureFactory.getFigure( 
			Ellipse.class.getName() );
		ef.setBoundBox( new BoundBox( 100, 100, 400, 300 ) );
		ef.setColor( Color.BLACK );
		ef.setFillColor( Color.YELLOW );
		ef.setThickness( 3 );
		add( ef );

		TextFigure tf = (TextFigure)FigureFactory.getFigure( 
			TextFigure.class.getName() );
		tf.setBoundBox( new BoundBox( 100, 100, 400, 300 ) );
		tf.setColor( Color.RED );
		tf.setFont( new Font( "Arial", Font.BOLD, 32 ) );
		tf.setText( "ABCabc123" );
		add( tf );
	}

	public Iterator<Figure> getFigures() {
	
		return figures.iterator();
	}
	
	private List<Figure> figures;

}
