package homework.task2345;

import homework.task2345.shop.Address;

import java.util.Objects;

public abstract class PublicBuilding extends Building {

    protected String publicPurpose;

    public PublicBuilding(Address<?> address, String publicPurpose) {
        super(address);
        this.publicPurpose = publicPurpose;
    }

    @Override
    public String toString() {
        return "Public purpose: " + publicPurpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PublicBuilding that = (PublicBuilding) o;
        return publicPurpose.equals(that.publicPurpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicPurpose);
    }
}