import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GETRequestTest {

    @Test
    public void testGETRequest() {
        given().
                baseUri("https://postman-echo.com").
                when().
                get("/get").
                then().
                assertThat().
                statusCode(200).
                and().
                body("headers.x-forwarded-proto", equalTo("https")).
                and().
                body("headers.x-forwarded-port", equalTo("443")).
                and().
                body("headers.host", equalTo("postman-echo.com")).
                and().
                body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)")).
                and().
                body("headers.accept", equalTo("*/*")).
                and().
                body("headers.accept-encoding", equalTo("gzip,deflate")).
                and().
                body("url", equalTo("https://postman-echo.com/get"));
    }
}