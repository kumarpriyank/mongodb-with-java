package com.mongodb;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkFreeMarkerStyle {
			
	public static void main(String[] args){
		
		 final Configuration config = new Configuration();
		 config.setClassForTemplateLoading(HelloWorldSparkFreeMarkerStyle.class, "/");
	 
		Spark.get("/", new Route(){

			public Object handle(final Request request,
								 final Response response){
				
				try {
					// TODO Auto-generated method stub
					HashMap<String,Object> fruitMap = new HashMap<String,Object>();
					fruitMap.put("fruits", Arrays.asList("apple", "orange","watermelon", "peach"));
					StringWriter writer = new StringWriter(); 
					Template fruitPickerTemp = config.getTemplate("resources/fruitPicker.ftl");
					fruitPickerTemp.process(fruitMap, writer);
					System.out.println(writer);
					return writer;
						
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
			}
		});
		
		Spark.post("/favourite_fruit", new Route(){

			public Object handle(final Request request, final Response response) throws Exception {
				// TODO Auto-generated method stub
				final String fruit = request.queryParams("fruit");
				if(fruit == null)
					return "Choose a fruit. Pick One ";
				else
					return "Your Favourite fruit is " + fruit;
			}
		});
			 
	}
}
