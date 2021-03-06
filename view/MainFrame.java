package view;

import view.commands.UndoCommand;
import view.commands.Tool;
import controler.App;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import model.ModelListener;
import view.Canvas;
import view.commands.*;


public class MainFrame extends JFrame implements ModelListener {

    private Canvas canvas;
    public static Command commands[] = new Command[8];
    private static int SETLINETOOL = 0;
    private static int SETRECTTOOL = 1;
    private static int SETELLIPSETOOL = 2;
    private static int SETTEXTTOOL = 3;
    private static int REDO = 4;
    private static int UNDO = 5;

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
        
        
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               commands[UNDO].execute();

            }
        });
        menuEdit.add(undo);
        
        JMenuItem redo = new JMenuItem("Rehacer");
        
        
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               commands[REDO].execute();

            }
        });
        menuEdit.add(redo);
        
        mbar.add(menuEdit);
        super.setSize(400, 500);
    }

    private void add(Canvas canvas, String center) {
        // TODO Auto-generated method stub

    }

    public void setTextArea(final JTextArea editor) {
        canvas.setTextArea(editor);
    }

    public void repaintCanvas() {
        canvas.repaint();

    }

    public void init() {
        canvas = new Canvas();
        canvas.init();

        defineCommands();

        //decorator
        JScrollPane scrollPane = new JScrollPane(canvas);
        //observer
        App.getInstance().addListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        add(BorderLayout.CENTER, canvas);
        setVisible(true);
        createToolBar();
    }

    @Override
    public void modelEvent(ModelEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createToolBar() {
        JToolBar toolbar = new JToolBar();
        addButtonsToolbar(toolbar);
        toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.Y_AXIS));
        add(BorderLayout.LINE_START, toolbar);

    }

    protected void addButtonsToolbar(JToolBar toolBar) {
        //first buttonLine
        int iconWith = 20;
        int iconHeight = 20;

        JButton buttonLine = new JButton();
        URL iconURL = getClass().getResource("/resourses/line.png");
        buttonLine.setIcon(new ImageIcon(new ImageIcon(iconURL).getImage().getScaledInstance(iconWith, iconHeight, java.awt.Image.SCALE_DEFAULT)));
        buttonLine.setSize(20, iconHeight);
        toolBar.add(buttonLine);
        
        //first buttonLine
        JButton buttonRect = new JButton();
        iconURL = getClass().getResource("/resourses/rect.png");
        buttonRect.setIcon(new ImageIcon(new ImageIcon(iconURL).getImage().getScaledInstance(iconWith, iconHeight, java.awt.Image.SCALE_REPLICATE)));
        buttonRect.setSize(25, iconHeight);
        toolBar.add(buttonRect);

        JButton buttonEllipse = new JButton();
        iconURL = getClass().getResource("/resourses/ellipse.png");
        buttonEllipse.setIcon(new ImageIcon(new ImageIcon(iconURL).getImage().getScaledInstance(iconWith, iconHeight, java.awt.Image.SCALE_REPLICATE)));
        buttonEllipse.setSize(iconWith, iconHeight);
        toolBar.add(buttonEllipse);
        
        toolBar.setVisible(true);
        buttonEllipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands[SETELLIPSETOOL].execute();
            }
        });
        
        buttonLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands[SETLINETOOL].execute();
            }
        });
        buttonRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands[SETRECTTOOL].execute();
            }
        });
    }

    public void setActiveTool(int tool) {
        canvas.setActiveTool(tool);
    }

    private void defineCommands() {
        commands[SETELLIPSETOOL] = new SetActiveTool(Canvas.ELLIPSETOOL);
        commands[SETLINETOOL] = new SetActiveTool(Canvas.LINETOOL);
        commands[SETRECTTOOL] = new SetActiveTool(Canvas.RECTTOOL);
        commands[SETTEXTTOOL] = new SetActiveTool(Canvas.TEXTTOOL);
        commands[UNDO] = new UndoCommand();
        commands[REDO] = new RedoCommand();

    }

}
