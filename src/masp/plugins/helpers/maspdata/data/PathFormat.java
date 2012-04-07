package masp.plugins.helpers.maspdata.data;

public final class PathFormat {
	
	public static final String pathBuffer = "\\s*[\\w\\.\\]+\\s*";
	
	/**
	 * This basic format is for SQL. Essentially, you create it in the format database(.db for SQLite) <br>
	 * Table, row, value. This corresponds to a the code<br>
	 * <b>Please note that this is not syntactically correct and that the indexes are in non-zero index format.
	 * <code>
	 * CREATE TABLE IF NOT EXISTS split(";")[2] (split(";")[3]);
	 * INSERT INTO split(";")[2] VALUES (split(":")[2]) WHERE 'split(":")[3]' = split(";")[4];
	 * </code>
	 * List of uses and segments<br>
	 * Segment 1: DB Name, for example, test.db would write in a db named test.db<br>
	 * Segment 2: Table in which you will place the value<br>
	 * Segment 3: Row to place in<br>
	 * Segment 4: Value to place in said row<br>
	 * Segment 5: Row to use in where<br>
	 * Segment 6: Value to use in where<br>
	 */
	public static final PathFormat sqlFormat = new PathFormat(pathBuffer + "," + pathBuffer + "," + pathBuffer + ":" + pathBuffer + ":\\s*(" + pathBuffer + "," + pathBuffer + ")+");
	
	private final String regex; 
	
	public PathFormat(String regex) {
		this.regex = regex;
	}
	
	public String getRegex() {
		return this.regex;
	}
	
	public boolean matches(String path) {
		return path.matches(this.regex);
	}
	
}
