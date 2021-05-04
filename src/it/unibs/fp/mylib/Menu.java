package it.unibs.fp.mylib;

/**
 * La classe <strong>Menu</strong> permette di generare un menu a più voci
 * supponendo che la voce per uscire sia sempre lo zero. La classe offre anche
 * alcuni metodi che possono tornare utili per la gestione della visualizzazione
 * del menu
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class Menu {
  final private static String CORNICE = "---------------------------------------------------";
  final private static String VOCE_USCITA = "\n0\tEsci\n";
  final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

  /**
   * Rappresenta il titolo del menu
   */
  private String titolo;
  /**
   * Contiene tutte le voci del menu
   */
  private String[] voci;

  /**
   * Costruttore che crea un oggetto di tipo menu specificando un titolo e le voci
   * di esso
   * 
   * @param titolo Indica il titolo del menu
   * @param voci   Indica le voci del menu
   */
  public Menu(String titolo, String[] voci) {
    this.titolo = "\n" + titolo;
    this.voci = voci;
  }

  /**
   * Stampa a video il menu richiamando il metodo <code>stampaMenu()</code> per
   * poi utilizzare il metodo
   * <code>leggiInteroCompreso(messaggio, minimo, massimo)</code> della classe
   * <em>InputDati</em> in modo da ritornare la voce scelta dall'utente
   * 
   * @return Un <code>int</code> rappresentante la voce del menu scelta
   *         dall'utente
   */
  public int scegli() {
    stampaMenu();

    return InputDati.leggiInteroCompreso(RICHIESTA_INSERIMENTO, 0, voci.length);
  }

  /**
   * Permette di stampare a video il menu. Per primo verrà stampato il titolo del
   * menu incorniciato poi tutte le voci del menu
   */
  public void stampaMenu() {
    System.out.println(CORNICE);
    System.out.println(titolo);
    System.out.println(CORNICE);

    for (int i = 0; i < voci.length; i++) {
      System.out.println((i + 1) + "\t" + voci[i]);
    }

    System.out.println(VOCE_USCITA);
  }

  /**
   * Rileva il sistema operativo ed esegue il comando "cls" o "clear" in modo da
   * pulire la console
   */
  public static void pulisciConsole() {
    try {
      String operatingSystem = System.getProperty("os.name");

      if (operatingSystem.contains("Windows")) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      } else {
        ProcessBuilder pb = new ProcessBuilder("clear");
        Process startProcess = pb.inheritIO().start();

        startProcess.waitFor();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Interrompe l'esecuzione del programma per un certo numero di millisecondi
   * 
   * @param millisecondi Il numero di millisecondi per cui deve interrompere
   *                     l'esecuzione del programma
   */
  public static void aspetta(int millisecondi) {
    try {
      Thread.sleep(millisecondi);
    } catch (InterruptedException e) {
      System.out.println("Thread is interrupted");
    }
  }

  /**
   * Stampa un certo messaggio seguito da una successione di puntini (...) in modo
   * da simulare un caricamento
   * 
   * @param messaggio Indica il messaggio da stampare
   */
  public static void messaggioCaricamento(String messaggio) {
    System.out.print(messaggio + ".");
    aspetta(1000);
    System.out.print(".");
    aspetta(1000);
    System.out.print(".");
    aspetta(1000);
    pulisciConsole();
  }
}
