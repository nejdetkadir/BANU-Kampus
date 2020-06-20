package com.nejdetkadirr.banucampus.ui.communities;

public class Community {

    String image;
    String name;
    String manager;
    String advisor;

    public Community(String image, String name, String manager, String advisor) {
        this.image = image;
        this.name = name;
        this.manager = manager;
        this.advisor = advisor;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public String getAdvisor() {
        return advisor;
    }
}
