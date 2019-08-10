package hu.reverselogic.meter_reading.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.reverselogic.meter_reading.entities.ConsumptionPlace;
import hu.reverselogic.meter_reading.entities.Meter;
import hu.reverselogic.meter_reading.repositories.ConsumptionPlaceRepository;
import hu.reverselogic.meter_reading.repositories.MeterRepository;
import hu.reverselogic.meter_reading.repositories.UserRepository;

@Service
public class MeterService{
    private MeterRepository meterRepository;
    private ConsumptionPlaceRepository consumptionPlaceRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public void setRepositories(MeterRepository meterRepository, ConsumptionPlaceRepository consumptionPlaceRepository)
    {
        this.meterRepository = meterRepository;
        this.consumptionPlaceRepository = consumptionPlaceRepository;
    }

    public List<Meter> ListAll()
    {
        List<Meter> list = new ArrayList<>();
        meterRepository.findAll().forEach(list::add);
        return list;
    }

    public List<Meter> ListAllByID(long id)
    {
        List<Meter> meterlist = new ArrayList<>();
        Set<ConsumptionPlace> placelist = userRepository.findByID(id).getcPlaces();
        for (ConsumptionPlace place : placelist) {
            meterRepository.findByConsumptionPlaceID(place.getID()).forEach(meterlist::add);
        }
        return meterlist;
    }
}