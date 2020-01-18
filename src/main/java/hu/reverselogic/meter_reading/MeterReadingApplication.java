package hu.reverselogic.meter_reading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import hu.reverselogic.meter_reading.repositories.UserRepository;
import hu.reverselogic.meter_reading.repositories.ConsumptionPlaceRepository;
import hu.reverselogic.meter_reading.repositories.MeterRepository;
import hu.reverselogic.meter_reading.entities.User;
import hu.reverselogic.meter_reading.entities.ConsumptionPlace;
import hu.reverselogic.meter_reading.entities.Meter;
import java.util.Date;
import hu.reverselogic.meter_reading.repositories.ReadingRepository;

@SpringBootApplication
public class MeterReadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeterReadingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository urepository, ConsumptionPlaceRepository cprepository, MeterRepository mRepository, ReadingRepository rRepository)
	{
		return(args) -> {
			Meter meter = new Meter("víz", (long)1232134 , new Date());
			ConsumptionPlace place = new ConsumptionPlace("xyz utca 9.", meter);
			User nefelejts = new User("Nefelejts Virág", "nefelejts@virag.com", "abc", place);
			urepository.save(nefelejts);
			cprepository.save(place);
			mRepository.save(meter);

			Meter meter2 = new Meter("víz", (long)1233134 , new Date());
			ConsumptionPlace place2 = new ConsumptionPlace("xyz utca 2.",meter2);
			User ibolya = new User("Virág Ibolya", "ibolya@virag.com", "abc", place2);
			urepository.save(ibolya);
			cprepository.save(place2);
			mRepository.save(meter2);
		};
	}

}
