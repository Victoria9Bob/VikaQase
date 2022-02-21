package enums;

public enum CaseBehavior {
    NOT_SET("Not set"),
    POSITIVE("Positive"),
    NEGATIVE("Negative"),
    DESTRUCTIVE("Destructive");

    private String name;

    CaseBehavior(String name) {
        this.name = name;
    }

    public static CaseBehavior fromString(String text) {
        for (CaseBehavior b : CaseBehavior.values()) {
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
