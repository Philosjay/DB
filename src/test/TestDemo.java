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

		
		System.out.println("cpuռ����=" + WindowsInfoUtil.getCpuRatioForWindows());
		System.out.println("��ʹ���ڴ�=" + WindowsInfoUtil.getMemery());
		System.out.println("����ռ�������" + WindowsInfoUtil.getDisk());
	}
	
	@Test
	public void OSUtilsTest(){

	}
}
