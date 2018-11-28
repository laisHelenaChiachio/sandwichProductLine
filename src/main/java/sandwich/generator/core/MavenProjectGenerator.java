package sandwich.generator.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import lombok.Getter;
import org.apache.commons.io.FileUtils;



public class MavenProjectGenerator {

  @Getter
  private Path path;

  private HashSet<Path> addedFiles = new HashSet<>();

  public MavenProjectGenerator(Path path) throws IOException {
    this.path = path;
  }

  public MavenProjectGenerator AddEssentials() throws IOException {
    // Copy Maven project essentials
    AddFile(projectPath.resolve("src\\main\\resources\\templates\\pom.xml"), this.path.resolve("pom.xml"));
    // Copy Project core + shared
    AddFile("src\\main\\java\\sandwich\\shared");
    AddFile("src\\main\\java\\sandwich\\spl\\cli");
    AddFile("src\\main\\java\\sandwich\\spl\\core");
    return this;
  }

  public MavenProjectGenerator AddFile(String relativePath) throws IOException {
    AddFile(projectPath.resolve(relativePath), this.path.resolve(relativePath));
    return this;
  }

  public MavenProjectGenerator AddFile(Path source, Path target) throws IOException {
    if (!addedFiles.contains(source)) {
      if(Files.isDirectory(source)) {
        AddDirectory(source, target);
      } else {
        CreateDirectoryRecursively(target.getParent());
        Files.copy(source, target);
        addedFiles.add(source);
      }
    }
    return this;
  }

  private void AddDirectory(Path source, Path target) throws IOException {
    FileUtils.copyDirectory(source.toFile(), target.toFile());
  }

  public MavenProjectGenerator Compile(Path mavenPath) throws IOException {
    Compile_P(mavenPath.toString());
    return this;
  }
  public MavenProjectGenerator Compile() throws IOException {
    Compile_P("mvn");
    return this;
  }

  public MavenProjectGenerator Execute() {
    // TODO
    return this;
  }

  private void Compile_P(String maven) throws IOException {
    Runtime rt = Runtime.getRuntime();
    Process pr = rt.exec(maven + " clean install -f " + this.path);
  }

  public MavenProjectGenerator CreateDirectoryRecursively(Path path) throws IOException {
    if (Files.notExists(path)) {
      CreateDirectoryRecursively(path.getParent());
      Files.createDirectory(path);
    }
    return this;
  }

  public MavenProjectGenerator Cleanup() {
    try {
      FileUtils.deleteDirectory(this.path.toFile());
    } catch (Exception ignored) {
      try {
        Thread.sleep(100);
        FileUtils.deleteDirectory(this.path.toFile());
      } catch (Exception ignored2) {}
    }
    return this;
  }

  private final Path projectPath = Paths.get(System.getProperty("user.dir"));

}
