// Helps the program bring in the data from the database and display it
// Getters and Setters for the data from the Course table
public class CourseTable {
    String courseID, name, department, description, teacherID;
            public CourseTable(String courseID, String name, String department,String description, String teacherID){
                this.courseID = courseID;
                this.name = name;
                this.department = department;
                this.description = description;
                this.teacherID = teacherID;
            }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
}
