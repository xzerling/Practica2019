/*
 * Sistema de administracion de telas y paños.
 * Superintendencia de Maquinas, Planta Nueva Aldea.
 * Arauco 2019 - Practica Profesional.
 */

package javaapplication1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Álvaro Elgueda Labra - Univerisad de Talca.
 * 
 */

public class Equipo
{
    private int codigoZap;
    private int diasOp;
    private String tag;
    private String nombre;
    private String tipo;
    private String proveedor;
    private String descripcion;
    private String posi;
    private String estado;
    private Calendar fechaIngreso;
    private Calendar fechaSalida;
    
    public Equipo()
    {
        this.fechaIngreso = Calendar.getInstance();
    }

    public Equipo(int codigo, String nombre, String tipo, String descripcion, Calendar fechaIngreso) {
        this.codigoZap = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
    }

    public int getCodigoZap() {
        return codigoZap;
    }

    public void setCodigoZap(int codigoZap) {
        this.codigoZap = codigoZap;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getDiasOp() {
        return diasOp;
    }

    public void setDiasOp(int diasOp) {
        this.diasOp = diasOp;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPosi() {
        return posi;
    }

    public void setPosi(String posi) {
        this.posi = posi;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Calendar getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Calendar fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public void print()
    {
        System.out.println("**********************************************************");
        //System.out.println("*** Codigo: "+this.codigo);
        System.out.println("*** Nombre: "+this.nombre);
        System.out.println("*** Tipo: "+this.tipo);
        System.out.println("*** Posi: "+this.posi);
        System.out.println("*** Descripcion: "+this.descripcion);
        System.out.println("*** FechaIngreso: "+this.formatoCalendario(this.fechaIngreso));
        System.out.println("*** Estado: " + this.estado);
        System.out.println("*** Dias Operativos: "+this.diasOp());
        System.out.println("*** FechaSalida: "+this.formatoCalendario(this.fechaSalida));
        System.out.println("**********************************************************");

    }
    
    public String formatoCalendario(Calendar cal)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formato.format(cal.getTime());
        return fecha;
    }
    
    private int diasOp()
    {
        long t1 = this.fechaIngreso.getTimeInMillis();
        long t2 = Calendar.getInstance().getTimeInMillis();
        
        int dias = (int) ((t2-t1)/1000/60/60/24+1);
        return dias;
    }
    
    
    
    public void printEquipo()
    {
        System.out.println("**********************************************************");
        System.out.println("*** Sap: " + this.codigoZap);
        System.out.println("*** Nombre: " + this.nombre);
        System.out.println("*** Proveedor: " + this.proveedor);
        System.out.println("*** Fecha de ingreso: " + this.formatoCalendario(this.fechaIngreso));
        System.out.println("*** Estado: " + this.estado);
        System.out.println("*** Dias de operacion: " + this.diasOp);
        System.out.println("*** Proximo cambio: " + this.fechaSalida);
        System.out.println("**********************************************************");
    }
    
}
