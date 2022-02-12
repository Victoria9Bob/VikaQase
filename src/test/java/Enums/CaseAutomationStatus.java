package Enums;

public enum CaseAutomationStatus {
    NOT_AUTOMATED("Not automated"),
    TO_BE_AUTOMATED("To be automated"),
    AUTOMATED("Automated");

    private String name;

    CaseAutomationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CaseAutomationStatus fromString(String text) {
        for (CaseAutomationStatus b : CaseAutomationStatus.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
