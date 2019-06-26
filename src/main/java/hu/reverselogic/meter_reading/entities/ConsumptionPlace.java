package hu.reverselogic.meter_reading.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConsumptionPlace{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long userID;

    public ConsumptionPlace(String name, Long userID)
    {
        this.name = name;
        this.userID = userID;
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

    public Long getUserID()
    {
        return this.userID;
    }

    @Override
    public String toString()
    {
        return "";
    }
}