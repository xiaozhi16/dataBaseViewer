package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class database {
	private static ArrayList<String> databaseNames = new ArrayList<String>();
	private static String driver="com.mysql.jdbc.Driver";
	private String host;
	private String user;
	private String pwd;
	private Integer port;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public static ArrayList<String> getDatabaseNames() {
		return databaseNames;
	}
	public static void setDatabaseNames(ArrayList<String> databaseNames) {
		database.databaseNames = databaseNames;
	}
	
	public database() {
		
	}
	public database(String host,String user,String pwd,Integer port) {
		
	}
	public static Connection connect(String host,String user,String pwd,String port){
		String url="jdbc:mysql://"+host+":"+port;
		System.out.println(url);
		try {
			Class.forName(database.driver);
			Connection connect = DriverManager.getConnection(url, user, pwd);
			
			return connect;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	//拿到数据库集合
	public static ArrayList<String> getDatabase(Connection connection) throws SQLException {
		ArrayList<String> databases = new ArrayList<String>();
		Statement sql = connection.createStatement();
		ResultSet result = sql.executeQuery("show databases");
		while(result.next())
		{
			database.databaseNames.add(result.getString("database"));
			databases.add(result.getString("database"));
		}
		return databases;
	}
	public static ArrayList<String> getTableName(Connection connection,String databaseName) throws SQLException {
		// 拿到该数据库的table
		ArrayList<String> tables=new ArrayList<String>();
		Statement sql = connection.createStatement();
		String query = "show tables;";
		sql.execute("use "+databaseName+";");
		ResultSet result = sql.executeQuery(query);
		while(result.next())
		{
			tables.add(result.getString(1));
			
		}
		return tables;
	}
	public static ResultSet OpenTable(Connection connection,String tableName,String databaseName) throws SQLException
	{
		String sql="select * from "+databaseName+"."+tableName+";";
		ResultSet result = connection.createStatement().executeQuery(sql);
		return result;
	}
}
