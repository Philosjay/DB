package test;

import org.junit.Test;

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

		
		System.out.println("cpuռ����=" + WindowsInfoUtil.getCpuRatioForWindows());
		System.out.println("��ʹ���ڴ�=" + WindowsInfoUtil.getMemery());
		System.out.println("����ռ�������" + WindowsInfoUtil.getDisk());
	}
	
	@Test
	public void OSUtilsTest(){
        try {
            // System��Ϣ����jvm��ȡ
            OSUtils.property();
            System.out.println("----------------------------------");
            // cpu��Ϣ
            OSUtils.cpu();
            System.out.println("----------------------------------");
            // �ڴ���Ϣ
            OSUtils.memory();
            System.out.println("----------------------------------");
            // ����ϵͳ��Ϣ
            OSUtils.os();
            System.out.println("----------------------------------");
            // �û���Ϣ
            OSUtils.who();
            System.out.println("----------------------------------");
            // �ļ�ϵͳ��Ϣ
            OSUtils.file();
            System.out.println("----------------------------------");
            // ������Ϣ
            OSUtils.net();
            System.out.println("----------------------------------");
            // ��̫����Ϣ
            OSUtils.ethernet();
            System.out.println("----------------------------------");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
	}
}
