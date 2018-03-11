package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import services.CpuInfoService;
import services.DiskInfoService;
import utils.OSUtils;
import utils.WindowsInfoUtil;


public class TestDemo{

	@Test
	public void fun1(){
		System.out.println("yahaha!");
		System.out.println(System.getProperty("java.library.path"));
	}

	@Test
	public void WinUtilTest(){

		
		System.out.println("cpu占有率=" + WindowsInfoUtil.getCpuRatioForWindows());
		System.out.println("可使用内存=" + WindowsInfoUtil.getMemery());
		System.out.println("各盘占用情况：" + WindowsInfoUtil.getDisk());
	}
	
	@Test
	public void OSUtilsTest(){
        try {
//            // System信息，从jvm获取
////            OSUtils.property();
//            System.out.println("----------------------------------");
//            // cpu信息
//           OSUtils.cpu();
//            System.out.println("----------------------------------");
//            // 内存信息
////            OSUtils.memory();
//            System.out.println("----------------------------------");
//            // 操作系统信息
////            OSUtils.os();
//            System.out.println("----------------------------------");
//            // 用户信息
////            OSUtils.who();
//            System.out.println("----------------------------------");
//            // 文件系统信息
            OSUtils.file();
/////*            System.out.println("----------------------------------");
//            // 网络信息
//            OSUtils.net();
//            System.out.println("----------------------------------");
//            // 以太网信息
//            OSUtils.ethernet();
////*/             System.out.println("----------------------------------");
        	
        	List<HashMap<String, Object>> mapList = OSUtils.getCpuPercMapList();
        	for(int i=0;i<mapList.size();i++){
        		System.out.println(mapList.get(i));
        	}
        	
        	
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	}
	
	@Test
	public void cpuServiceTest(){
		CpuInfoService ser = new CpuInfoService();
		List<HashMap<String,Object>> list = ser.getInfoHashList();
		List<HashMap<String,Object>> list2 = ser.fllterInfoThenAddInfo(list);
		
		for(int i=0;i<list2.size();i++){
			ser.addInfo(list2.get(i));
		}
		
		
		
	}
	
	@Test
	public void diskServiceTest(){
		DiskInfoService ser = new DiskInfoService();
		List<HashMap<String,Object>> list = ser.getInfoHashList();
		List<HashMap<String,Object>> list2 = ser.fllterInfoThenAddInfo(list);
		
		for(int i=0;i<list2.size();i++){
			ser.addInfo(list2.get(i));
		}
	}
	
	
	@Test
	public void dbTest(){
		DiskInfoService ser = new DiskInfoService();
		ser.addInfo(null);

	}
}
