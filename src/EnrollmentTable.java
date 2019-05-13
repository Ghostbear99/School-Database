// Helps the program display the data from the Enrollment table (database)
// Getters and setters for the data that will be set in their respsective columns
public class EnrollmentTable {
    String enrollmentID, studentID, courseID, teacherID;

    public EnrollmentTable(String enrollmentID,String studentID,String courseID,String teacherID){
        this.enrollmentID = enrollmentID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.teacherID = teacherID;
    }

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
}
