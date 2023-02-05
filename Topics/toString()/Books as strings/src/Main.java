import java.util.Arrays;
import java.util.StringJoiner;

class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "title=" +
                this.title +
                ",yearOfPublishing=" +
                String.valueOf(this.yearOfPublishing) +
                ",authors=" +
                Arrays.toString(this.authors).replace(", ", ",");
    }
}