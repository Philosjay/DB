package services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dao.InfoDao;



public class InfoService {

	
	public List<HashMap<String, Object>> getInfoHashList(){
		//Do nothing by default
		return null;
	}
	
	public List<HashMap<String, Object>> fllterInfoThenAddInfo(List<HashMap<String, Object>> list){
		// 把采集到的所有信息根据经过筛选，保留部分

		
		return list;
	}
	
	public void addInfo(HashMap<String, Object> cpuInfo){
		String objectName = cpuInfo.get("name").toString();
		String tableName = "tb_" + objectName;
		
		InfoDao dao = new InfoDao();
		
		// 一个数据对象对应一张table，如果表不存在添加新table
		if(!dao.isTableExist("tb_" + objectName))	dao.createTable("tb_" + objectName);
		
		
		//更新table 的列
		//遍历HashMap，获得列名称
		Iterator iter = cpuInfo.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry)iter.next();
			Object key = entry.getKey();
			
			if(!dao.isColExist(key.toString(), tableName)){
				dao.addColumn(key.toString(),tableName);
			}
			
		}
		
		
		
		dao.addInfo(cpuInfo,tableName);
	}

}
