
package registration1;

 
import registration1.TaskManager;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.ArrayList;

public class TaskManagerTest {

  TaskManager taskManager=new TaskManager();
    
    // Sample data for testing
    int[] durations = {5, 8, 2, 11};
    String[] taskNames = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
    String[] statuses = {"To Do", "Doing", "Done", "To Do"};
    String[] developers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberhoizer"};
    String[] ids = {"CR:0:IKE", "CR:1:ARD", "CR:2:THA", "AD:3:NDA"};

    // Constructor to initialize tasks for testing
    public TaskManagerTest() {
    }

    @Test
    public void testManipulateArrays() {
        
    }


    @Test
    public void testSearchTask() {
        String actual = TaskManager.searchTask("Create Reports");
        String expected = "Create Login, Mike Smith, To Do";
        
    }

    @Test
    public void testDeveloperTasks() {
        String actual = TaskManager.developerTasks("Samantha Paulson");
        String expected = "Create Reports, Done";
        
    }
 
    @Test
    public void testDeleteTask() {
        String actual = TaskManager.deleteTask("Create Reports");
        String expected = "Entry Create Reports successfully deleted.";
        
    } 

    @Test
    public void testDisplayReport() {
    }

    @Test
    public void testGetArrays() {
    }

    @Test
    public void testLongestTask() {
    }
    
}