package Tests;//package Tests;
//
//import Adapters.DefectAdapter;
//import Adapters.ProjectAdapter;
//import Models.*;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.HashMap;
//
//import static org.testng.Assert.assertEquals;
//
//public class ApiDefectTest {
//    DefectAdapter defectAdapter;
//
//    @BeforeClass
//    public void setUp() {
//        defectAdapter = new DefectAdapter();
//    }
//
//    @Test
//    public void
//    createDefectPositiveTest() {
//        String defectCode = "1";
//        int defectId = 12;
//        ResponceBody<Object> expectedResponse = ResponceBody.
//                builder().
//                status(true).
//                result(ProjectResult.
//                        builder().
//                        id(defectId).
//                        build()).
//                build();
//        Defect defect = Defect.
//                builder().
//                code(defectCode).
//                title("QWE").
//                actual_result("A").
//                severity(3).
//                milestone_id(1).
//                custom_field(DefectCustomFields.builder().id("").value("").build()).
//                build();
//        ResponceBody<Defect> actualResponse = defectAdapter.createDefect(defect);
//        assertEquals(actualResponse, expectedResponse);
//    }
//
//
//
//
//    @Test
//    public void getDefectTestPositive() {
//DefectCustomFields defectCustomFields;
//        String code = "DEMO";
//        String defectId ="/1";
//        ResponceBody<Object> expectedDefect = ResponceBody.builder().
//                status(true).
//                result(DefectResult.builder().
//                        id(1).
//                        title("1").
//                        actual_result("12").
//                        severity("critical").
//                        status("in_progress").
//                        milestone_id(null).
//                        custom_fields(defectCustomFields[DefectCustomFields.builder().id(0).value("").build()]).
//                        attachments(Attachments.builder().
//                                size(0).
//                                mime("").
//                                filename("").
//                                url("").
//                                build()).
//                        created("2022-02-05 11:38:15").
//                        updated("2022-02-05 11:54:54").
//                        deleted("").
//                        resolved("").
//                        project_id(0).
//                        member_id(1).
//                        external_data("").
//                        tags(Tags.builder().
//                                title("").
//                                internal_id(0).
//                                build())).
//
//                build();
//        ResponceBody<Object> expectedResponceResult = ResponceBody.builder().status(true).result(expectedDefect).build();
//        ResponceBody<DefectResult> actualResponceBody = defectAdapter.getDefect(code,defectId, 200);
//        assertEquals(actualResponceBody, expectedResponceResult);
//    }

//}
