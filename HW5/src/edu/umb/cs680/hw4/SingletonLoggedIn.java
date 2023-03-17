package edu.umb.cs680.hw4;

public class SingletonLoggedIn implements State {
    SecurityContext ctx;

    private static SingletonLoggedIn instance = null;

    SingletonLoggedIn(SecurityContext ctx){
        this.ctx = ctx;
    }

    public static SingletonLoggedIn getInstance(SecurityContext ctx){
        if(instance == null)
            instance = new SingletonLoggedIn(ctx);
        return instance;
    }

    @Override
    public void login(EncrptPass pass){
        //isActive returns true only when called 1st time
        if(!ctx.isActive()){
            ctx.changeState(new SingletonLoggedOut(ctx));
            ctx.login(pass);
        }
        else {
            System.out.println("Already logged in");
        }
    }

    @Override
    public void logout(){
        ctx.changeState(new SingletonLoggedOut(ctx));
        System.out.println("Successfully logged out");
    }
}
