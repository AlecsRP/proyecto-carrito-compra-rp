package carritocompra.controller;

import carritocompra.models.Carrito;
import carritocompra.models.CarritoSelecc;
import carritocompra.models.Producto;
import carritocompra.service.CarritoServiceInterface;
import carritocompra.service.ProductoServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoServiceInterface carritoService;
    private final ProductoServiceInterface productoService;

    public CarritoController(CarritoServiceInterface carritoService, ProductoServiceInterface productoService) {
        this.carritoService = carritoService;
        this.productoService = productoService;
    }

    @GetMapping
    public String verCarrito(Model model) {
        Carrito carrito = carritoService.obtenerCarrito();
        model.addAttribute("carrito", carrito);
        return "carrito";
    }

    //esto es lo mismo que en mi otro controller
    @GetMapping("json")
    @ResponseBody
    public Carrito obtenerCarritoJson() {
        return carritoService.obtenerCarrito();
    }

    //aca lo mismo pero para "item"
    @GetMapping("/json/{item}")
    @ResponseBody
    public List<CarritoSelecc> obtenerItemsJson() {
        return carritoService.obtenerCarrito().select;
    }

    @PostMapping("/agregar")
    public String agregarProducto(@RequestParam Long productoId) {
        Producto p = productoService.obtenerProductoPorId(productoId);

        if (p != null) {
            CarritoSelecc item = new CarritoSelecc(p, 1);
            carritoService.agregarCarrito(item);
        }
        return "redirect:/carrito";
    }

    //este metodo lo uso para eliminar productos o items
    @PostMapping("/eliminar")
    public String eliminarProducto(@RequestParam Long productoId) {
        carritoService.eliminarProducto(productoId);
        return "redirect:/carrito";
    }

    //con este metodo vacio
    @PostMapping("/vaciar")
    public String vaciarCarrito() {
        carritoService.vaciarCarrito();
        return "redirect:/carrito";
    }

    @PostMapping("/comprar")
    public String comprar() {
        carritoService.vaciarCarrito(); // Vacía el carrito después de comprar
        return "redirect:/carrito/compra-exitosa";
    }

    @GetMapping("/compra-exitosa")
    public String mostrarCompraExitosa() {
        return "compra-exitosa";
    }
}