/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;

/**
 *
 * @author Dulfrey
 */
public interface DrawingListener {

    public static enum DrawingEvent {
        ADDED,
        DELETED,
        DESELECTED,
        MOVED,
        SAVED;
        private Object payload;

        public DrawingEvent setPayload( final Object payload ) {
            this.payload = payload;
            return this;
        }

        public Object getPayload() {
            return payload;
        }
    }

    public abstract void update( DrawingEvent de );

}
