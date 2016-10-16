package model;

import view.BoundBox;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Iterator;

public abstract class Figure implements Shape {

    private Color color = Color.BLACK;
    private BoundBox bbox;
    private boolean selected;

    protected abstract void doPaint( Graphics2D g );

    protected abstract boolean doEditProperties();

    //template method
    public boolean editProperties( MouseEvent e ) {
        boolean r = false;
        if ( bbox.contains( e.getPoint() ) ) {
            doEditProperties();
            r = true;
        }
        return r;
    }
    
    public boolean editProperties( final Point pt ) {
		boolean r = false;
		
		if ( bbox.contains( pt ) ) {
			doEditProperties();
			r = true;
		}
		
		return r;
	}

    protected Figure() {

        color = new Color( 0, 0, 0 );
        bbox = null;
    }

    protected Figure( final BoundBox boundBox ) {

        color = new Color( 0, 0, 0 );
        bbox = boundBox;
    }

    @Override//template method
    public final void paint( final Graphics2D g ) {

        // 1. set color
        g.setColor( color );

        // 2. do paint
        doPaint( g );

        // 3. if selected paint bbox
        if ( selected ) {
            bbox.paint( g );
        }
    }

    public Color getColor() {

        return color;
    }

    public void setColor( Color color ) {

        this.color = color;
    }

    public BoundBox getBoundBox() {

        return bbox;
    }

    public void setBoundBox( BoundBox bbox ) {

        this.bbox = bbox;
    }

    public boolean isSelected() {

        return selected;
    }

    public void setSelected( boolean b ) {

        selected = b;
    }

    public static class NullIterator
            implements Iterator<Figure> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Figure next() {
            return null;
        }

        @Override
        public void remove() {
        }
    }

    public Iterator<Figure> iterator() {

        return new NullIterator();
    }

    public void select( BoundBox bbox2 ) {
        BoundBox bbox3 = bbox.normalized();
        if ( bbox2.contains( bbox3 ) ) {
            selected = true;
        }
    }

    public void select( Point pt ) {
        if ( bbox.contains( pt ) ) {
            selected = true;
        }
    }

}
