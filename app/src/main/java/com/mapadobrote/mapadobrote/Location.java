package com.mapadobrote.mapadobrote;

public class Location {
    public int id;
    public String nameOfLocation;
    public String stateOfLocation;
    public String addressOfLocation;
    public String workingHours;
    public String descriptionOfLocation;
    public String emailOfLocation;
    public String facebookPage;
    public String webSite;

    Location(int id, String nameOfLocation, String stateOfLocation, String addressOfLocation, String workingHours, String descriptionOfLocation, String emailOfLocation, String facebookPage, String webSite) {
        this.id = id;
        this.nameOfLocation = nameOfLocation;
        this.stateOfLocation = stateOfLocation;
        this.addressOfLocation = addressOfLocation;
        this.workingHours = workingHours;
        this.descriptionOfLocation = descriptionOfLocation;
        this.emailOfLocation = emailOfLocation;
        this.facebookPage = facebookPage;
        this.webSite = webSite;
    }
}
