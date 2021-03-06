package controler;

import view.commands.Tool;
import view.MainFrame;
import view.BoundBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JTextArea;
import model.*;
import view.*;
import view.commands.Command;
import view.commands.CreateFigure;
import view.commands.UndoableCommand;

public class App {

    private Drawing model;
    private MainFrame view;
    private UndoManager ct;

    private App() {
        model = new Drawing( DrawingListFactory.getFigureList() );
        view = new MainFrame( "Design Patterns v0.1" );
        ct = new UndoManager();
    }

    public Iterator<Figure> getFigures() {

        return model.getFigures();
    }

    public void add( final Figure f ) {

        if ( f != null ) {
            Command create = new CreateFigure( f );
            create.execute();
            model.add( f );
            view.repaintCanvas();
        }
    }

    public void addListener( final ModelListener ml ) {

        //model.addListener( ml );
    }

    public void newDocument() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    public void undo() {
        ct.undo();
    }

    public void select( final Point ptReleased ) {
        model.select( ptReleased );
    }

    public void select( Point ptPressed, Point ptReleased ) {
//       BoundBox  bbox = new BoundBox(x, y, w, h);

//        for ( Figure f : fig ) {
//            
//        }
    }

    public void setActiveTool( int tool ) {
        view.setActiveTool( tool );
    }

    public Drawing.Memento saveToMemento() {
        return model.saveToMemento();
    }

    public void undo( UndoableCommand aThis ) {
        aThis.unExecute();
        view.repaintCanvas();
    }

    void restoreFromMemento( Drawing.Memento memento ) {
        model.restoreFromMemento( memento );
    }

    public void addcommandToUndoManager( CreateFigure aThis ) {
        ct.addCommand( aThis );
    }

    //Singleton con Lazy inicialization 
    private static class LazyHolder {

        private static final App instance = new App();
    }

    public static App getInstance() {

        return LazyHolder.instance;
    }

    private void run() {

        model.init();
        view.init();
        ct.init();
        view.setBounds( 50, 50, 800, 600 );
        view.setVisible( true );
    }

    public void addDrawingListener( final DrawingListener dl ) {
        if ( dl != null ) {
            model.addListener( dl );
        }
    }

    public static void main( String[] args ) {
        App app = App.getInstance();
        app.run();
    }

    public void editProperties( final Point pt ) {
        model.editProperties( pt );
    }

    public void setTextArea( final JTextArea editor ) {
        view.setTextArea( editor );
    }

//        private java.util.List<model.Figure> testFigures() {
//		
//		java.util.List<model.Figure> list = new LinkedList<>();
//		
//		BoundBox bbox = new BoundBox( 100, 100, 400, 300 );
//		
//		list.add( new TextFigure(
//			Color.BLUE, bbox, 
//			new Font( "Arial", Font.PLAIN, 24), 
//			"text" ));
//		
//		list.add( new Line( Color.BLUE, bbox, 1 ) );
//		list.add( new Rectangle( Color.BLUE, bbox, 1, null ) );
//		list.add( new Ellipse( Color.BLUE, bbox, 1, null ) );
//
//		return list;
//	}
}
