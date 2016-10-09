package view;
import controler.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.ModelListener;
import view.Canvas;

public class MainFrame extends JFrame implements ModelListener{
    private Canvas canvas;//quitar layout manager 
	public MainFrame(String string) {
		
		super(string);
		add(new Canvas(), BorderLayout.CENTER);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                JMenuBar mbar = new JMenuBar();
                JMenu menu = new JMenu("File");
                JMenuItem item = new JMenuItem("New Drawing");
                 item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        App.getInstance().newDocument();
                        new JPopupMenu("New document");
                        
                    }
                });
                this.setJMenuBar(mbar);
                
                 menu.add(item);
                 mbar.add(menu);
                 
                  JMenu menuEdit = new JMenu("Editar");
                JMenuItem undo = new JMenuItem("Deshacer");
                 item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        App.getInstance().undo();
                        
                        
                    }
                });
                  menuEdit.add(undo);
                 mbar.add(menuEdit);
                super.setSize(400,500);
	}

	private void add(Canvas canvas, String center) {
		// TODO Auto-generated method stub
		
	}

	public void repaintCanvas() {
		// TODO Auto-generated method stub
		
	}
	public void init() {
		App.getInstance().addListener( this );
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

    @Override
    public void modelEvent(ModelEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
