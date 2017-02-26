package Problem11;

public class Cat extends Animal{

    private double specificBreedInfo;

    public Cat(String breed, String name, double specificBreedInfo) {
        super(breed, name);
        this.specificBreedInfo = specificBreedInfo;
    }

    public double getSpecificBreedInfo() {
        return this.specificBreedInfo;
    }

    @Override
    public String toString() {
        String normalizedSpecificBreedInfo;
        if (this.getBreed().equals("StreetExtraordinaire")) {
            normalizedSpecificBreedInfo = String.valueOf((int)this.getSpecificBreedInfo());
        }else if (this.getBreed().equals("Cymric")) {
            normalizedSpecificBreedInfo = String.format("%.2f", this.getSpecificBreedInfo());
        }else {
            normalizedSpecificBreedInfo = String.valueOf((int)this.getSpecificBreedInfo());
        }

        return String.format("%s %s %s%n",
                this.getBreed(), this.getName(), normalizedSpecificBreedInfo);
    }
}
