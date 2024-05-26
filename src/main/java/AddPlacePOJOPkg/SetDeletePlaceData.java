package AddPlacePOJOPkg;

public class SetDeletePlaceData extends POJODeleteJson
{
	public POJODeleteJson ReadDeletePayload(String id) 
	{
		POJODeleteJson pdj = new POJODeleteJson();
	
         pdj.setPlace_id(id);
         
         return pdj;
    }
}
	
	class POJODeleteJson
    {
	 String place_id;

	 public String getPlace_id() 
	 {
		return place_id;
	 }

	 public void setPlace_id(String place_id) 
	 {
		this.place_id = place_id;
	 } 	

   }