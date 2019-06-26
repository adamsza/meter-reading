package hu.reverselogic.meter_reading.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private @Temporal(TemporalType.DATE) Date registrationDate;
    private String state;
    private @Temporal(TemporalType.DATE) Date lastloginDate;

    public User(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationDate = new Date();
        this.state = "default";
        this.lastloginDate = this.registrationDate;
    }

    public User(){}

    public Long getID()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public Date getRegistrationDate()
    {
        return this.registrationDate;
    }

    public String getState()
    {
        return this.state;
    }

    public Date getLastLoginDate()
    {
        return this.lastloginDate;
    }

    @Override
    public String toString()
    {
        return String.format("User[id=%d, email='%s', password?, registrationDate=", id, email);
    }
}