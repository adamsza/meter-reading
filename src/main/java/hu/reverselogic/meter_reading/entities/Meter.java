package hu.reverselogic.meter_reading.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Meter{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long consumptionPlaceID;
    private String type;
    private Long factoryNO;
    private @Temporal(TemporalType.DATE) Date authenticationEndDate;

    public Meter(Long consumptionplaceID, String type, Long factoryNO, Date authenticationEndDate)
    {
        this.consumptionPlaceID = consumptionplaceID;
        this.type = type;
        this.factoryNO = factoryNO;
        this.authenticationEndDate = authenticationEndDate;
    }

    public Meter() {
	}

	public Long getId()
    {
        return this.id;
    }

    public Long getConsumptionPlaceID()
    {
        return this.consumptionPlaceID;
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
}