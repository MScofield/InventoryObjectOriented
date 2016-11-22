package IronYard;
/*
	Description

Use inheritance in your inventory project. To do so, create at least five different classes for product categories. Each one should set a different value for the "category" field.

Requirements

**Use String.format or System.out.printf anywhere you are manually concatenating strings with +.
**Create at least five classes that extend your existing inventory item class, each one representing a product category.
Each category class should have a constructor that sets the "category" field to the appropriate name.
Create a static createItem method in your main class which returns an object using the correct category class (or throws and error for an invalid category name).
static InventoryItem createItem(String name, int quantity, String category)
Use createItem to create a new item for option 1.
When you list the items, list their category as well.
git addy:  "https://github.com/mscofield/inventoryobjectoriented.git"

	 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public Main() {

    }
    static ArrayList<InventoryItems> inventoryItems = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        //do {
        do {
            int inventoryOptions;
            System.out.println("The options for this inventory are as follows [1/2/3/4]");
            System.out.println("Key [1] to create a new inventory item.");
            System.out.println("Key [2} to remove an item");
            System.out.println("Key [3] to update the quantity of an item.");
            System.out.println("key [4] to list all items in inventory.");
            inventoryOptions = Integer.parseInt(scanner.nextLine());

            switch (inventoryOptions) {
                case 1:
                    System.out.println("Please key the number corresponding to the category you would like your new item filed under:");
                    System.out.println("[1] Lewd References.");
                    System.out.println("[2] Udder Ridiculousness.");
                    System.out.println("[3] Firefly Quotes.");
                    System.out.println("[4] Shameless Nonsense.");
                    System.out.println("[5] Things to Avoid.");
                    int categoryChoice = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please key name of the item you would like added to the list: ");
                    String name = scanner.nextLine();
                    System.out.println("Please key the quantity of the item you are adding to inventory: ");
                    int quantity = Integer.parseInt(scanner.nextLine());


                    //InventoryItems createItem = new InventoryItems(name,quantity,category);
                    inventoryItems.add(createItem(name,quantity, categoryChoice));
                    //createItem(name, quantity, category);
                    break;
                case 2:
                    System.out.println("Enter the number of the item to remove");
                    int itemRemove = Integer.parseInt(scanner.nextLine());
                    inventoryItems.remove(itemRemove - 1);
                    break;
                case 3:
                    System.out.println("Enter the number of the item you would like to update: ");
                    int itemUpdate = Integer.parseInt(scanner.nextLine());
                    InventoryItems itemCall = (inventoryItems.get(itemUpdate - 1));
                    System.out.println("Enter the new quantity value: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    itemCall.quanTITy = newQuantity;

                    break;
                case 4:
                    int i = 1;
                    for (InventoryItems itemList : inventoryItems) {
                        System.out.printf("%d. %s - %s \n", i, itemList.itemName, itemList.cateGory);
                        //System.out.println(i + ". " + itemList.itemName);
                        {
                            i++;
                        }
                    }
                    break;
            }
            //}while (logOut);

        }while (true) ;
    }
    public static InventoryItems createItem(String name, int quantity, int categoryChoice) {
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter the name if the item you would like added to the list: ");
        //String itemName = scanner.nextLine();
        if (categoryChoice == 1){
            LewdReferences itemAdd = new LewdReferences(name,quantity);
            return  itemAdd;
        }else if(categoryChoice == 2){
            UdderRidiculousness itemAdd = new UdderRidiculousness(name,quantity);
            return itemAdd;
        }else if(categoryChoice == 3){
            Fireflyisms itemAdd = new Fireflyisms(name,quantity);
            return itemAdd;
        }else if(categoryChoice == 4){
            ShamelessNonsense itemAdd = new ShamelessNonsense(name,quantity);
            return itemAdd;
        }else if(categoryChoice == 5){
            ThingsToAvoid itemAdd = new ThingsToAvoid(name,quantity);
            return itemAdd;
        }else
            return null;
        //InventoryItems itemAdd = new InventoryItems();
        //inventoryItems.add(itemAdd);

    }
}
