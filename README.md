Simple wrapper around Jackson to create JsonNodes easily for testing or whatever
It exposes just two static functions, JO to create a Json Object and JA to create a Json Array.

Example
```
import static com.caboose.io.sorrymsjackson.Json.*;

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
```
Renders to
`{"users":[{"name":"larry","age":13,"boop":null},{"name":"barry","age":24,"pants":false,"empty":[]}]}`