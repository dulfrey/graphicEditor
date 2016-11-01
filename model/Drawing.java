package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;

import java.util.*;
import view.*;

public class Drawing {

    private final List<DrawingListener> listeners;
    private List<Figure> figures;
    
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
        Ellipse ef = (Ellipse) FigureFactory.getFigure( Ellipse.class.getName() );
        ef.setBoundBox( new BoundBox( 100, 100, 400, 300 ) );
        ef.setColor( Color.BLACK );
        ef.setFillColor( Color.YELLOW );
        ef.setThickness( 3 );
        add( ef );
        Line l = (Line) FigureFactory.getFigure( Line.class.getName() );
        l.setBoundBox( new BoundBox( 100, 100, 400, 300 ) );
        l.setColor( Color.yellow );

        add( l );
        TextFigure tf = (TextFigure) FigureFactory.getFigure(
                TextFigure.class.getName() );
        tf.setBoundBox( new BoundBox( 50, 50, 400, 300 ) );
        tf.setColor( Color.RED );
        tf.setFont( new Font( "Arial", Font.BOLD, 32 ) );
        tf.setText( "ABCabc123" );
        add( tf );
    }

    //16.iterator
    public Iterator<Figure> getFigures() {
        return figures.iterator();
    }

    

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
    
     public Memento saveToMemento(){
        return new Memento(figures);
        }
     
     public void restoreFromMemento(Memento m){
         this.figures = m.getSavedState();
     }
    
    //implementación de memento 
    public  class Memento {

        private final List<Figure> state;
        
        private Memento( List<Figure> figures ) {
            state = figures;
        }

        private List<Figure> getSavedState() {
            return this.state;
        }
       
    }
}
