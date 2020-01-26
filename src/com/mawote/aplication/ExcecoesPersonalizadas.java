package com.mawote.aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mawote.model.entities.Reservas;
import com.mawote.model.exception.DomainException;

public class ExcecoesPersonalizadas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do quarto: ");
			Integer numeroDoQuarto = sc.nextInt();
			System.out.print("Data do check-in: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out: ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservas reservas = new Reservas(numeroDoQuarto, checkIn, checkOut);
			System.out.println(reservas);
			
			System.out.println();
			System.out.println("Atualizar reservas:");
			System.out.print("Numero do quarto: ");
			numeroDoQuarto = sc.nextInt();
			System.out.print("Data do check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out: ");
			checkOut = sdf.parse(sc.next());
			
			reservas.atualizarDatas(checkIn, checkOut);
			System.out.println(reservas);
		}
		catch(ParseException e) {
			System.out.println("Formato da data invalido!");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
			
		sc.close();
	}

}
