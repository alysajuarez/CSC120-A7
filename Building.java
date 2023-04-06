public class Building {

    /**
    * protected string name for building
    */
    protected String name;
    /**
    * protected string address for building
    */
    protected String address;
    /**
    * protected int for number of floors in building 
    */
    protected int nFloors;
    /**
    * protected int setting  default value if not inside building
    */
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /* Default constructor */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /* Overloaded constructor with address only */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /* Overloaded constructor with name, address */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /* Full constructor */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }


    /* Accessor to get name of buillding */
    public String getName() {
        return this.name;
    }

    /* Accessor to get address of buillding */
    public String getAddress() {
        return this.address;
    }

    /* Accessor to get number of floors of buillding */
    public int getFloors() {
        return this.nFloors;
    }

    /* Navigation methods */

    /** 
    * method to enter the house
    */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /** 
    * method to exit the house
    */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

    /** 
    * method to go to a floor in building if there is an elevator 
    */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /** 
    * method to go up a floor 
    */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /** 
    * method to go down a floor if there is an elevator 
    */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /** 
    * method to print the methods for a building
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }


    /** 
    * method to return string of class in a clean way 
    * 
    * @return String
    *        string description of class
    */  
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();
    }

}
