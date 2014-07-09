package biz.sunce.db;

import java.sql.Connection;

public interface DbConnection {
	public Connection getConnection();
	public String freeConnection(Connection conn);
	public int performUpdate(String upd);
	public  java.sql.ResultSet performQuery(String upit, int limit);
	public  java.sql.ResultSet performQuery(String upit);
}

