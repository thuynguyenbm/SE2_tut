package to_do.chain_of_responsibility;

import to_do.chain_of_responsibility.middleware.Middleware;
import to_do.chain_of_responsibility.middleware.RoleCheckMiddleware;
import to_do.chain_of_responsibility.middleware.ThrottlingMiddleware;
import to_do.chain_of_responsibility.middleware.UserExistsMiddleware;
import to_do.chain_of_responsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        //TO-DO: Register email & pass for 2 account types: admin & user
        server.register("admin@example.com", "123");
        server.register("thuy@gmail.com", "1212");

        // All checks are linked. Client can build various chains using the same components.
        Middleware middleware = new ThrottlingMiddleware(1);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            //TO-DO: Ask for email & password then save to suitable variables
            System.out.println("Enter your email:");
            String email = reader.readLine();
            System.out.println("Enter your password:");
            String pw = reader.readLine();
            //TO-DO: Try to login to server with given email & password
            //then store the result to variable 'success'
            success = server.logIn(email, pw);
        } while (!success);
    }
}
