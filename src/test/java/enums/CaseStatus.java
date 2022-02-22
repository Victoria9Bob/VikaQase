package enums;

public enum CaseStatus {
    ACTUAL("Actual"),
    DRAFT("Draft"),
    DEPRECATED("Deprecated");

    private String name;

    CaseStatus(String name) {
        this.name = name;
    }

    public static CaseStatus fromString(String text) {
        for (CaseStatus b : CaseStatus.values()) {
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
