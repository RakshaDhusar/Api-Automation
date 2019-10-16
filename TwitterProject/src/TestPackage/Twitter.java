package TestPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
public class Twitter {

	Properties prop;
	
	@Test
	public void getTweet() throws Exception {
		prop= new Properties();
		FileInputStream fls= new FileInputStream("C:\\New folder\\222\\TwitterProject\\src\\org\\testng\\annotations\\TwitterBase.properties");
		prop.load(fls);
		
		RestAssured.baseURI= prop.getProperty("host");
		Response res= given().auth().oauth(prop.getProperty("consumerKey"), prop.getProperty("consumerSecret"), prop.getProperty("token"), prop.getProperty("tokenSecret")).
				when().get(Resources.getResource1()).
				then().extract().response();
		
		String response= res.asString();
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		
		String text= js.get("text").toString();
		System.out.println(text);
	}

	public static void main(String[] args) {
		prop.getProperty("tokenSecret")
	}

}
