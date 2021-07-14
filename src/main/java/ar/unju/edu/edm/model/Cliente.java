package ar.unju.edu.edm.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//import java.util.Date;
import java.time.Period;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	private int nroDocumento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimCompra;
	private String password;
	private String tipoDocumento;
	private int codigoAreaTelefono;
	private int numTelefono;
	private String email;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, hoy);
		edad = periodo.getYears();		
		return edad;
	}

	public LocalDate getFechaUltimCompra() {
		return fechaUltimCompra;
	}

	public void setFechaUltimCompra(LocalDate fechaUltimCompra) {
		this.fechaUltimCompra = fechaUltimCompra;
	}


	public String gettUltCompra() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaUltimCompra, fechaActual);
		return " T Desde Ultima Compra  Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays() ;	
	}

	public String gettNac() {
		LocalDate fechaActual = LocalDate.now();
		long dias = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual);
		return " T. en Dias desde Nacimiento: " + dias;	
	}
	
	public String gettHastaCumple() {
		LocalDate fechaActual = LocalDate.now();
		LocalDate sigCumple = fechaNacimiento.withYear(fechaActual.getYear());
		if (sigCumple.isBefore(fechaActual) || sigCumple.isEqual(fechaActual)) {
            sigCumple = sigCumple.plusYears(1);
        }

        Period periodo = Period.between(fechaActual, sigCumple);
        long periodo2 = ChronoUnit.DAYS.between(fechaActual, sigCumple);
        return "T. Hasta sig. Cumpleaños: " + periodo.getMonths() + " meses  " +
                           periodo.getDays() + " dias (" + periodo2 + " dias en total)";
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}