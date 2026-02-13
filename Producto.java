public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;

    public Producto (String codigo, String nombre, double precio, int cantidad, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

        // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

        // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
 
        // Método de cálculo
    public double calcularValorTotal() {
        return precio * cantidad;
    }

        // Método para mostrar información formateada
    public void mostrarInformacion() {
        System.out.printf("%-10s %-15s %-10.2f %-10d %-15s %-10.2f\n",
                codigo, nombre, precio, cantidad, categoria, calcularValorTotal());
    }
}
