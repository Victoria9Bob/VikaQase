package Models;

import Enums.SuiteParentSuite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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
