package sandwich.spl;


import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.junit.Test;
import sandwich.spl.cli.Client;
import sandwich.spl.core.product.IProduct;

public class CliTest {

  private final static String DatabaseFilePath = ".\\data.json";
  private final static String AltDatabaseFilePath = ".\\out\\data.json";

  @Test(timeout = 1500)
  public void CopyDirectoryTest() throws IOException {
//    Collection<IProduct> productDatabase;
//    try {
//      productDatabase = Client.loadDatabase(new File(DatabaseFilePath));
//    } catch (IOException ignored) {
//      productDatabase = Client.loadDatabase(new File(AltDatabaseFilePath));
//    }
//
//    IProduct prod = (IProduct) productDatabase.toArray()[9];
//    int size = prod.getSteps().size();
  }
}
