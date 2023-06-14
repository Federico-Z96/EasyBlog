package com.example.EasyBlog.Entity.Enum;

public enum TypeGenderArticlesEnum {
    COOKING("Cooking"),
    HOME_AND_GARDEN("Home and garden"),
    SPORT("Sport"),
    TECNOLOGIC("Tecnologic"),
    GAMES("Games"),
    NATURE_AND_ANIMALS("Natural"),
    FINANCE("Finance"),
    NEWS("News"),
    GOSSIP("Gossip"),
    OTHER("Other"),;

    private String description;

    private TypeGenderArticlesEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
