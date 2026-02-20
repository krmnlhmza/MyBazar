import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static List<Person> users = new ArrayList<>();
    public static List<Item> items = new ArrayList<>();
    public static List<Campaign> campaigns = new ArrayList<>();


    public static int customerIdCounter = 1;
    public static int itemIdCounter = 1;

    public static void main(String[] args) {

        String usersFile = "users.txt";
        String itemsFile = "item.txt";
        String commandsFile = "commands.txt";


        loadUsers(usersFile);


        loadItems(itemsFile);


        processCommands(commandsFile);
    }



    private static void loadUsers(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                String type = parts[0];
                String name = parts[1];
                String email = parts[2];
                Date dob = parseDate(parts[3]);

                if (type.equals("ADMIN")) {
                    double salary = Double.parseDouble(parts[4]);
                    String password = parts[5];
                    users.add(new Admin(name, email, dob, salary, password));
                } else if (type.equals("TECH")) {
                    double salary = Double.parseDouble(parts[4]);
                    boolean isSenior = parts[5].equals("1"); // 1 ise senior
                    users.add(new Technician(name, email, dob, salary, isSenior));
                } else if (type.equals("CUSTOMER")) {
                    double balance = Double.parseDouble(parts[4]);
                    String password = parts[5];
                    // ID otomatik atanıyor
                    users.add(new Customer(customerIdCounter++, name, email, dob, balance, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadItems(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                String type = parts[0];
                Item newItem = null;


                if (type.equals("DESKTOP")) {
                    newItem = new Desktop(Double.parseDouble(parts[1]), 0, parts[2], parts[3],
                            Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7],
                            Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), parts[10]);
                } else if (type.equals("LAPTOP")) {
                    newItem = new Laptop(Double.parseDouble(parts[1]), 0, parts[2], parts[3],
                            Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7],
                            Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), Integer.parseInt(parts[10]));
                } else if (type.equals("BOOK")) {
                    newItem = new Book(Double.parseDouble(parts[1]), 0, parts[2], parts[3], parts[4], parts[5], Integer.parseInt(parts[6]));
                }



                else if (type.equals("TABLET")) {
                    newItem = new Tablet(Double.parseDouble(parts[1]), 0, parts[2], parts[3],
                            Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7],
                            Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), parts[10]);
                } else if (type.equals("TV")) {
                    newItem = new TV(Double.parseDouble(parts[1]), 0, parts[2], parts[3],
                            Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]));
                } else if (type.equals("SMARTPHONE")) {
                    newItem = new SmartPhone(Double.parseDouble(parts[1]), 0, parts[2], parts[3],
                            Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6]);
                } else if (type.equals("CDDVD")) {
                    newItem = new CDDVD(Double.parseDouble(parts[1]), 0, parts[2], parts[3], parts[4], parts[5]);
                } else if (type.equals("PERFUME")) {
                    newItem = new Perfume(Double.parseDouble(parts[1]), 0, parts[2], parts[3], parts[4],
                            Integer.parseInt(parts[5]), parts[6].equals("1"), Integer.parseInt(parts[7]));
                } else if (type.equals("HAIRCARE")) {
                    newItem = new HairCare(Double.parseDouble(parts[1]), 0, parts[2], parts[3], parts[4],
                            Integer.parseInt(parts[5]), parts[6].equals("1"), parts[7].equals("1"));
                } else if (type.equals("SKINCARE")) {
                    newItem = new SkinCare(Double.parseDouble(parts[1]), 0, parts[2], parts[3], parts[4],
                            Integer.parseInt(parts[5]), parts[6].equals("1"), parts[7].equals("1"));
                }

                if (newItem != null) {
                    newItem.setItemID(itemIdCounter++); // ID ata ve artır

                    newItem.setStock(10);
                    items.add(newItem);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processCommands(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\t");
                String command = parts[0];


                switch (command) {
                    case "ADDCUSTOMER":

                        String adminName = parts[1];
                        Person adminUser = findUserByName(adminName);

                        if (adminUser == null || !(adminUser instanceof Admin)) {
                            System.out.println("No admin person named " + adminName + " exists!");
                        } else {

                            users.add(new Customer(customerIdCounter++, parts[2], parts[3], parseDate(parts[4]),
                                    Double.parseDouble(parts[5]), parts[6]));

                        }
                        break;

                    case "SHOWCUSTOMER":

                        String adminNameShow = parts[1];
                        int custIdShow = Integer.parseInt(parts[2]);
                        Person adminShow = findUserByName(adminNameShow);

                        if (adminShow == null || !(adminShow instanceof Admin)) {
                            System.out.println("No admin person named " + adminNameShow + " exists!");
                        } else {
                            Customer c = findCustomerById(custIdShow);
                            if (c != null) {
                                System.out.println(c.toString());
                            } else {
                                System.out.println("No customer with ID " + custIdShow + " exists!");
                            }
                        }
                        break;

                    case "SHOWCUSTOMERS":
                        String adminNameAll = parts[1];
                        Person adminAll = findUserByName(adminNameAll);
                        if (adminAll == null || !(adminAll instanceof Admin)) {
                            System.out.println("No admin person named " + adminNameAll + " exists!");
                        } else {
                            for (Person p : users) {
                                if (p instanceof Customer) {
                                    System.out.println(p.toString());
                                }
                            }
                        }
                        break;

                    case "ADDTOCART":

                        int cIdCart = Integer.parseInt(parts[1]);
                        int iIdCart = Integer.parseInt(parts[2]);
                        Customer cartCust = findCustomerById(cIdCart);

                        if (cartCust == null) {
                            System.out.println("No customer with ID number " + cIdCart + " exists!");
                        } else {
                            Item itemToAdd = findItemById(iIdCart);
                            if (itemToAdd == null) {
                                System.out.println("Invalid item ID");
                            } else {
                                if (itemToAdd.getStock() > 0) {
                                    cartCust.getCart().addItem(itemToAdd);
                                    System.out.println("The item " + itemToAdd.getClass().getSimpleName() +
                                            " has been successfully added to your cart.");
                                } else {
                                    System.out.println("We are sorry. The item is temporarily unavailable.");
                                }
                            }
                        }
                        break;

                    case "ORDER":

                        int cIdOrder = Integer.parseInt(parts[1]);
                        String cPassOrder = parts[2];
                        Customer orderCust = findCustomerById(cIdOrder);

                        if (orderCust == null) {
                            System.out.println("No customer with ID number " + cIdOrder + " exists!");
                        } else {
                            if (!orderCust.getPassword().equals(cPassOrder)) {
                                System.out.println("Order could not be placed. Invalid password.");
                            } else if (orderCust.getCart().getItemList().isEmpty()) {
                                System.out.println("You should add some items to your cart before order request!");
                            } else {

                                double totalOrderPrice = 0;
                                List<Item> cartItems = orderCust.getCart().getItemList();

                                for (Item item : cartItems) {
                                    double itemPrice = item.getPrice();

                                    for (Campaign camp : campaigns) {

                                        String type = item.getClass().getSimpleName().toUpperCase();
                                        if (camp.getItemType().equals(type)) {
                                            itemPrice -= (itemPrice * camp.getDiscountRate() / 100.0);
                                        }
                                    }
                                    totalOrderPrice += itemPrice;
                                }


                                if (orderCust.getStatus() == Status.SILVER) {
                                    totalOrderPrice -= (totalOrderPrice * 0.10);
                                } else if (orderCust.getStatus() == Status.GOLDEN) {
                                    totalOrderPrice -= (totalOrderPrice * 0.15);
                                }


                                if (orderCust.getBalance() >= totalOrderPrice) {

                                    orderCust.setBalance(orderCust.getBalance() - totalOrderPrice);

                                    for (Item item : cartItems) {
                                        item.decreaseStock(1);
                                    }


                                    Order newOrder = new Order(cIdOrder, totalOrderPrice, new ArrayList<>(cartItems));
                                    orderCust.getOrderHistory().add(newOrder);


                                    orderCust.getCart().emptyCart();

                                    System.out.println("Done! Your order will be delivered as soon as possible. Thank you!");



                                } else {
                                    System.out.println("Order could not be placed. Insufficient funds.");
                                }
                            }
                        }
                        break;

                    case "DEPOSITMONEY":

                        int cIdDep = Integer.parseInt(parts[1]);
                        double amount = Double.parseDouble(parts[2]);
                        Customer depCust = findCustomerById(cIdDep);
                        if (depCust != null) {
                            depCust.setBalance(depCust.getBalance() + amount);

                        } else {
                            System.out.println("No customer with ID number " + cIdDep + " exists!");
                        }
                        break;

                    case "EMPTYCART":
                        int cIdEmpty = Integer.parseInt(parts[1]);
                        Customer empCust = findCustomerById(cIdEmpty);
                        if(empCust != null) {
                            empCust.getCart().emptyCart();
                            System.out.println("The cart has been emptied.");
                        } else {
                            System.out.println("No customer with ID number " + cIdEmpty + " exists!");
                        }
                        break;

                    case "CREATECAMPAIGN":

                        String admCamp = parts[1];
                        Person admP = findUserByName(admCamp);
                        if (admP == null || !(admP instanceof Admin)) {
                            System.out.println("No admin person named " + admCamp + " exists!");
                        } else {
                            int rate = Integer.parseInt(parts[5]);
                            String iType = parts[4];
                            if (rate > 50) {
                                System.out.println("Campaign was not created. Discount rate exceeds maximum rate of 50%.");
                            } else {

                                boolean exists = false;
                                for(Campaign c : campaigns) {
                                    if(c.getItemType().equals(iType)) {
                                        exists = true; break;
                                    }
                                }
                                if(exists) {
                                    System.out.println("Campaign already exists for this item type.");
                                } else {
                                    campaigns.add(new Campaign(parts[2], parts[3], iType, rate));

                                }
                            }
                        }
                        break;

                    case "SHOWCAMPAIGNS":
                        int cIdCamp = Integer.parseInt(parts[1]);
                        Customer campCust = findCustomerById(cIdCamp);
                        if (campCust == null) {
                            System.out.println("No customer with ID number " + cIdCamp + " exists!");
                        } else {
                            if (campaigns.isEmpty()) {
                                System.out.println("No campaign has been created so far!");
                            } else {
                                System.out.println("Active campaigns:");
                                for (Campaign c : campaigns) {
                                    System.out.println(c.getDiscountRate() + "% sale of " + c.getItemType() + " until " + "date"); // Date kısmı Campaign classında tutuluyor
                                }
                            }
                        }
                        break;


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Person findUserByName(String name) {
        for (Person p : users) {
            if (p.getName().equals(name)) return p;
        }
        return null;
    }

    private static Customer findCustomerById(int id) {
        for (Person p : users) {
            if (p instanceof Customer && ((Customer) p).getCustomerID() == id) {
                return (Customer) p;
            }
        }
        return null;
    }

    private static Item findItemById(int id) {
        for (Item i : items) {
            if (i.getItemID() == id) return i;
        }
        return null;
    }

    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
        } catch (ParseException e) {
            return new Date();
        }
    }
}