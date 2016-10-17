/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dulfrey
 */
public  abstract  class FigureFactory {
    
    private static Map<String,FigureFactory> map = new HashMap<>();
    public abstract Figure create();
    
	public static Figure getFigure( String clazz ) {
		
		Figure figure = null;
	
		assert clazz != null;
		
		if ( !map.containsKey( clazz ) ) {
			try {
				// load class dynamically
				Class.forName( clazz );
			}
			catch ( ClassNotFoundException e ) {
				throw new RuntimeException( "Bad shape creation: " + clazz );
			}
		}

		FigureFactory factory = map.get( clazz );
		
		if ( factory != null ) {
			figure = factory.create();
		}
		else {
			throw new RuntimeException( "Bad shape creation: " + clazz );
		}
		
		return figure;
	}
    
    public static void register(String clazz , FigureFactory factory){
        map.put(clazz, factory);
    }
    
    
}
