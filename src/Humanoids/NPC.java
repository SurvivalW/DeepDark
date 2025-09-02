package Humanoids;
public class NPC {
    public String name;
    public String location;
    public String relationship;

    public NPC(String name, String location, String relationship)
    {
        this.name = name;
        this.location = location;
        this.relationship = relationship;
    }

    public void updateRelationship(String updatedRelationship)
    {
        relationship = updatedRelationship;
    }

    public void updateLocation(String updatedLocation)
    {
        location = updatedLocation;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }

    public String getRelationship()
    {
        return relationship;
    }
}
