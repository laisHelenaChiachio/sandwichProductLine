package sandwich.spl.core.product.step;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import sandwich.spl.core.product.IProductItem;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// Should be in package: v... but we need it to serialize easier
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
