package Models;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class DefectResult {
    int id;
    String title;
    String actual_result;
    String severity;
    String status;
    String milestone_id;
    List<DefectCustomFields> custom_fields;
    Attachments attachments;
    String created;
    String updated;
    String deleted;
    String resolved;
    int project_id;
    int member_id;
    String external_data;
    Tags tags;
}
