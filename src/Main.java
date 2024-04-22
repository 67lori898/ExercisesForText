
import static tools.utility.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Sara data  anche la classe leggi persona nella verifica:
        int maxPpl = 0;
        int contaStudenti=0;
        String[] choice = {"Menù scelta",
                "[1]Inserimento studente",
                "[2]Visualizza elenco studenti",
                "[3]Cancellazione studente",
                "[4]Ricerca studente"};

        String[] deleteMenu = {
                "Elimina studente:",
                "[1]Elimina mediante nome e cognome",
                "[2]Elimina studente mediante codice di matricola ",
                "[3]Elimina studente tramite la posizione"
        };

        boolean fine = true;


        //Controlla che sia stato inserito un numero valido;
        do{
            System.out.println("Inserisci il numero di persone[MAX 10]:");
             maxPpl = keyboard.nextInt();
             keyboard.nextLine();
        }while(maxPpl<0||maxPpl>10);

        Studente[] arrStudents= new Studente[maxPpl];

        //Continua affinche la variabile booleana fine è uguale a true;
        do {
        switch (menu(choice, keyboard)) {
            case 1:
                if (contaStudenti < maxPpl) {

                    arrStudents[contaStudenti] = leggiStudente(keyboard);
                    contaStudenti++;
                    System.out.println("\nStudente inserito correttamente.");
                } else {
                    System.out.println("\nLe iscrizioni al corso sono terminate");


                }


                break;

            case 2:
                //Visualizazzione dell'elenco studenti
                showStds(arrStudents, contaStudenti);
                break;


            case 3:

                //Chiediamo all'utente di inserire il nome e il cognome:
                Studente deleteStd = new Studente();
                switch (menu(deleteMenu, keyboard)) {
                    case 1:

                        System.out.println("Inserisci il nome: ");
                        deleteStd.nome = keyboard.nextLine();
                        System.out.println("Inserisci il cognome: ");
                        deleteStd.cognome = keyboard.nextLine();
                        deleteByNamSurn(contaStudenti, arrStudents, deleteStd);
                        break;
                    case 2:
                        System.out.println("Inserisci il codice di matricola: ");
                        deleteStd.codiceMatricola = keyboard.nextLine();
                        break;

                    case 3:
                        int pos = 0;
                        do {
                            System.out.println("Inserisci la posizione dello studente che vuoi eliminare");
                            pos = keyboard.nextInt();
                        } while (pos < 0 || pos > arrStudents.length - 1);
                        deleteByIndex(pos, arrStudents);
                }
                break;

            case 4:

                //Ricerca studente tramitre posizione: for se l'indice esiste return
                break;

            default:
                fine=false;
                break;

        }


    }while(fine);
    }
    public static Studente leggiStudente(Scanner keyboard){
      //Chiediamo all'utente di inserire i suoi dati;
          Studente alunno= new Studente();
          System.out.println("Inserisci il nome dello studente: ");
          alunno.nome=keyboard.nextLine();
          System.out.println("Inserisci il cognome dello studente: ");
          alunno.cognome=keyboard.nextLine();
          System.out.println("Inserisci il codice matricola dello studente: ");
          alunno.codiceMatricola=keyboard.nextLine();
         //Per ritornare un oggetto alunno la classe deve essere di tipo studente.



        return alunno;


    }


    //Metodo void perchè non ritorna nessun valore.
    public static  void showStds(Studente [] arrStudents,int contaStudenti) {

         /*for(Studente i: arrStudents) {
             if (i != null) {
                 i.stampaStd();
             }
         }*/
         for(int i=0;i<contaStudenti;i++){
            if(arrStudents[i]!=null) {
                System.out.println(arrStudents[i].stampaStd());
            }
         }
    }


    //Metodo che permette di eliminare uno studente mediante il telefono;
    private static void deleteByCode(int contaStudenti,Studente [] arrStudents,Studente deleteStd){
        for(int i=0; i<contaStudenti;i++){
            if(deleteStd.codiceMatricola.equals(arrStudents[i].codiceMatricola)){
                arrStudents[i]=null;

            }

        }
    }

    //Metodo che permette di elimninare uno studente mediante il nome e cognome;
    private static void deleteByNamSurn(int contaStudenti,Studente [] arrStudents,Studente deleteStd){
        for(int i=0; i<contaStudenti;i++){
            if(deleteStd.nome.equals(arrStudents[i].nome)&&deleteStd.cognome.equals(arrStudents[i].cognome)){
                arrStudents[i]=null;

            }

        }
    }
    //Chiediamo all'utente di eliminare mediante l'indice
     private static void deleteByIndex(int pos, Studente [] arrStudents){

         for(int i=0; i< arrStudents.length-1;i++){
             if(i==pos){

                 arrStudents[i]=null;
             }

         }

    }



}