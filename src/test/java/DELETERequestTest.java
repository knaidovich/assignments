import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DELETERequestTest {

    @Test
    public void testDELETERequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given().
                baseUri("https://postman-echo.com").
                contentType("text/plain").
                body(requestBody).
                when().
                delete("/delete").
                then().
                assertThat().
                statusCode(200).
                and().
                body("data", equalTo(requestBody)).
                and().
                body("headers.x-forwarded-proto", equalTo("https")).
                and().
                body("headers.x-forwarded-port", equalTo("443")).
                and().
                body("headers.host", equalTo("postman-echo.com")).
                and().
                body("headers.content-length", equalTo("58")).
                and().
                body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")).
                and().
                body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)")).
                and().
                body("headers.accept", equalTo("*/*")).
                and().
                body("headers.accept-encoding", equalTo("gzip,deflate")).
                and().
                body("data", equalTo("This is expected to be sent back as part of response body.")).
                and().
                body("url", equalTo("https://postman-echo.com/delete"));
    }
}