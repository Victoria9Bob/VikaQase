package enums;

public enum SuiteParentSuite {
    PROJECT_ROOT("Project root"),
    AUTHORIZATION("Authorization"),
    PROJECTS("Projects"),
    WORKSPACE("Workspace");

    private String name;

    SuiteParentSuite(String name) {
        this.name = name;
    }

    public static SuiteParentSuite fromString(String text) {
        for (SuiteParentSuite b : SuiteParentSuite.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
