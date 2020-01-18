package hu.reverselogic.meter_reading.services;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hu.reverselogic.meter_reading.datas.ReadingData;
import hu.reverselogic.meter_reading.entities.ConsumptionPlace;
import hu.reverselogic.meter_reading.entities.Image;
import hu.reverselogic.meter_reading.entities.Meter;
import hu.reverselogic.meter_reading.entities.Reading;
import hu.reverselogic.meter_reading.repositories.ImageRepository;
import hu.reverselogic.meter_reading.repositories.MeterRepository;
import hu.reverselogic.meter_reading.repositories.ReadingRepository;

@Service
public class ReadingService {
    @Autowired
    private ReadingRepository readingRepository;
    @Autowired
    private MeterRepository meterRepository;
    @Autowired
    private ImageRepository imageRepository;

    public List<Reading> ListAll() {
        List<Reading> list = new ArrayList<>();
        readingRepository.findAll().forEach(list::add);
        return list;
    }

    public List<Reading> ListAllByID(long id) {
        List<Reading> list = new ArrayList<>();
        readingRepository.findByMeterId(id).forEach(list::add);
        Collections.reverse(list);
        return list;
    }

    public Long newReading(ReadingData readingData, MultipartFile file) throws NoSuchAlgorithmException, IOException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Meter meter = meterRepository.findOneById(readingData.getMeterID());
        try {
            String hashname = generatename(file.getOriginalFilename(), meter.getConsumptionPlace());
            Reading newreading = new Reading(readingData.getValue(), format.parse(readingData.getReadingDate()), hashname);
            if(hashname != null)
            {
                Image image = new Image(hashname, file.getBytes());
                imageRepository.save(image);
            }
            newreading.setMeter(meter);
            readingRepository.save(newreading);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return readingData.getMeterID();
        
    }

    private String generatename(String filename, ConsumptionPlace cPlace) throws NoSuchAlgorithmException
    {
        if(filename.equals("")) return null;
        String imagename = filename + cPlace.getUser().getEmail() + new Date().toString();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(imagename.getBytes());
        byte[] digest = md.digest();
        String hashedname = DatatypeConverter.printHexBinary(digest).toUpperCase();

        return hashedname;
    }
}