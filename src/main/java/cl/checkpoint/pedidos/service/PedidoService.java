package cl.checkpoint.pedidos.service;

import cl.checkpoint.pedidos.model.Pedido;
import cl.checkpoint.pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository repo;

    public PedidoService(PedidoRepository repo) {
        this.repo = repo;
    }

    public List<Pedido> listar() {
        return repo.findAll();
    }

    public Pedido obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado"));
    }

    public Pedido crear(Pedido item) {
        if (item.getEstado() == null)
            item.setEstado("RECIBIDO");
        return repo.save(item);
    }

    public Pedido actualizar(Long id, Pedido item) {
        Pedido actual = obtener(id);
        if (item.getClienteId() != null)
            actual.setClienteId(item.getClienteId());
        if (item.getProducto() != null)
            actual.setProducto(item.getProducto());
        if (item.getCantidad() != null)
            actual.setCantidad(item.getCantidad());
        if (item.getEstado() != null)
            actual.setEstado(item.getEstado());
        return repo.save(actual);
    }

    public void eliminar(Long id) {
        obtener(id);
        repo.deleteById(id);
    }

}
