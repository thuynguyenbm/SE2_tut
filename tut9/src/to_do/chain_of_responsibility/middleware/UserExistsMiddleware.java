package to_do.chain_of_responsibility.middleware;

//import tuts.tut9.complete.chain_of_responsibility.server.Server;

import to_do.chain_of_responsibility.server.Server;

/**
 * ConcreteHandler. Checks whether a user with the given credentials exists.
 */
public class UserExistsMiddleware extends Middleware {
    private Server server;

    //TO-DO: Implement the UserExistsMiddleWare() method
    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        //TO-DO: Check for invalid email => show error message then return false
        if (!email.matches("[a-zA-Z0-9]*@[a-z]*(.com)") || !server.hasEmail(email)) {
            System.out.println("Invalid email!");
            return false;
        }
        //TO-DO: Check for invalid password for an email => show error message then return false
        if (!server.isValidPassword(email,password)){
            System.out.println("Password is not correct!");
            return false;
        }
        return true;
    }
}