import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;


//by Marco Mereu
//for CS2336 - Computer Science 2 at UTDallas

public class whereISS {

	
   public static void main(String[] args) throws IOException, JSONException
   { 

	  startWebRequestISS(null);
	   
   }
  

static String startWebRequestISS(String city) throws IOException, JSONException
   {
	   
	   String wehereISSURL = "http://api.open-notify.org/iss-now.json";           
	 //this will hold the JSON Response from the server
	     StringBuilder resultISS2 = new StringBuilder(); 
    URL url = new URL(wehereISSURL);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    while ((line = rd.readLine()) != null) {
    	resultISS2.append(line);
    }
    rd.close();// to close the url link
    
    // this will print the json string from the website above
    //System.out.println(resultISS2.toString());
	 
    
  //printing the weather details
    System.out.println("The International Space Station (ISS) is currently located at: ");
    //lon
    double result_lon = whereISS2(resultISS2.toString());
    System.out.println("longitute is: " + result_lon);
   
    //lat
    double result_lat = whereISS3(resultISS2.toString());
    System.out.println("latitude is: " + result_lat);
	 
    return resultISS2.toString(); 
    
	   } 
	 
      
   
	//class to handle the longitude from the json string
private static double whereISS2(String json ) throws JSONException{
	
	 JSONObject jsonObject = new JSONObject(json);
	  
	   //coord
	   JSONObject JSONObject_iss_position = jsonObject.getJSONObject("iss_position");
	   double result_lon = JSONObject_iss_position.getDouble("longitude");
	  
	return result_lon;
	
}

//class to handle the latitude from the json string
private static double whereISS3(String json ) throws JSONException{
	
	 JSONObject jsonObject = new JSONObject(json);
	  
	   //coord
	   JSONObject JSONObject_iss_position = jsonObject.getJSONObject("iss_position");
	   double result_lat = JSONObject_iss_position.getDouble("latitude");
	 
	return result_lat;
	
}
}