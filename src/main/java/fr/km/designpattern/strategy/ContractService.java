package fr.km.designpattern.strategy;

public class ContractService {
    public static void main(String[] args) {

    }
}

interface Contract{};

class DwellingContract implements Contract{
    private String name;
    public DwellingContract(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DwellingContract{" +
                "name='" + name + '\'' +
                '}';
    }
}

class LifeContract implements Contract{
    private String name;
    public LifeContract(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LifeContract{" +
                "name='" + name + '\'' +
                '}';
    }
}

class AutoContract implements Contract{
    private String name;
    public AutoContract(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AutoContract{" +
                "name='" + name + '\'' +
                '}';
    }
}

interface ContractFactory{
    Contract create(String code, String name);
}

/**
 * initial situation with switch case
 */
class ContractFactoryImpl implements ContractFactory{
    public Contract create(String code, String name) {
        switch (code){
            case "LF":
                return new LifeContract(name);
            case "AU" :
                return new AutoContract(name);
            case "DW" :
                return new DwellingContract(name);
            default:
                throw new IllegalArgumentException("not valid code");
        }
    }
}
