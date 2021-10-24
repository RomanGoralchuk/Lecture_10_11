package by.itacademy.javaenterprise.goralchuk;


import by.itacademy.javaenterprise.goralchuk.blogic.Patient;
import by.itacademy.javaenterprise.goralchuk.utils.ConnectionToDataBase;
import by.itacademy.javaenterprise.goralchuk.utils.PatientSQLCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class MainTest {

    private static final Logger logger = LoggerFactory.getLogger(MainTest.class);

    public static void main(String[] args) {

        ConnectionToDataBase connect = new ConnectionToDataBase();
        Connection connection1 = connect.getNewConnection();

        PreparedStatement statement = null;
        ResultSet resultSet = null;

/*        try {
            statement = connection1.prepareStatement(PatientSQLCommands.ADD_PATIENT);
            Patient.insert(statement, "Toto","Cutugno", "M", java.sql.Date.valueOf("1968-09-04"));
            Patient.insert(statement, "Alice","Cooper", "M", java.sql.Date.valueOf("1950-09-04"));
            Patient.insert(statement, "Lola","Brigitta", "F", java.sql.Date.valueOf("1930-09-04"));

        } catch (SQLException e) {
            logger.error(e.toString());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection1 != null) {
                    connection1.close();
                }
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }*/

        Connection connection2 = connect.getNewConnectionViaFile();
        try {
            statement = connection1.prepareStatement(PatientSQLCommands.SELECT_PATIENTS);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("patient_ID");
                Date registration = resultSet.getDate("patient_registration");
                String name = resultSet.getString("patient_name");
                String surname = resultSet.getString("patient_surname");
                String sex = resultSet.getString("patient_sex");
                Date birthday = resultSet.getDate("patient_birthday");

                Patient patient = new Patient();
                patient.setId(id);
                patient.setRegistration(registration);
                patient.setName(name);
                patient.setSurname(surname);
                patient.setSex(sex);
                patient.setBirthday(birthday);

                System.out.println(patient);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection2 != null) {
                    connection2.close();
                }
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
    }
}
