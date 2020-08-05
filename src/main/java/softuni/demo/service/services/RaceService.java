package softuni.demo.service.services;

import softuni.demo.domain.model.Race;
import softuni.demo.service.model.RaceServiceModel;
import softuni.demo.web.model.RaceAddModel;

import java.util.List;

public interface RaceService {
   RaceServiceModel addRace(RaceServiceModel raceServiceModel);
   RaceServiceModel findByName(String name);
   List<RaceServiceModel> findAllRaces();

   RaceServiceModel findById(String id);
}
