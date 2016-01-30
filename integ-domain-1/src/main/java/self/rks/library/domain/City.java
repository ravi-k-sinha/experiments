package self.rks.library.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class City extends GeoArea {

    @ManyToOne
    private State state;

    public City(){}

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }


}
