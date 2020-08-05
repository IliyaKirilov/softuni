package softuni.demo.web.model;

import javax.validation.constraints.Min;

public class OfferAddModel {
    private double price;
    private String description;



    public OfferAddModel() {
    }

    @Min(value = 0,message = "Enter valid price!")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
