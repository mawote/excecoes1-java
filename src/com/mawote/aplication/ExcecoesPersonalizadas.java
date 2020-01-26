package com.mawote.aplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mawote.model.entities.Reservas;

public class ExcecoesPersonalizadas {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		Integer numeroDoQuarto = sc.nextInt();
		System.out.print("Data do check-in: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-out: ");
		Date checkOut = sdf.parse(sc.next());
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro nas datas! \nA data do check-out deve ser depois da data do chck.in");
		}
		else {
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
			
			String erro = reservas.atualizarDatas(checkIn, checkOut);
			if (erro != null){
				System.out.println("Erro na reserva!\n" + erro);
			}
			else{
				System.out.println(reservas);
			}
			
		}
		
		
		sc.close();
	}

}
