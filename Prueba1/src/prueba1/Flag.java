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
public class Flag 
{
    private boolean fPickUp;
    private boolean f2daPrensa;
    private boolean f3raSuperior;
    private boolean f3raInferior;
    private boolean f3TelaSup;
    private boolean f3TelaInf;
    private boolean fManta;
    private boolean fTransversal;
    private boolean fExHumedo;
    private boolean fExSeco;
    
    public Flag()
    {
        this.fPickUp = false;
        this.f2daPrensa = false;
        this.f3raSuperior = false;
        this.f3raInferior = false;
        this.f3TelaSup = false;
        this.f3TelaInf = false;
        this.fManta = false;
        this.fTransversal = false;
        this.fExHumedo = false;
        this.fExSeco = false;
    }

    public boolean isfPickUpTrue() {
        return fPickUp;
    }

    public void setfPickUp(boolean fPickUp) {
        this.fPickUp = fPickUp;
    }

    public boolean isF2daPrensaTrue() {
        return f2daPrensa;
    }

    public void setF2daPrensa(boolean f2daPrensa) {
        this.f2daPrensa = f2daPrensa;
    }

    public boolean isF3raSuperiorTrue() {
        return f3raSuperior;
    }

    public void setF3raSuperior(boolean f3raSuperior) {
        this.f3raSuperior = f3raSuperior;
    }

    public boolean isF3raInferiorTrue() {
        return f3raInferior;
    }

    public void setF3raInferior(boolean f3raInferior) {
        this.f3raInferior = f3raInferior;
    }

    public boolean isF3TelaSupTrue() {
        return f3TelaSup;
    }

    public void setF3TelaSup(boolean f3TelaSup) {
        this.f3TelaSup = f3TelaSup;
    }

    public boolean isF3TelaInfTrue() {
        return f3TelaInf;
    }

    public void setF3TelaInf(boolean f3TelaInf) {
        this.f3TelaInf = f3TelaInf;
    }

    public boolean isfMantaTrue() {
        return fManta;
    }

    public void setfManta(boolean fManta) {
        this.fManta = fManta;
    }

    public boolean isfTransversalTrue() {
        return fTransversal;
    }

    public void setfTransversal(boolean fTransversal) {
        this.fTransversal = fTransversal;
    }

    public boolean isfExHumedoTrue() {
        return fExHumedo;
    }

    public void setfExHumedo(boolean fExHumedo) {
        this.fExHumedo = fExHumedo;
    }

    public boolean isfExSeco() {
        return fExSeco;
    }

    public void setfExSeco(boolean fExSeco) {
        this.fExSeco = fExSeco;
    }
    
}
