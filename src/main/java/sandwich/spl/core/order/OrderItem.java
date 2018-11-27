package sandwich.spl.core.order;

import java.util.ArrayList;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sandwich.spl.core.product.IProduct;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
  private IProduct product;
  private Collection<OrderItemSubitem> subItems;

  public OrderItem(IProduct product){
    this.product = product;
    this.subItems = new ArrayList<>();
  }

  public float getTotalPrice() {
    return product.getPrice() + subItems
        .stream()
        .map(s -> s.getQuantity() * s.getSubItem().getPrice())
        .reduce((a, b) -> a+b)
        .orElse(0.00f);
  }
}
