package com.pluralsight;

public enum ShellType {

    CORN("Corn"),
    FLOUR("Flour"),
    HARD_SHELL("Hard Shell"),
    BOWL("Bowl");

    private final String displayName;

    ShellType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
