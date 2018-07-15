package lj.global;

import java.io.File;

import lj.util.DbUtils;
import lj.util.IntUtils;
import lj.util.SpringUtils;
import lj.util.StringUtils;

public class AppFun extends PlatformFun {
	
	/*
	 * 预装载
	 */
	public static int preLoad() {
		System.out.println("开始预加载...............");
		
		//1-设置平台参数
		PlatformVar.DATABSE_TYPE=DbUtils.DATABASE_TYPE_ORACLE;
		PlatformVar.platformPath=System.getProperty("user.dir");
		AppVar.appPath=System.getProperty("user.dir");
		
		
		//3-启动Spring MVC
		String springConfig=AppVar.appPath+File.separator+AppConst.PATH_CONFIG+File.separator+ "beans.xml";
		if(SpringUtils.getBeanFactory(springConfig)==null)
			return IntUtils.INT_FAIL;
		
		
		
		return IntUtils.INT_SUCCESS;
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	public String exitSystem(){
		
		return StringUtils.STR_EMPTY;
	}
	
	
}
