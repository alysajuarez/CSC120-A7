//import javax.management.RuntimeErrorException;

/* This is a stub for the Cafe class */
public class Cafe extends Building {

    /**
    * private int for the number of ounces of coffee remaining in inventory
    */
    private int nCoffeeOunces; 
    /**
    * private int for the number of sugar packets remaining in inventory
    */
    private int nSugarPackets; 
    /**
    * private int for the number of "splashes" of cream remaining in inventory
    */
    private int nCreams; 
    /**
    * private int for the number of cups remaining in inventory
    */
    private int nCups; 


    /** 
    * constructs attributes for Library class
    * @param String name 
    *         name of cafe
    * @param String address
    *         address of cafe
    * @param int nFloors
    *         int of number of floors in cafe
    */ 
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 500;
        this.nSugarPackets = 200;
        this.nCreams = 200;
        this.nCups = 30;
        System.out.println("You have built a cafe: "+ this.name);
    }
    

    /** 
    * method to sell coffee
    * @param int size
    *           size of drink being sold
    * @param int nSugarPackets
    *           number of sugar packets in coffee
    * @param int nCreams
    *           number of splashes of cream in coffee
    */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){

        if (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams || this.nCups < 1){
            restock(100, 50, 50, 20);
            this.nCoffeeOunces = this.nCoffeeOunces - size;
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
            this.nCreams = this.nCreams - nCreams;
            this.nCups = this.nCups - 1;
        }
        else{
            this.nCoffeeOunces = this.nCoffeeOunces - size;
            this.nSugarPackets = this.nSugarPackets - nSugarPackets;
            this.nCreams = this.nCreams - nCreams;
            this.nCups = this.nCups - 1;

        }

    }


    /** 
    * overloaded method to sell the default coffee in a particular size
    * @param int size
    *           size of drink being sold
    */
    public void sellCoffee(int size){

        this.sellCoffee(size, 2, 2);
    }


    /** 
    * method to restock cafe items when needed
    * @param int nCoffeeOunces
    *           ounces of coffee to add to stock
    * @param int nSugarPackets
    *           number of sugar packets in coffee to add to stock
    * @param int nCreams
    *           number of splashes of cream in coffee to add to stock 
    * @param int int nCups
    *           number of cups to restock
    */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
    
    }


    /** 
    * overloaded method to restock cups when cafe needs more cups but doesn't need other items
    * @param int int nCups
    *           number of cups to restock
    */
    private void restock(int nCups){
        this.nCups = this.nCups + nCups;
    
    }


    /** 
    * method to print the methods for the cafe  
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()\n + restock()" );
    }


   

    /** 
    * method to throw exception if someone tries to go to another floor of cafe
    * @param int floorNum
    *     floor number to go to 
    */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("you are not permitted to move floors in this building");
    }


    /** 
    * method to return string of class in a clean way 
    * 
    * @return String toString
    *         string description of class
    */  
    public String toString() {
        String description = super.toString();
        description += " There are currently " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " sugar packets, " + this.nCreams + " splashes of cream, and " + this.nCups + " cups in stock";
        return description;
      }


    public static void main(String[] args) {
        Cafe starbucks = new Cafe("Starbucks", "King St", 1);
        System.out.println(starbucks);
        starbucks.sellCoffee(490, 199, 199);
        System.out.println(starbucks);
        starbucks.sellCoffee(15, 3, 3);
        System.out.println(starbucks);
        starbucks.showOptions();

        starbucks.sellCoffee(16);
        System.out.println(starbucks);
        starbucks.restock(10);
        System.out.println(starbucks);

        starbucks.enter();
        starbucks.goToFloor(2);
        
    }
    
}
