import org.junit.rules.ExternalResource;
import spark.Spark;

public class ClearRule extends ExternalResource {

  protected void before() { }

  protected void after() {
    Word.clear();
    Definition.clear();
  }
}
