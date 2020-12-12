package fr.km.designpattern.strategy;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * WAY 2
 * In order to be able to use the pattern strategy, we must remove the switch block
 * <p>
 * replacing this switch by using COMPOSITION
 * <p>
 * switch (code){
 * case "LF":
 * return new LifeContract(name);
 * case "AU" :
 * return new AutoContract(name);
 * case "DW" :
 * return new DwellingContract(name);
 * default:
 * throw new IllegalArgumentException("not valid code");
 * }
 */

public class ContractType {
    String code;
    Function<String, Contract> create;

    public ContractType(String code, Function<String, Contract> create) {
        this.code = code;
        this.create = create;
    }

    public String getType() {
        return this.code;
    }

    public Contract create(String name) {
        return create.apply(name);
    }
}

/**
 * other way to implements ContractFactory by using pattern strategy
 */
class ContractFactoryHelper implements  ContractFactory  {

    private ContractType auto = new ContractType("AU", name -> new AutoContract(name));
    private ContractType life = new ContractType("LF", name -> new LifeContract(name));
    private ContractType dwelling = new ContractType("DW", name -> new DwellingContract(name));

    private List<ContractType> list = Stream.of(auto, life, dwelling).collect(Collectors.toList());

    @Override
    public Contract create(String code, String name)  {
        return list.stream()
                .filter(type -> type.code.equals(code))
                .findAny()
                .map(ct ->ct.create(name))
                .orElse(null);
    }
}

class test {
    public static void main(String[] args) {
        ContractFactoryHelper fact = new ContractFactoryHelper();
        final Contract contract = fact.create("LF", "Victor Strate");
        System.out.println(contract); // print  -> LifeContract{name='Victor Strate'}
    }
}