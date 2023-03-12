package edu.umb.cs680.hw4;

public class SingletonLoggedOut implements State{

    SecurityContext ctx;

    private static SingletonLoggedOut instance = null;

    public SingletonLoggedOut(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public static SingletonLoggedOut getInstance(SecurityContext ctx){
        if(instance == null)
            instance = new SingletonLoggedOut(ctx);
        return instance;
    }

    @Override
    public void login(EncrptPass pass) {
        if(AuthenticatorUser.AunthenticateUser(ctx,pass)){
            ctx.changeState(new SingletonLoggedIn(ctx));
            System.out.println("Login Successful");
        }
        else {
            System.out.println("Authentication error");
        }

    }

    @Override
    public void logout() {
        System.out.println("Already Logged out");
    }
}
