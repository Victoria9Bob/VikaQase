package Tests;

import Adapters.ProjectAdapter;
import Models.*;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiProjectTest {
    Faker faker = new Faker();
    ProjectAdapter projectAdapter;
    private final String projectCode = faker.file().fileName();
    private final String title = faker.name().title();

    @BeforeClass
    public void setUp() {
        projectAdapter = new ProjectAdapter();
    }

    @Test
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

    @Test
    public void getProjectBTestNegative() {
        projectAdapter.getProject(projectCode, 404);
    }

    @Test
    public void getProjectTestPositive() {
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
