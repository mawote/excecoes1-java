package com.mawote.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.mawote.model.exception.DomainException;

public class Reservas {
	
	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas() {
	}
	
	public Reservas(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A data do check-out deve ser depois da data do chck.in");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}
	
	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if(checkIn.before(agora)||checkOut.before(agora)) {
			throw new DomainException("As datas da reserva devem ser a posterior!");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A data do check-out deve ser depois da data do chck.in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "RESERVA: "
				+"Quarto: "
				+getNumeroDoQuarto()
				+", check-in: "
				+sdf.format(getCheckIn())
				+", check-Out: "
				+sdf.format(getCheckOut())
				+", "
				+duracao()
				+" noites";
	}
}
