package hu.reverselogic.meter_reading;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hu.reverselogic.meter_reading.entities.ConsumptionPlace;
import hu.reverselogic.meter_reading.entities.Meter;
import hu.reverselogic.meter_reading.entities.Reading;
import hu.reverselogic.meter_reading.entities.User;
import hu.reverselogic.meter_reading.repositories.ConsumptionPlaceRepository;
import hu.reverselogic.meter_reading.repositories.MeterRepository;
import hu.reverselogic.meter_reading.repositories.ReadingRepository;
import hu.reverselogic.meter_reading.repositories.UserRepository;

@SpringBootApplication
public class MeterReadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeterReadingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository urepository, ConsumptionPlaceRepository cprepository, MeterRepository mRepository, ReadingRepository rRepository)
	{
		return(args) -> {
			User imi = new User("Nagy Imre", "nagyimre@gmail.com", "imi");
			urepository.save(imi);
			ConsumptionPlace place = new ConsumptionPlace("xyz utca 9.", imi.getID());
			cprepository.save(place);
			Meter meter = new Meter(place.getID(), "víz", (long)1232134 , new Date());
			mRepository.save(meter);
			Reading reading = new Reading(meter.getId(),(float)1222.12, new Date(), "valami.hu/image");
			rRepository.save(reading);

			User jani = new User("Nagy János", "nagyjanos@gmail.com", "jani");
			urepository.save(jani);
			ConsumptionPlace place2 = new ConsumptionPlace("xyz utca 2.", jani.getID());
			cprepository.save(place2);
			Meter meter2 = new Meter(place2.getID(), "víz", (long)1233134 , new Date());
			mRepository.save(meter2);
			Reading reading2 = new Reading(meter2.getId(),(float)422.62, new Date(), "valami.hu/image2");
			rRepository.save(reading2);
		};
	}

}
