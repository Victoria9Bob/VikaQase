package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class DefectResult {
    int id;
    String title;
    String actual_result;
    String status;
    String milestone_id;
    String severity;
    int user_id;
    List<Attachments> attachments;
    List<DefectCustomFields> custom_fields;
    String created;
    String updated;
    String resolved;
    int project_id;
    String external_data;
    List<Tags> tags;
}
