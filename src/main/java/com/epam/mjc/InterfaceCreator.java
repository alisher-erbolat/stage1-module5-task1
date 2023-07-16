package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s:
                 x) {
                char c = s.charAt(0);
                if (!Character.isUpperCase(c)) return false;
            }return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int size = x.size();
            for (int i=0; i<size; i++) {
                if (x.get(i)%2==0) x.add(x.get(i));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            if (values.size()>0){
                for (int i=0; i< values.size(); i++){
                    String[] strs = values.get(i).split(" ");
                    if (!(Character.isUpperCase(values.get(i).charAt(0)) && values.get(i).endsWith(".") && strs.length>3)){
                        values.remove(i);
                        i--;
                    }
                }
            }
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return (x) -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : x){
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
