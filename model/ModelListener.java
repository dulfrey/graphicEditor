package model;

public interface ModelListener {

	public static enum ModelEvent {
		
		F_ADDED, 
		F_SELECTED, 
		F_DESELECTED, 
		F_CHANGED,
		F_REMOVED,
		F_GROUP,
		F_UNGROUP,
		F_UNDOABLE,
		M_SAVED, 		
	}
	
	void modelEvent( ModelEvent me );
}
