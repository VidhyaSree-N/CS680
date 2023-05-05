package edu.umb.cs680.hw9;

public class SingletonLoggedOut implements State{

    SecurityContext ctx;

    private static SingletonLoggedOut instance = null;

    private SingletonLoggedOut(SecurityContext ctx) {
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
            ctx.changeState(SingletonLoggedIn.getInstance(ctx));
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
