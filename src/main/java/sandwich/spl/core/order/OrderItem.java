package sandwich.spl.core.order;

import java.util.ArrayList;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sandwich.spl.core.product.IProduct;
import sandwich.spl.core.product.IProductItem;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
  private IProduct product;
  private Collection<IProductItem> subItems;

  public OrderItem(IProduct product){
    this.product = product;
    this.subItems = new ArrayList<>();
  }
}
