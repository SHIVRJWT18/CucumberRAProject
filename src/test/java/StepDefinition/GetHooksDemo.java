package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class GetHooksDemo 
{
  /* Execute this class when Delete Place runs separately using tag = "Delete Place" is required only to run.
   *  
  	 In this case required place_id in delete Payload being null beacuse it run separetley and before that
  	 no Add Place is executed  
  	 
  	  Run this class to get place_id to be used in delete payload when run separtely
  */

	@Before("@DeletePlace")
	public void BeforeDeleteCaseTest() throws IOException
	{
		
	 AddPlaceAPITest apat =new AddPlaceAPITest();
		
	 if(AddPlaceAPITest.pid==null)
	 {
		apat.add_multiple_places_payload("Keshav Verma", "456 Kerti Vihar","6632458789", "www.ksyper.com", "French");
	
	    apat.user_calls_for_adding_place_using_http_request("AddPlaceAPI", "POST");
	    
	    apat.the_api_response_should_be_success_with_status_code(200);
	    
	    apat.user_calls_for_getting_details_using_http_request("GetPlaceAPI","GET");
	    
	    apat.verify_the_placeid_gernated_maps_to_the("Keshav Verma");
	 }
	}
	
}
