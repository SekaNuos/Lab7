package com.company;

import com.sun.jdi.IntegerValue;

import java.util.*;
import java.util.stream.Collectors;

public class Filter {
//a
    public List<Train> trainsToStation(ArrayList<Train> list,String station) {
        List<Train> mas = new ArrayList<>();
        for (Train train : list) {
            if (train.getStation().equals(station)) {
                mas.add(train);
            }
        }
        mas.sort(Comparator.comparing(Train::getTime));
        return mas;
    }
//b
    public List<Train> trainsToStationAfterTime(ArrayList<Train> list, String station, int time) {
        List<Train> mas = new ArrayList<>();
        for (Train train : list) {
            if (train.getStation().equals(station) && train.getTime() > time) {
                mas.add(train);
            }
        }
        mas.sort(Comparator.comparing(Train::getTime));
        return mas;
    }
//с
    public List<Train> trainsToStationWithCourierSeats(ArrayList<Train> list, String station) {
        List<Train> mas = new ArrayList<>();
        for(Train train : list)
        {
            if(train.getStation().equals(station)  && train.getSeatsCoupe() > 0)
                mas.add(train);
        }
        return mas;
    }
//d
    public List<Train> trainsToStationsIncreasingSeats(ArrayList<Train> list, String station) {
        List<Train> mas = new ArrayList<>();
        for (Train train : list) {
            if (train.getStation().equals(station)) {
                mas.add(train);
            }
        }
        mas.sort(Comparator.comparing(Train::getSeatsNumber));
        return mas;
    }
//e
    public Set<String> listOfStations(ArrayList<Train> list) {
        List<String> list2 = new ArrayList<>();
        for(Train train : list) {
            list2.add(train.getStation());
        }
        HashMap<String, Integer> hm = new HashMap<>();
        Set<String> distinct = new HashSet<>(list2);
        for (String s: distinct) {
            hm.put(s,Collections.frequency(list2, s));
        }
        List<Map.Entry<String, Integer> > temp = new LinkedList<>(hm.entrySet());
        Collections.sort(temp, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<String, Integer> results = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : temp) {
            results.put(aa.getKey(), aa.getValue());
        }
        return results.keySet();
    }
//e
/*
    public Set<String> listOfStations(ArrayList<Train> list) {
        List<String> list2 = new ArrayList<>();
        for(Train train : list) {
            list2.add(train.getStation());
        }
        Set<String> distinct = new HashSet<>(list2);
        for (String s: distinct) {
            System.out.println(s + ": " + Collections.frequency(list2, s));
            statAndFreq.put(s,Collections.frequency(list2, s));
        }
        return distinct;
    }
*/
//f
    public Map<String, List<Train>> getStationsAndTrains(List<Train> list ) {
        Map<String, List<Train>> index = new HashMap<>();
        for (Train train : list) {
            index.computeIfAbsent(train.getStation(), k -> new ArrayList<>()).add(train);
        }
        return index;
    }
    public static void print(List<Train> list) {
        for(Train flat : list)
            System.out.print(flat.toString());
    }
    public static void printIndex(Map<String, List<Train>> index){
        System.out.print(index);
    }
    public static void printIncreasingStations(Set<String> map) {
        System.out.print(map);
    }
}

