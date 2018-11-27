package sandwich.spl.variants.product.step;

import java.util.ArrayList;
import java.util.List;
import sandwich.spl.core.product.step.IProductManufactureStep;
import sandwich.spl.variants.product.ProductItem;

public abstract class ProductManufactureStep implements IProductManufactureStep {

  private int minQuantity = 0;
  private int maxQuantity = 0;

  private List<ProductItem> subItems = new ArrayList<>();

  @Override
  public int getMinQuantity() { return minQuantity; }
  @Override
  public void setMinQuantity(int minQuantity) {this.minQuantity = minQuantity; }

  @Override
  public int getMaxQuantity() { return maxQuantity; }
  @Override
  public void setMaxQuantity(int maxQuantity) {this.maxQuantity = maxQuantity; }

  @Override
  public List<ProductItem> getSubItems() { return subItems; }
}
