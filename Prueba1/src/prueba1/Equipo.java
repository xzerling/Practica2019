/*
 * Sistema de administracion de telas y paños.
 * Superintendencia de Maquinas, Planta Nueva Aldea.
 * Arauco 2019 - Practica Profesional.
 */

package prueba1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Álvaro Elgueda Labra - Univerisad de Talca.
 * 
 */

public class Equipo
{
    private int codigoSap;
    private int diasOp;
    private int codInterno;
    private int planOperativo;
    private String idCajaPaño;
    private String nombre;
    private String tipo;
    private String proveedor;
    private String causaCambio;
    private Calendar fechaIngreso;
    private Calendar fechaSalida;
    
    public Equipo()
    {
        this.fechaIngreso = Calendar.getInstance();
    }

    public Equipo(int codigo, String nombre, String tipo, String causaCambio, Calendar fechaIngreso) {
        this.codigoSap = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.causaCambio = causaCambio;
        this.fechaIngreso = fechaIngreso;
    }

    public int getPlanOperativo() {
        return planOperativo;
    }

    public void setPlanOperativo(int planOperativo) {
        this.planOperativo = planOperativo;
    }

    public int getCodigoSap() {
        return codigoSap;
    }

    public int getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(int codInterno) {
        this.codInterno = codInterno;
    }
    
    public void setCodigoSap(int codigoSap) {
        this.codigoSap = codigoSap;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getDiasOp() {
        return this.diasOp;
    }

    public void setDiasOp(int diasOp) {
        this.diasOp = diasOp;
    }

    public String getIdCajaPaño() {
        return idCajaPaño;
    }

    public void setIdCajaPaño(String idCajaPaño) {
        this.idCajaPaño = idCajaPaño;
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

    public String getCausaCambio() {
        return causaCambio;
    }

    public void setCausaCambio(String causaCambio) {
        this.causaCambio = causaCambio;
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
        System.out.println("*************************************************");
        System.out.println("*** Nombre: "+this.nombre);
        System.out.println("*** Tipo: "+this.tipo);
        //System.out.println("*** Descripcion: "+this.causaCambio);
        if(this.fechaIngreso != null)
        {
            System.out.println("*** FechaIngreso: "+this.formatoCalendario(this.fechaIngreso));
        }
        else
        {
            System.out.println("*** FechaIngreso: Error");
        }
        System.out.println("*** Identificador caja paño: " + this.idCajaPaño);
        System.out.println("*** Dias Operativos: "+this.actualizarDiasOp());
        if(this.fechaSalida != null)
        {
            System.out.println("*** FechaSalida: "+this.formatoCalendario(this.fechaSalida));
        }
        else
        {
            System.out.println("*** FechaSalida: Error");
        }
        System.out.println("*** Plan Operativo: "+this.planOperativo);
        System.out.println("*************************************************");

    }
    
    public String formatoCalendario(Calendar cal)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = formato.format(cal.getTime());
        return fecha;
    }
    
    public int actualizarDiasOp()
    {
        if(this.fechaIngreso != null)
        {
        long t1 = this.fechaIngreso.getTimeInMillis();
        long t2 = Calendar.getInstance().getTimeInMillis();
        
        int dias = (int) ((t2-t1)/1000/60/60/24)+1;
        this.diasOp = dias;
        return dias;
        }
        else
        {
            return -1;
        }
    }
    
    
    
    public void printEquipo()
    {
        System.out.println("**********************************************************");
        System.out.println("*** Sap: " + this.codigoSap);
        System.out.println("*** Nombre: " + this.nombre);
        System.out.println("*** Proveedor: " + this.proveedor);
        System.out.println("*** Fecha de ingreso: " + this.formatoCalendario(this.fechaIngreso));
        System.out.println("*** Estado: " + this.idCajaPaño);
        System.out.println("*** Dias de operacion: " + this.diasOp);
        System.out.println("*** Proximo cambio: " + this.fechaSalida);
        System.out.println("**********************************************************");
    }
    
    /*
    public String getPosi() {
        return posi;
    }

    public void setPosi(String posi) {
        this.posi = posi;
    }*/
    
    
}
