package test;

import org.junit.Test;
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

	}
}
