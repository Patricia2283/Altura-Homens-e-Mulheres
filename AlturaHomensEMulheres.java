package br.com.exercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AlturaHomensEMulheres {

	public static void main(String[] args) {

		int qntdMulheres = 0;
		int qntdHomens = 0;
		double altura = 0;
		double soma = 0;
		double mediaAlturaHomens = 0;
		double maior = 0;
		double menor = 10;
		String regex = "\\d+\\.\\d{2}";

		Scanner leitura = new Scanner(System.in);

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Digite seu gênero: M para masculino ou F para feminino");
				String genero = leitura.next().toUpperCase();

				if (genero.equals("M")) {
					qntdHomens++;
					soma += altura;

				} else if (genero.equals("F")) {
					qntdMulheres++;

				} else {
					System.out.println("Gênero inválido!");

					continue;
				}

				System.out.println("Digite a sua altura(casa decimal separada por ponto): ");
				while (true) {
					String inputAltura = leitura.next();
					if (inputAltura.matches(regex)) {
						altura = Double.parseDouble(inputAltura);
						break;
					} else {
						System.out.println("Altura inválida! Digite novamente: ");

					}
				}

				if (altura > maior) {
					maior = altura;
				} else if (altura < menor) {
					menor = altura;

				}

			}

		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("Digite um número válido!");
			leitura.nextLine();

		}
		mediaAlturaHomens = soma / qntdHomens;

		System.out.println("A maior altura do grupo é: " + maior + " metros, e a menor é de " + menor + " metros");
		System.out.println("A média de altura dos homens é: " + mediaAlturaHomens + " metros");
		System.out.println("O número de mulheres é: " + qntdMulheres);

		leitura.close();
	}
}