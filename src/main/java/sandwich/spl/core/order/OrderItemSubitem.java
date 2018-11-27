package sandwich.spl.core.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sandwich.spl.core.product.subitem.IProductItem;

@Getter
@Setter
@AllArgsConstructor
public class OrderItemSubitem {
  private IProductItem subItem;
  private short quantity;
}
