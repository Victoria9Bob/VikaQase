package Models;

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
    int milestone_id;
    String[] attachments;
 List<DefectCustomFields> custom_field;
    String[] tags;

}
