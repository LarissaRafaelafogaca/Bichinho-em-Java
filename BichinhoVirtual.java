package Projeto;

import java.util.Scanner;

class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean vivo;
    private int caloria;
    private int forca;

    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.forca = 10;
    }

    public void comer() {
        if (vivo && caloria < 100) {
            caloria += 10;
            forca -= 2;
            System.out.println("O animal comeu e agora sua força é " + forca + " e suas calorias valem " + caloria + ".");
        } else if (!vivo) {
            System.out.println("O animal está morto e não pode comer.");
        } else {
            System.out.println("O animal está cheio e não precisa comer.");
        }
    }

    public void correr() {
        if (vivo && caloria > 0) {
            forca -= 5;
            caloria -= 5;
            System.out.println("O animal está correndo! Agora sua força é de " + forca + " e suas calorias valem " + caloria + ".");
        } else if (!vivo) {
            System.out.println("O animal está morto e não pode correr.");
        } else {
            System.out.println("O animal está exausto e não consegue correr.");
        }
    }

    public void dormir() {
        if (vivo) {
            forca += 10;
            caloria -= 2;
            System.out.println("O animal está dormindo agora! Sua força aumentou para " + forca + " e suas calorias diminuíram para " + caloria + ".");
        } else {
            System.out.println("O animal está morto e não pode dormir.");
        }
    }

    public void morrer() {
        vivo = false;
        forca = 0;
        System.out.println("O animal morreu!");
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void mostrarStatus() {
        System.out.println("O animal se chama " + nome + ", é da classe " + classe + " e da família " + familia + ".");
        System.out.println("Força: " + forca + ", Calorias: " + caloria + ", Idade: " + idade);
    }
}

public class BichinhoVirtual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Crie seu novo animal");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        Animal animal = new Animal(nome, classe, familia);
        animal.mostrarStatus();

        while (animal.estaVivo()) {
            System.out.println("\nO que o " + nome + " vai fazer agora?");
            System.out.println("1- Comer");
            System.out.println("2- Correr");
            System.out.println("3- Dormir");
            System.out.println("4- Morrer");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    animal.comer();
                    break;
                case 2:
                    animal.correr();
                    break;
                case 3:
                    animal.dormir();
                    break;
                case 4:
                    animal.morrer();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        System.out.println("\nGAME OVER!");
        scanner.close();
    }
}
