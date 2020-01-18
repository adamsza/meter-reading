package hu.reverselogic.meter_reading.entities;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ConsumptionPlace> cPlaces;

    public User(String name, String email, String password, ConsumptionPlace... cPlaces)
    {
        this.name = name;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.registrationDate = new Date();
        this.state = "default";
        this.lastloginDate = this.registrationDate;
        this.cPlaces = Stream.of(cPlaces).collect(Collectors.toSet());
        this.cPlaces.forEach(x -> x.setUser(this));
    }

    public User(User user)
    {
        this.id = user.getID();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.registrationDate = user.getRegistrationDate();
        this.state = user.getState();
        this.lastloginDate = user.getLastLoginDate();
        this.cPlaces = user.getcPlaces();
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

    public Set<ConsumptionPlace> getcPlaces() {
        return cPlaces;
    }

    public void setcPlaces(Set<ConsumptionPlace> cPlaces) {
        this.cPlaces = cPlaces;
    }

}