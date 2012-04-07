package masp.plugins.helpers.maspdata.storagemethods;

import masp.plugins.helpers.maspdata.Saveable;
import masp.plugins.helpers.maspdata.data.DataNode;
import masp.plugins.helpers.maspdata.data.PathFormat;
import masp.plugins.helpers.maspdata.exceptions.PathSyntaxError;

/**
 * Generic interface used by the storage methods so that the client doesn't need to use one specific method of saving.
 * 
 * @author Denkfaehigkeit
 * 
 * @see PathFormat, DataManager
 *
 */
public interface StorageMethod {
	
	/**
	 * This method allows storage methods to have custom path formats required, for example,
	 * a vanilla file format might be path/sub/folder/file.yml;node.to.path:value
	 * whereas a SQL example might simply be db,table,column:value
	 * 
	 * @return Returns the desired format for the path.
	 * 
	 */
	public PathFormat getFormat();
	
	/**
	 * This will be called when the DataManager is given the format the client would like to use in storage.
	 * 
	 * @see Saveable
	 * 
	 * @param Class that implements Saveable, getData() will be called and data will be saved to a specific file.
	 *
	 */
	public void save(Saveable save) throws PathSyntaxError;
	
	/**
	 * This method loads all the values that are saved by the object. Please note, that if you modify the method, some data may not be
	 * read properly.
	 * 
	 * @param Saveable instance to load, should be blank.
	 * @return An array of datanodes with values set at what was read.
	 */
	public DataNode[] load(Saveable save) throws PathSyntaxError;
	
}
