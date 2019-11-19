package emulador_bd.domain;

public class Vehicle extends BaseModel {
    private String plate;

    public Vehicle(String plate) {
        super();

        if (plate.length() > 9) {
            this.plate = plate.substring(0, 9);
        } else {
            this.plate = plate;
        }
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        if (plate.length() > 9) {
            this.plate = plate.substring(0, 9);
        } else {
            this.plate = plate;
        }
    }

    @Override
    public String toString() {
        return "Veiculo [Placa=" + plate + "]";
    }
}
