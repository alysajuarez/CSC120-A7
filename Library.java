import java.util.Hashtable;

//import javax.management.RuntimeErrorException;

/* This is a stub for the Library class */
public class Library extends Building{

  /**
  * private Hashtable of Strings and Booleans for books in collection
  */
  private Hashtable<String, Boolean> collection;
  boolean hasElevator = true;


    /**
    * constructs attributes for Library class
    * @param String name 
    *         name of library
    * @param String address
    *         address of library
    * @param int nFloors
    *         int of number of floors in library
    */ 
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: " + this.name);
    }

  
    /**
    * overloaded construtor with added hasElevator parameter for rare cases when a library does not have an elevator 
    * @param String name 
    *         name of library
    * @param String address
    *         address of library
    * @param int nFloors
    *         int of number of floors in library
    * @param boolean hasElevator
    *         boolean for whether or not library has elevator
    */ 
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: " + this.name);
    }


    


    /**
    * method to get number of books in library
    * @return this.collection.size()
    */
    public int nBooks() {
      return this.collection.size();
    }
    

    /**
    * method to add a book to library's collection
    * @param String title
    *           title of book to add along with key to indicate true or false to if it's checked out
    */
    public void addTitle(String title){
      this.collection.put(title, true);
    }


    /** 
    * method to remove a book from library's collection
    * @param String title
    *           title of book to remove 
    * @return String 
    *     of title removed 
    */
    public String removeTitle(String title) { 
      if (!this.collection.containsKey(title)){ 
        throw new RuntimeException(title + " is not a part of this library's collection");
      }
        this.collection.remove(title); 
        return title + "has been removed from the library's collection";
        
    }


    /** 
    * overloaded method to remove a book from library's collection along with a parameter for condition of book
    * @param String title
    *           title of book to remove 
    * @param String condition
    *           condtion of the book 
    * @return String
    *     of title removed and its condition
    */
    public String removeTitle(String title, String condition) { 
      if (!this.collection.containsKey(title)){ 
        throw new RuntimeException(title + " is not a part of this library's collection");
      }
        this.collection.remove(title); 
        return title + " has been removed from the library's collection. it was in " + condition + " conditon";
        
    }


    /** 
    * method to check out a book from the library if it is in the collection and available and change value to false 
    * @param String title
    *           title of book 
    */
    public void checkOut(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException(title + " is not a part of this library's collection");
      }
      else {
        if (this.collection.get(title) != true){
          throw new RuntimeException(title + " is currently checked out");
        }
        else {
          this.collection.replace(title, true, false);
        }
      }
    }


    /** 
    * method to return book to library
    * @param String title
    *           title of book 
    */
    public void returnBook(String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException(title + " is not a part of this library's collection, you cannot return it");
      }
      else {
        if (this.collection.get(title) == true){
          throw new RuntimeException(title + " has not been checked out by you");
        }
        else {
          this.collection.replace(title,false, true);
        }
      }
    }



    /** 
    * method to return book to library
    * @param String title
    *          title of book 
    * @return boolean containsTitle
    *         returns true if the title appears as a key in collection, false otherwise
    */
    public boolean containsTitle(String title){ 
      if (this.collection.containsKey(title)){
        return true;
      }
      else{
        return false;
      }
    }
  

    /** 
    * method to return book to library
    * @param String title
    *          title of book 
    * @return boolean isAvailable
    *         returns true if the title is currently available, false otherwise
    */
    public boolean isAvailable(String title){ 
      if (this.collection.containsKey(title)==true){
        if (this.collection.get(title)==true){
          return true;
        }
        else{
          System.out.println(title + " is currently checked out");
          return false;
    
        }
      }
      else{
        System.out.println(title + " is not a part of this library's collection");
        return false;
      }
    }
      
      

    /** 
    * method to print out the entire collection in an easy-to-read way (including checkout status)
    * 
    */
    public void printCollection(){ // 
      if (this.collection.isEmpty()){
        System.out.println("no books");
      }
      else{
        System.out.println(collection.toString()); 
      }
    
    }

    /** 
    * method to go to a floor in library if there is an elevator 
    * @param int floorNum
    *     floor number to go to 
    */
    public void goToFloor(int floorNum) {
      if (this.hasElevator) {
        super.goToFloor(floorNum);
      } else {
        throw new RuntimeException(this.name + " does not have an elevator");
      }
    }



    /** 
    * method to print the methods for the library
    */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + nBooks()\n + addTitle(n)\n + removeTitle(n)\n + checkOut(n)\n + returnBook(n)\n + containsTitle(n)\n + isAvailable(n)\n + printCollection()" );
    }


    /** 
    * method to return string of class in a clean way 
    * 
    * @return String toString
    *         string description of class
    */  
    public String toString() {
      String description = super.toString();
      description += " there are currently " + this.nBooks() + " books in this library's collection";
      return description;
    }




  
    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "Central Campus", 3);
      Library littlelibrary = new Library("little library", "downtown", 1, false);
      //System.out.println(forbes);
      neilson.addTitle("the shining");
      neilson.addTitle("the hunger games");
      neilson.addTitle("citizen");
      //System.out.println(neilson);
      neilson.printCollection();
      neilson.removeTitle("the hunger games");
      neilson.printCollection();
      // System.out.println(neilson);
      neilson.checkOut("citizen");
      neilson.printCollection();
      //neilson.isAvailable("citizen");
      neilson.returnBook("citizen");
      neilson.isAvailable("citizen");
      //System.out.println(neilson.containsTitle("citizen"));
      // System.out.println(neilson.containsTitle("the hunger games"));
      neilson.showOptions();
      neilson.enter();
      neilson.goToFloor(3);
      System.out.println(neilson.removeTitle("the shining", "poor"));
      littlelibrary.enter();
      littlelibrary.goToFloor(2);
    
    }
  
  }