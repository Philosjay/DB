package app;

import java.util.HashMap;
import java.util.List;

import services.CpuInfoService;
import services.DiskInfoService;

public class Application {
	
	static public void main(String[] args){
		CpuInfoService cpuInfoLoader = new CpuInfoService();
		DiskInfoService diskInfoLoader = new DiskInfoService();

		//初始化table
		List<HashMap<String, Object>> cpuList = cpuInfoLoader.fllterInfo(cpuInfoLoader.getInfoHashList());
		List<HashMap<String, Object>> diskList = diskInfoLoader.fllterInfo(diskInfoLoader.getInfoHashList());
		
		//每个cpu对应一个service，每个service提供数据库操作
		CpuInfoService[] cpuService = new CpuInfoService[cpuList.size()];
		DiskInfoService[] diskService = new DiskInfoService[diskList.size()];
		
		//初始化所有cpuService
		for(int i=0;i<cpuService.length;i++){
			cpuService[i] = new CpuInfoService();
			cpuService[i].initTable(cpuList.get(i));
			cpuService[i].prepareBatch(cpuList.get(i));
		}
		
		//初始化所有diskService
		for(int i=0;i<diskService.length;i++){
			diskService[i] = new DiskInfoService();
			diskService[i].initTable(diskList.get(i));
			diskService[i].prepareBatch(diskList.get(i));
		}
		
		
		for(int i=0;i<20;i++){
			
			cpuList = cpuInfoLoader.fllterInfo(cpuInfoLoader.getInfoHashList());
			diskList = diskInfoLoader.fllterInfo(diskInfoLoader.getInfoHashList());
			
			
			for(int j=0;j<cpuService.length;j++){
				cpuService[j].addInfoToBatch(cpuList.get(j));
			}
			for(int j=0;j<diskService.length;j++){
				diskService[j].addInfoToBatch(diskList.get(j));
			}
			
			
			System.out.println(i);
		}
		
		
		
		//开始批处理
		// cpu批处理
		for(int i=0;i<cpuService.length;i++){
			cpuService[i].executeBatch();
		}
		//disk批处理
		for(int i=0;i<diskService.length;i++){
			diskService[i].executeBatch();
		}
	}

}
