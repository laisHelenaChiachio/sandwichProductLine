package sandwich.spl;


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
    Collection<IProduct> productDatabase;
    try {
      productDatabase = Client.loadDatabase(DatabaseFilePath);
    } catch (IOException ignored) {
      productDatabase = Client.loadDatabase(AltDatabaseFilePath);
    }

    int i = 0;
  }
}
