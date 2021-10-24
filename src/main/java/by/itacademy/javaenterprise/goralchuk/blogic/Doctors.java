package by.itacademy.javaenterprise.goralchuk.blogic;

import lombok.Data;

@Data
public class Doctors {
    private int id;
    private String name;
    private String surname;
    private String specialization;

    @Override
    public String toString() {
        return "\n Doctor: " +
                "id=" + id +
                ", name='" + name +
                ", surname='" + surname +
                ", specialization='" + specialization + "'";
    }
}
