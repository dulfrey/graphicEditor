package controler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Figure;

public class DrawingListFactory {

	@SuppressWarnings("unchecked")
	public static <T> T getFigureList() {
		
		T list = null;
		
		// is there a system property?
		String className = System.getProperty(KEY);
		if ( className != null ) {
			try {
				Class<? extends List<Figure>> clazz = 
					(Class<? extends List<Figure>>)Class.forName(className);
				
				list = (T)clazz.newInstance();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return (list == null ? (T)new LinkedList<Figure>() : list);
	}
	public static final String KEY = "container";
}
