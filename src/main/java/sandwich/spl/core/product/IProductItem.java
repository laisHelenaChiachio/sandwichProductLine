package sandwich.spl.core.product;

public interface IProductItem {
  String getName();
  void setName(String name);

  String getDescription();
  void setDescription(String description);

  float getPrice();
  void setPrice(float price);

  int getMinQuantity();
  void setMinQuantity(int q);

  int getMaxQuantity();
  void setMaxQuantity(int q);
}
