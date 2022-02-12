package Enums;

public enum CaseIsFlaky {
    NO("No"),
    YES("Yes");

    private String name;

    CaseIsFlaky(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CaseIsFlaky fromString(String text) {
        for (CaseIsFlaky b : CaseIsFlaky.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
