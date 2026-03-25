package mx.unam.libro.api.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "Libro")
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El titulo no puede estar en blanco")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank(message = "El libro tiene que tener autor")
    @Size(max = 100)
    @Column(nullable = false)
    private String autor;

    @NotBlank(message = "El libro tiene que tener editorial")
    @Size(max = 100)
    @Column(nullable = false)
    private String editorial;

    @NotBlank(message = "La editorial debe tener forma de contacto")
    @Email(message = "El correo debe ser valido")
    @Column(nullable = false, name = "email_editorial")
    private String mailEditorial;

    @NotNull(message = "El libro debe de tener un precio")
    @Column(nullable = false)
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    @NotBlank(message = "El libro debe de tener genero literario")
    @Column(nullable = false)
    private String genero;
}
