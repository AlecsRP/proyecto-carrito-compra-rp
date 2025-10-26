package carritocompra.controller;

import carritocompra.models.Producto;
import carritocompra.service.ProductoServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoServiceInterface productoService;

    public ProductoController(ProductoServiceInterface productoService) {
        this.productoService = productoService;
    }


   //este metodo es el get mapping para el html la vista o frontend
    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "productos";
    }

    //este metodo es para ver la informacion del producto
    @GetMapping("/{id}")
    public String verDetalleProducto(@PathVariable Long id, Model model){
        Producto producto = productoService.obtenerProductoPorId(id);
        if(producto == null){
            return "redirect:/productos";
        }
        model.addAttribute("producto", producto);
        return "producto-detalle";
    }

    //este es para mi api que me devolvera el json
    @GetMapping("/json")
    @ResponseBody
    public List<Producto> listarProductosJson(){
        return productoService.listarProductos();
    }

    //este lo use solo para buscar por id esta de mas
    @GetMapping("/json/{id}")
    @ResponseBody
    public Producto obtenerProductoJson(@PathVariable long id){
        return productoService.obtenerProductoPorId(id);
    }
}