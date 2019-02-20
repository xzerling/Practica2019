/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

/**
 *
 * @author Zerling
 */
public class CreaEquipo 
{

    public CreaEquipo()
    {
    }
    
    public Equipo crearPickUp()
    {
        Equipo pickUp = new Equipo();
        pickUp.setCodInterno(0);
        pickUp.setCodigoSap(334560);
        pickUp.setNombre("Pick Up");
        pickUp.setDescripcion("Paño Pick up");
        pickUp.setTag("noTag");
        
        return pickUp;
    }
    
    public Equipo crear2daPrensa()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(1);
        equipo.setCodigoSap(334561);
        equipo.setNombre("2da Prensa");
        equipo.setDescripcion("Paño segunda prensa");
        equipo.setTag("noTag");
        
        return equipo;
    }
    
    public Equipo crear3raSuperior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(2);
        equipo.setCodigoSap(0);
        equipo.setNombre("3ra Superior");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crear3raInferior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodigoSap(0);
        equipo.setCodInterno(3);
        equipo.setNombre("3ra Inferior");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearTelaSuperior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(4);
        equipo.setCodigoSap(0);
        equipo.setNombre("Tela Superior");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearTelaInferior()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(5);
        equipo.setCodigoSap(0);
        equipo.setNombre("Tela Inferior");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearManta()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(6);
        equipo.setCodigoSap(0);
        equipo.setNombre("Manta");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearCTrnasversal()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(7);
        equipo.setCodigoSap(0);
        equipo.setNombre("C. Transversal");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearExHumedo()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(8);
        equipo.setCodigoSap(0);
        equipo.setNombre("Tela Extremo Humedo");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
    public Equipo crearExSeco()
    {
        Equipo equipo = new Equipo();
        equipo.setCodInterno(9);
        equipo.setCodigoSap(0);
        equipo.setNombre("Nivel Extremo Seco");
        equipo.setDescripcion("NoDescription");
        equipo.setTag("noTag");
        
        return equipo;
    }
}
