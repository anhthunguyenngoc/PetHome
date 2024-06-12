package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class API {
	
	private static final String API_URL = "http://localhost:8080/"; 
	
	private int getResponse(HttpClient client, HttpRequest request, ArrayList<String> varGet, List<ArrayList<String>> res) {
		int statusCode = -1;
		try {
	    	HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    	statusCode = response.statusCode();
	    	System.out.println(response.body());
	        try {    	
	            if(!(response.statusCode() == 200)) {
	            	System.out.println(response.body());
	            }else {
	            JSONArray jsonArray = new JSONArray(response.body());
	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                ArrayList<String> row = new ArrayList<>();
	                for(int j=0; j< varGet.size(); j++) {
		            	row.add(""+jsonObject.get(varGet.get(j)));
		    		}
	                res.add(row);
	            }
	            }
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return statusCode;
	}
	
	private int getResponse(HttpClient client, HttpRequest request, ArrayList<String> varGet, ArrayList<String> res) {
		int statusCode = -1;
		try {
	    	HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    	statusCode = response.statusCode();
	    	System.out.println(response.body());
	        try {   
	        	JSONObject jsonObject = new JSONObject(response.body());
	        	System.out.println(response.body());
                for(int j=0; j< varGet.size(); j++) {
	            	res.add(""+jsonObject.get(varGet.get(j)));
	    		}
	            
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return statusCode;
	}
	
	private int getResponse(HttpClient client, HttpRequest request) {
		int statusCode = -1;
	    try {
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());       
	        statusCode = response.statusCode();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return statusCode;
	}
	
	public int postData(ArrayList<String> varPost, ArrayList<String> varGet, ArrayList<String> arr, List<ArrayList<String>> res, String url) {	
		JSONObject data = new JSONObject();
		
		for(int i=0; i< varPost.size(); i++) {
			data.put(varPost.get(i), arr.get(i));
		}
	    
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(API_URL+url))
	          .header("Content-Type", "application/json")
	          .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
	          .build();

	    return getResponse(client, request, varGet, res);
	}
	
	public int postData(ArrayList<String> varPost, ArrayList<String> varGet, ArrayList<String> arr, ArrayList<String> res, String url) {	
		JSONObject data = new JSONObject();
		
		for(int i=0; i< varPost.size(); i++) {
			data.put(varPost.get(i), arr.get(i));
		}
	    
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(API_URL+url))
	          .header("Content-Type", "application/json")
	          .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
	          .build();

	    return getResponse(client, request, varGet, res);
	}
	
	public int getData(ArrayList<String> var, ArrayList<String> res, String url) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(API_URL+url))
              .GET()
              .build();

        return getResponse(client, request, var, res);
    }
	
	public int getData(ArrayList<String> var, List<ArrayList<String>> res, String url) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(API_URL+url))
              .GET()
              .build();

        return getResponse(client, request, var, res);
    }
	
	public int putData(ArrayList<String> varPost, ArrayList<String> arr, String url) {	
		JSONObject data = new JSONObject();
		
		for(int i=0; i< varPost.size(); i++) {
			data.put(varPost.get(i), arr.get(i));
		}

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(API_URL+url))
              .header("Content-Type", "application/json")
              .PUT(HttpRequest.BodyPublishers.ofString(data.toString()))
              .build();
        
		return getResponse(client, request);
    }
	
	public int delData(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(API_URL+url))
              .DELETE()
              .build();

        return getResponse(client, request);
    }
}
