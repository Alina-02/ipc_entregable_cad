/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc_project;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Booking;

/**
 *
 * @author nymok
 */
public class memberBooking {
    
    private final StringProperty pista = new SimpleStringProperty();
    private final StringProperty dia = new SimpleStringProperty();
    private final StringProperty horaIni = new SimpleStringProperty();
    private final StringProperty horaFin = new SimpleStringProperty();
    private final StringProperty pagada = new SimpleStringProperty();
    
    private Booking b = null;
    
    public memberBooking(String pista, String dia, String horaIni, String horaFin, String pagada, Booking b){
        this.pista.setValue(pista);
        this.dia.setValue(dia);
        this.horaIni.setValue(horaIni);
        this.horaFin.setValue(horaFin);
        this.pagada.setValue(pagada);
        this.b = b;
    }
    
    public final StringProperty pistaProperty(){
        return pista;
    }
    
    public final StringProperty diaProperty(){
        return dia;
    }
    
    public final StringProperty horaIniProperty(){
        return horaIni;
    }
    
    public final StringProperty horaFinProperty(){
        return horaFin;
    }
    
    public final StringProperty pagadaProperty(){
        return pagada;
    }
    
    public final Booking getBooking(){
        return b;
    }
}
