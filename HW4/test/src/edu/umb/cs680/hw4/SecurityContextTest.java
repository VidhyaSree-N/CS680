package edu.umb.cs680.hw4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityContextTest {
    User user = null;
    SecurityContext ctx = new SecurityContext(user);
    EncrptPass pass = null;

    @Test
    public void testInitialState() {
        assertTrue(ctx.getState() instanceof SingletonLoggedOut);
    }

    @Test
    public void testLogin() {
        ctx.login(pass);
        assertTrue(ctx.getState() instanceof SingletonLoggedIn);
    }

    @Test
    public void testMultipleLogin() {
        ctx.login(pass);
        ctx.login(pass);
        assertFalse(ctx.isActive());
        assertTrue(ctx.getState() instanceof SingletonLoggedIn);
    }

    @Test
    public void testAlreadyLoggedIn() {
        ctx.login(pass);
        State stateBefore = ctx.getState();
        ctx.login(pass);
        State stateAfter = ctx.getState();
        assertEquals(stateBefore, stateAfter);
    }

    @Test
    public void testLogout() {
        ctx.login(pass);
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
