package Adapters;

import Models.Project;
import Models.ProjectResult;
import Models.ResponceBody;
import com.google.common.reflect.TypeToken;

public class ProjectAdapter extends BaseAdapter{
    final String PROJECT_URI = "project/";

    public String getAllProjects(int expectedCode){
        return get(PROJECT_URI,expectedCode);
    }

    public ResponceBody getProject(String projectCode, int expectedStatusCode){
        return gson.fromJson(get(PROJECT_URI+projectCode,expectedStatusCode),new TypeToken<ResponceBody<Project>>(){}.getType());
    }
        public ResponceBody createProject(Project project){
        return gson.fromJson(post(PROJECT_URI,gson.toJson(project),200),new TypeToken<ResponceBody<ProjectResult>>(){}.getType());
    }
}
