package adapters;

import com.google.common.reflect.TypeToken;
import io.qameta.allure.Step;
import models.Project;
import models.ProjectResult;
import models.ResponceBody;

public class ProjectAdapter extends BaseAdapter {
    final String PROJECT_URI = "project/";

    public String getAllProjects(int expectedCode) {
        return get(PROJECT_URI, expectedCode);
    }

    @Step("Get project by code: {projectCode}; expected status code: {expectedStatusCode}")
    public ResponceBody<Project> getProject(String projectCode, int expectedStatusCode) {
        return gson.fromJson(get(PROJECT_URI + projectCode, expectedStatusCode), new TypeToken<ResponceBody<Project>>() {
        }.getType());
    }

    @Step("Create project by code: {projectCode}; expected status code: 200")
    public ResponceBody<Project> createProject(Project project) {
        return gson.fromJson(post(PROJECT_URI, gson.toJson(project), 200), new TypeToken<ResponceBody<ProjectResult>>() {
        }.getType());
    }
}
