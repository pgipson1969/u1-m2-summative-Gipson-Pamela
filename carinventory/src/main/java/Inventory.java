
import java.util.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    static int id = 1000;
    static Map<Integer, Car> carInventoryMap = new HashMap ();
    static List<Car> carList = new ArrayList<> ();
    static List<Integer> keyList = new ArrayList<> ();

    public static void main(String[] args) {

        int userEnteredId = 1000;
        boolean contMainOp = true, isNumber = false;
        Scanner scanner = new Scanner ( System.in );
        String input;
        int inputNum;

        while (contMainOp) {
            System.out.println ( "1. Add \t 2. Delete \t 3. List \t 4. Search \t 5. Exit" );
            isNumber = true;
            input = scanner.nextLine ();
            isNumber = isNumber ( input );

            if (isNumber == true)
                inputNum = Integer.parseInt ( input );
            else
                break;


            //inputNum = Integer.parseInt(input);
            switch (inputNum) {
                case 1:
                    //Adding
                    addCar ( carInventoryMap );
                    break;
                case 2:
                    //Delete
                    listCars ( carInventoryMap );
                    System.out.println ( "Enter car Id to delete car" );
                    int carId = scanner.nextInt ();
                    scanner.nextLine ();
                    boolean carFound = deleteCar ( carInventoryMap, userEnteredId );
                    if (carFound == true) {
                        System.out.println ( "Car deleted" );
                        listCars ( carInventoryMap );
                    }
                    break;
                case 3:
                    //List
                    listCars ( carInventoryMap );
                    break;
                case 4:
                    // Search

                    System.out.println ( "Search by 1. Make 2. Model 3. Color 4: Year 5. Miles" );
                    String searchStr;
                    int searchNum;
                    searchStr = scanner.nextLine ();
                    if (isNumber ( searchStr ) == true) {
                        inputNum = Integer.parseInt ( searchStr );
                        String search;
                        switch (inputNum) {
                            case 1:
                                System.out.println ( "Search by Make, enter a make" );
                                listCars ( carInventoryMap );
                                search = scanner.nextLine ();
                                searchCarsByMake ( carInventoryMap, search );
                                break;
                            case 2:
                                System.out.println ( "Search by Model, enter a model" );
                                listCars ( carInventoryMap );
                                search = scanner.nextLine ();
                                searchCarsByModel ( carInventoryMap, search );
                                break;

                            case 3:
                                System.out.println ( "Search by Color, enter a make" );
                                listCars ( carInventoryMap );
                                search = scanner.nextLine ();
                                searchCarsByColor ( carInventoryMap, search );
                                break;

                            case 4:

                                System.out.println ( "Search by Year, enter a year" );
                                listCars ( carInventoryMap );
                                search = scanner.nextLine ();

                                isNumber = isNumber ( search );

                                if (isNumber == true)
                                    inputNum = Integer.parseInt ( search );
                                else {
                                    System.out.println ( "entered value is not a valid number" );
                                    break;
                                }

                                // scanner.nextLine();

                                searchCarsByYear ( carInventoryMap, inputNum );
                                break;

                            case 5:
                                System.out.println ( "Search for cars that is less than the miles entered" );
                                listCars ( carInventoryMap );
                                search = scanner.nextLine ();

                                isNumber = isNumber ( search );

                                if (isNumber == true)
                                    inputNum = Integer.parseInt ( search );
                                else {
                                    System.out.println ( "entered value is not a valid number" );
                                    break;
                                }

                                // scanner.nextLine();

                                searchCarsByMiles ( carInventoryMap, inputNum );
                                break;

                            default:
                                System.out.println ( "Entered value is not within range" );
                                break;

                        }
                    }


                    break;
                case 5:
                    System.out.println ( "Exiting the program" );
                    contMainOp = false;
                    break;
                default:
                    System.out.println ( "Enter a valid number" );

            }

            //scanner.nextLine();

        }


        // addCar(carInventoryMap);

        //    carInventoryMap.
        //listCars(carInventoryMap);

//        searchCarsByMake(carInventoryMap, "nissan");
//        searchCarsByModel(carInventoryMap, "rav");
//        searchCarsByColor(carInventoryMap, "red");
//        searchCarsByYear(carInventoryMap, 2000);
//        searchCarsByMiles(carInventoryMap, 10000);


    }

    public static boolean isNumber(String str) {
        boolean isNumber = true;
        //input = scanner.nextLine();
        for (int i = 0; i < str.length (); i++) {
            if (Character.isDigit ( str.charAt ( i ) ) == false) {
                isNumber = false;
                break;

            }

        }

        return isNumber;

    }

    public static boolean deleteCar(Map<Integer, Car> carInventoryMap, int userEnteredId) {

        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet ().iterator ();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        boolean carFound = false;
        while (iterator.hasNext ()) {
            Map.Entry<Integer, Car> carEntry = iterator.next ();
            tmpCar = carEntry.getValue ();
            if (carEntry.getKey () == userEnteredId) {
                iterator.remove ();
                //carInventoryMap.remove(userEnteredId); this will throw error when list gets modified other than
                // Iterator. Either break when using carInventorymap-remove or use iterator to removew
                carFound = true;
                // break;
            }
        }
        return carFound;
    }

    public static void printCarList(List<Car> carList, List<Integer> keyList) {

        int i = 0;
        System.out.println ( "" );
        //carList.clear();
        while (i < carList.size ()) {

            System.out.println ( keyList.get ( i ) + "\t" + carList.get ( i ).getMake () + "\t" +
                    carList.get ( i ).getModel () + "\t" +
                    carList.get ( i ).getColor () + "\t" +
                    carList.get ( i ).getMiles () + "\t" +
                    carList.get ( i ).getYear () );
            i++;
        }

        carList.clear ();
        keyList.clear ();


    }

    public static List<Car> searchCarsByMake(Map<Integer, Car> carInventoryMap, String make) {

        carList.clear ();
        keyList.clear ();
        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet ().iterator ();

//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        while (iterator.hasNext ()) {
            Map.Entry<Integer, Car> carEntry = iterator.next ();

            tmpCar = carEntry.getValue ();
            if (tmpCar.getMake ().equals ( make )) {
                carList.add ( tmpCar );
                keyList.add ( carEntry.getKey () );

            }

           /*System.out.println(carEntry.getValue().getMake()+"\t" +
                   carEntry.getValue().getModel()+ "\t"+
                   carEntry.getValue().getColor()+ "\t"+
                   carEntry.getValue().getMiles()+ "\t"+
                   carEntry.getValue().getYear());

            */
        }
        printCarList ( carList, keyList );
        return null;
    }

    public static List<Car> searchCarsByMiles(Map<Integer, Car> carInventoryMap, int miles) {

        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet ().iterator ();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        while (iterator.hasNext ()) {
            Map.Entry<Integer, Car> carEntry = iterator.next ();
            tmpCar = carEntry.getValue ();
            if (tmpCar.getMiles () < miles) {
                carList.add ( tmpCar );
                keyList.add ( carEntry.getKey () );
            }

           /*System.out.println(carEntry.getValue().getMake()+"\t" +
                   carEntry.getValue().getModel()+ "\t"+
                   carEntry.getValue().getColor()+ "\t"+
                   carEntry.getValue().getMiles()+ "\t"+
                   carEntry.getValue().getYear());

            */
        }
        printCarList ( carList, keyList );
        return null;
    }

    public static List<Car> searchCarsByColor(Map<Integer, Car> carInventoryMap, String color) {

        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet ().iterator ();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        while (iterator.hasNext ()) {
            Map.Entry<Integer, Car> carEntry = iterator.next ();
            tmpCar = carEntry.getValue ();
            if (tmpCar.getColor ().equals ( color )) {
                carList.add ( tmpCar );
                keyList.add ( carEntry.getKey () );
            }

        }
        printCarList ( carList, keyList );
        return null;
    }

    public static List<Car> searchCarsByYear(Map<Integer, Car> carInventoryMap, int year) {

        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet ().iterator ();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;

        while (iterator.hasNext ()) {
            Map.Entry<Integer, Car> carEntry = iterator.next ();
            tmpCar = carEntry.getValue ();
            if (tmpCar.getYear () == year) {
                carList.add ( tmpCar );
                keyList.add ( carEntry.getKey () );
            }

        }
        printCarList ( carList, keyList );
        return null;
    }


    public static List<Car> searchCarsByModel(Map<Integer, Car> carInventoryMap, String model) {

        Iterator<Map.Entry<Integer, Car>> iterator = carInventoryMap.entrySet ().iterator ();
//List<Car> carList = new ArrayList<>();

        Car tmpCar;
        while (iterator.hasNext ()) {
            Map.Entry<Integer, Car> carEntry = iterator.next ();
            tmpCar = carEntry.getValue ();
            if (tmpCar.getModel ().equals ( model )) {
                carList.add ( tmpCar );
                keyList.add ( carEntry.getKey () );
            }


        }
        printCarList ( carList, keyList );
        Inventory () {
        }

        public static void listCars ( Map < Integer, Car > hashMap){
            Iterator<Map.Entry<Integer, Car>> iterator = hashMap.entrySet ().iterator ();

            Iterator<Integer> keyIterator = hashMap.keySet ().iterator ();

            while (iterator.hasNext ()) {
                Map.Entry<Integer, Car> carEntry = iterator.next ();
                System.out.println ( keyIterator.next () + "\t" + carEntry.getValue ().getMake () + "\t" +
                        carEntry.getValue ().getModel () + "\t" +
                        carEntry.getValue ().getColor () + "\t" +
                        carEntry.getValue ().getMiles () + "\t" +
                        carEntry.getValue ().getYear () );
            }

        }

         public static void addCar ( Map < Integer, Car > hashMap){
            Scanner scanner = new Scanner ( System.in );
            String make, model, color;
            int year, milesOnOdometer;
            Car car;
            //for (int i = 0; i < 2; i++) {
            // adding objects to the Hashmap
            car = new Car ();
            //System.out.println("Enter the input for Car Object" + i + 1 + ": ");
            System.out.print ( "Make: " );
            make = scanner.nextLine ();
            System.out.print ( "Model: " );
            model = scanner.nextLine ();
            System.out.print ( "Color: " );
            color = scanner.nextLine ();
            System.out.print ( "Year: " );
            year = scanner.nextInt ();
            scanner.nextLine ();
            System.out.print ( "Miles: " );
            milesOnOdometer = scanner.nextInt ();
            scanner.nextLine ();
            car.setColor ( color );
            car.setMake ( make );
            car.setModel ( model );
            car.setMiles ( milesOnOdometer );
            car.setYear ( year );
            ;
            hashMap.put ( id++, car );
        }

    }
}