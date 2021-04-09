import java.util.*;
import java.io.*;
/*

Design a system for the following scenario:
1. An item list contains item code, name, rate, and quantity for several items.
2. Whenever a new item is added in the list uniqueness of item code is to be checked. Register a new product
with its price.
3. Time to time rate of the items may change.
4. Whenever an item is issued or received existence of the item is checked and quantity is updated.
5. In case of issue, availability of quantity is also to be checked.
6. User may also like to know price/quantity available for an item.
7. Find how many items cost more than a given amount. The amount will be a parameter. 8. Remember
that the methods have to return an error code if for example an invalid item code is given

*/

class Item{
    String code;
    String name;
    float rate;
    int quantity;
    void takeInput(int x){
        Scanner obj=new Scanner(System.in);
        System.out.println("Type the name of the Item:");
        name=obj.nextLine();
        System.out.println("Type the rate of the Item:");
        rate=obj.nextFloat();
        System.out.println("Type the quantity of the Item:");
        quantity=obj.nextInt();
        code = name.substring(0,3) + String.valueOf(x);
    }
    void display(){
        System.out.println("Item name:" + name + " " + "Code: " + code + " " + "Rate: " + rate + " " + "Quantity: " + quantity);
    }
}

class Shop{
    ArrayList<Item> a = new ArrayList<Item>();
    static int curr = 0;
    public void addNewItem(){
        curr++;
        Item i = new Item();
        i.takeInput(curr);
        a.add(i);
    }
    public void rateChange(){
        Scanner obj=new Scanner(System.in);
        System.out.println("Type the name of the Item:");
        String n=obj.nextLine();
        int ind=-1;
        for(int i=0;i<a.size();i++){
            if(a.get(i).name.equals(n)){
                ind = i;
            }
        }
        if(ind==-1){
            System.out.println("Item does not exist");
            return;
        }
        System.out.println("Enter new rate:");
        float r=obj.nextFloat();
        a.get(ind).rate=r;
    }  
    public void issueItem(){
        Scanner obj=new Scanner(System.in);
        System.out.println("Type the name of the Item:");
        String n=obj.nextLine();
        int ind=-1;
        for(int i=0;i<a.size();i++){
            if(a.get(i).name.equals(n)){
                ind = i;
            }
        }
        if(ind==-1){
            System.out.println("Item does not exist");
            return;
        }
        System.out.println("Enter quantity:");
        float q=obj.nextInt();
        if(a.get(ind).quantity>=q){
            a.get(ind).quantity-=q;
            System.out.println("Quantity updated.");
        }else{
            System.out.println("Sufficient Quantity not present.");
        }
    }
    public void depositItem(){
        Scanner obj=new Scanner(System.in);
        System.out.println("Type the name of the Item:");
        String n=obj.nextLine();
        int ind=-1;
        for(int i=0;i<a.size();i++){
            if(a.get(i).name.equals(n)){
                ind = i;
            }
        }
        if(ind==-1){
            System.out.println("Item does not exist");
            return;
        }
        System.out.println("Enter quantity:");
        float q=obj.nextInt();
        a.get(ind).quantity+=q;
        System.out.println("Quantity updated.");
        
    }
    public void findPrice(){
        Scanner obj=new Scanner(System.in);
        System.out.println("Type the name of the Item:");
        String n=obj.nextLine();
        int ind=-1;
        for(int i=0;i<a.size();i++){
            if(a.get(i).name.equals(n)){
                ind = i;
            }
        }
        if(ind==-1){
            System.out.println("Item does not exist");
            return;
        }
        System.out.print("The price of the item is ");
        System.out.println(a.get(ind).rate);
    }
    public void findQuantity(){
        Scanner obj=new Scanner(System.in);
        System.out.println("Type the name of the Item:");
        String n=obj.nextLine();
        int ind=-1;
        for(int i=0;i<a.size();i++){
            if(a.get(i).name.equals(n)){
                ind = i;
            }
        }
        if(ind==-1){
            System.out.println("Item does not exist");
            return;
        }
        System.out.println("Enter quantity:");
        float q=obj.nextInt();
        if(a.get(ind).quantity>=q){
            System.out.println("Sufficient quantity present.");
        }else{
            System.out.println("Sufficient Quantity not present.");
        }

    }
    public void findNumberAbove(float r){
        System.out.println("The number of items above that price:");
        for(int i=0;i<a.size();i++){
            if(a.get(i).rate>r){
                System.out.println(a.get(i).name);
            }
        }
    }
    public void displayAll(){
        for(int i=0;i<a.size();i++){
            a.get(i).display();
        }
    }
}

class Two{
    public static void main(String args[]){
            String user;
        int ch;
        Scanner sc = new Scanner(System.in);
        Shop s = new Shop();
        System.out.println(" Enter SEO for Stock entry operator, SK for Shopkeeper, nothing to exit : ");
        user = sc.nextLine();
        while (!user.equals("")) {
            float am;
            String ic;
            char c;
            switch (user.toUpperCase()) {
            case "SK":
                System.out.println("Enter 1 to add item, 2 to change rate(price) of an item");
                System.out.print("3 to issue an item,4 to deposit fresh supply an item, 0 to exit : ");
                ch = sc.nextInt();
                while (ch != 0) {
                    switch (ch) {
                    case 1:
                        System.out.println("Enter item details.");
                        s.addNewItem();
                        s.displayAll();
                        break;
                    case 2:
                        s.rateChange();
                        s.displayAll();
                        break;
                    case 3:
                        s.issueItem();
                        s.displayAll();
                        break;
                    case 4:
                        s.depositItem();
                        s.displayAll();
                        break;
                    default:
                        if (ch != 0)
                            System.out.println("Wrong input.");
                        break;
                    }
                    System.out.print("Enter your choice (0/1/2/3/4) : ");
                    ch = sc.nextInt();
                }
                break;
            case "SEO":
            default:
                if (user.equals(""))
                    break;
                System.out.println("Enter 1 to add item, 2 to change rate(price) of an item");
                System.out.println("3 to issue an item,4 to deposit new items, 5 to check quantity of an item");
                System.out.println("6 to know price of an item");
                System.out.print("7,to know how many items cost more than a given amount. 0 to exit : ");
                ch = sc.nextInt();
                while (ch != 0) {
                    switch (ch) {
                    case 1:
                        System.out.println("Enter item details.");
                        s.addNewItem();
                        s.displayAll();
                        break;
                    case 2:
                        s.rateChange();
                        s.displayAll();
                        break;
                    case 3:
                        s.issueItem();
                        s.displayAll();
                        break;
                    case 4:
                        s.depositItem();
                        s.displayAll();
                        break;
                    case 5:
                        s.findQuantity();
                        break;
                    case 6:
                        s.findPrice();
                        break;
                    case 7:
                        System.out.print("Enter amount : ");
                        am = sc.nextFloat();
                        s.findNumberAbove(am);
                        break;
                    default:
                        if (ch != 0)
                            System.out.println("Wrong input.");
                    }
                    System.out.println("Enter your choice (0/1/2/3/4/5/6/7) : ");
                    ch = sc.nextInt();
                }

            }
            System.out.println("Enter your choice (SEO/SK/) : ");
            user = sc.nextLine();
        }
        sc.close();
    }
}