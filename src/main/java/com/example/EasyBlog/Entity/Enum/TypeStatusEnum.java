package com.example.EasyBlog.Entity.Enum;

public enum TypeStatusEnum {
    ACTIVE("active"),
    INACTIVE("inactive"),
    SUSPENDED("Suspended");

    private String description;

    private TypeStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
