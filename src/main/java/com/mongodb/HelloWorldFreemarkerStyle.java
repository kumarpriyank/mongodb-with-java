package com.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFreemarkerStyle {

	
 public static void main(String[] args){
	 Configuration config = new Configuration();
	 config.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
 
	 try {
		Template helloTemp = config.getTemplate("resources/hello.ftl");
		StringWriter writer = new StringWriter();
		Map<String, Object> helloMap = new HashMap<String,Object>();
		helloMap.put("name", "Priyank Kumar");
		helloTemp.process(helloMap, writer);
		
		System.out.println(writer);
		
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
}
