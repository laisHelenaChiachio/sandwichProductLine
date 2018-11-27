package sandwich.spl.core.order;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sandwich.spl.core.product.Product;
import sandwich.spl.variants.product.subitem.ProductItem;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
  private Product product;
  private Collection<ProductItem> subItems;
}
