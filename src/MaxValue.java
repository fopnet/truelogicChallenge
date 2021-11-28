import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxValue {
    private static class Pojo {
        public Pojo(String id, int value) {
            this.id = id;
            this.value = value;
        }

        private String id;
        private int value;

        public String getId() {
            return id;
        }

        // public void setId(String id) {
        // this.id = id;
        // }
        public int getValue() {
            return value;
        }

        public String toString() {
            return String.format("Pojo({%s},{%d})", id, value);
        }
        // public void setValue(int value) {
        // this.value = value;
        // }
    }

    public static void main(String[] args) {
        List<Pojo> pojos = Arrays.asList(new Pojo("1", 1), new Pojo("2", 1));
        Pojo max = pojos.stream().max(Comparator.comparing(Pojo::getValue)).get();
        System.out.println(max);
    }
}
