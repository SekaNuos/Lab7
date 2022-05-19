package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        ReadingFile File = new ReadingFile();
        Filter filter = new Filter();
        String filename = "txt.txt";
        ArrayList<Train> trains = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        trains.add(new Train(1,  "Киев", 2213, 1500, 8, 0, 8));
        trains.add(new Train(2,  "Киев", 1351, 1200, 2, 7, 2));
        trains.add(new Train(3,  "Ужгород", 9183, 1100, 6, 3, 3));
        trains.add(new Train(4,  "Киев", 1544, 930, 4, 2, 1));
        trains.add(new Train(5,  "Винница", 2613, 930, 0, 6, 5));
        trains.add(new Train(6,  "Ужгород", 1895, 2300, 5, 3, 3));

        File.writeInFile(filename, trains);

        ArrayList<Train> newList = new ArrayList<>();
        newList = File.readFromFile(filename,newList);

        for(Train p : newList)
            System.out.printf(p.toString());

        String station;
        int  time;

        System.out.println("\n\nА - Список поездов идущих к одной заданой станции по времени отправки ");
        System.out.println("\nВведите название станции: ");
        station=sc.nextLine();
        filter.print(filter.trainsToStation(newList, station));

        System.out.println("\n\nB - Список поездов идущих к одной заданой станции после заданой времени отправки");
        System.out.println("\nВведите название станции: ");
        station=sc.nextLine();
        System.out.println("\nВведите время отправки: ");
        time = sc.nextInt();
        filter.print(filter.trainsToStationAfterTime(newList, station,time));

        System.out.println("\n\nC - Список поездов идущих к одной заданой станции с местами Купе ");
        System.out.println("\nВведите название станции: ");
        station=sc2.nextLine();
        filter.print(filter.trainsToStationWithCourierSeats(newList, station));

        System.out.println("\n\nD - Список поездов идущих к одной заданой станции по зростанию мест");
        System.out.println("\nВведите название станции: ");
        station=sc2.nextLine();
        System.out.println("\nСписок поездов:");
        filter.print(filter.trainsToStationsIncreasingSeats(newList, station));

        System.out.println("\n\nE - Список всех станций в порядке возростания запланированных поездов");
        System.out.println("\nСписок станций");
        filter.printIncreasingStations(filter.listOfStations(newList));

        System.out.println("\n\nF - Список станций и поездов, которые к ним надвигаются: ");
        System.out.println("\nСтанции и поезда");
        filter.printIndex(filter.getStationsAndTrains(trains));


    }

   
}