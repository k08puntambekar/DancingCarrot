package ReKritiks.Dashboard;

import androidx.annotation.NonNull;

public class UserModel {
    String mobile;
    String name;
    String email;
    String username;
    String password;

    public UserModel() {
    }

    public UserModel(String mobile, String name, String email, String username, String password) {
        this.mobile = mobile;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
