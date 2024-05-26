package StepDefinition;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.testng.Assert;

import AddPlacePOJOPkg.SetAddPlaceData;
import AddPlacePOJOPkg.SetDeletePlaceData;
import RestAssuredUtilityPkg.APIResourcesCollection;
import RestAssuredUtilityPkg.ReUsableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddPlaceAPITest extends ReUsableMethods
{
	RequestSpecification reqspec;
	ResponseSpecification respspec;
	Response res;
	static String addresponse,getresponse;
	APIResourcesCollection resourceApi;
	static String pid;

	@Given("Add Place Payload")
	public void add_place_payload() throws IOException 
	{
		SetAddPlaceData setaddplace = new SetAddPlaceData();
		
	    reqspec =   given().spec(ReUsableMethods.GetRequestSpecification()).body(setaddplace.buildAddPlacePayload());
	}

	
    @Given("Add Multiple Places Payload {string} {string} {string} {string} {string}")
    public void add_multiple_places_payload(String Name, String Address, String MobileNo, String Website, String Language) throws IOException 
    {
		SetAddPlaceData setaddplace = new SetAddPlaceData();
		
	    reqspec =   given().spec(ReUsableMethods.GetRequestSpecification()).body(setaddplace.buildMultipleAddPlacePayload(Name,Address,MobileNo,Website,Language));
	
    }
		
    @When("User calls {string} for adding place using {string} Http request")
    public void user_calls_for_adding_place_using_http_request(String resrc, String httpmethod) 
	{
     resourceApi = 	APIResourcesCollection.valueOf(resrc);
    
     System.out.println("ResourceUrl is: "+resourceApi.getResource());
    	
	  respspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 
	  if(httpmethod.equalsIgnoreCase("POST"))
      {
       res = reqspec.when().post(resourceApi.getResource());
	  }
	  else if(httpmethod.equalsIgnoreCase("GET"))
      {
		  // write get code if want to remove {When} method for {GET} HTTP request 
	  }
	  else if(httpmethod.equalsIgnoreCase("DELETE"))
	  {
		// write delete code if want to remove {When} method for {DELETE} HTTP request 	  
	  }	  
	  else
	  {
		Assert.fail("Invalid Selection of Http Method");
	  }	 
	  
	  res = res.then().log().all().spec(respspec).extract().response();
	  
	  }
	  	
	@Then("The API response should be success with status code {int}")
	public void the_api_response_should_be_success_with_status_code(Integer int1) 
	{
	 addresponse = res.asString();	
		
     Assert.assertEquals(res.getStatusCode(),int1,"Status code is not matched");
	}
	
	@Then("The {string} of response body is {string}")
	public void the_of_response_body_is(String key, String value) 
	{
    
     String fetchJson = ReUsableMethods.ParsingJsonMethod(addresponse,key);
     
     Assert.assertEquals(fetchJson,value,"Json value is not matched with provided Value");
     
	}
	
	@When("User calls {string} for getting details using {string} Http request")
	public void user_calls_for_getting_details_using_http_request(String resrc, String httpmethod) 
	{	     
	 String plceid = ReUsableMethods.ParsingJsonMethod(addresponse,"place_id");
	 
	 pid = plceid;
	 	 
	 reqspec = given().spec(reqspec).queryParam("place_id", pid);
		
	 resourceApi = 	APIResourcesCollection.valueOf(resrc);
	    
	 System.out.println("ResourceUrl is: "+resourceApi.getResource());
	    	
	 respspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			 
	  if(httpmethod.equalsIgnoreCase("Get"))
      {
	   res = reqspec.when().get(resourceApi.getResource());
	  }
	  else
	  {
		Assert.fail("Invalid Selection of Http Method");
	  }	 
	  
	  res = res.then().log().all().extract().response();		
	}
	
	@Then("Verify the placeid gernated maps to the {string}")
	public void verify_the_placeid_gernated_maps_to_the(String Expname) 
	{        			     
		getresponse = res.asString();
				
	    String actname =  ReUsableMethods.ParsingJsonMethod(getresponse,"name");
	   	     
	    Assert.assertEquals(actname,Expname,"Json value is not matched with provided Value");
	}
	
	
	@Given("Delete Place Payload")
	public void delete_place_payload() throws IOException 
	{	     		
     SetDeletePlaceData sdpd = new SetDeletePlaceData();
         
	 reqspec =   given().spec(ReUsableMethods.GetRequestSpecification()).body(sdpd.ReadDeletePayload(pid));

	}

	
	@When("User calls {string} for deleting place using {string} Http request")
	public void user_calls_for_deleting_place_using_http_request(String resrc, String httpmethod) 
	{
	 resourceApi = 	APIResourcesCollection.valueOf(resrc);
	     
	 System.out.println("ResourceUrl is: "+resourceApi.getResource());
	  	
	 respspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			 
	 if(httpmethod.equalsIgnoreCase("POST"))
	 {
	       res = reqspec.when().post(resourceApi.getResource());
	 }
	 else
	 {
			Assert.fail("Invalid Selection of Http Method");
	 }	 
		  
		  res = res.then().log().all().spec(respspec).extract().response();
	}
	


	

	
}
