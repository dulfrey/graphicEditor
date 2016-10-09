package view;

import controler.App;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.util.Iterator;

import javax.swing.JPanel;
import model.Figure;

public class Canvas extends JPanel  {

	@Override
	public void paint( final Graphics g ) {
		super.paint( g );
		
		Iterator<Figure> it = App.getInstance().getFigures();
		while ( it.hasNext() ) {
			it.next().paint( (Graphics2D)g );
		}
	}

        
        public  Canvas(){
            addMouseListener(new MouseAdapter() {
                public mouseClicked()
                
});
            
        }
	//App.getInstance().add( f );	
}
