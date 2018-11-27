package sandwich.spl.variants.product.step;

import java.util.List;
import sandwich.spl.core.product.IProductItem;
import sandwich.spl.core.product.step.IProductManufactureStep;


public class SandwichStep extends ProductManufactureStep implements IProductManufactureStep {

  public SandwichStep(String title, int minQuantity, int maxQuantity,
      List<IProductItem> subItems) {
    super(title, minQuantity, maxQuantity, subItems);
  }

  public SandwichStep(String title, int minQuantity, int maxQuantity) {
    super(title, minQuantity, maxQuantity);
  }
}
