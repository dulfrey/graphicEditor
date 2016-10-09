package model;

import view.BoundBox;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;

// Abstract Factory
public abstract class ShapeFactory {

	public abstract Figure create();
	public abstract Figure create(BoundBox bbox);
	
	private static Map<String, ShapeFactory> map = new HashMap<>();
	
	public static void registerFactory( 
		final String key, final ShapeFactory factory ) {
		
		map.put( key, factory );
	}
	
	public static Figure getShape( final String key ) 
		throws InvalidKeyException {
		
		Figure shape = null;
		ShapeFactory factory = map.get( key );
		
		if ( factory == null ) {
		
			try {
				Class.forName( key );
			}
			catch ( ClassNotFoundException e ) {
	
				e.printStackTrace();
			}
			
			factory = map.get( key );
			if ( factory == null ) {
				
				throw new InvalidKeyException( "Class " + key + " not registered!" );
			}
		
		}
		shape = factory.create();		
		return shape;
	}
	
	public static Figure getShape( final String key , BoundBox bbox) 
			throws InvalidKeyException {
			
			Figure shape = null;
			ShapeFactory factory = map.get( key );
			
			if ( factory == null ) {
			
				try {
					Class.forName( key );
				}
				catch ( ClassNotFoundException e ) {
		
					e.printStackTrace();
				}
				
				factory = map.get( key );
				if ( factory == null ) {
					
					throw new InvalidKeyException( "Class " + key + " not registered!" );
				}
			
			}
			shape = factory.create(bbox);			
			return shape;
		}
}
