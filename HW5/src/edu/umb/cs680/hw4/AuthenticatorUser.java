package edu.umb.cs680.hw4;

public class AuthenticatorUser {
    //Modified authenticator to retuen false if password is null
    //this helps in negative testing
    public static boolean AunthenticateUser(SecurityContext ctx, EncrptPass pass) {
        if (pass == null) {
            return false;
        } else {
            return true;
        }
    }
}
