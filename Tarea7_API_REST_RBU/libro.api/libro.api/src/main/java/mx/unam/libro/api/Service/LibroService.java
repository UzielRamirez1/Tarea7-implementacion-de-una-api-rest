package mx.unam.libro.api.Service;

import mx.unam.libro.api.Modelo.Libro;
import mx.unam.libro.api.Repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    //Agregamos el repository por constructor
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    //obtener TODOS
    public List<Libro> listarTodo() {
        return libroRepository.findAll();
    }
    //obtener por ID
    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El libro con ID " + id + "no existe."));
    }
    //Insert / Update
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }
    //Delete
    public void eliminar(Long id){
        libroRepository.deleteById(id);
    }
    //Patch
    public Libro actualizarParcial(Long id, Libro libroDetalles){
        Libro libro = libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        //actualizacion a los campos NO NULOS EN LA PETICION
        if(libroDetalles.getTitulo()!=null){libro.setTitulo(libroDetalles.getTitulo());}
        if(libroDetalles.getAutor()!=null){libro.setAutor(libroDetalles.getAutor());}
        if(libroDetalles.getEditorial()!=null){libro.setEditorial(libroDetalles.getEditorial());}
        if(libroDetalles.getMailEditorial()!=null){libro.setMailEditorial(libroDetalles.getMailEditorial());}
        if(libroDetalles.getPrecio()!=null){libro.setPrecio(libroDetalles.getPrecio());}
        if(libroDetalles.getGenero()!=null){libro.setGenero(libroDetalles.getGenero());}

        return libroRepository.save(libro);
    }
}
