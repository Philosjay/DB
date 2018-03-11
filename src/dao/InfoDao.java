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
	
	
	public void addInfo(HashMap<String, Object> info,String tableName){
		
		//获取数据库连接
		try {
			con = JdbcUtils.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//插入信息
		try {			
			//完善sql模板

			String sql_cols = "insert into " + tableName  + "(";
			String sql_values = "values (";
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

			
			//遍历HashMap，获得列名称
			i =1;
			Iterator iter = info.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry)iter.next();
				Object val = entry.getValue();

				pstm.setString(i, val.toString());
				i++;
			}
			
			
			
//			pstm.addBatch(arg0);

			
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			throw new RuntimeException(e);
		}
		finally{
			try {
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
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
				if(stm!=null)stm.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
	
	public void createTable(String name){
		try{
			con = JdbcUtils.getConnection();
			String sql = "CREATE table " + name;
			sql += "(" + "id char(11),"
					+	"name varchar(50)"
					+ ")";
			stm = con.createStatement();		
			stm.executeUpdate(sql);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			try {
				if(stm!=null)stm.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
	
	
	public boolean isColExist(String colName,String tableName){
		try{		
			con = JdbcUtils.getConnection();
			
			
			
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
				if(stm!=null)stm.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
	
	public void addColumn(String colName,String tableName){
		
		try{		
			con = JdbcUtils.getConnection();				
			stm = con.createStatement();
			
			String sql = "ALTER TABLE `" + tableName +"` ADD column " + colName + " varchar(30)";
			stm.executeUpdate(sql);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			try {
				if(stm!=null)stm.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		}
	}
}
