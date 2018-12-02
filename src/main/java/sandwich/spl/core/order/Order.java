package sandwich.spl.core.order;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.binding.Bindings;
import lombok.Getter;

public class Order {
  @Getter
  private List<OrderItem> items = new ArrayList<>();

// TODO => Fix error
  public float getTotalPrice() {
    return items.stream()
        .map(oi -> oi.getTotalPrice())
        .reduce((a, b) -> a+b)
        .orElse(0.00f);
  }

    public List<OrderItem> getItems() {
      return items;
    }
}
