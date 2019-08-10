//by Marco Mereu
//for CS2336 - Computer Science 2 at UTDallas

public class WeatherFetcher {
   public static void main(String[] args) throws JSONException
   {
	
       try {
           startWebRequest("Dallas");

       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
      
   }
  

static String startWebRequest(String city) throws IOException, JSONException
   {
	// Input city from user
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the city: ");
       city = input.nextLine();
       input.close();
	   //URL address for the weather data
	     String weatherURL = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=26aa1d90a24c98fad4beaac70ddbf274";           
	   //this will hold the JSON Response from the server
	     StringBuilder resultWeather = new StringBuilder(); 
     URL url = new URL(weatherURL);
     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
     conn.setRequestMethod("GET");
     BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
     String line;
     while ((line = rd.readLine()) != null) {
    	 resultWeather.append(line);
  
      }
      rd.close();// to close the url link
      
      //this will print the json string from the weather api
      //System.out.println(resultWeather.toString());
      
  
      //printing the weather details
      
      //lon
      double result_lon = resultWeather2(resultWeather.toString());
      System.out.println("The longitute is: " + result_lon);
     
      //lat
      double result_lat = resultWeather3(resultWeather.toString());
      System.out.println("The latitude is: " + result_lat);
      
      //base
      String result_base = resultWeather4(resultWeather.toString());
      System.out.println("Sunrise is at: " + result_base);
      
      //temperature now
      double result_temp = resultWeather5(resultWeather.toString());
      System.out.println("The temperature now is: " + result_temp);
      
      //humidity
      double result_humidity = resultWeather6(resultWeather.toString());
      System.out.println("The humidity is: " + result_humidity);
      
      //pressure
      double result_pressure = resultWeather7(resultWeather.toString());
      System.out.println("The pressure is: " + result_pressure);
      
      //temp min
      double result_min = resultWeather8(resultWeather.toString());
      System.out.println("The temp min is: " + result_min);
      
      //temp max
      double result_max = resultWeather9(resultWeather.toString());
      System.out.println("The temp max is: " + result_max);
      
      //wind speed
      double result_speed = resultWeather10(resultWeather.toString());
      System.out.println("Wind speed is: " + result_speed);
      
      //deg
      double result_deg  = resultWeather11(resultWeather.toString());
      System.out.println("The deg is: " + result_deg);
      
      //clouds
      int result_all = resultWeather12(resultWeather.toString());
      System.out.println("The all is: " + result_all);
      //city
      String result_name = resultWeather13(resultWeather.toString());
      System.out.println("The City is: " + result_name);
      
      //country
      String result_country = resultWeather14(resultWeather.toString());
      System.out.println("The Country is: " + result_country);
      
      //id
      int result_sunrise = resultWeather15(resultWeather.toString());
      System.out.println("The sunrise is at: " + result_sunrise);
      
      //cod
      int result_sunset = resultWeather16(resultWeather.toString());
      System.out.println("The sunset is at: " + result_sunset);
      
      //printing the json string with the information
      return resultWeather.toString();
   }

   //longitude
   static double resultWeather2(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	 
	   //coord
	   JSONObject JSONObject_coord = jsonObject.getJSONObject("coord");
	   double result_lon = JSONObject_coord.getDouble("lon");
	   
	   return result_lon;
   }
   //latitude
   static double resultWeather3(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
		 
	   //coord
	   JSONObject JSONObject_coord = jsonObject.getJSONObject("coord");
	   
	   double result_lat = JSONObject_coord.getDouble("lat");
	   return result_lat;
   } 
	//base 
   static String resultWeather4(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
		 
     //"base"
       String result_base = jsonObject.getString("base");
       return result_base;
   } 
   
   static double resultWeather5(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_main = jsonObject.getJSONObject("main");
       double result_temp = JSONObject_main.getDouble("temp");
       double result_now_Fahrenheit= (((result_temp - 273) * 9/5) + 32);
       return result_now_Fahrenheit;
   }
   
   static double resultWeather6(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_main = jsonObject.getJSONObject("main");
	   double result_humidity = JSONObject_main.getDouble("humidity");
	   return result_humidity;
	   
   }
   
   static double resultWeather7(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_main = jsonObject.getJSONObject("main");
	   double result_pressure = JSONObject_main.getDouble("pressure");
	   return result_pressure;
	   
   }
   
   static double resultWeather8(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_main = jsonObject.getJSONObject("main");
	   double result_temp_min = JSONObject_main.getDouble("temp_min");
	   double result_min_Fahrenheit = (((result_temp_min - 273) * 9/5) + 32);
	   //return result_temp_min;
	   return result_min_Fahrenheit;
	   
   }
   
   static double resultWeather9(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_main = jsonObject.getJSONObject("main");
	   double result_temp_max = JSONObject_main.getDouble("temp_max");
	   double result_max_Fahrenheit = (((result_temp_max - 273) * 9/5) + 32);
	   return result_max_Fahrenheit;
	   
   }
   
   static double resultWeather10(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_wind = jsonObject.getJSONObject("wind");
       double result_speed = JSONObject_wind.getDouble("speed");
       return result_speed;
   }
   
   static double resultWeather11(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_wind = jsonObject.getJSONObject("wind");
	   double result_deg = JSONObject_wind.getDouble("deg");
       return result_deg;
   }
   
   static int resultWeather12(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_clouds = jsonObject.getJSONObject("clouds");
       int result_all = JSONObject_clouds.getInt("all");
       return result_all;
   }
   //City name
   static String resultWeather13(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   String result_name = jsonObject.getString("name");
	   return result_name;
   }
   
   //Country
   static String resultWeather14(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_sys = jsonObject.getJSONObject("sys");
	   String result_country = JSONObject_sys.getString("country");
       return result_country;
	   
   }
   static int resultWeather15(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_sys = jsonObject.getJSONObject("sys");
       //String result_country = JSONObject_sys.getString("country");
       int result_sunrise = JSONObject_sys.getInt("sunrise");
       return result_sunrise;
	   
   }
   static int resultWeather16(String json) throws JSONException
   {
	   JSONObject jsonObject = new JSONObject(json);
	   JSONObject JSONObject_sys = jsonObject.getJSONObject("sys");
       //String result_country = JSONObject_sys.getString("country");
       int result_sunset = JSONObject_sys.getInt("sunset");
       return result_sunset;
	   
   }

   } 
 