package KiboUniBSFpLib;

import java.io.IOException;

/**
 * The <strong>Menu</strong> class creates a menu with multiple entry supposing that zero is always the exit option. The class also contains some method that may result useful visualizing the menu.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public class Menu {
  final private static String FRAME = "---------------------------------------------------";
  final private static String EXIT_ENTRY = "\n0.\tExit\n";
  final private static String INSERT_REQUEST = "Digit the number of the desired option > ";

  /**
   * Rappresenta il titolo del menu.
   */
  private final String titolo;
  /**
   * Contiene tutte le voci del menu.
   */
  private final String[] voci;

  /**
   * Indica se si vuole visualizzare la voce d'uscita oppure no.
   */
  private final boolean voce_uscita;

  /**
   * Costruttore che crea un oggetto di tipo menu specificando un titolo, le voci di esso e se si vuole visualizzare la voce d'uscita oppure no.
   *
   * @param titolo      Indica il titolo del menu.
   * @param voci        Indica le voci del menu.
   * @param voce_uscita Indica se si vuole visualizzare la voce d'uscita oppure no.
   */
  public Menu(String titolo, String[] voci, boolean voce_uscita) {
    this.titolo = titolo;
    this.voci = voci;
    this.voce_uscita = voce_uscita;
  }

  /**
   * Permette di stampare a video il menu. Per primo verrà stampato il titolo del menu incorniciato poi tutte le voci del menu.
   */
  public void stampaMenu() {
    StringBuffer menu = new StringBuffer();

    menu.append(String.format("%s\n%s\n%s\n", FRAME, titolo, FRAME));

    for (int i = 0; i < voci.length; i++)
      menu.append(String.format("%d.\t%s\n", (i + 1), voci[i]));

    if (voce_uscita)
      menu.append(EXIT_ENTRY);

    System.out.println(menu);
  }

  /**
   * Stampa a video il menu richiamando il metodo <code>stampaMenu()</code> per poi utilizzare il metodo <code>leggiInteroCompreso(messaggio, minimo, massimo)</code> della classe <em>InputDati</em> in modo da ritornare la voce scelta dall'utente.
   *
   * @return Un <code>int</code> rappresentante la voce del menu scelta dall'utente.
   */
  public int scegli() {
    stampaMenu();

    if (voce_uscita)
      return InputData.readIntegerBetween(INSERT_REQUEST, 0, voci.length);
    else
      return InputData.readIntegerBetween(INSERT_REQUEST, 1, voci.length);
  }

  /**
   * Rileva il sistema operativo ed esegue il comando "cls" o "clear" in modo da pulire la console.
   */
  public static void pulisciConsole() throws IOException, InterruptedException {
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
  }

  /**
   * Interrompe l'esecuzione del programma per un certo numero di millisecondi.
   *
   * @param millisecondi Il numero di millisecondi per cui deve interrompere l'esecuzione del programma.
   */
  public static void aspetta(int millisecondi) {
    try {
      Thread.sleep(millisecondi);
    } catch (InterruptedException e) {
      System.out.println("Thread is interrupted");
    }
  }

  /**
   * Stampa un certo messaggio seguito da una successione di puntini (...) in modo da simulare un caricamento
   *
   * @param messaggio Indica il messaggio da stampare.
   */
  public static void messaggioCaricamento(String messaggio) throws IOException, InterruptedException {
    System.out.print(messaggio + ".");
    aspetta(1000);
    System.out.print(".");
    aspetta(1000);
    System.out.print(".");
    aspetta(1000);
    pulisciConsole();
  }
}
