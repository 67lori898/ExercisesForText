public class Studente {

    public String nome;
    public String cognome;
    public String codiceMatricola;

    //Creazione del costruttore dell'ogetto studente;
    /*Studente(String nome, String cognome,String codiceMatricola){
              this.nome=nome;
              this.cognome=cognome;
              this.codiceMatricola=codiceMatricola;*/

   //Metodo che stampa i dati dello studente formattati;
    public String stampaStd() {
        return String.format("Nome: %s Cognome: %s Codice Matricola: %s", nome, cognome, codiceMatricola);
    }

}





