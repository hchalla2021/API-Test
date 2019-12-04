package RestAPI_GET_POST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class RestAPIPost {

	 @Test
		public  void UserPost() throws IOException { 
		// TODO Auto-generated method stub
		 final String POST_PARAMS = "{\n" + "\"userId\": 1,\r\n" +
			        "    \"id\": 2,\r\n" +
			        "    \"title\": \"Test Hari Title\",\r\n" +
			        "    \"body\": \"Test hari Body\"" + "\n}";
			    System.out.println(POST_PARAMS);
			    URL obj = new URL("https://jsonplaceholder.typicode.com/posts?userId=1");
			    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
			    postConnection.setRequestMethod("POST");
			    postConnection.setRequestProperty("userId", "a1bcdefgh");
			    postConnection.setRequestProperty("Content-Type", "application/json");
			    postConnection.setDoOutput(true);
			    OutputStream os = postConnection.getOutputStream();
			    os.write(POST_PARAMS.getBytes());
			    os.flush();
			    os.close();
			    int responseCode = postConnection.getResponseCode();
			    System.out.println("POST Response Code :  " + responseCode);
			    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
			    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
			        BufferedReader in = new BufferedReader(new InputStreamReader(
			            postConnection.getInputStream()));
			        String inputLine;
			        StringBuffer response = new StringBuffer();
			        while ((inputLine = in .readLine()) != null) {
			            response.append(inputLine);
			        } in .close();
			        // print result
			        System.out.println(response.toString());
			    } else {
			        System.out.println("POST NOT WORKED");
      	}
	}
}
