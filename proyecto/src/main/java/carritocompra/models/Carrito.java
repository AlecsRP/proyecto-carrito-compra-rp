package carritocompra.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//El model para mi carrito
@Getter@Setter
public class Carrito {

    public List<CarritoSelecc> select = new ArrayList<>();
    public void agregarProducto(CarritoSelecc Producto){
        select.add(Producto);
    }
    public double getTotal(){
        return select.stream().mapToDouble(CarritoSelecc::getSubtotal).sum();
    }

}
