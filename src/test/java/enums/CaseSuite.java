package enums;

public enum CaseSuite {
    TEST_CASES_WITHOUT_SUITE("Test cases without suite"),
    AUTHORIZATION("Authorization"),
    PROJECTS("Projects"),
    WORKSPACE("Workspace");

    private String name;

    CaseSuite(String name) {
        this.name = name;
    }

    public static CaseSuite fromString(String text) {
        for (CaseSuite b : CaseSuite.values()) {
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
