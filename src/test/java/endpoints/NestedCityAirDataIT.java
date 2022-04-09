package endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import tech.grasshopper.filter.ExtentRestAssuredFilter;

public class NestedCityAirDataIT {

	private static final String token = "1a5d8f027e344fa191b88e966bdb5d4aa4853d4a";

	@Test
	public void getRomeAirData() {
		given().param("token", token).filter(new ExtentRestAssuredFilter()).when()
				.get("https://api.waqi.info/feed/rome/").then().statusCode(equalTo(200));
	}

	@Nested
	class Tabbed {

		@Test
		public void getParisAirData() {
			given().param("token", token).filter(new ExtentRestAssuredFilter()).when()
					.get("https://api.waqi.info/feed/paris/").then().statusCode(equalTo(200));
		}
	}
}
