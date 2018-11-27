package sandwich.spl.core.order;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class Order {
  @Getter
  private List<OrderItem> items = new ArrayList<>();

// TODO => Fix error
  public float getTotalPrice() {
//    return items.stream()
//        .map(itm -> itm.getProduct().getPrice()
//            + itm.getSubItems().stream()
//            .map(sub -> sub.getPrice() * sub.getQuantity())
//            .reduce((s1, s2) -> s1+s2)
//        )
//        .reduce((i1, i2) -> a+b)
//        .orElse(0.00f);
    return 0;
  }
}
