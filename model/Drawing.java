package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;

import java.util.*;
import view.*;

public class Drawing {
    
    private final List<DrawingListener> listeners;
    
    public Drawing( final List<Figure> figures ) {

        this.figures = figures;
        listeners = new LinkedList<>();
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
        Ellipse ef = (Ellipse) FigureFactory.getFigure(
                Ellipse.class.getName() );
        ef.setBoundBox( new BoundBox( 100, 100, 400, 300 ) );
        ef.setColor( Color.BLACK );
        ef.setFillColor( Color.YELLOW );
        ef.setThickness( 3 );
        add( ef );

        TextFigure tf = (TextFigure) FigureFactory.getFigure(
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
    
    public void editProperties( final Point pt ) {
		Iterator<Figure> it = figures.listIterator();

		while ( it.hasNext() ) {
			Figure f = it.next();
			
			if ( f.editProperties( pt ) ) {
				break;
			}
		}
	}
    
    
   // DrawingListener
	public void addListener( final DrawingListener dl ) {
		listeners.add( dl );
	}

    public void select( Point ptReleased ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

}