package sandwich.spl.core.product;

import java.util.List;
import sandwich.shared.Category;

public interface IProduct {
  String getName();
  void setName(String name);

  String getDescription();
  void setDescription(String description);

  float getPrice();
  void setPrice(float price);

  Category getCategory();

  List<IProductItem> getSubItems();
}
