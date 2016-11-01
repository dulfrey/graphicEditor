/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package view.commands;
import controler.*;

/**
 *
 * @author Dulfrey
 */
public class SelectionTool extends Tool{

    @Override
    protected void processMouseReleased() {
        if ( ptPressed.equals(ptReleased)) {
            App.getInstance().select(ptReleased);
        }else{
            App.getInstance().select( ptPressed, ptReleased  );
        }
    }
    
}
