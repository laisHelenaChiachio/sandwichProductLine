package sandwich.spl.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import sandwich.shared.Category;
import sandwich.spl.core.order.Order;
import sandwich.spl.core.order.OrderItem;
import sandwich.spl.core.order.OrderItemSubitem;
import sandwich.spl.core.product.IProduct;
import sandwich.spl.core.product.IProductItem;
import sandwich.spl.core.product.Sandwich;
import sandwich.spl.core.product.step.IProductManufactureStep;
import sandwich.spl.variants.product.ProductItem;
import sandwich.spl.variants.product.step.SandwichStep;

public class Client {

  private final static String DatabaseFilePath = "./database.json";

  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  private static Collection<IProduct> productDatabase;


  public static void main(String[] args) {
    productDatabase = loadDatabase(DatabaseFilePath);

    Order order = mainLoop();
    checkout();
  }

  private static Order mainLoop() {
    Order order = new Order();

    while (true) {
      StringBuilder sb = new StringBuilder()
          .append("  Select your option: ").append('\n')
          .append('\n')
          .append("   0: Cancel Order").append('\n')
          .append("   1: Checkout").append('\n')
          .append('\n');;

      for (int i=0; i<Category.values().length; i++) {
        if (isCategoryValid(Category.values()[i])){
          sb.append("   ")
              .append(i+2)
              .append(": Add a ")
              .append(Category.values()[i].toString().toLowerCase())
              .append('\n');
        }
      }
      sb.append('\n')
          .append("       Total Items: ").append(order.getItems().size()).append('\n')
          .append("       Total Price: ").append(String.format("%10.2f", order.getTotalPrice())).append("$\n")
          .append('\n');

      Print(sb.toString());
      String s;
      try {
        s = reader.readLine();
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }

      switch (s) {
        case "0":
          order = new Order();
          break;
        case "1":
          return order;
        default:
          for (int i=0; i<Category.values().length; i++) {
            if (s.equals(""+(i+2))) {
              Optional<OrderItem> item = addProductLoop(Category.values()[i]);
              if (item.isPresent()) {
                order.getItems().add(item.get());
              }
              break;
            }
          }
      }
    }
  }

  private static boolean isCategoryValid(Category category) {
    return true; // TODO
  }

  private static boolean isSubitemCategoryValid(Category category) {
    return true; // TODO
  }

  private static Optional<OrderItem> addProductLoop(Category category) {
    if (!isCategoryValid(category)){
      return Optional.empty();
    }

    StringBuilder sb = new StringBuilder()
        .append("  Select your ").append(category.toString().toLowerCase()).append(" option: ").append('\n')
        .append('\n')
        .append("   0: [Return]").append('\n')
        .append('\n');

    IProduct[] products = productDatabase.stream()
        .filter(p -> p.getCategory().equals(category))
        .toArray(IProduct[]::new);
    for (int i=0; i<products.length; i++) {
      if (isCategoryValid(Category.values()[i])){
        sb.append("   ")
            .append(i+1)
            .append(": ").append(products[i].getName()).append(" (")
            .append(String.format("%10.2f", products[i].getPrice())).append("$)\n");
      }
    }

    String out = sb.toString();

    while (true) {
      Print(out);
      String s;
      try {
        s = reader.readLine();
      } catch (Exception e) {
        e.printStackTrace();
        return Optional.empty();
      }

      switch (s) {
        case "0":
          return Optional.empty();
        default:
          for (int i=0; i<products.length; i++) {
            if (s.equals(""+(i+1))) {
              // If product has building steps
              if (!products[i].getSteps().isEmpty()) {
                Optional<Collection<OrderItemSubitem>> subItems = stepLoop(category, products[i], 0);
                if (!subItems.isPresent()) {
                  return Optional.empty();
                }
                return Optional.of(new OrderItem(products[i], subItems.get()));
              // Product does not have building steps
              } else {
                return Optional.of(new OrderItem(products[i]));
              }
            }
          }
      }
    }
  }

  private static Optional<Collection<OrderItemSubitem>> stepLoop(Category category, IProduct product, int stepNum) {
    if (!isCategoryValid(category)){
      return Optional.empty();
    }
    List<OrderItemSubitem> subitems = new ArrayList<>();

    while (true) {
      IProductManufactureStep step = product.getSteps().get(stepNum);

      // Construct header
      StringBuilder sb = new StringBuilder()
          .append("  Step ").append(stepNum).append(": ").append(step.getTitle()).append('\n');
      if (step.getMinQuantity() != 0) {
        sb.append("    Min: ").append(step.getMinQuantity());
      }
      if (step.getMaxQuantity() != 0) {
        sb.append("    Max: ").append(step.getMaxQuantity());
      }
      sb.append('\n')
          .append('\n');

      // Construct Navigation Options
      if (stepNum == 0) {
        sb.append("   0: [Cancel]").append('\n');
      } else {
        sb.append("   0: [Previous]").append('\n');
      }

      // Min step items ok
      boolean ok = step.getMinQuantity() <= subitems.stream()
          .filter(itm -> step.getSubItems().contains(itm.getSubItem()))
          .map(itm -> itm.getQuantity())
          .reduce((a, b) -> a+b)
          .orElse(0);
      // Min of each item in step ok
      ok = ok && 0 == subitems.stream()
          .filter(itm -> step.getSubItems().contains(itm.getSubItem()))
          .filter(itm -> itm.getQuantity() < itm.getSubItem().getMinQuantity())
          .count();
      // Only show next step it selected min quantity
      if (ok) {
        if (stepNum == product.getSteps().size() - 1) {
          sb.append("   1: [Finish]").append('\n');
        } else {
          sb.append("   1: [Next]").append('\n');
        }
      }

      // Construct Item options
      for (int i = 0; i < step.getSubItems().size(); i++) {
        IProductItem item = step.getSubItems().get(i);
        sb.append("   ").append(i + 2).append(": ").append(item.getName());
        if (item.getPrice() != 0) {
          sb.append(" - ").append(String.format("%10.2f", item.getPrice()));
        }
        if (item.getMinQuantity() != 0) {
          sb.append(" (min: ").append(item.getMinQuantity()).append(")");
        }
        if (item.getMaxQuantity() != 0) {
          sb.append(" (max: ").append(item.getMaxQuantity()).append(")");
        }
        long count = subitems.stream()
            .filter(itm -> itm.getSubItem() == item)
            .count();
        if (count > 0) {
          sb.append(" (selected: ").append(count).append(")");
        }
        sb.append('\n');
      }

      // Capturing Selection
      Print(sb.toString());
      String s;
      try {
        s = reader.readLine();
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }

      switch (s) {
        case "0": // Previous / Cancel
          if (stepNum == 0) {
            return Optional.empty();
          } else {
            stepNum--;
            continue;
          }
        case "1": // Next / Finish
          if (stepNum == product.getSteps().size() - 1) {
            return Optional.of(subitems);
          } else {
            stepNum++;
            continue;
          }
        default:
          for (int i = 0; i < step.getSubItems().size(); i++) {
            if (s.equals(""+(i+2))) {
              IProductItem item = step.getSubItems().get(i);
              // Max step items ok
              boolean maxReached = (step.getMaxQuantity() > 0) &&
                  step.getMaxQuantity() <= subitems.stream()
                      .filter(itm -> step.getSubItems().contains(itm.getSubItem()))
                      .map(itm -> itm.getQuantity())
                      .reduce((a, b) -> a + b)
                      .orElse(0);
              // Max of each item in step ok
              maxReached = maxReached || subitems.stream()
                  .filter(itm -> itm.getSubItem() == item)
                  .filter(itm -> itm.getQuantity() >= item.getMaxQuantity())
                  .findFirst()
                  .isPresent();

              if (!maxReached) {
                Optional<OrderItemSubitem> curSubitem = subitems.stream()
                    .filter(itm -> itm.getSubItem() == item)
                    .findFirst();
                if (curSubitem.isPresent()) {
                  curSubitem.get().setQuantity(curSubitem.get().getQuantity() + 1);
                } else {
                  subitems.add(new OrderItemSubitem(item, 1));
                }
              }
            }
          }
      }
    }
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
    //FinalProduct fp = FinalProduct.deserializeFromFile(file);
    // TODO
    // Mock values
    Collection<IProduct> ret = new ArrayList<>();

    ret.add(new Sandwich("Sanduba feito 1", "", 5f));
    ret.add(new Sandwich("Sanduba feito 2", "", 6f));
    IProduct p = new Sandwich("Sanduba montar", "", 6f);
    {
      List<IProductManufactureStep> steps = p.getSteps();
      SandwichStep s = new SandwichStep("Sellect Bread", 1, 1);
      steps.add(s);
      {
        List<IProductItem> subItems = s.getSubItems();
        subItems.add(new ProductItem("Normal", "", 0, 0, 0));
        subItems.add(new ProductItem("Gluten Free", "", 0, 0, 0));
      }
      s = new SandwichStep("Sellect Protein", 1, 1);
      steps.add(s);
      {
        List<IProductItem> subItems = s.getSubItems();
        subItems.add(new ProductItem("Beef", "", 0, 0, 0));
        subItems.add(new ProductItem("Chicken", "", 0, 0, 0));
      }
      s = new SandwichStep("Additions?", 0, 0);
      steps.add(s);
      {
        List<IProductItem> subItems = s.getSubItems();
        subItems.add(new ProductItem("Tomato", "", 0, 0, 1));
        subItems.add(new ProductItem("Bacon", "", 2, 0, 1));
      }
    }
    ret.add(p);


    return ret;
  }
}
