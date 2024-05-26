package RestAssuredUtilityPkg;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class ReUsableMethods  
{
   public static RequestSpecification reqstspec;
   private static String Filepath = "F:\\SHIV NEWSCRIPTS\\CucumberRAProject\\src\\main\\java\\ConfigPkg\\BaseEnvironment.properties";
   
   public static String ParsingJsonMethod(String getresponse,String Key)
   {	   
	JsonPath jsp = new JsonPath(getresponse);
			
	return jsp.get(Key).toString();
	}
   
   public static SessionFilter GetSession()
   {
	SessionFilter sf = new SessionFilter();
	
	return sf;   
   }
   
   public static RequestSpecification GetRequestSpecification() throws IOException
   {
	 
	PrintStream logs;

	if(reqstspec==null)
	{
	 logs = new PrintStream(new FileOutputStream("./logs/Apiautomation.log"));		
		
     reqstspec = new RequestSpecBuilder().setBaseUri(getProperties("baseUrl")).addQueryParam("key", "qaclick123")
            .addFilter(RequestLoggingFilter.logRequestTo(logs))
            .addFilter(ResponseLoggingFilter.logResponseTo(logs))
            .setContentType(ContentType.JSON).build();	    
   
     return reqstspec;    
   }
	return reqstspec;
   }
   

   public static String getProperties(String Key) throws IOException
   {
    Properties prop = new Properties();
    
    FileInputStream fis = new FileInputStream(Filepath);
    
    prop.load(fis);
    
    String property = prop.getProperty(Key);
    
    return property;    
   }
   
   
	
}
