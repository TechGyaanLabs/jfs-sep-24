package com.careerit.cj.day26;

import java.util.Comparator;
import java.util.List;

interface Parser{

}

class CityParser implements Parser{

}
class IciciParser implements Parser{

}
class IciciTransactions extends Transactions{

}
class CityTransactions extends Transactions{

}
class TransactionProcessor<T extends Transactions>{

    public void process(T t){
        // Process the transaction
    }
}
class Transactions{

}
public class GenericExample3 {



    public static void main(String[] args) {

        List<String> list1 = List.of("Krish","Manoj","John","Smith");
        list1.sort(Comparator.naturalOrder());
        GenericExample3 obj = new GenericExample3();
        List<Transactions> list = obj.loadTransactions("transactions.json.json", new CityParser());
        System.out.println(list);
    }

    public <T extends Parser> List<Transactions> loadTransactions(String fileName,T t){

        return null;
    }
}




