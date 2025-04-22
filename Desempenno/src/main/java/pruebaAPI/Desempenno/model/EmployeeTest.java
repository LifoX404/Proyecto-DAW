package pruebaAPI.Desempenno.model;

import jakarta.persistence.*;

@Entity
@Table(name="Employee")
public class EmployeeTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column(name = "firstName", length = 20)
    private String firstName;

}
