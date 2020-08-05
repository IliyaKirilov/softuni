package softuni.demo.service.services;

import softuni.demo.domain.model.Offer;
import softuni.demo.service.model.OfferServiceModel;

import java.util.Set;

public interface OfferService {
    OfferServiceModel addOffer(OfferServiceModel offerServiceModel);
    Set<OfferServiceModel> findAll();

}
