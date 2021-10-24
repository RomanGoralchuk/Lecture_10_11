package by.itacademy.javaenterprise.goralchuk.blogic;

import by.itacademy.javaenterprise.goralchuk.utils.ConnectionToDataBase;
import by.itacademy.javaenterprise.goralchuk.utils.PatientSQLCommands;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@Data
public class Patient {
    private int id;
    private Date registration;
    private String name;
    private String surname;
    private String sex;
    private Date birthday;

    private static final Logger logger = LoggerFactory.getLogger(ConnectionToDataBase.class);

    public static void insert(PreparedStatement statement, String name, String surname, String sex, Date birthday) {
        try {
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, sex);
            statement.setDate(4, (java.sql.Date) birthday);
            statement.executeUpdate();
        } catch (SQLException | NullPointerException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public String toString() {
        return "\n Patient: " +
                "id=" + id +
                ", registration=" + registration +
                ", name='" + name +
                ", surname='" + surname +
                ", sex='" + sex +
                ", birthday=" + birthday;
    }
}

