package view;

import controler.App;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.DrawingListener;
import model.Figure;

public class Canvas extends JPanel  implements DrawingListener{
        
    
        
	@Override
	public void paint( final Graphics g ) {
		super.paint( g );
		
		Iterator<Figure> it = App.getInstance().getFigures();
		while ( it.hasNext() ) {
			it.next().paint( (Graphics2D)g );
		}
	}

        public void setTextArea( final JTextArea editor ) {
		if ( editor != null ) {
			// just one at a time
			if ( getComponentCount() == 0 ) {
				add( editor );
			}
		}
		else {
			removeAll();
		}
	}
        
        public void init() {
		setBackground( Color.WHITE );
		setLayout( null );
		
		// Observer
		addMouseListener( new MouseAdapter() {
			@Override
		    public void mouseClicked( final MouseEvent me ) {
				if ( me.getClickCount() == 2 ) {
					App.getInstance().editProperties( me.getPoint() );
				}
			}
		} );
		
		// Observer
		App.getInstance().addDrawingListener( this );
	}
	//App.getInstance().add( f );	

    @Override
    public void update( DrawingEvent de ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }
}
