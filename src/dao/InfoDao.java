package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import utils.JdbcUtils;

public class InfoDao {
	Connection con=null;
	PreparedStatement pstm = null;
	Statement stm = null;
	ResultSet rs =null;
	
	String sql_cols ;
	String sql_values ;
	
	public void prepareBatch(HashMap<String, Object> info,String tableName){
		
		//插入信息
		try {			
			//完善sql模板

			sql_cols = "insert into " + tableName  + "(";
			sql_values = "values (";
			for(int i=0; i< info.size(); i++){
				sql_values += "?";
				if(i<info.size()-1){
					sql_values += ",";
				}else{
					sql_values += ")";
				}
			}
			
			Map<String, Object> map = info;
			int i=0;
			for (Entry entry : map.entrySet()) {
				sql_cols += entry.getKey().toString();
				if(i<info.size()-1){
					sql_cols += ",";
				}else{
					sql_cols += ")";
				}
				i++;
			}
			
			pstm = con.prepareStatement(sql_cols + sql_values);	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void addInfoToBatch(HashMap<String, Object> info,String tableName){
		
		//插入信息
		try {			

			//遍历HashMap，获得列名称
			int i =1;
			Iterator iter = info.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry)iter.next();
				Object val = entry.getValue();

				pstm.setString(i, val.toString());
				i++;
			}
			
			
			
			pstm.addBatch();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void executeBatch(){
		try {
			System.out.println(pstm.toString());
			pstm.executeBatch();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(pstm!=null)	pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
	
	
	public boolean isTableExist(String tableName) {
		// TODO Auto-generated method stub

		try{
			con = JdbcUtils.getConnection();
			String sql = "SELECT COUNT(0) FROM information_schema.tables WHERE table_name = '" + tableName + "'";
			
			stm = con.createStatement();		
			rs = stm.executeQuery(sql);
			boolean isExist= false;
			while(rs.next()){
				if(rs.getString("COUNT(0)").equals("1"))	isExist = true;
			}
			return isExist;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(stm!=null)stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
	
	public void createTable(String name){
		try{
			String sql = "CREATE table " + name;
			sql += "(" + "id INT UNSIGNED  PRIMARY KEY AUTO_INCREMENT,"
					+	"name varchar(50),"
					+ 	"time TIMESTAMP  "
					+ ")";
			stm = con.createStatement();		
			stm.executeUpdate(sql);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(stm!=null)stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
	
	
	public boolean isColExist(String colName,String tableName){
		try{		
			
			stm = con.createStatement();
			
			String sql =  "select COUNT(0) from information_schema.columns WHERE table_name = '"+ tableName +  
					"' AND column_name = '" + colName + "'";
			rs = stm.executeQuery(sql);
			
			boolean isExist = false;
			while(rs.next()){
				if(rs.getString("COUNT(0)").equals("1")){
					isExist = true;
				}
			}
			
			return isExist;

			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(stm!=null)stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
	
	public void addColumn(String colName,String tableName){
		
		try{						
			stm = con.createStatement();
			
			String sql = "ALTER TABLE `" + tableName +"` ADD column " + colName + " double";
			stm.executeUpdate(sql);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			try {
				if(rs!=null) rs.close();
				if(stm!=null)stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
}
