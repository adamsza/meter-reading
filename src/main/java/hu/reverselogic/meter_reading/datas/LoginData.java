package hu.reverselogic.meter_reading.datas;

public class LoginData{
    private String email;
    private String password;

    public LoginData(){}

    public LoginData(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String useremail)
    {
        email = useremail;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String userpassword)
    {
        password = userpassword;
    }
}