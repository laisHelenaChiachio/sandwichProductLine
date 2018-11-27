package sandwich.spl.variants.product.subitem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import sandwich.spl.core.product.subitem.IProductItem;

@Builder
@AllArgsConstructor
public class ProductItem implements IProductItem {

  private String name;
  private String description;
  private float price;
  private int minQuantity = 0;
  private int maxQuantity = 0;

  public ProductItem(String name, String description, float price){
    this.name = name;
    this.description = description;
    this.price = price;
  }

  @Override
  public String getName() { return name; }
  @Override
  public void setName(String name) { this.name = name; }

  @Override
  public String getDescription() { return description; }
  @Override
  public void setDescription(String description) { this.description = description; }

  @Override
  public float getPrice() { return price; }
  @Override
  public void setPrice(float price) {this.price = price; }

  @Override
  public int getMinQuantity() { return minQuantity; }
  @Override
  public void setMinQuantity(int minQuantity) {this.minQuantity = minQuantity; }

  @Override
  public int getMaxQuantity() { return maxQuantity; }
  @Override
  public void setMaxQuantity(int maxQuantity) {this.maxQuantity = maxQuantity; }
}
