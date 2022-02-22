package models;

import enums.SuiteParentSuite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Suite {
    private String suiteName;
    private SuiteParentSuite parentSuite;
    private String description;
    private String preconditions;
}
