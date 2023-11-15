package hust.soict.headspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {

    public static void main(String[] args) {
        // Nguyen Duc Phu 20215116: Code session 9
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println(System.currentTimeMillis() - start);
        // Nguyen Duc Phu 20215116: print around 360

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println(System.currentTimeMillis() - start);
        // Nguyen Duc Phu 20215116: print around 2
    }
}
