package pl.eud.pwr.ztw.books;

public class Author {


    private final String firstName;
    private final String lastName;

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }
    public Author(String name){
        String[] splited = name.split("\\s+");
        if (splited.length == 2) {
            this.firstName = splited[0];
            this.lastName = splited[1];
        }
        else {
            this.firstName = name;
            this.lastName = "";
        }

    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        return "Author: "+this.firstName + " " + this.lastName;
    }

}
