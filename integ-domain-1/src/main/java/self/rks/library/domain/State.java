package self.rks.library.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class State extends GeoArea {

    @ManyToOne
    private Country country;

    public State(){}

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
