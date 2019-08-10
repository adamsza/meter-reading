package hu.reverselogic.meter_reading.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ConsumptionPlace{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn
    private User user;

    public ConsumptionPlace(String name)
    {
        this.name = name;
    }

    public ConsumptionPlace(){}

    public Long getID()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public User getUser()
    {
        return this.user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "";
    }
}