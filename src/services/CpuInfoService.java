package services;

import java.util.HashMap;
import java.util.List;

import org.hyperic.sigar.SigarException;

import utils.OSUtils;



public class CpuInfoService extends InfoService{
	
	@Override
	public List<HashMap<String, Object>> getInfoHashList(){
		List<HashMap<String, Object>> list = null;
		try {
			list = OSUtils.getCpuPercMapList();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
