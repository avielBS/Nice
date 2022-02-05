package DAUManagment;
import Data.Dau;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class DAUHolder {

    private final ConcurrentHashMap<String, HashSet<Dau>> dateMap;
    private static DAUHolder dauHolder;

    private DAUHolder(){
        dateMap = new ConcurrentHashMap<>();
    }

    public static DAUHolder getInstance(){
        if (dauHolder == null){
            dauHolder = new DAUHolder();
        }
        return dauHolder;
    }

    public void addDau(List<Dau> daus){
        this.organizeDataByDate(daus);
    }

    /**
     * This function organize the data in HashMap by dau date
     */
    private void organizeDataByDate(List<Dau> dauList){

        for( Dau dau : dauList){
            if(this.dateMap.containsKey(dau.getDate())){
                this.dateMap.get(dau.getDate()).add(dau);
            }else{
                HashSet<Dau> set = new HashSet<>();
                set.add(dau);
                this.dateMap.put(dau.getDate(), set);
            }
        }
    }

    public HashSet<Dau> getDauByDate(String date){
        if (this.dateMap.containsKey(date))
            return this.dateMap.get(date);
        else
            return new HashSet<>();
    }

    public void reset(){
        dauHolder = null;
    }

}
