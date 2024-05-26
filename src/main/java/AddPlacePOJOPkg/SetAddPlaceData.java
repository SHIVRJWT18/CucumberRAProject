package AddPlacePOJOPkg;

import java.util.ArrayList;

public class SetAddPlaceData 
{

	public AddPlace buildAddPlacePayload()
	{
		 AddPlace ap = new AddPlace();
		 
		 ap.setAccuracy(145);
		 ap.setLanguage("Afaganism");
		 ap.setName("Rohit Chandel");
		 ap.setPhone_number("86302152525");
		 ap.setAddress("168 Vatika Park New Basoni");
		 ap.setWebsite("https://www.google.com/");
		 
		 ArrayList<String> ml = new ArrayList<String>();
		 ml.add("Smaller");
		 ml.add("Medium");
		 ml.add("Larger");
		 ml.add("XLarge");
		 ml.add("XXLarge");
		 
		 ap.setTypes(ml);
		 
		 GetLocation gl = new GetLocation();
		 
		 gl.setLat(-129.369);
		 gl.setLng(61.245);
		 
		 ap.setLocation(gl);
		 
		 return ap;
	}
	
	public AddPlace buildMultipleAddPlacePayload(String Name,String Address,String MobileNo,String Website,String Language)
	{
		 AddPlace ap = new AddPlace();
		 
		 ap.setAccuracy(145);		
		 ap.setName(Name);
		 ap.setPhone_number(MobileNo);
		 ap.setAddress(Address);
		 ap.setWebsite(Website);
		 ap.setLanguage(Language);
		 
		 ArrayList<String> ml = new ArrayList<String>();
		 ml.add("Smaller");
		 ml.add("Medium");
		 ml.add("Larger");
		 ml.add("XLarge");
		 ml.add("XXLarge");
		 
		 ap.setTypes(ml);
		 
		 GetLocation gl = new GetLocation();
		 
		 gl.setLat(-129.369);
		 gl.setLng(61.245);
		 
		 ap.setLocation(gl);
		 
		 return ap;
	}
}
