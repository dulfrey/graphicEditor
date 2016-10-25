package model;

import controler.App;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import view.BoundBox;

public class TextFigure extends Figure implements DocumentListener {

    private Font font;
    private String text;
    private JTextArea editor;

    static {
        FigureFactory.register( TextFigure.class.getName(), new Factory() );

    }

    public TextFigure() {

        super();

    }

    @Override
    public void doPaint( Graphics2D g ) {
        g.setFont( getFont() );
        FontMetrics mFont = g.getFontMetrics();
        g.drawString( getText(), getBoundBox().x, getBoundBox().y + mFont.getAscent() );

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
    public void setFont( Font font ) {
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
    public void setText( String text ) {
        this.text = text;
    }

    @Override
    public void insertUpdate( DocumentEvent e ) {
        String str = editor.getText();
        char last = str.charAt( str.length() - 1 );
        if ( last == KeyEvent.VK_ENTER ) {
            // trim enter 
            text = str.substring( 0, str.length() - 1 );
            stopEdit();

        }
    }
    
    //6. Adapter
    private void starEdit() {
        editor = createTextArea();
        App.getInstance().setTextArea( editor );
        editor.setBounds( getBoundBox() );
        editor.setText( text == null ? "" : text );
        editor.setFont( font == null ? new Font( "SansSerif", Font.PLAIN, font.getSize() ) : font );
        editor.setSelectionStart( 0 );
        editor.setSelectionEnd( text == null ? 0 : text.length() );
        editor.setVisible( true );
        //swing mvc
        final Document doc = editor.getDocument();
        doc.addDocumentListener( this );

    }

    @Override
    public void removeUpdate( DocumentEvent e ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate( DocumentEvent e ) {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    private JTextArea createTextArea() {
        JTextArea editor = new JTextArea( 5, 10 );
        editor.setVisible( false );
        editor.setLineWrap( true );
        editor.setWrapStyleWord( true );
        return editor;
    }

    @Override
    protected boolean doEditProperties() {
        editor = createTextArea();
        return true;
    }

    private void stopEdit() {
        // Swing -> MVC
        final Document doc = editor.getDocument();
        doc.removeDocumentListener( this );

        editor.setVisible( false );
        App.getInstance().setTextArea( editor = null );
    }

    private static class Factory extends FigureFactory {

        @Override
        public Figure create() {
            return new TextFigure();
        }

    }
}
