//Imported
import java.util.ArrayList;
import java.util.Scanner;

class Main {

  //Colour
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

  //Tax Method
  static float taxMethod (float amount, int index){
    return((amount*index)*1.13f);
  }


  public static void main(String[] args) {


    //Pre Code
    Scanner scan = new Scanner(System.in);
    ArrayList<Item> items = new ArrayList<>();
    Item temp;
    ArrayList<String> sort = new ArrayList<String>();
    String name;
    String itemNum0;
    char option = ' ';
    long itemNum = 0;
    int numItems = 0;
    int quantity = 0;
    float price = 0;
    float total = 0;

    //Initial Items
    while(numItems < 5){
      try{
      System.out.print("Number of Items: ");
      numItems = Integer.parseInt(scan.nextLine());
      }
      catch (Exception e){
        System.out.println("Please Enter a Valid Input");
        continue;
      }

      if(numItems < 5){
        System.out.println("At least 5 items must be entered");
      }
    }

    // Name, Item Number, Price, and Quantity for Items
    for (int i = 0; i < numItems; i++) {
      System.out.println("Item #" + (i + 1));

      while (true) {
        try {
          System.out.print("  Name: ");
          name = scan.nextLine();

          // Handling
          if (name.isEmpty() || name.isBlank()) {
            throw new Exception();
          }
          break;
        }
        catch (Exception e) {
          System.out.println("Please Enter a Valid Input");
        }
      }

      while (true) {
        try {
          System.out.print("  Item Number: ");
          itemNum0 = scan.nextLine();
          itemNum = Long.parseLong(itemNum0);

          // Handling
          if (itemNum0.length() != 10) {
            throw new Exception();
          }
          break;
        }
        catch (Exception e) {
          System.out.println("Please Enter a 10 Digit Item Number");
        }
      }

      while (true) {
        try {
          System.out.print("  Price: $");
          price = Float.parseFloat(scan.nextLine());
          break;
        }
        catch (Exception e) {
          System.out.println("Please Enter a Valid Input");
        }
      }

      while (true) {
        try {
          System.out.print("  Quantity: ");
          quantity = Integer.parseInt(scan.nextLine());
          break;
        }
        catch (Exception e) {
          System.out.println("Please Enter a Valid Input");
        }
      }

      items.add(new Item(name, itemNum, price, quantity));
      sort.add(new String(name));
    }

    //Menu Loop*******************************
    while(Character.toUpperCase(option) != 'D'){

      //Inventory Output
      for(int i = 0;i < 56;i++){
        System.out.print("-");
      }
      System.out.printf("%n%s%-17s%-20s%-12s%-12s%s", "|", ANSI_RED_BACKGROUND + ANSI_WHITE + " Item", "Name", "Quantity", "Price After Tax", ANSI_RESET + "|");

      //Objects Loop
      for(int i = 1;i < items.size()+1;i++){
        System.out.printf("%n%s%-7s%-5d%-20s%-12s%s%-14s%s", "|", ANSI_BLUE_BACKGROUND + " #", i, items.get(i-1).getName(), items.get(i-1).getQuantity(), "$", taxMethod(items.get(i-1).getPrice(), items.get(i-1).getQuantity()), ANSI_RESET + "|");
      }

      //Total
      total = 0;
      for(int i=0; i<items.size(); i++){
        total = total + taxMethod(items.get(i).getPrice(), items.get(i).getQuantity());
      }
      System.out.printf("%n%s%40s%-14.2f%s%n", "|" + ANSI_BLUE_BACKGROUND, "Total: $", total, ANSI_RESET + "|");
      for(int i = 0;i < 56;i++){
        System.out.print("-");
      }

      System.out.println(items.size());

      //Modification Options
      System.out.printf("%n%-34s%n%-33s%n%-24s%n", ANSI_BLACK_BACKGROUND + ANSI_RED + "Modifications", ANSI_RESET + ANSI_BLACK_BACKGROUND + "  A. Add to Inventory", "  B. Exit");
      System.out.print(ANSI_RESET + "Option: ");
      option = scan.nextLine().charAt(0);

      //Adding to Inventory
      if(Character.toUpperCase(option) == 'A'){

        while(true){
          try{
            System.out.print("Number of Items to Add: ");
            numItems = Integer.parseInt(scan.nextLine());
            break;
          }
          catch (Exception e){
            System.out.println("Please Enter a Valid Input");
          }
        }

        for(int i = 0;i < numItems;i++){
          System.out.println("Item #" + (items.size() + 1));

          while (true) {
            try {
              System.out.print("  Name: ");
              name = scan.nextLine();

              // Handling
              if (name.isEmpty() || name.isBlank()) {
                throw new Exception();
              }
              break;
            }
            catch (Exception e) {
              System.out.println("Please Enter a Valid Input");
            }
          }

          while (true) {
            try {
              System.out.print("  Item Number: ");
              itemNum0 = scan.nextLine();
              itemNum = Long.parseLong(itemNum0);

              // Handling
              if (itemNum0.length() != 10) {
              throw new Exception();
              }
              break;
            }
            catch (Exception e) {
              System.out.println("Please Enter a 10 Digit Item Number");
            }
          }

          while (true) {
            try {
              System.out.print("  Price: $");
              price = Float.parseFloat(scan.nextLine());
              break;
            }
            //Handling
            catch (Exception e) {
              System.out.println("Please Enter a Valid Input");
            }
          }

          while (true) {
            try {
              System.out.print("  Quantity: ");
              quantity = Integer.parseInt(scan.nextLine());
              break;
            }
            //Handling
            catch (Exception e) {
              System.out.println("Please Enter a Valid Input");
            }
          }

          items.add(new Item(name, itemNum, price, quantity));
          sort.add(new String(name));
        }
      }

      //Alphabetical Sorting
      else if(Character.toUpperCase(option) == 'B'){
        for (int x=0; x<items.size()-1; x++){
          for (int i=0; i<items.size()-1-x; i++){
            if (items.get(i).getName().compareTo(items.get(i+1).getName()) > 0){

              temp = items.get(i);
              items.set(i,items.get(i+1) );
              items.set(i+1, temp);

            }
          }
        }
      }

      //Numerical Sorting
      else if(Character.toUpperCase(option) == 'C'){
        for (int x=0; x<items.size()-1; x++){
          for (int i=0; i < items.size()-1-x; i++){
            if (items.get(i).getPrice() > items.get(i+1).getPrice()){

              temp = items.get(i);
              items.set(i,items.get(i+1) );
              items.set(i+1, temp);

            }
          }
        }
      }
    }
  }
}