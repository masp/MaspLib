package masp.plugins.helpers.maspdata.exceptions;

import masp.plugins.helpers.maspdata.data.PathFormat;

/**
 * This is used when a path passed does not meet the specified regular expression/format required.
 * 
 * @see PathFormat, StorageMethod, DataManager
 * 
 * @author Denkfaehigkeit
 */
public class PathSyntaxError extends Exception {

	private static final long serialVersionUID = 8120305108795083560L;
	
	private PathFormat format;
	private String path;
	
	/**
	 * Constructs a PathSyntaxException
	 * 
	 * @param Path format that is checked/specified
	 * @param Actual path string that violates the condition.
	 */
	public PathSyntaxError(PathFormat format, String path) {
		super("Format: " + format.getRegex() + "\n" + "Path: " + path);
		this.format = format;
		this.path = path;
	}
	
	/**
	 * @return Path that was invalid
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * @return The format that's correct.
	 */
	public PathFormat getFormat() {
		return this.format;
	}
	
}
