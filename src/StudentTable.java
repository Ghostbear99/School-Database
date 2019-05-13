// Helps the program display the data from the Student table (database)
// Getters and Setters for the data that will be set in their respective columns
public class StudentTable {
    String studentid, lastname, firstname, address, state, phone, grade;

    public StudentTable(String studentid, String lastname, String firstname, String address, String state, String phone, String grade){
        this.studentid = studentid;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.state = state;
        this.phone = phone;
        this.grade = grade;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
