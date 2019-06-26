package hu.reverselogic.meter_reading.datas;

public class ReadingData{
    private Long meterID;
    private Float value;
    private String readingDate;
    private String imageURL;

    public ReadingData(){}

    public ReadingData(Long meterID, Float value, String readingDate, String imageURL)
    {
        this.meterID = meterID;
        this.value = value;
        this. readingDate = readingDate;
        this.imageURL = imageURL;
    }

    public void setMeterID(Long meterID)
    {
        this.meterID = meterID;
    }

    public Long getMeterID()
    {
        return meterID;
    }

    public void setValue(Float value)
    {
        this.value = value;
    }

    public Float getValue()
    {
        return this.value;
    }

    public void setReadingDate(String readingDate)
    {
        this.readingDate = readingDate;
    }

    public String getReadingDate()
    {
        return this.readingDate;
    }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }

    public String getImageURL()
    {
        return this.imageURL;
    }
}