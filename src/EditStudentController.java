import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
// Controller class for the EditStudent.fxml scene
// Allows the user to edit info in the Student table
public class EditStudentController implements Initializable {

    @FXML
    private ChoiceBox choice;
    @FXML
    private TextField newinfo;
    @FXML
    private TextField studentID;

    String database;
    String user;
    String password;

    public void data(String a, String b, String c) {
        database = a;
        user = b;
        password = c;
    }
    // When the user hits the 'Apply' button the program retrieves what the user chose form the ChoiceBox
    // It then connects to the databse and retrieves the data from the TextFields
    // It then calls the repsective procedure
    public void Apply(ActionEvent event) throws IOException {
        String connectionUrl =
                "jdbc:sqlserver://SQL2.cis245.mc3.edu:1433;" +
                        "databaseName=" + database + ";user=" + user + ";password=" + password;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        if(choice.getValue().toString().equals("First Name")){
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);

                CallableStatement statement = conn.prepareCall("{call usp_chg_student_first_name(?,?)}");

                statement.setString(1, newinfo.getText());
                statement.setString(2, studentID.getText());
                statement.execute();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try {
                    rs.close();
                } catch (Exception e) {
                }
                if (stmt != null) try {
                    stmt.close();
                } catch (Exception e) {
                }
                if (conn != null) try {
                    conn.close();
                } catch (Exception e) {
                }
            }

        }else if(choice.getValue().toString().equals("Last Name")){
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);

                CallableStatement statement = conn.prepareCall("{call usp_chg_student_last_name(?,?)}");

                statement.setString(1, newinfo.getText());
                statement.setString(2, studentID.getText());
                statement.execute();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try {
                    rs.close();
                } catch (Exception e) {
                }
                if (stmt != null) try {
                    stmt.close();
                } catch (Exception e) {
                }
                if (conn != null) try {
                    conn.close();
                } catch (Exception e) {
                }
            }

        }else if(choice.getValue().toString().equals("Address")){
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);

                CallableStatement statement = conn.prepareCall("{call usp_chg_student_address(?,?)}");

                statement.setString(1, newinfo.getText());
                statement.setString(2, studentID.getText());
                statement.execute();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try {
                    rs.close();
                } catch (Exception e) {
                }
                if (stmt != null) try {
                    stmt.close();
                } catch (Exception e) {
                }
                if (conn != null) try {
                    conn.close();
                } catch (Exception e) {
                }
            }

        }else if(choice.getValue().toString().equals("State")){
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);

                CallableStatement statement = conn.prepareCall("{call usp_chg_student_state(?,?)}");

                statement.setString(1, newinfo.getText());
                statement.setString(2, studentID.getText());
                statement.execute();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try {
                    rs.close();
                } catch (Exception e) {
                }
                if (stmt != null) try {
                    stmt.close();
                } catch (Exception e) {
                }
                if (conn != null) try {
                    conn.close();
                } catch (Exception e) {
                }
            }

        }else if(choice.getValue().toString().equals("Phone")){
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);

                CallableStatement statement = conn.prepareCall("{call usp_chg_student_phone(?,?)}");

                statement.setString(1, newinfo.getText());
                statement.setString(2, studentID.getText());
                statement.execute();
                statement.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try {
                    rs.close();
                } catch (Exception e) {
                }
                if (stmt != null) try {
                    stmt.close();
                } catch (Exception e) {
                }
                if (conn != null) try {
                    conn.close();
                } catch (Exception e) {
                }
            }
            }else if(choice.getValue().toString().equals("Grade")){
                try {
                    //establish connection
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    conn = DriverManager.getConnection(connectionUrl);

                    CallableStatement statement = conn.prepareCall("{call usp_chg_student_grade(?,?)}");

                    statement.setString(1, newinfo.getText());
                    statement.setString(2, studentID.getText());
                    statement.execute();
                    statement.close();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rs != null) try {
                        rs.close();
                    } catch (Exception e) {
                    }
                    if (stmt != null) try {
                        stmt.close();
                    } catch (Exception e) {
                    }
                    if (conn != null) try {
                        conn.close();
                    } catch (Exception e) {
                    }
                }


            }else{

        }

    }
    // Sends the user to the EditInfo.fxml scene when the user hits the 'Back' button
    public void changeSceenBack(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditInfo.fxml"));
        Parent searchView = loader.load();
        EditInfoController a = loader.<EditInfoController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Adds items to the choice ChoiceBox
        choice.getItems().add("First Name");
        choice.getItems().add("Last Name");
        choice.getItems().add("Address");
        choice.getItems().add("State");
        choice.getItems().add("Phone");
        choice.getItems().add("Grade");
    }
}

