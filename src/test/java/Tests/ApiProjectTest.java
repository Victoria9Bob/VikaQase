package Tests;

import Adapters.ProjectAdapter;
import Models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiProjectTest {
    ProjectAdapter projectAdapter;

    @BeforeClass
    public void setUp() {
        projectAdapter = new ProjectAdapter();
    }

    @Test
    public void
    createProjectPositiveTest() {
        String projectCode = "QWER";
        String title = "OA14V";
        ResponceBody<Object> expectedResponse = ResponceBody.
                builder().
                status(true).
                result(ProjectResult.
                        builder().
                        code(projectCode).
                        build()).
                build();
        Project project = Project.
                builder().
                title(title).
                code(projectCode).
                build();
        ResponceBody<Project> actualResponse = projectAdapter.createProject(project);
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getProjectBTestNegative() {
        String code = "DE12";
        projectAdapter.getProject(code, 404);
    }

    @Test
    public void getProjectTestPositive() {
        String code = "DEMO";
        String title = "Demo Project";
        Project expectedProject = Project.builder().
                title(title).
                code(code).
                counts(Counts.builder().
                        cases(11).
                        suites(4).
                        milestones(2).
                        defects(ProjectDefects.builder().
                                open(1).
                                total(2).
                                build()).
                        runs(Runs.builder().
                                total(4).
                                active(1).
                                build()).

                        build()).
                build();
        ResponceBody<Object> expectedResponceResult = ResponceBody.builder().status(true).result(expectedProject).build();
        ResponceBody<Project> actualResponceBody = projectAdapter.getProject(code, 200);
        assertEquals(actualResponceBody, expectedResponceResult);
    }

}
