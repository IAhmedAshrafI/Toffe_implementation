import java.util.HashMap;
import java.util.Map;

public class AuthenticationController {
    
    private final Map<String, user> usersByEmail;
    private final Map<Integer, user> loggedInUsersById;
    private int nextUserId;
    
    public AuthenticationController() {
        usersByEmail = new HashMap<>();
        loggedInUsersById = new HashMap<>();
        nextUserId = 1;
    }
    
    public user registerUser(String email, String password, String address) throws Exception {
        if (usersByEmail.containsKey(email)) {
            throw new Exception("User with email " + email + " already exists.");
        }
        
        if (!isPasswordSecure(password)) {
            throw new Exception("Password should be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }
        
        String otp = sendOTP(email);
        
        user newUser = new user(nextUserId++, email, password, address, otp);
        usersByEmail.put(email, newUser);
        
        return newUser;
    }
    
    public user login(String email, String password) throws Exception {
        user user = usersByEmail.get(email);
        
        if (user == null) {
            throw new Exception("User with email " + email + " does not exist.");
        }
        
        if (!user.getPassword().equals(password)) {
            throw new Exception("Incorrect password.");
        }
        
        if (loggedInUsersById.containsKey(user.getId())) {
            throw new Exception("User with ID " + user.getId() + " is already logged in.");
        }
        
        loggedInUsersById.put(user.getId(), user);
        
        return user;
    }
    
    public void logout(int userId) throws Exception {
        user user = loggedInUsersById.get(userId);
        
        if (user == null) {
            throw new Exception("User with ID " + userId + " is not logged in.");
        }
        
        loggedInUsersById.remove(userId);
    }
    
    public String sendOTP(String email) {
        // implementation for sending OTP to the user's email
        return "1234"; // return a dummy OTP for testing purposes
    }
    
    public boolean verifyOTP(String email, String otp) {
        user user = usersByEmail.get(email);
        
        if (user == null) {
            return false;
        }
        
        return user.getOtp().equals(otp);
    }
    
    public void resetPassword(String email, String password) throws Exception {
        user user = usersByEmail.get(email);
        
        if (user == null) {
            throw new Exception("User with email " + email + " does not exist.");
        }
        
        if (!isPasswordSecure(password)) {
            throw new Exception("Password should be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        }
        
        user.setPassword(password);
    }
    
    private boolean isPasswordSecure(String password) {
        // implementation for checking if password is secure
        return password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}");
    }
}