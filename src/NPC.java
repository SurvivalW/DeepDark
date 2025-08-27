public class NPC {
    String name;
    String location;
    String relationship;

    public NPC(String name, String location, String relationship)
    {
        this.name = name;
        this.location = location;
        this.relationship = relationship;
    }

    public void updateRelashionship(String updatedRelationship)
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

    public String getRelashionship()
    {
        return relationship;
    }
}
