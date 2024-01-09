package bean;

public class User {
    private int id,type;
    private String name,username,email,password,mobile;

    public User(int id, int type, String name, String username, String email, String password, String mobile) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User(int type, String name, String username, String email, String password, String mobile) {
        this.type = type;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }
    
    
}
