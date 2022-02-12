package Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tags {
    String title;
    int internal_id;
}
