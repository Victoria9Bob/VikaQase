package Models;

import Enums.SuiteParentSuite;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Data
@Builder
public class Suite {
    private String suiteName;
    private SuiteParentSuite parentSuite;
    private String description;
    private String preconditions;

    public Suite(String suiteName, SuiteParentSuite parentSuite, String description, String preconditions) {
        this.suiteName = suiteName;
        this.parentSuite = parentSuite;
        this.description = description;
        this.preconditions = preconditions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Suite)) return false;
        Suite suite = (Suite) o;
        return Objects.equals(getSuiteName(), suite.getSuiteName()) && Objects.equals(getParentSuite(), suite.getParentSuite()) && Objects.equals(getDescription(), suite.getDescription()) && Objects.equals(getPreconditions(), suite.getPreconditions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuiteName(), getParentSuite(), getDescription(), getPreconditions());
    }
}
