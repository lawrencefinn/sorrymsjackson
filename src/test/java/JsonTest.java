import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import static org.fest.assertions.api.Assertions.*;
import static com.caboose.io.sorrymsjackson.Json.*;

/**
 * DESCRIPTION
 */
public class JsonTest {
    @Test
    public void testJson(){
        JsonNode js = JO("test", "kitty");
        assertThat(js.get("test").asText()).isEqualTo("kitty");
    }

    @Test
    public void testComplexJson(){
        JsonNode js = JO("user", JO(
                "best", "kitty"
        ));
        assertThat(js.get("user").get("best").asText()).isEqualTo("kitty");
    }

    @Test
    public void testJsonArray(){
        JsonNode js = JA("cat", "bat", "rat", 7, false, 13.2, null);
        assertThat(js.get(0).asText()).isEqualTo("cat");
        assertThat(js.get(1).asText()).isEqualTo("bat");
        assertThat(js.get(2).asText()).isEqualTo("rat");
        assertThat(js.get(3).asInt()).isEqualTo(7);
        assertThat(js.get(4).asBoolean()).isEqualTo(false);
        assertThat(js.get(5).asDouble()).isEqualTo(13.2);
        assertThat(js.get(6).isNull()).isTrue();
    }

    @Test
    public void testComplexJsonArray(){
        JsonNode js = JO("users", JA(
                JO(
                        "name", "larry",
                        "age", 13,
                        "boop", null
                ),
                JO(
                        "name", "barry",
                        "age", 24,
                        "pants", false,
                        "empty", JA()
                )
        ));
        assertThat(js.get("users").size()).isEqualTo(2);
        JsonNode user1 = js.get("users").get(0);
        assertThat(user1.get("name").asText()).isEqualTo("larry");
        assertThat(user1.get("age").asInt()).isEqualTo(13);
        assertThat(user1.get("boop").isNull()).isTrue();
        JsonNode user2 = js.get("users").get(1);
        assertThat(user2.get("name").asText()).isEqualTo("barry");
        assertThat(user2.get("age").asInt()).isEqualTo(24);
        assertThat(user2.get("pants").asBoolean()).isFalse();
        assertThat(user2.get("empty").size()).isEqualTo(0);
    }

    @Test
    public void testJsonArrayComplex(){
        JsonNode js = JA(
                JO(
                        "name", "larry",
                        "age", 13,
                        "boop", null
                ),
                JO(
                        "name", "barry",
                        "age", 24,
                        "pants", false,
                        "thir", 13.2,
                        "empty", JA()
                )
        );
        assertThat(js.size()).isEqualTo(2);
        JsonNode user1 = js.get(0);
        assertThat(user1.get("name").asText()).isEqualTo("larry");
        assertThat(user1.get("age").asInt()).isEqualTo(13);
        assertThat(user1.get("boop").isNull()).isTrue();
        JsonNode user2 = js.get(1);
        assertThat(user2.get("name").asText()).isEqualTo("barry");
        assertThat(user2.get("age").asInt()).isEqualTo(24);
        assertThat(user2.get("thir").asDouble()).isEqualTo(13.2);
        assertThat(user2.get("pants").asBoolean()).isFalse();
        assertThat(user2.get("empty").size()).isEqualTo(0);
    }
}
