package sandwich.generator;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import sandwich.generator.core.MavenProjectGenerator;


public class MavenGeneratorTests {

  MavenProjectGenerator generator;

  public MavenGeneratorTests() throws IOException {
    generator = new MavenProjectGenerator(Paths.get(".\\out\\"));
  }

  @Before
  public void BeforeTest() throws IOException {
    try {
      FileUtils.deleteDirectory(new File(".\\out\\"));
    } catch (Exception ignored) {
      try {
        Thread.sleep(100);
        FileUtils.deleteDirectory(new File(".\\out\\"));
      } catch (Exception ignored2) {}
    }
  }

  @Test(timeout = 1500)
  public void CopyDirectoryTest() throws IOException {
    generator.AddFile("src\\main\\java\\sandwich\\");
  }

  @Test(timeout = 1500)
  public void CopyFileTest() throws IOException {
    generator.AddFile("src\\main\\java\\sandwich\\shared\\Category.java");
  }

  @Test(timeout = 1500)
  public void AllTest() throws IOException {
    generator
        .AddEssentials()
        .Compile(Paths.get("C:\\Users\\Maglethong Spirr\\AppData\\Local\\JetBrains\\Toolbox\\apps\\IDEA-U\\ch-0\\182.4505.22\\plugins\\maven\\lib\\maven3\\bin\\mvn.cmd"));
  }
}
