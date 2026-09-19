package com.ejemplo.crud.service;

import com.ejemplo.crud.exception.ProductoNoEncontradoException;
import com.ejemplo.crud.model.Producto;
import com.ejemplo.crud.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
    }

    public Producto crear(Producto producto) {
        producto.setId(null); // evita que se sobrescriba un registro existente
        return repository.save(producto);
    }

    public Producto actualizar(Long id, Producto datos) {
        Producto existente = obtenerPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setDescripcion(datos.getDescripcion());
        existente.setPrecio(datos.getPrecio());
        existente.setStock(datos.getStock());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        Producto existente = obtenerPorId(id);
        repository.delete(existente);
    }
}
