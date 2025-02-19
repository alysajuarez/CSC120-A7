import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Neilson", "Central Campus", 3));
        myMap.addBuilding(new House("Comstock", "The Quad", 3, true, true));
        myMap.addBuilding(new House("Cushing", "The Quad", 4, true));
        myMap.addBuilding(new House("King", "The Quad", 4, true, true));
        myMap.addBuilding(new Cafe("Compass", "Neilson", 1));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "Central Campus", 1));
        myMap.addBuilding(new House("Morrow", "The Quad", 4, false));
        myMap.addBuilding(new House("Tyler", "Green Street", 3, true));
        myMap.addBuilding(new Building("Sabin Reed", "44 College Ln, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Campus Center", "100 Elm St, Northampton, MA 01063", 2));
        myMap.addBuilding(new Library("Forbes", "20 West St, Northampton, MA 01060 (Off-Campus)", 3));
        System.out.println(myMap);
    }
    
}
