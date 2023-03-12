package edu.umb.cs680.hw4;

public class Main {
    public static void main(String[] args){
        User user = new User();
        SecurityContext ctx = new SecurityContext(user);
        EncrptPass pass = new EncrptPass();

        //login for 1st time
        ctx.login(pass);
        //trying to login when logged in
        ctx.login(pass);
        //isActive returns false called 2nd time
        ctx.login(pass);
        //Logging out
        ctx.logout();
        //Logging out when logged out
        ctx.logout();
    }
}
