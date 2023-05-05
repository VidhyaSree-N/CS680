package edu.umb.cs680.hw9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityContextTest {
    User user = null;
    SecurityContext ctx = new SecurityContext(user);
    EncrptPass pass = null;
    EncrptPass pass1 = new EncrptPass("abx");

    @Test
    public void testInitialState() {
        assertTrue(ctx.getState() instanceof SingletonLoggedOut);
    }

    @Test
    public void testNullLogin() {
        ctx.login(pass);
        assertFalse(ctx.getState() instanceof SingletonLoggedIn);
    }


    @Test
    public void testMultipleLogin() {
        //login for 1st time
        ctx.login(pass1);
        assertTrue(ctx.isActive());
        //trying to login when logged in
        ctx.login(pass1);
        //isActive returns false called 2nd time
        assertFalse(ctx.isActive());
        ctx.login(pass1);
        //Logging out
        ctx.logout();
        //Logging out when logged out
        ctx.logout();
        assertTrue(ctx.getState() instanceof SingletonLoggedOut);
    }

    @Test
    public void testLogout() {
        ctx.login(pass1);
        ctx.logout();
        assertTrue(ctx.getState() instanceof SingletonLoggedOut);
    }

    @Test
    public void testMultipleLogout() {
        ctx.logout();
        ctx.logout();
        assertTrue(ctx.getState() instanceof SingletonLoggedOut);
    }

    @Test
    public void testAlreadyLoggedOut() {
        State stateBefore = ctx.getState();
        ctx.logout();
        State stateAfter = ctx.getState();
        assertEquals(stateBefore , stateAfter);
    }

}
