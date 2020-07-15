package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Set;

public class TestBase {

  @BeforeMethod
  public void init() {
    RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  public boolean isIssueOpen(int issueId) throws IOException {
    if (getIssueStatus(issueId).equals("closed")) {
      return false;
    }
    return true;
  }

  public String getIssueStatus(int issueId) throws IOException {
    Set<Issue> Issues = getIssues();
    for (Issue issue : Issues) {
      if (issue.getId() == issueId) {
        String json = RestAssured.given()
                .parameter("subject", issue.getSubject())
                .parameter("description", issue.getDescription())
                .get("https://bugify.stqa.ru/api/issues.json").asString();
        JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_status").getAsString();
      }
    }
    return null;
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  protected Set<Issue> getIssues() throws IOException {

    //String json = getExecutor().execute(Request.Get("https://bugify.stqa.ru/api/issues.json")).returnContent().asString();

    String json = RestAssured.get("https://bugify.stqa.ru/api/issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");

    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
  }
}
