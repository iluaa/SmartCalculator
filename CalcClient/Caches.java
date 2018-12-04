import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Caches {
    private static LinkedList<String> cacheFirstLvl = new LinkedList<>();
    private static ArrayList<String> cacheSecondLvl = new ArrayList<>();

    public boolean isInCacheFirst (String operation){
        ListIterator<String> iterator = cacheFirstLvl.listIterator();
        while (iterator.hasNext()){
            String searchOperation = iterator.next();
            searchOperation = searchOperation.split("=",2)[0];

            if (searchOperation.equals(operation))
                return true;

        }
        return false;
    }

    public boolean isInCacheSecond (String operation){
        for (String str : cacheSecondLvl){
            if (str.contains(operation))
                return true;
        }
        return false;
    }

    public String toReadFromCacheFirst(String operation){
        String allOperation = "";
        ListIterator<String> iterator = cacheFirstLvl.listIterator();

        while(iterator.hasNext()){
            String current = iterator.next();
            if (current.contains(operation)) {
                allOperation = current;
                iterator.remove();
            }
        }
        cacheFirstLvl.add(allOperation);

        return allOperation;
    }

    String toReadFromCacheSecond (String operation){
        String allExpression = "";

        for (String str : cacheSecondLvl){
            if (str.contains(operation))
                allExpression = str;
        }

        return allExpression;
    }

    void toWriteInCache (String operation){
        int cash1Limit = 10;
        if (cacheFirstLvl.size() < cash1Limit)
            cacheFirstLvl.add(operation);
        else {
            cacheFirstLvl.add(operation);
            cacheSecondLvl.add(cacheFirstLvl.get(0));
            cacheFirstLvl.remove(0);
        }
    }
    int getSizeCacheSecond(){
        return cacheSecondLvl.size();
    }
    void removeItemCashSecond(int item){
        cacheSecondLvl.remove(item);
    }
}
