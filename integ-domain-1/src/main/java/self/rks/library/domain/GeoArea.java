package self.rks.library.domain;

import javax.persistence.*;

/**
 * A geographical area that is bounded by geographical boundaries
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class GeoArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    protected String code;

    public GeoArea() {}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoArea geoArea = (GeoArea) o;

        return id.equals(geoArea.id);

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}