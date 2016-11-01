package view;

import view.commands.Tool;
import view.commands.LineCreationTool;
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
import view.commands.EllipseCreationTool;
import view.commands.RectangleCreationTool;
import view.commands.SelectionTool;
import view.commands.TextCreationTool;

public class Canvas extends JPanel implements DrawingListener {

    private static int LINETOOL = 0;
    private static int RECTTOOL = 1;
    private static int ELLIPSETOOL = 2;
    private static int TEXTTOOL = 3;
    private static int SELECTIONTOOL = 0;

    private Tool[] tools;

    private Tool activeTool;
   

    @Override
    public void paint( final Graphics g ) {
        super.paint( g );

        Iterator<Figure> it = App.getInstance().getFigures();
        while ( it.hasNext() ) {
            it.next().paint( (Graphics2D) g );
        }
    }

    public void setTextArea( final JTextArea editor ) {
        if ( editor != null ) {
            // just one at a time
            if ( getComponentCount() == 0 ) {
                add( editor );
            }
        } else {
            removeAll();
        }
    }

    public void init() {
        setBackground( Color.WHITE );
        setLayout( null );

        tools[LINETOOL] = new LineCreationTool();
        tools[SELECTIONTOOL] = new SelectionTool();
        tools[RECTTOOL] = new RectangleCreationTool();
        tools[ELLIPSETOOL] = new EllipseCreationTool();
        tools[TEXTTOOL] = new TextCreationTool();
        
        // Observer  6. Adapter
        addMouseListener( new MouseAdapter() {
            @Override
            public void mouseClicked( final MouseEvent me ) {
                if ( me.getClickCount() == 2 ) {
                    App.getInstance().editProperties( me.getPoint() );
                }

            }
        } );

        activeTool = new LineCreationTool();
        
        addMouseListener( activeTool );
        
        // Observer
        App.getInstance().addDrawingListener( this );

    }
    //App.getInstance().add( f );	

    @Override
    public void update( DrawingEvent de ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    public void setActiveTool( int tool ) {
        this.activeTool = tools[tool];
    }

}
