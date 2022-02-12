package Enums;

public enum CaseLayer {
    UNKNOWN("Unknown"),
    E2E("E2E"),
    API("API"),
    UNIT("Unit");

    private String name;

    CaseLayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CaseLayer fromString(String text) {
        for (CaseLayer b : CaseLayer.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
