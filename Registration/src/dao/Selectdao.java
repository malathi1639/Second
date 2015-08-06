package dao;

import java.sql.*;

import java.util.*;
public class Selectdao {

	 private Selectdb database;

	    public Selectdao(Selectdb database) {
	        this.database = database;
	    }

	    public List<Bean> list() throws SQLException {
	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;
	        List<Bean> areas = new ArrayList<Bean>();

	        try {
	            connection = database.getConnection();
	            statement = connection.prepareStatement("SELECT * FROM registration");
	            resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                Bean area = new Bean();
	                area.setName(resultSet.getString("name"));
	                area.setId(resultSet.getInt("id"));
	                area.setAge(resultSet.getInt("age"));
	                area.setAddress(resultSet.getString("address"));
	                area.setMailid(resultSet.getString("mailid"));
	                areas.add(area);
	            }
	        } finally {
	            if (resultSet != null) try { resultSet.close(); } catch (SQLException logOrIgnore) {}
	            if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
	            if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
	        }

	        return areas;
	    }
}
