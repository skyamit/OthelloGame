public class User {
    private String name;
    private char color;

    public User(){}

    public User(String nm,char c) {
        name = nm;
        color = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(char c) {
        this.color = c;
    }

    public char getColor() {
        return color;
    }

}