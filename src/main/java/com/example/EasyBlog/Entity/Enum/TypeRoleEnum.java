package com.example.EasyBlog.Entity.Enum;

public enum TypeRoleEnum {
    READER("Reader"),
    WRITER("Writer"),
    MOD("Mod"),
    ADMIN("Admin");

    private final String description;

    private TypeRoleEnum (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
