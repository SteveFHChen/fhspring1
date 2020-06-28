package fhjunittest;

import com.fh.forjunit.UserManager;

public class LoginPresenter {
	
    private UserManager userManager = new UserManager();

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (password == null || password.length() < 6) return;

        userManager.performLogin(username, password);
    }
    
    public void setUserManager(UserManager userManager) {  //<==
        this.userManager = userManager;
    }

}