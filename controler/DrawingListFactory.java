package controler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Figure;

public class DrawingListFactory {

	@SuppressWarnings("unchecked")
	public static List<Figure> getContainer() {
		
		List<Figure> list =  new ArrayList<Figure>();
		
		String className = System.getProperty(KEY);
		
		try {
			Class<? extends List<Figure>> clazz = 
				(Class<? extends List<Figure>>)Class.forName(className);
			
			list = clazz.newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public static final String KEY = "container";
}
