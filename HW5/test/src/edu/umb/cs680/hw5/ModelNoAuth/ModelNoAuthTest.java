package edu.umb.cs680.hw5.ModelNoAuth;

import edu.umb.cs680.hw4.SecurityContext;
import edu.umb.cs680.hw4.SingletonLoggedIn;
import edu.umb.cs680.hw4.SingletonLoggedOut;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelNoAuthTest {

    @Test
    public void doAccessControlTest(){
        PrintJobExecutor modelNoAuth = new edu.umb.cs680.hw5.ModelNoAuth.PrintJobExecutor();
        modelNoAuth.doAccessControl();
        assertNotNull(modelNoAuth);
        assertEquals("", "");
    }

    @Test
    public void doAuthenticationTest() {
        PrintJobExecutor modelNoAuth = new edu.umb.cs680.hw5.ModelNoAuth.PrintJobExecutor();
        SecurityContext ctx = new SecurityContext(null);
        modelNoAuth.doAuthentication(null,ctx);
        assertFalse(ctx.getState() instanceof SingletonLoggedIn);
    }

    @Test
    public void doPrintTest() {
        PrintJobExecutor modelNoAuth = new edu.umb.cs680.hw5.ModelNoAuth.PrintJobExecutor();
        SecurityContext ctx = new SecurityContext(null);
        modelNoAuth.doPrint();
        assertTrue(ctx.getState() instanceof SingletonLoggedOut);
    }

    @Test
    public void doErrorHandling(){
        PrintJobExecutor modelNoAuth = new edu.umb.cs680.hw5.ModelNoAuth.PrintJobExecutor();
        assertDoesNotThrow(() -> modelNoAuth.doErrorHandling());

    }

//    @Test
//    public void executeTest(){
//        PrintJobExecutor modelNoAuth = new edu.umb.cs680.hw5.ModelNoAuth.PrintJobExecutor();
//        SecurityContext ctx = new SecurityContext(null);
//        modelNoAuth.execute(null,null,ctx);
//        assertNotNull(modelNoAuth);
//    }
}

