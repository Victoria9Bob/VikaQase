package Enums;

public enum CaseType {
    OTHER("Other"),
    FUNCTIONAL("Functional"),
    SMOKE("Smoke"),
    REGRESSION("Regression"),
    SECURITY("Security"),
    USABILITY("Usability"),
    PERFORMANCE("Performance"),
    ACCEPTANCE("Acceptance"),
    COMPATIBILITY("Compatibility"),
    INTEGRATION("Integration"),
    EXPLORATORY("Exploratory");

    private String name;

    CaseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CaseType fromString(String text) {
        for (CaseType b : CaseType.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
