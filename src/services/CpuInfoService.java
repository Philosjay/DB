package services;

import infomanagers.CpuInfo;

import org.hyperic.sigar.SigarException;

import utils.OSUtils;

public class CpuInfoService {
	
	CpuInfo[] cpuInfoList = null;
	
	public CpuInfo[] loadCpuList(){
		double list[][];
	
			try {
				list = OSUtils.getCpuPercList();
				cpuInfoList = new CpuInfo[list.length];
				for(int i=0;i<list.length;i++){
					cpuInfoList[i]=new CpuInfo();
				}
				
				
				for(int i=0;i<list.length;i++){
					cpuInfoList[i].setId(i+1);
					cpuInfoList[i].setUserUseRate(list[i][0]);
					cpuInfoList[i].setSysUseRate((list[i][1]));
					cpuInfoList[i].setWaitRate((list[i][2]));
					cpuInfoList[i].setErrorRate(list[i][3]);
					cpuInfoList[i].setIdleRate(list[i][4]);
					cpuInfoList[i].setTotalUserate((list[i][5]));
				}
			} catch (SigarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		
		return cpuInfoList;
		
		
	
	}
}
