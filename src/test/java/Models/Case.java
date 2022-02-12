package Models;

import Enums.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
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

    public Case(String title, CaseStatus status, String description, CaseSuite suite, CaseSeverity severity, CasePriority priority, CaseType type, CaseLayer layer, CaseIsFlaky isFlaky, CaseMilestone milestone, CaseBehavior behavior, CaseAutomationStatus automationStatus, String pre_conditions, String post_conditions) {
        this.title = title;
        this.status = status;
        this.description = description;
        this.suite = suite;
        this.severity = severity;
        this.priority = priority;
        this.type = type;
        this.layer = layer;
        this.isFlaky = isFlaky;
        this.milestone = milestone;
        this.behavior = behavior;
        this.automationStatus = automationStatus;
        this.pre_conditions = pre_conditions;
        this.post_conditions = post_conditions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Case)) return false;
        Case aCase = (Case) o;
        return Objects.equals(title, aCase.title) && Objects.equals(status, aCase.status) && Objects.equals(description, aCase.description) &&
                Objects.equals(suite, aCase.suite) && Objects.equals(severity, aCase.severity) && Objects.equals(priority, aCase.priority) &&
                Objects.equals(type, aCase.type) && Objects.equals(layer, aCase.layer) && Objects.equals(isFlaky, aCase.isFlaky) && Objects.equals(milestone, aCase.milestone) &&
                Objects.equals(behavior, aCase.behavior) && Objects.equals(automationStatus, aCase.automationStatus) && Objects.equals(pre_conditions, aCase.pre_conditions) &&
                Objects.equals(post_conditions, aCase.post_conditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, status, description, suite, severity, priority, type, layer, isFlaky, milestone, behavior, automationStatus, pre_conditions, post_conditions);
    }
}
