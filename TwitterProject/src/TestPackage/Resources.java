package TestPackage;

public class Resources
{
	public static String getResource1() {
		String res= "/home_timeline.json";
		return res;
	}

	public static String postResource1() {
		String res= "/update.json";
		return res;
	}
	
	public static String retweetResource1() {
		String res= "/tweets.json";
		return res;
	}

	public static void main(String[] args) {
		prop.getProperty("tokenSecret")
	}
}
