package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import view.BoundBox;

public class TextFigure extends Figure implements DocumentListener{

	private Font font;
	private String text;
        private JTextArea editor;
	
        
        static {
        FigureFactory.register(TextFigure.class.getName() ,new Factory());
        
        }
	public TextFigure() {
		
		super( );
		
	}
        

	@Override
	public void doPaint(Graphics2D g) {
		g.setFont(getFont());
		          FontMetrics mFont = g.getFontMetrics();
                          g.drawString(iterator, 0, 0);
		BoundBox bbox = getBoundBox();
		g.drawString(getText(), bbox.x, bbox.y);
	}

    /**
     * @return the font
     */
    public Font getFont() {
        return font;
    }

    /**
     * @param font the font to set
     */
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        private static class Factory extends FigureFactory{

        @Override
        public Figure create() {
            return new TextFigure();
        }
            
        
        }
}
