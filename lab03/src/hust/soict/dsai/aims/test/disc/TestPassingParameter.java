package hust.soict.dsai.aims.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        // Nguyen Duc Phu 20215116 3. Passing parameter
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);

        System.out.println("Nguyen Duc Phu 20215116: jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Nguyen Duc Phu 20215116: cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Nguyen Duc Phu 20215116: jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        // Nguyen Duc Phu 20215116 swap the title
        Object tmp = 01;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        // Nguyen Duc Phu 20215116 change the title
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}