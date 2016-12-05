package Day3;

import java.util.ArrayList;
import java.util.List;

class Triangle {

    private List<Cote> cotes = new ArrayList<>();

    private int id = 0;

    void addCote(int length) {

        cotes.add(new Cote(id++, length));
    }

    boolean isValid() {
     int a = cotes.get(0).length;
     int b = cotes.get(1).length;
     int c = cotes.get(2).length;

     return (a + b > c) && (b+c > a) && (a+c > b);
    }

    private void printTriangle() {
//        System.out.println("----------------------TRIANGLE-----------------------");
//        cotes.forEach(System.out::println);
    }

    class Cote
    {
        int id;
        int length;

        public Cote(int i, int length) {

            this.id = i;
            this.length = length;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof Cote) && ((Cote) obj).id == id;
        }
    }
}
