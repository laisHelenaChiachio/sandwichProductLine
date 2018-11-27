package sandwich.spl.core.order;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class Order {
  @Getter
  private List<OrderItem> items = new ArrayList<>();

  public float TotalCost() {
    return items.stream()
        .map(a -> a.getProduct().getProductPrice())
        .reduce((a, b) -> a+b)
        .orElse(0.00f);
  }
}
