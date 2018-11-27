package sandwich.spl.core.product.step;

import java.util.List;
import sandwich.spl.core.product.IProductItem;

public interface IProductManufactureStep {

  String getTitle();
  void setTitle(String title);

  int getMinQuantity();
  void setMinQuantity(int q);

  int getMaxQuantity();
  void setMaxQuantity(int q);

  List<IProductItem> getSubItems();
}
