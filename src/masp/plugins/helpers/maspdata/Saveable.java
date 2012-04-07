package masp.plugins.helpers.maspdata;

import masp.plugins.helpers.maspdata.data.DataNode;

/**
 * Implement this interface and override getData() in order to allow 
 * yourself to easily save and load data via DataManager.
 * getData() should return a list of DataNode(s) which should reflect 
 * the data you'd like to use, and the default value you'd like.
 * 
 * @author Denkfaehigkeit
 * 
 * @see DataManager, DataNode
 *
 */

public interface Saveable {
	
	/**
	 * Override this method in order to add the saving and loading features. To load/initialize an object of this nature,
	 * just use DataManager.load(Class), which will then return the corresponding data type.
	 * 
	 * @return Returns the data nodes that you'd like this object to save and load from.
	 * 
	 */
	public DataNode[] getData();
	
}
