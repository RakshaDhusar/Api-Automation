package TestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
public class Tweet 
{
Properties prop;
	
	@Test
	public void postTweet() throws IOException {
		prop= new Properties();
		FileInputStream fls= new FileInputStream("C:\\QualitestPractice\\TwitterProject\\src\\files\\data.properties");
		prop.load(fls);
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
		Response res= given().auth().oauth(prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).
				queryParam("status", prop.getProperty("tweet_value")).
				when().post(Resources.postResource1()).
				then().extract().response();
		String response= res.asString();
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		
		String text= js.get("text").toString();
		System.out.println(text);
		
		String id= js.get("id").toString();
		System.out.println(id);
		
		//delete the tweet
		given().auth().oauth(prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).
		when().post("/destroy/"+id+".json").
		then().assertThat().statusCode(200);
	}

	public static void main(String[] args) {
		prop.getProperty("tokenSecret")
	}

}
