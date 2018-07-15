package lj.global;

import java.io.File;

import lj.util.DbUtils;
import lj.util.FileUtils;

/**
 * 应用程序常量
 * 
 * @author samlv
 *
 */
public class AppConst extends PlatformConst {
	// 配置文件路径
	public final static String PATH_CONFIG = "config";
	// 上传文件路径
	public final static String PATH_UPLOAD = "upload";
	// 用户上传目录
	public final static String PATH_USER = PATH_UPLOAD + File.separator + "user";
	// 用户头像上传目录
	public final static String PATH_USER_IMAGE = PATH_USER + File.separator + "image";
    
	//下载文件路径
	public final static String PATH_DOWNLOAD="download";
	
	/**
	 * session变量
	 */
	public final static String SESSION_USERINFO="userInfo";
	
	/**
	 * 重要URL
	 */
	public final static String URL_LOGIN="login";
	public final static String URL_MAIN="main";
	public final static String URL_DOWNLOAD="download";
	
	
	/**
	 * ICE设置
	 */
	public final static String[] ICE_ARGS_DATA=new String[0];
	public final static String[] ICE_ARGS_CHECK=new String[0];
	public final static String[] ICE_ARGS_CONTROL=new String[0];
	
	public final static String ICE_IP_DATA="127.0.0.1";
	public final static String ICE_IP_CHECK="127.0.0.1";
	public final static String ICE_IP_CONTROL="127.0.0.1";
	
	public final static int ICE_PORT_DATA=20001;
	public final static int ICE_PORT_CHECK=20002;
	public final static int ICE_PORT_CONTROL=20003;
	
	public final static String ICE_OA_DATA="DataServiceAdapter";
	public final static String ICE_OA_CHECK="CheckServiceAdapter";
	public final static String ICE_OA_CONTROL="ControlServiceAdapter";
	
	public static final String MOSQUITTO_HOST_PORT = "tcp://www.uelab.top:1883";
}
