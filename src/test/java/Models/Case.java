package Models;

import Enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Case {
    private String title;
    private CaseStatus status;
    private String description;
    private CaseSuite suite;
    private CaseSeverity severity;
    private CasePriority priority;
    private CaseType type;
    private CaseLayer layer;
    private CaseIsFlaky isFlaky;
    private CaseMilestone milestone;
    private CaseBehavior behavior;
    private CaseAutomationStatus automationStatus;
    private String pre_conditions;
    private String post_conditions;
    private String action;
    private String inputData;
    private String expectedResult;
}
