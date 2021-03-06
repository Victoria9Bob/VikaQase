package tests;

import adapters.ProjectAdapter;
import com.github.javafaker.Faker;
import models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class ApiProjectTest {
    Faker faker = new Faker();
    private final String projectCodeNegative = faker.name().lastName().toUpperCase(Locale.ROOT);
    private final String projectCode = faker.name().firstName().toUpperCase(Locale.ROOT);
    private final String title = faker.name().lastName();
    ProjectAdapter projectAdapter;

    @BeforeClass(groups = "ApiTests")
    public void setUp() {
        projectAdapter = new ProjectAdapter();
    }

    @Test(groups = "ApiTests")
    public void
    createProjectPositiveTest() {

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

    @Test(groups = "ApiTests")
    public void getProjectBTestNegative() {
        projectAdapter.getProject(projectCodeNegative, 404);
    }

    @Test(groups = "ApiTests")
    public void getProjectTestPositive() {
        String projectCode = "API";
        String title = "TESTS";
        Project expectedProject = Project.builder().
                title(title).
                code(projectCode).
                counts(Counts.builder().
                        cases(0).
                        suites(0).
                        milestones(0).
                        defects(ProjectDefects.builder().
                                open(0).
                                total(0).
                                build()).
                        runs(Runs.builder().
                                total(0).
                                active(0).
                                build()).

                        build()).
                build();
        ResponceBody<Object> expectedResponceResult = ResponceBody.builder().status(true).result(expectedProject).build();
        ResponceBody<Project> actualResponceBody = projectAdapter.getProject(projectCode, 200);
        assertEquals(actualResponceBody, expectedResponceResult);
    }
}
