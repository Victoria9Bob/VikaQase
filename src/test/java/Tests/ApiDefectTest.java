package Tests;//package Tests;

import Adapters.DefectAdapter;
import Models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ApiDefectTest {
    DefectAdapter defectAdapter;

    @BeforeClass(groups = "ApiTests")
    public void setUp() {
        defectAdapter = new DefectAdapter();
    }

    @Test(groups = "ApiTests")
    public void
    createDefectPositiveTest() {
        String defectCode = "12";
        int defectId = 1;
        ResponceBody<Object> expectedResponse = ResponceBody.
                builder().
                status(true).
                result(ProjectResult.
                        builder().
                        id(defectId).
                        build()).
                build();
        Defect defect = Defect.
                builder().
                code(defectCode).
                title("QWE").
                actual_result("A").
                severity(3).
                milestone_id(1).
                attachments(Arrays.asList(Attachments.
                        builder().
                        filename("guyg").
                        build())).
                custom_field(Arrays.asList(DefectCustomFields.
                        builder().
                        id("0").
                        value("hl").
                        build())).
                tags(Arrays.asList(Tags.
                        builder().
                        title("hyfukyg").
                        build())).
                build();
        ResponceBody<Defect> actualResponse = defectAdapter.createDefect(defect);
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
                        title("1").
                        actual_result("12").
                        severity("critical").
                        status("in_progress").
                        milestone_id(null).
                        custom_fields(Arrays.asList(DefectCustomFields.builder().id("0").value("kyfg").build())).
                        attachments(Attachments.builder().
                                size(0).
                                mime("").
                                filename("").
                                url("").
                                build()).
                        created("2022-02-05 11:38:15").
                        updated("2022-02-05 11:54:54").
                        deleted("").
                        resolved("").
                        project_id(0).
                        member_id(1).
                        external_data("").
                        tags(Arrays.asList(Tags.builder().
                                title("kjy").
                                internal_id(0).
                                build()))).

                build();
        ResponceBody<Object> expectedResponceResult = ResponceBody.builder().status(true).result(expectedDefect).build();
        ResponceBody<DefectResult> actualResponceBody = defectAdapter.getDefect(code, defectsId, 200);
        assertEquals(actualResponceBody, expectedResponceResult);
    }

}
