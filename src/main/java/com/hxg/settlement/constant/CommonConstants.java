package com.hxg.settlement.constant;

/**
 * Created by ace on 2017/8/29.
 */
public class CommonConstants {
	public static final int CODE_SUCCESS = 2000000; // 成功
	public static final String MSG_SUCCESS = "OK";
	public static final int CODE_ILLEGAL_ARGUMENT = 3000000; // 参数不合法
	public static final int CODE_ILLEGAL_APPTOKEN = 3000001; // apptoken不合法或已过期
	public static final int CODE_SERVER_ERROR = 5000000; // 服务器未捕获异常
	
	/**
     * 权限资源类型
     */
    public final static String RESOURCE_TYPE_MENU = "menu";
    public final static String RESOURCE_TYPE_BTN = "button";
    
    public final static String RESOURCE_REQUEST_METHOD_GET = "GET";
    public final static String RESOURCE_REQUEST_METHOD_PUT = "PUT";
    public final static String RESOURCE_REQUEST_METHOD_DELETE = "DELETE";
    public final static String RESOURCE_REQUEST_METHOD_POST = "POST";

    public final static String RESOURCE_ACTION_VISIT = "访问";

    public final static String BOOLEAN_NUMBER_FALSE = "0";

    public final static String BOOLEAN_NUMBER_TRUE = "1";
}
