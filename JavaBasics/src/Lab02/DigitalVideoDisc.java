package Lab02;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Nguyen Duc Phu 20215161: Getter generation
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    // Nguyen Duc Phu 20215161: Constructor method generation
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {

        // Nguyen Duc Phu 20215116: Override equals method
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /*
         * Nguyen Duc Phu 20215116: Check if o is an instance of DigitalVideoDisc or not
         * "null instanceof [type]" also returns false
         */
        if (!(o instanceof DigitalVideoDisc)) {
            return false;
        }

        // Nguyen Duc Phu 20215116: typecast o to Complex so that we can compare data
        // members
        DigitalVideoDisc disc = (DigitalVideoDisc) o;

        // Nguyen Duc Phu 20215116: Compare the data members and return accordingly
        return length == disc.length
                && cost == disc.cost
                && title.equals(disc.title)
                && category.equals(disc.category)
                && director.equals(disc.director);
    }
}