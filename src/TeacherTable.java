// Helps the program display the data from the Teacher table (database)
// Getters and Setters for the data that will go in their respective column
public class TeacherTable {
    String teacherid, lastname, firstname, address, state, email, phone;

    public TeacherTable(String teacherid, String lastname, String firstname, String address, String state, String email, String phone){
        this.teacherid = teacherid;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.state = state;
        this.email = email;
        this.phone = phone;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
