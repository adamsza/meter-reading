package hu.reverselogic.meter_reading.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "readings")
public class Reading{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Meter meter;
    private Float meterActualValue;
    private @Temporal(TemporalType.DATE) Date readingDate;
    private @Temporal(TemporalType.DATE) Date recordingDate;
    private String imagename;

    public Reading(Float meterActualValue, Date readingDate, String imagename)
    {
        this.meterActualValue = meterActualValue;
        this.readingDate = readingDate;
        this.recordingDate = new Date();
        this.imagename = imagename;
    }

    public Reading() {
	}

	public Long getId() {
        return this.id;
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

    public Meter getMeter() {
        return meter;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

}