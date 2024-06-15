package Practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Library {

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private Map<Integer, String> borrows = new HashMap<>();

    public void libraryStatus(){
        System.out.println("Books registered:");
        for(Book b: books){
            System.out.println("    " + b);
        }
        System.out.println("Users registered");
        for(User u: users){
            System.out.println("    " + u);
        }
        System.out.println("Books borrowed");
        for(Map.Entry<Integer, String> entry : borrows.entrySet()){
            int userId = entry.getKey();
            String bookTitle = entry.getValue();
            User user = findUserById(userId);
            System.out.println("    " + user.getName() + " borrowed " + bookTitle);
        }
    }

    private User findUserById(int id){
        for(User u : users) {
            if(u.getId() == id) {
                return u;
            }
        }
        return null; // Handle case where user is not found
    }
    public void addBook(Book b){
        this.books.add(b);
    }

    public void registerUser(User u){
        this.users.add(u);
    }
    public void borrowBook(Integer id, String title){
        for (Book b : books) {
            if (b.getTitle().equals(title) && b.isStatus()) {
                b.setStatus(false);
                this.borrows.put(id, title);
                return;
            }
        }
        System.out.println("Book not available for borrowing or not found.");
    }
    public void returnBook(Integer id, String title){
        for (Book b : books) {
            if (b.getTitle().equals(title) && !b.isStatus()) {
                b.setStatus(true);
                this.borrows.remove(id, title);
                return;
            }
        }
        System.out.println("Book not available for returning or not found.");
    }
}
