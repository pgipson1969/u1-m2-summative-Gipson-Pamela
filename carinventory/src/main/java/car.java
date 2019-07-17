
    import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

    public class Car {
        protected String make;
        protected String model;
        protected int year;
        protected String color;
        protected int miles;



        public void listCars(Map<Integer,Car> hashMap){
            Iterator<Map.Entry<Integer,Car>> iterator = hashMap.entrySet().iterator();


            while (iterator.hasNext()){
                Map.Entry<Integer,Car> carEntry = iterator.next();
                System.out.println(carEntry.getValue().getMake()+"\t" +
                        carEntry.getValue().getModel()+ "\t"+
                        carEntry.getValue().getColor()+ "\t"+
                        carEntry.getValue().getMiles()+ "\t"+
                        carEntry.getValue().getYear());
            }

        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getMiles() {
            return miles;
        }

        public void setMiles(int miles) {
            this.miles = miles;
        }
    }
}
