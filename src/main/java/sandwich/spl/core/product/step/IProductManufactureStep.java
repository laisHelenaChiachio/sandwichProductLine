package sandwich.spl.core.product.step;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import sandwich.shared.Category;
import sandwich.spl.core.product.IProductItem;

public interface IProductManufactureStep {

  String getTitle();
  void setTitle(String title);

  int getMinQuantity();
  void setMinQuantity(int q);

  int getMaxQuantity();
  void setMaxQuantity(int q);

  List<IProductItem> getSubItems();
  void setSubItems(List<IProductItem> items);


  public static IProductManufactureStep castToTrueType(IProductManufactureStep step, Category category)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
    String name = category.toString().toLowerCase();
    name = name.substring(0, 1).toUpperCase() + name.substring(1);
    IProductManufactureStep trueTyped = null;
    Class c = Class.forName("sandwich.spl.variants.product.step." + name + "Step");

    Constructor ctr = c.getConstructor(String.class, int.class, int.class, List.class);
    trueTyped = (IProductManufactureStep) ctr.newInstance(step.getTitle(), step.getMinQuantity(), step.getMaxQuantity(), step.getSubItems());

    return trueTyped;
  }
}
