package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Defect {
    String code;
    String title;
    String actual_result;
    int severity;
//    int milestone_id;
//    List<Attachments> attachments;
//    List<DefectCustomFields> custom_field;
//    List<Tags> tags;

}
