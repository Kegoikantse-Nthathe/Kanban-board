/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package registration1;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import registration1.Login;
/**
 *
 * @author mmatl 
 */
public class LoginTest {
    Login login=new Login();
    
    public LoginTest() { 
    }

    @Test
    public void testCheckUserName() {
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!!!"));

        
        boolean expected = true;
        boolean actual = login.checkUserName("kyl_1");
        
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckPasswordComplexity() {
        
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));

        
        boolean expected = true;
        boolean actual = login.checkPasswordComplexity("Ch&&sec@ke99!");
        
        assertEquals(expected, actual);
    }

@Test
    public void testRegisterUser() {
        // test with correct input
        String expected = "User name successfully captured." + "\n" + "Password successfully captured.";
        String actual = login.registerUser("Ch&&sec@ke99!", "kyl_1");
        
        assertEquals(expected, actual);
        
        // test with incorrect input
        
        expected = "Username is not correctly formatted, please ensure that your "
                    + "username contains an underscore and is no 5 characters in length";
        actual = login.registerUser("ch&&sec@ke99!", "kyl_11");
    }
/*
 @Test
    public void testLoginUser() {
        assertTrue(login.LoginUser("Password!1", "user_", login.checkUserName("user_"), login.checkPasswordComplexity("Password!1")));
        assertFalse(login.LoginUser("Passwordgyuhj", "user!!!!!!", login.checkUserName("user!!!!!!"), login.checkPasswordComplexity("Passwordgyuhj")));
    }    
   */
    @Test
    public void testReturnLoginStatus() {
        // with incorrect data
        String expected = "Username or password incorrect, please try again";
        String actual = login.returnLoginStatus(false, "Mmatlou", "Lebelo");
        assertEquals(expected, actual);
        
 // with correct data
        expected = "Welcome, Mmatlou Lebelo, it is great to see you again.";
        actual = login.returnLoginStatus(true, "Mmatlou", "Lebelo");
        assertEquals(expected, actual);
        
    }
}
    
  

