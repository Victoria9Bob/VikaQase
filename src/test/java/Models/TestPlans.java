package Models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class TestPlans {
    private String title;
    private String description;

    public TestPlans(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
