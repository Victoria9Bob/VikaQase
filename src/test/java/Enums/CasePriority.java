package Enums;

public enum CasePriority {
    NOT_SET("Not set"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private String name;

    CasePriority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CasePriority fromString(String text) {
        for (CasePriority b : CasePriority.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
