import java.util.Scanner;

public class Main {
    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("---------- TO DO LIST ---------- ");
        System.out.println("1 - Criar uma nova tarefa        ");
        System.out.println("2 - Visualizar tarefas           ");
        System.out.println("3 - Visualizar tarefas concluídas");
        System.out.println("4 - Sair                         ");
        System.out.println("Digite a opção desejada:         ");
        opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        String nome;
        String[] tarefas = new String[100];
        int count = 0;
        String opcao_menu;
        String[] tarefasConcluidas = new String[100];
        int countConcluidas = 0;
        int finishCheck;

        do {
            opcao = menu();
            if(opcao == 1){
                do {
                    System.out.println("CRIAR NOVAS TAREFAS");
                    System.out.println("Digite o nome da tarefa que você quer cadastrar: ");
                    nome = scanner.nextLine();
                   if(count < tarefas.length){
                       tarefas[count] = nome;
                       count++;
                   } else {
                       System.out.println("Limite de tarefas atingida!");
                       break;
                   }
                    System.out.println("Deseja cadastrar uma nova tarefa? (S/N)");
                    opcao_menu = scanner.nextLine();
                } while (!opcao_menu.equals("N"));
            }else if(opcao == 2){
                System.out.println("VISUALIZAR AS TAREFAS EXISTENTES");
                for (int i = 0; i < count; i++){
                    System.out.println((i + 1) + ". " + tarefas[i]);
                }
                System.out.println("Deseja marcar alguma tarefa como concluída? (S/N)");
                opcao_menu = scanner.nextLine();
                if(opcao_menu.equalsIgnoreCase("S")){
                    System.out.println("Digite o número da Task que você quer marcar: ");
                    finishCheck = scanner.nextInt();
                    scanner.nextLine();
                    if(finishCheck > 0 && finishCheck <= count){
                        tarefasConcluidas[countConcluidas] = tarefas[finishCheck - 1];
                        countConcluidas++;
                        for(int i = finishCheck - 1; i < count - 1; i++){
                            tarefas[i] = tarefas[i + 1];
                        }
                        tarefas[count - 1] = null;
                        count--;
                    } else {
                        System.out.println("Número inválido");
                    }
                }
            } else if (opcao == 3) {
                System.out.println("VISUALIZAR TAREFAS CONCLUÍDAS");
                for (int i = 0; i < countConcluidas; i++){
                    System.out.println((i + 1) + ". " + tarefasConcluidas[i]);
                }
            }
        } while (opcao != 4);
        System.out.println("Finalizando Programa!");
    }
}
