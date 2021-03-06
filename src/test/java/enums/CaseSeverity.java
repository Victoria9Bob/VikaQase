package enums;

public enum CaseSeverity {
    NOT_SET("Not set"),
    BLOCKER("Blocker"),
    CRITICAL("Critical"),
    MAJOR("Major"),
    NORMAL("Normal"),
    MINOR("Minor"),
    TRIVIAL("Trivial");

    private String name;

    CaseSeverity(String name) {
        this.name = name;
    }

    public static CaseSeverity fromString(String text) {
        for (CaseSeverity b : CaseSeverity.values()) {
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
