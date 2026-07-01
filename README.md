# TruckLoader-Program
A very simple database implementation, which will read data records from the user, store them in arrays, and then allow the user to printout selected records according to some criteria.

## Objectives
- Creating, storing, and accessing variables
- Understanding the role of types
- Creating expressions from operators, variables and values
- Using conditional execution to implement decision-making
- Creating, storing to, accessing, and iterating through arrays
- Using loops to implement repetitive behaviour
- Nesting conditional execution within loops, or vice versa

## Specifically we require the code to
- the user specifies how many boxes can fit in the truck, which sets how many data records will be read.
- The customer’s name, weight and if the box contains a dangerous good, should then be sequentially read in from the user and stored in arrays.
  - This data should be stored in three separate arrays: one for customer names, one for weight, and one for dangerous goods, i.e. the first element of the names array should be the first box customer name, the first element of the weight array should be the weight of the first box, the first element of the dangerous goods array should be the if the first box contains dangerous goods.
  - To keep things simple, assuming that names will be entered as single words, as in the example, is okay. This will allow you to use Scanner’s next() method rather than nextLine()since the latter can be a bit troublesome.

- The dangerous goods array should be a boolean array, since this is more efficient than storing binary values as strings or characters.
  - That is, “Dangerous Goods” should be stored as true, and “Non-Dangerous Goods” should be stored as false.

- Once the user has finished entering the data, they should be given the option to:
  - List all the entries in the database. You can print every box information, as in the example.
  - List all the entries that match a customer name, as specified by the user.
  - List all the entries that match a particular Dangerous or Non-Dangerous Goods, as specified by the user.
  - Quit, at which point the program should display a farewell message and exit.

- The program should keep asking the user what they want to do until they choose to exit.
  - You will need an outer loop to implement this behaviour.
  - Note that your program will automatically exit when execution reaches the end of the main method. You should not use System.exit() to achieve this.
