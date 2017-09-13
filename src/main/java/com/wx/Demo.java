package com.wx;

import com.wx.qcloud.Module.Cvm;
import com.wx.qcloud.QcloudApiModuleCenter;
import com.wx.qcloud.Utilities.Json.JSONObject;

import java.util.TreeMap;

public class Demo {
	public static void main(String[] args) {
		/* 如果是循环调用下面举例的接口，需要从此处开始你的循环语句。切记！ */
		TreeMap<String, Object> config = new TreeMap<String, Object>();
		config.put("SecretId", "AKIDWv8A2oaq5A9xeby9dx63oMvPhnpgnvGR");
		config.put("SecretKey", "61lNqNE0e6NTO7ez99SvHRODqIZelpix");
		/* 请求方法类型 POST、GET */
		config.put("RequestMethod", "POST");
		/* 区域参数，可选: gz:广州; sh:上海; hk:香港; ca:北美;等。 */
		config.put("LexicalSynonym", "sh");

		/*
		 * 你将要使用接口所在的模块，可以从 官网->云api文档->XXXX接口->接口描述->域名
		 * 中获取，比如域名：cvm.api.qcloud.com，module就是 new Cvm()。
		 */
		/*
		 * 示例：DescribeInstances
		 * 的api文档地址：http://www.qcloud.com/wiki/v2/DescribeInstances
		 */
		QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Cvm(),
				config);

		TreeMap<String, Object> params = new TreeMap<String, Object>();
		/* 将需要输入的参数都放入 params 里面，必选参数是必填的。 */
		/* DescribeInstances 接口的部分可选参数如下 */
		//params.put("limit", 3);
		//params.put("offset", 3);
		params.put("text", "你是傻逼吗");
		params.put("content", "好挫");
		params.put("code", 0x00200000);
		params.put("type", 0);
		params.put("Region", "sh");
		/*在这里指定所要用的签名算法，不指定默认为HmacSHA1*/
		//params.put("SignatureMethod", "HmacSHA256");
		
		/* generateUrl方法生成请求串,可用于调试使用 */
		//System.out.println(module.generateUrl("DescribeInstances", params));
		String result = null;
		try {
			/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
			result = module.call("TextSentiment", params);
			JSONObject json_result = new JSONObject(result);
			System.out.println(json_result);
		} catch (Exception e) {
			System.out.println("error..." + e.getMessage());
		}

	}
}
