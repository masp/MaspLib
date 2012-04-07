package masp.plugins.helpers.maspdata.storagemethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import masp.plugins.helpers.maspdata.Saveable;
import masp.plugins.helpers.maspdata.data.DataNode;
import masp.plugins.helpers.maspdata.data.PathFormat;
import masp.plugins.helpers.maspdata.exceptions.PathSyntaxError;

public class SQLiteMethod implements StorageMethod {
	
	private HashMap<String, Connection> conns = new HashMap<String, Connection>();
	
	public SQLiteMethod() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		conns.put("default", DriverManager.getConnection("jdbc:sqlite:default.db"));
	}
	
	public Connection getDefaultConnection() {
		return this.conns.get("default");
	}
	
	@Override
	public PathFormat getFormat() {
		return PathFormat.sqlFormat;
	}

	@Override
	public void save(Saveable save) throws PathSyntaxError {
		if (save == null) {
			throw new IllegalArgumentException("You must pass a non-null Saveable!");
		}
		String path = "";
		for (DataNode node : save.getData()) {
			path = node.getPath();
			if (this.getFormat().matches(path)) {
				// TODO
			} else {
				throw new PathSyntaxError(this.getFormat(), path);
			}
		}
	}

	@Override
	public DataNode[] load(Saveable save) throws PathSyntaxError {
		return null;
	}

}
