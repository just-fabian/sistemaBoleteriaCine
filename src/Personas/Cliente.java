package Personas;

import Personas.Persona;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Cliente extends Persona {

    private String correo;
    private int puntos;

    public Cliente(String nombre, int id, String fechaNacimiento, int telefono, String ubicacion) {
        super(nombre, id, fechaNacimiento, telefono, ubicacion);
        puntos = 0;
    }

//    public Personas.Cliente(String nombre, int id, String fechaNacimiento, int telefono, String ubicacion, String correo) {
//        super(nombre, id, fechaNacimiento, telefono, ubicacion);
//        this.setCorreo(correo);
//    }

    public void sumarPuntos(int puntosSumados){
        puntos = puntos + puntosSumados;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setCorreo(String correo) {
        if(!correo.equals("")) {
            this.correo = correo;
        }
    }

    public int getAniosDeEdad(){
        LocalDate hoy = LocalDate.parse(LocalDate.now().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate fechaDeNacimiento = LocalDate.parse(getFechaNacimiento(), DateTimeFormatter.ISO_LOCAL_DATE);

        Period period = Period.between(hoy, fechaDeNacimiento);
        return Math.abs(period.getYears());
    }
}
