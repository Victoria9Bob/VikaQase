package tests;//package Tests;

import adapters.DefectAdapter;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
@Log4j2
public class ApiDefectTest {
    Faker faker = new Faker();
    DefectAdapter defectAdapter;

    @BeforeClass(groups = "ApiTests")
    public void setUp() {
        defectAdapter = new DefectAdapter();
    }

    @Test(groups = "ApiTests")
    public void createDefectPositiveTest() {
        String defectCode = "/DEMO";
        ResponceBody<Object> expectedResponse = ResponceBody.
                builder().
                status(true).
                result(CreateDefectResult.
                        builder().
                        build()).
                build();
        Defect defect = Defect.
                builder().
                title(faker.name().title()).
                actual_result(faker.chuckNorris().fact()).
                severity(2).
                build();
        ResponceBody<Defect> actualResponse = defectAdapter.createDefect(defectCode, defect);
        assertEquals(actualResponse, expectedResponse);
    }


    @Test(groups = "ApiTests")
    public void getDefectTestPositive() {
        String code = "DEMO/";
        int defectsId = 1;
        ResponceBody<Object> expectedDefect = ResponceBody.builder().
                status(true).
                result(DefectResult.builder().
                        id(1).
                        title("hg").
                        actual_result("12").
                        status("in_progress").
                        milestone_id(null).
                        severity("normal").
                        user_id(1).
                        attachments(Arrays.asList()).
                        custom_fields(Arrays.asList()).
                        created("2022-02-05 11:38:15").
                        updated("2022-02-20 15:26:50").
                        tags(Arrays.asList()).
                        build()).

                build();
        ResponceBody<DefectResult> actualResponceBody = defectAdapter.getDefect(code, defectsId, 200);
        assertEquals(actualResponceBody, expectedDefect);
    }

}
