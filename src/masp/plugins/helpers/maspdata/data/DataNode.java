package masp.plugins.helpers.maspdata.data;


/**
 * This object is immutable, it is used to store data. To create one, just create an object
 * and pass it and implement Saveable, then override getData() and 
 * 
 * @author Denkfaehigkeit
 * 
 * @see Saveable, Path
 *
 */
public final class DataNode {
	
	private final Object value;
	private final Object defaultValue;
	private final PathFormat format;
	private final String path;
	
	/**
	 * It is NOT suggested that you use this constructor! It is severely dangerous to not use a default value.
	 * Use at your own risk!
	 * 
	 * Note: Suggested that you use multiple formats for each data value, to allow users to have choice. 
	 * 
	 * @deprecated Not advised to use!
	 * 
	 * @param Subjective path to data storage method. See documentation in DataManager for path format.
	 * @param Any object value that will be saved, also will be saved as the default value
	 * @param Specifies the type of path being used. It is suggested that you provide multiple formats
	 * 
	 */
	public DataNode(String path, Object value, PathFormat format) {
		this.path = path;
		this.value = value;
		this.defaultValue = value;
		this.format = format;
	}
	
	/**
	 * Suggested to use this!
	 * 
	 * Note: It is suggest that you use multiple path formats for each data value, to allow users to have more choices in their saving/loading.
	 * 
	 * @param Subjective path to data storage method. See documentation in DataManager for path format.
	 * @param Value that will be stored by DataManager
	 * @param Default value used if value is null or not usuable
	 * @param Specifies the format type of the path passed.
	 */
	
	public DataNode(String path, Object value, Object defaultValue, PathFormat format) {
		this.path = path;
		this.value = value;
		this.defaultValue = defaultValue;
		this.format = format;
	}
	
	/**
	 * @return Value of the DataNode(to save)
	 */
	public Object getValue() {
		return this.value;
	}
	
	/**
	 * @return Default value used if getValue() is null or unusable. 
	 */
	public Object getDefaultValue() {
		return this.defaultValue;
	}
	
	/**
	 * @return The subjective path to save the data
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * @return The path format that the path of the data node is written in.
	 */
	public PathFormat getFormat() {
		return this.format;
	}
	
}
