package emulador_bd.domain;

import java.util.ArrayList;
import java.util.List;

public class Address extends BaseModel {
    private String street;
    private transient Person person;
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Address(String street, Person person, Vehicle vehicleList) {
        super();

        if (street.length() > 29) {
            this.street = street.substring(0, 29);
        } else {
            this.street = street;
        }

        this.person = person;
        this.vehicleList.add(vehicleList);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street.length() > 29) {
            this.street = street.substring(0, 29);
        } else {
            this.street = street;
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicles) {
        this.vehicleList = vehicles;
    }

    @Override
    public String toString() {
        return "Endereço [Logradouro=" + street + ", Veículos=" + vehicleList + "]";
    }
}
