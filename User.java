import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private Address address;
    private Phone phone;
    private boolean isAdmin;
    private boolean isLoggedIn;

    public boolean register(String email, String password, Address address) {
        // Validation logic for email, password, and address
        // ...

        // Registration logic
        // ...

        // Return true if registration is successful, false otherwise
        return true;
    }

    public boolean login(String email, String password) {
        // Validation logic for email and password
        // ...

        // Login logic
        // ...

        // Return true if login is successful, false otherwise
        return true;
    }

    public void logout() {
        // Logout logic
        // ...
    }
}
