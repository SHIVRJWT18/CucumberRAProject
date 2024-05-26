package RestAssuredUtilityPkg;

public enum APIResourcesCollection 
{
 /* enum: 
  * It is a special class in java which has collection
	of constants or methods.	
	These are treated as method with String argument in enum even there is 
	no parenthesis we can call these methods by putting constructor
	when we have to declare  list of methods then it require Comma
	to separate and at the end we put semi colon for termination. 
	
	*/
	
  
  AddPlaceAPI("/maps/api/place/add/json"),
  GetPlaceAPI("/maps/api/place/get/json"),
  DeletePlaceAPI("/maps/api/place/delete/json");
  
  private String resource;	
  APIResourcesCollection(String reso)  
  {
	this.resource=reso;
  }
  
  public String getResource()
  {
	  return resource;
  }
}
