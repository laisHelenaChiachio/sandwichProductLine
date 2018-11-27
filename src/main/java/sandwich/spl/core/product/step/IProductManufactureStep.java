package sandwich.spl.core.product.step;

import java.util.List;
import sandwich.spl.variants.product.ProductItem;

public interface IProductManufactureStep {

  int getMinQuantity();
  void setMinQuantity(int q);

  int getMaxQuantity();
  void setMaxQuantity(int q);

  List<ProductItem> getSubItems();
}
