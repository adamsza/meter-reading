package hu.reverselogic.meter_reading.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.reverselogic.meter_reading.datas.ReadingData;
import hu.reverselogic.meter_reading.entities.Reading;
import hu.reverselogic.meter_reading.repositories.ReadingRepository;

@Service
public class ReadingService {
    private ReadingRepository readingRepository;

    @Autowired
    public void setReadingRepository(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    public List<Reading> ListAll() {
        List<Reading> list = new ArrayList<>();
        readingRepository.findAll().forEach(list::add);
        return list;
    }

    public List<Reading> ListAllByID(long id) {
        List<Reading> list = new ArrayList<>();
        readingRepository.findByMeterId(id).forEach(list::add);
        return list;
    }

    public Long newReading(ReadingData readingData) {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Reading newreading = new Reading(readingData.getMeterID(), readingData.getValue(),
                    format.parse(readingData.getReadingDate()), readingData.getImageURL());
            readingRepository.save(newreading);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return readingData.getMeterID();
        
    }
}