package hu.reverselogic.meter_reading.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reading{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long meterId;
    private Float meterActualValue;
    private @Temporal(TemporalType.DATE) Date readingDate;
    private @Temporal(TemporalType.DATE) Date recordingDate;
    private String imageURL;

    public Reading(Long meterId, Float meterActualValue, Date readingDate, String imageUrl)
    {
        this.meterId = meterId;
        this.meterActualValue = meterActualValue;
        this.readingDate = readingDate;
        this.recordingDate = new Date();
        this.imageURL = imageUrl;
    }

    public Reading() {
	}

	public Long getId() {
        return this.id;
    }

    public Long getMeterId()
    {
        return this.meterId;
    }

    public Float getMeterActualValue() {
        return this.meterActualValue;
    }

    public Date getReadingDate() {
        return this.readingDate;
    }

    public Date getRecordingDate() {
        return this.recordingDate;
    }

    public String getImageURL() {
        return this.imageURL;
    }
}