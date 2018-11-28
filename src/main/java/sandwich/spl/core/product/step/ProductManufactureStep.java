package sandwich.spl.core.product.step;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sandwich.spl.core.product.IProductItem;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// Should be in package: variant... but we need it to serialize easier
public class ProductManufactureStep implements IProductManufactureStep {

  private String title;
  private int minQuantity = 0;
  private int maxQuantity = 0;

  @JsonDeserialize(contentAs = ProductItem.class)
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

  public void setSubItems(List<IProductItem> items) {
    this.subItems = items;
  }
}
