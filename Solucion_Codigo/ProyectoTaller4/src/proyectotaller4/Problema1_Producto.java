
package proyectotaller4;
public class ProyectoTaller4 {
    public static Producto p1;
    public static Producto p2;

    public static void main(String[] args) {
        
        p1 = new Producto(1001, 11);
        p1.calcularDescuento(p1.precioP, p1.cantidadP);
        p1.calcularPrecioFinal();
        System.out.println(p1);
        p2 = new Producto();
        p2.setPrecioP(1200.4);
        p2.setCantidadP(8);
        p2.calcularDescuento(p2.precioP, p2.cantidadP);
        p2.calcularPrecioFinal();
        System.out.println(p2);
        
        
    }
    
}
class Producto {

    public double precioP;
    public int cantidadP;
    public double descuento;
    public double precioFinal;

    public Producto() {
    }

    public Producto(double precioP, int cantidadP) {
        this.precioP = precioP;
        this.cantidadP = cantidadP;
    }

    public void setPrecioP(double precioP) {
        this.precioP = precioP;
    }

    public void setCantidadP(int cantidadP) {
        this.cantidadP = cantidadP;
    }

    public double calcularDescuento(double precioP, int cantidadP) {
        if (precioP >= 1000 && cantidadP >= 10) {
            this.descuento = 10;
        } else if (precioP < 1000) {
            this.descuento = 5;
        } else {
            this.descuento = 0;
        }
        return this.descuento;
    }

    public double calcularPrecioFinal() {
        this.precioFinal = (this.cantidadP * this.precioP) - (this.cantidadP * this.precioP * (this.descuento / 100));
        return this.precioFinal;
    }

    @Override
    public String toString() {
        return "Producto{" + "precioP=" + precioP + ", cantidadP=" + cantidadP + ", descuento=" + descuento + ", precioFinal=" + precioFinal + '}';
    }

}
