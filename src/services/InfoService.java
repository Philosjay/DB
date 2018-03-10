package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import utils.JdbcUtils;


public class InfoService {
	Connection con=null;
	PreparedStatement pstm = null;
	ResultSet rs =null;
	
	public List<HashMap<String, Object>> getInfoHashList(){
		//Do nothing by default
		return null;
	}
	
	public void addInfo(HashMap<String, Object> cpuInfo){
		try {
			con = JdbcUtils.getConnection();
			
			//完善sql模板
			String sql = "insert into tb_stu3 (username,password) values";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, "Zelda");
			pstm.setString(2, "666");
			
			pstm.executeUpdate();
		} catch (Exception e) {
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

}
