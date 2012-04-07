package masp.plugins.helpers.maspdata;

import java.util.ArrayList;

import masp.plugins.helpers.maspdata.data.DataNode;
import masp.plugins.helpers.maspdata.exceptions.PathSyntaxError;
import masp.plugins.helpers.maspdata.storagemethods.StorageMethod;

/**
 * This manager handles all saving, loading, and handling of data throughout various methods. Simply put, this is the 
 * connection to the rest of the program's inner-working. Via this, you should be able to accomplish any simple task that you 
 * want.
 * 
 * @author Denkfaehigkeit
 * 
 * @see Saveable, DataNode, PathFormat, StorageMethod
 *
 */
public class DataManager {
	
	private static ArrayList<StorageMethod> methods = new ArrayList<StorageMethod>();
	
	private DataManager() { }
	
	/**
	 * You must add a storage method in order to call it in load or save! Otherwise, you will receive a NullPointerException!
	 * 
	 * @param method Object whose super class implements StorageMethod that you'd like to add.
	 */
	public static void addStorageMethod(StorageMethod method) {
		methods.add(method);
	}
	
	/**
	 * Saves a saveable's data in an easy to use consistent bug-free format.
	 * 
	 * @param savee Saveable object that you wish to save.
	 * @param clazz Class of the StorageMethod that you would want to use, i.e <code>DataManager.save(saveable, SQLiteMethod.class);</code>
	 * @throws Thrown if storage method is not found.
	 * @throws Thrown if the saveable's path format is not compatible with the storage method's path format.
	 */
	public static void save(Saveable savee, Class<? extends StorageMethod> clazz) throws NullPointerException, PathSyntaxError {
		boolean found = false;
		for (StorageMethod method : methods) {
			if (method.getClass().equals(clazz)) {
				method.save(savee);
				found = true;
			}
		}
		if (found == false) {
			throw new NullPointerException("Storage method not found! Please be sure to register/add your DataStorage before attempting to reference it.");
		}
	}
	
	/**
	 * Loads a saveable's data<br>
	 * <b>Please note that an empty object will work, i.e using reflection newInstance()</b>
	 * 
	 * @param savee Saveable to load
	 * @param clazz Storage method to use
	 * @return The equivalent data objects with their values modified to the stored values, using the DataNode's path variable.
	 * @throws Thrown if StorageMethod was not found.
	 * @throws Thrown if the saveable's path format is not compatible with the storage method's path format.
	 */
	public static DataNode[] load(Saveable savee, Class<? extends StorageMethod> clazz) throws NullPointerException, PathSyntaxError {
		DataNode[] nodes = null;
		for (StorageMethod method : methods) {
			if (method.getClass().equals(clazz)) {
				 nodes = method.load(savee);
			}
		}
		if (nodes == null) {
			throw new NullPointerException("Proper storage method not found, please register your method.");
		}
		return nodes;
	}
	
}
