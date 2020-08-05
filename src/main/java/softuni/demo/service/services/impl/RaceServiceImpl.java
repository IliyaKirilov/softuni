package softuni.demo.service.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.demo.domain.model.Race;
import softuni.demo.domain.repository.RaceRepository;
import softuni.demo.service.model.RaceServiceModel;
import softuni.demo.service.model.UserServiceModel;
import softuni.demo.service.services.RaceService;
import softuni.demo.web.model.RaceAddModel;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RaceServiceImpl implements RaceService {
    private final ModelMapper modelMapper;
    private final RaceRepository raceRepository;


    @Autowired
    public RaceServiceImpl(ModelMapper modelMapper, RaceRepository raceRepository) {
        this.modelMapper = modelMapper;
        this.raceRepository = raceRepository;
    }


    @Override
    public RaceServiceModel addRace(RaceServiceModel raceServiceModel) {


        Race race = this.modelMapper.map(raceServiceModel, Race.class);

        this.raceRepository.saveAndFlush(race);
        return this.modelMapper.map(race,RaceServiceModel.class);

    }

    @Override
    public RaceServiceModel findByName(String name) {

        return this.raceRepository.findByName(name)
                .map(race-> this.modelMapper.map(race, RaceServiceModel.class)).orElse(null);


    }

    @Override
    public List<RaceServiceModel> findAllRaces() {

        return this.raceRepository.findAll().stream()
                .map(race -> this.modelMapper.map(race,RaceServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public RaceServiceModel findById(String id) {

        Race race = this.raceRepository.findById(id).orElse(null);
        return this.modelMapper.map(race,RaceServiceModel.class);

    }
}
