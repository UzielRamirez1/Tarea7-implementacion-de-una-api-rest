package mx.unam.libro.api.Controlador;

import jakarta.validation.Valid;
import mx.unam.libro.api.Modelo.Libro;
import mx.unam.libro.api.Service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/libros")
public class LibroController {
    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    //Get all / select * from table Libro
    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroService.listarTodo();
    }

    //Get ID / select * from table Libto where id =
    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable Long id) {
        Libro libro = libroService.buscarPorId(id);
        return ResponseEntity.ok(libro);
    }
    //POST
    @PostMapping
    public ResponseEntity<Libro> guardar(@Valid @RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.guardar(libro), HttpStatus.CREATED);
    }
    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarCompleto(@PathVariable Long id, @Valid @RequestBody Libro libro) {
        Libro libroExistente = libroService.buscarPorId(id);

        libro.setId(Math.toIntExact(id));
        return ResponseEntity.ok(libroService.guardar(libro));
    }
    //PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<Libro> actualizarParcial(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        try{
            return ResponseEntity.ok(libroService.actualizarParcial(id, libroDetalles));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Libro> eliminar(@PathVariable Long id) {
        libroService.buscarPorId(id);
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
