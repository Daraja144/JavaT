package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import static java.lang.String.format;

public class TestBase {

  private final Properties properties;

  public TestBase() {
    properties = new Properties();
  }


  @BeforeSuite
  public void init() throws IOException {
    //RestAssured.authentication = RestAssured.basic(properties.getProperty("api-key"), "");
    RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(format("src/test/resources/%s.properties", target))));
  }


  public void skipIfNotFixed(int issueId) throws IOException {
    if (! isIssueClosed(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  public Set<Issue> getIssuesClosed() throws IOException {
    String json = RestAssured.get((properties.getProperty("rest_assured.api")) + "/filters/3/issues.json").asString();

    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }

  public boolean isIssueClosed(int issueId) throws IOException {
    Set<Issue> issuesClosed = getIssuesClosed();
    for (Issue issue : issuesClosed) {
      if (issue.getId() == issueId) {
        return true;
      }
    }
    return false;
  }

  public Set<Issue> getIssues() throws IOException {

    //String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues.json")).returnContent().asString();

    String json = RestAssured.get((properties.getProperty("rest_assured.api")) + "/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");

    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }

  public int createIssue(Issue newIssue) throws IOException {

    /*String json = getExecutor().execute(Request.Post("https://bugify.stqa.ru/api/issues.json")
            .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                    new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();*/

    String json = RestAssured.given()
            .parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post((properties.getProperty("rest_assured.api")) + "/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();

  }
}
