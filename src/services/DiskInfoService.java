package services;

import java.util.HashMap;
import java.util.List;

import org.hyperic.sigar.SigarException;

import utils.OSUtils;

public class DiskInfoService extends InfoService {
	
	@Override
	public List<HashMap<String, Object>> getInfoHashList(){
		List<HashMap<String, Object>> list = null;
		try {
			list = OSUtils.getDiskMapList();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
