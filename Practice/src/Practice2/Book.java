package Practice2;

public class Book {
    private String title;
    private String author;
    private boolean status = true;
    Book(String title, String author){
        setTitle(title);
        setAuthor(author);
    }

    public boolean isStatus() {
        return status;
    }
    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + " " + this.author + " " + this.status;
    }
}
