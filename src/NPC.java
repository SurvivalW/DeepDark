public class NPC {
    String name;
    String location;
    String relashionship;

    public NPC(String name, String location, String relashionship)
    {
        this.name = name;
        this.location = location;
        this.relashionship = relashionship;
    }

    public void updateRelashionship(String updatedRelashionship)
    {
        relashionship = updatedRelashionship;
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
        return relashionship;
    }
}
