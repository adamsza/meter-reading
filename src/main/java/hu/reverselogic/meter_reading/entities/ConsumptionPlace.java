package hu.reverselogic.meter_reading.entities;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="consumptionplaces")
public class ConsumptionPlace{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn
    private User user;
    @OneToMany(mappedBy = "consumptionPlace", cascade = CascadeType.ALL)
    private Set<Meter> meters;

    public ConsumptionPlace(String name, Meter... meters)
    {
        this.name = name;
        this.meters = Stream.of(meters).collect(Collectors.toSet());
        this.meters.forEach(x -> x.setConsumptionPlace(this));
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

    public Set<Meter> getMeters() {
        return meters;
    }

    public void setMeters(Set<Meter> meters) {
        this.meters = meters;
    }
}