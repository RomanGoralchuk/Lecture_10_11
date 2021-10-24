package by.itacademy.javaenterprise.goralchuk.utils;

public class PatientSQLCommands {
    public static final String ADD_PATIENT = "" +
            "INSERT INTO patients " +
            "(patient_name," +
            "patient_surname," +
            "patient_sex,patient_birthday) " +
            "VALUES" +
            " (?,?,?,?)";
    public static final String SELECT_PATIENTS = "" +
            "SELECT * FROM patients " +
            "WHERE patient_sex = 'M' " +
            "ORDER BY patient_name ASC " +
            "LIMIT 3 " +
            "OFFSET 1 " +
            "";
}
