package sandwich.spl.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import sandwich.shared.Category;
import sandwich.shared.FinalProduct;
import sandwich.spl.core.order.Order;
import sandwich.spl.core.product.IProduct;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Client {

  private final static String DatabaseFilePath = "./database.json";

  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) {
    //loadDatabase(DatabaseFilePath);

    Order order = addProductLoop();
    checkout();
  }

  private static Order addProductLoop() {
    Order order = new Order();

    StringBuilder sb = new StringBuilder()
        .append("  Select your option: ").append('\n')
        .append('\n')
        .append('\n')
        .append("   1: Cancel Order").append('\n')
        .append("   2: Checkout").append('\n');

    for (int i=0; i<Category.values().length; i++) {
      if (isCategoryValid(Category.values()[i])){
        sb.append("   ")
            .append(i+3)
            .append(": Add a ")
            .append(Category.values()[i].toString().toLowerCase())
            .append('\n');
      }
    }
    sb.append('\n')
        .append("       Total Items: ").append(order.getItems().size()).append('\n')
        .append("       Total Price: ").append(String.format("%10.2f", order.getTotalPrice())).append('\n')
        .append('\n');

    String out = sb.toString();

    while (true) {
      System.out.println();

      Print(out);
      String s;
      try {
        s = reader.readLine();
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }

      switch (s) {
        case "1":
          order = new Order();
          break;
        case "2":
          return order;
        default:
          for (int i=0; i<Category.values().length; i++) {
            if (s.equals(""+(i+3))) {
              addProductLoop(Category.values()[i]);
              break;
            }
          }
      }
    }
  }

  private static boolean isCategoryValid(Category category) {
    return true; // TODO
  }

  private static void addProductLoop(Category category) {
    if (!isCategoryValid(category)){
      return;
    }
    // TODO
  }

  private static void checkout() {

  }

  private static void Print(String s) {
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (Exception ignored) {
      System.out.println("\n\n\n\n\n\n\n\n\n");
    }
    System.out.println(s);
  }

  private static Collection<IProduct> loadDatabase(String file) {
    FinalProduct fp = FinalProduct.deserializeFromFile(file);

    throw new NotImplementedException();
  }
}
