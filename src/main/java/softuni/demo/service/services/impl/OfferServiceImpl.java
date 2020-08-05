package softuni.demo.service.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.demo.domain.model.Offer;
import softuni.demo.domain.repository.OfferRepository;
import softuni.demo.service.model.OfferServiceModel;
import softuni.demo.service.services.OfferService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(ModelMapper modelMapper, OfferRepository offerRepository) {
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
    }

    @Override
    public OfferServiceModel addOffer(OfferServiceModel offerServiceModel) {
        Offer offer = this.modelMapper.map(offerServiceModel, Offer.class);


        System.out.println();
        return this.modelMapper.map(this.offerRepository.saveAndFlush(offer),OfferServiceModel.class);
    }

    @Override
    public Set<OfferServiceModel> findAll() {

        if (this.offerRepository.count() == 0){
            return null;
        }else {
            return this.offerRepository.findAll().stream().map(offer -> this.modelMapper.map
                    (offer,OfferServiceModel.class)).collect(Collectors.toSet());
        }

    }


}
