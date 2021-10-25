package by.itacademy.javaenterprise.goralchuk;

import by.itacademy.javaenterprise.goralchuk.DAO.PatientsImplementsDAO;
import by.itacademy.javaenterprise.goralchuk.blogic.Patients;
import by.itacademy.javaenterprise.goralchuk.utils.ConnectionToDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class MainTest {



    public static void main(String[] args) {

        PatientsImplementsDAO patientsImplementsDAO = new PatientsImplementsDAO();

        System.out.println(patientsImplementsDAO.getAll());

        patientsImplementsDAO.create(new Patients("Larisa", "Dolina", "F", java.sql.Date.valueOf("1958-10-04")));

        System.out.println(patientsImplementsDAO.getLimit(PatientsImplementsDAO.SELECT_LIMITS_PATIENTS));

    }
}
