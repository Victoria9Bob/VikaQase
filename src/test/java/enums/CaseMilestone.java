package enums;

public enum CaseMilestone {
    NOT_SET("Not set"),
    RELEASE_1_1("Release 1.1"),
    RELEASE_1_0("Release 1.0");

    private String name;

    CaseMilestone(String name) {
        this.name = name;
    }

    public static CaseMilestone fromString(String text) {
        for (CaseMilestone b : CaseMilestone.values()) {
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
