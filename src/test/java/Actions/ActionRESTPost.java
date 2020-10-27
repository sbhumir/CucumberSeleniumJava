package Actions;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

public class ActionRESTPost {

	//private static HttpURLConnection connection;	

	public static void main(String[] args) {

		//create HttpClient handle connections asynchronously
		HttpClient client = HttpClient.newHttpClient();
		//build a request using url
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://jsonplaceholder.typicode.com/albums")).build();
		//send the request async - second parameter is to receive response body as a string
		//once the previous request is done, we proceed to next step
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				//want to get the response using async method
				.thenApply(HttpResponse::body)
				//use the body to print out
				.thenApply(ActionRESTPost::parse) //call parse using lambda expression
				//return a result from the complete in current state
				.join();
	}

	public static String parse(String responsebody) {
		JSONArray albums = new JSONArray(responsebody);

		for(int i = 0; i<albums.length();i++) {
			JSONObject album = albums.getJSONObject(i);
			//System.out.println(album);	
			int id = album.getInt("id");
			int userId = album.getInt("userId");
			String title = album.getString("title");
			System.out.println(id+" "+title+" "+userId);
			Assert.assertTrue("Hundered Users are not returned", albums.length()==100);
		}
		return null;
	}
}
