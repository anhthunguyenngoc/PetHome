package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class API {
	
	private static final String API_URL = "http://localhost:8080/users"; 
	
	public ArrayList<String> postData(ArrayList<String> varPost, ArrayList<String> varGet, ArrayList<String> arr, String url) {
		ArrayList<String> result = new ArrayList<>();
		
		JSONObject data = new JSONObject();
		
		for(int i=0; i< varPost.size(); i++) {
			data.put(varPost.get(i), arr.get(i));
		}
	    
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(url))
	          .header("Content-Type", "application/json")
	          .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
	          .build();
	    try {
	    	HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        try {
	        	JSONArray jsonArray = new JSONArray(response.body());
	            result.add(""+jsonArray.length());
	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                for(int j=0; j< varGet.size(); j++) {
		            	result.add(""+jsonObject.get(varGet.get(j)));
		    		}
	            }
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
	
	public ArrayList<String> getData(ArrayList<String> var, String url) {
		ArrayList<String> result = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(url))
              .GET()
              .build();

        try {
	    	HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        try {

	            JSONArray jsonArray = new JSONArray(response.body());
	            result.add(""+jsonArray.length());
	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                for(int j=0; j< var.size(); j++) {
		            	result.add(""+jsonObject.get(var.get(j)));
		    		}
	            }
	            
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	        return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public ArrayList<String> putData(ArrayList<String> varPost, ArrayList<String> varGet, ArrayList<String> arr, String url) {
		ArrayList<String> result = new ArrayList<>();
		
		JSONObject data = new JSONObject();
		
		for(int i=0; i< varPost.size(); i++) {
			data.put(varPost.get(i), arr.get(i));
		}

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(url))
              .header("Content-Type", "application/json")
              .PUT(HttpRequest.BodyPublishers.ofString(data.toString()))
              .build();
        
        try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());       
        	try {
        		JSONArray jsonArray = new JSONArray(response.body());
	            result.add(""+jsonArray.length());
	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                for(int j=0; j< varGet.size(); j++) {
		            	result.add(""+jsonObject.get(varGet.get(j)));
		    		}
	            }
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
        	return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
	
	public void delData(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(url))
              .DELETE()
              .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
