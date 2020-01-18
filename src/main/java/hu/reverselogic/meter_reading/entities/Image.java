package hu.reverselogic.meter_reading.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image{

    @Id
    private String name;
    @Lob
    private byte[] data;

    public Image(String name, byte[] data)
    {
        this.name = name;
        this.data = data;
    }

    public Image() {
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
