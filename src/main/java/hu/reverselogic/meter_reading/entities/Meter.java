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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "meters")
public class Meter{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn
    private ConsumptionPlace consumptionPlace;
    private String type;
    private Long factoryNO;
    private @Temporal(TemporalType.DATE) Date authenticationEndDate;
    @OneToMany(mappedBy = "meter", cascade = CascadeType.ALL)
    private Set<Reading> readings;

    public Meter(String type, Long factoryNO, Date authenticationEndDate, Reading...readings)
    {
        this.type = type;
        this.factoryNO = factoryNO;
        this.authenticationEndDate = authenticationEndDate;
        this.readings = Stream.of(readings).collect(Collectors.toSet());
        this.readings.forEach(x -> x.setMeter(this));
    }

    public Meter() {
	}

	public Long getId()
    {
        return this.id;
    }

    public String getType()
    {
        return this.type;
    }

    public Long getFactoryNO()
    {
        return this.factoryNO;
    }

    public Date getAuthenticationEndDate()
    {
        return this.authenticationEndDate;
    }

    public ConsumptionPlace getConsumptionPlace() {
        return consumptionPlace;
    }

    public void setConsumptionPlace(ConsumptionPlace consumptionPlace) {
        this.consumptionPlace = consumptionPlace;
    }
}