package edu.umb.cs680.hw4;

public class SecurityContext {

    private User user;
    private State state;
    private boolean isActive = true;

    public SecurityContext(User user){
        state = getState();
        this.user = user;
    }

    public void changeState(State newState){
        state = newState;
    }

    public void login(EncrptPass pass){
        state.login(pass);
    }

    public void logout(){
        state.logout();
    }

    //Return true in the first login, and return false afterwards
    boolean isActive(){
        boolean result = isActive;
        isActive = false;
        return result;
    }

    public State getState(){
        if(state == null){
            state = new SingletonLoggedOut(this);
        }
        return state;
    }
}
