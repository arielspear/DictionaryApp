import org.junit.*;
import static org.junit.Assert.*;

public class TaskTest {

  @Test
  public void Task_instanciatesCorrectly_true(){
    Task myTask = new Task("read a book");
    assertEquals(true, myTask instanceof Task);
  }

  @Test
  public void Task_instanciatesWithDescription_true(){
    Task myTask = new Task("read a book");
    assertEquals("read a book", myTask.getDescription());
  }
}
