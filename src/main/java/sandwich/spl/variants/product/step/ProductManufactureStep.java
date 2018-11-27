package sandwich.spl.variants.product.step;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import sandwich.spl.core.product.IProductItem;
import sandwich.spl.core.product.step.IProductManufactureStep;

@AllArgsConstructor
public abstract class ProductManufactureStep implements IProductManufactureStep {

  private String title;
  private int minQuantity = 0;
  private int maxQuantity = 0;

  private List<IProductItem> subItems = new ArrayList<>();

  public ProductManufactureStep(String title, int minQuantity, int maxQuantity){
    this.title = title;
    this.minQuantity = minQuantity;
    this.maxQuantity = maxQuantity;
  }

  @Override
  public String getTitle() { return title; }
  @Override
  public void setTitle(String title) {this.title = title; }

  @Override
  public int getMinQuantity() { return minQuantity; }
  @Override
  public void setMinQuantity(int minQuantity) {this.minQuantity = minQuantity; }

  @Override
  public int getMaxQuantity() { return maxQuantity; }
  @Override
  public void setMaxQuantity(int maxQuantity) {this.maxQuantity = maxQuantity; }

  @Override
  public List<IProductItem> getSubItems() { return subItems; }
}
