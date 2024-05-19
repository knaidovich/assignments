import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class POSTFormDataTest {

    @Test
    public void testPostFormData() {
        given().
                baseUri("https://postman-echo.com").
                contentType("application/x-www-form-urlencoded; charset=UTF-8").
                formParam("foo1", "bar1").
                formParam("foo2", "bar2").
                when().
                post("/post").
                then().
                assertThat().
                statusCode(200).
                and().
                body("form.foo1", equalTo("bar1")).
                and().
                body("form.foo2", equalTo("bar2")).
                and().
                body("headers.x-forwarded-proto", equalTo("https")).
                and().
                body("headers.x-forwarded-port", equalTo("443")).
                and().
                body("headers.host", equalTo("postman-echo.com")).
                and().
                body("headers.content-length", equalTo("19")).
                and().
                body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.22)")).
                and().
                body("headers.accept", equalTo("*/*")).
                and().
                body("headers.accept-encoding", equalTo("gzip,deflate")).
                and().
                body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8")).
                and().
                body("url", equalTo("https://postman-echo.com/post"));
    }
}