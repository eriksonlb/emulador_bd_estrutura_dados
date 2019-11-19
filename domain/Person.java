package emulador_bd.domain;

import java.util.ArrayList;
import java.util.List;

public class Person extends BaseModel {
    private String name;
    private char gender;
    private List<Address> addressList = new ArrayList<>();

    public Person(String name, char gender) {
        super();

        if (name.length() > 48) {
            this.name = name.substring(0, 48);
        } else {
            this.name = name;
        }

        if (gender != 'm' && gender != 'M' && gender != 'f' && gender != 'F') {
            this.gender = 'u';
        } else {
            this.gender = Character.toLowerCase(gender);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {

        if (gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F') {
            this.gender = Character.toLowerCase(gender);
        } else {
            this.gender = 'U';
        }
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddress(List<Address> addresses) {
        this.addressList = addresses;
    }

    @Override
    public String toString() {
        return "Pessoa [Nome=" + name + ", Sexo=" + gender + ", Endereços=" + addressList + "]";
    }
}
