package sandwich.spl.core.order;

import lombok.Getter;
import lombok.Setter;
import sandwich.spl.core.product.Product;

@Getter
@Setter
public class OrderItem {
  private Product product;
}
