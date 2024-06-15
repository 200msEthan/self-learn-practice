package Practice2;

public class User {
    private String name;
    private int id;

    private static int count = 1;
    User(String name){
        setName(name);
        setId(count);
        count++;
    }

    @Override
    public String toString() {
        return this.name + " " + this.id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}