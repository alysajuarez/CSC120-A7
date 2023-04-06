Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

For the House class, I overloaded the house constructor to add the parameter for if the house has an elevator; I chose to overload the constructor for this because most houses don't have elevators, but some do and we would need to know this for the goToFloor method. I also overloaded the moveIn method to add a parameter of an int for room; I did this so that in the print statement returned we can also see which room the resident moved into. 

For the Library class, I overloaded the constructor. The boolean hasElevator is set to true. The default constructor does not take in the boolean as a parameter. I chose to overload the constructor and add the method with the hasElevator parameter so that the boolean could be set to false for the rare cases in which a library does not have an elevator. I also overloaded the removeTitle method to add a parameter for the condition of the book; I did this so that the condition for the book being removed could be added to add context to why it may be being removed. 

For the Cafe class, I overloaded the sellCoffee method to have an instance for selling a default type of coffee in which only the size changes, and therefore creams and sugars are not included in the parameters. I also overloaded the restock method to have a method in which only number of cups to restock is taken as a parameter in cases when the cafe just needs more cups and doesn't need to restock any other materials since they might run out of cups more quickly.


What worked for me was figuring out how to use super when overriding methods. At first I was very confused, but after taking some to understand that super was taking from the parent class but could then have certain aspects switched, helped make overriding easier. One thing I struggled with was with figuring out which methods to overload. Once I got some practice with overloading methods it went quite well, but sometimes it was hard to figure out where to do so and what would be beneficial to do. Advice I would give students in the future is to maybe consult with other peers in order to brainstorm different things and ways to overload methods.



