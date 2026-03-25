package mx.unam.libro.api.Repository;

import mx.unam.libro.api.Modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
    //Los Metodos CRUD van aqui pero JPA ya los incluye por lo que va "vacia"
}
