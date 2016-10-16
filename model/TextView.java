/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics2D;
import javax.swing.JTextPane;
import model.Figure;

/**
 *
 * @author Dulfrey
 */
public class TextView extends Figure{

public TextFigure text = new TextFigure();


    @Override
    protected void doPaint(Graphics2D g) {
        text.setText("text");
        //this.text.getText());
    }

    @Override
    protected boolean doEditProperties() {
        throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }
}
