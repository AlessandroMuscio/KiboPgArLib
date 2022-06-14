package KiboUniBSFpLib;

import java.io.IOException;

/**
 * The <strong>Menu</strong> class creates a menu with multiple entry supposing
 * that zero is always the exit option. The class also contains some method that
 * may result useful visualizing the menu.
 *
 * @author Alessandro Muscio
 * @version 1.0
 */
public class Menu {
  final private static String FRAME = "---------------------------------------------------";
  final private static String EXIT_ENTRY = "0.\tExit\n";
  final private static String INSERT_REQUEST = "> ";

  /**
   * Represent the title of the menu.
   */
  private final String title;
  /**
   * Contains all the menu entries.
   */
  private final String[] entries;

  /**
   * Represent if you want to use the exit entry or not.
   */
  private final boolean useExitEntry;

  /**
   * Constructor that creates a <code>Menu</code> object Costruttore che crea un
   * oggetto di tipo menu specificando un titolo, le voci
   * di esso e se si vuole visualizzare la voce d'uscita oppure no.
   *
   * @param title        Indica il titolo del menu.
   * @param entry        Indica le voci del menu.
   * @param useExitEntry Indica se si vuole visualizzare la voce d'uscita oppure
   *                     no.
   */
  public Menu(String title, String[] entry, boolean useExitEntry) {
    this.title = title;
    this.entries = entry;
    this.useExitEntry = useExitEntry;
  }

  /**
   * Permette di stampare a video il menu. Per primo verrà stampato il titolo del
   * menu incorniciato poi tutte le voci del menu.
   */
  public void stampaMenu() {
    StringBuffer menu = new StringBuffer();

    menu.append(String.format("%s\n%s\n%s\n", FRAME, title, FRAME));

    for (int i = 0; i < entries.length; i++)
      menu.append(String.format("%d.\t%s\n", (i + 1), entries[i]));

    if (useExitEntry)
      menu.append(EXIT_ENTRY);

    System.out.println(menu);
  }

  /**
   * Stampa a video il menu richiamando il metodo <code>stampaMenu()</code> per
   * poi utilizzare il metodo
   * <code>leggiInteroCompreso(messaggio, minimo, massimo)</code> della classe
   * <em>InputDati</em> in modo da ritornare la voce scelta dall'utente.
   *
   * @return Un <code>int</code> rappresentante la voce del menu scelta
   *         dall'utente.
   */
  public int scegli() {
    stampaMenu();

    if (useExitEntry)
      return InputData.readIntegerBetween(INSERT_REQUEST, 0, entries.length);
    else
      return InputData.readIntegerBetween(INSERT_REQUEST, 1, entries.length);
  }

  /*
   * public static void pulisciConsole() throws IOException, InterruptedException
   * {
   * String operatingSystem = System.getProperty("os.name");
   * 
   * if (operatingSystem.contains("Windows")) {
   * ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
   * Process startProcess = pb.inheritIO().start();
   * 
   * startProcess.waitFor();
   * } else {
   * ProcessBuilder pb = new ProcessBuilder("clear");
   * Process startProcess = pb.inheritIO().start();
   * 
   * startProcess.waitFor();
   * }
   * }
   */

  public static void pulisciConsole() {
    System.out.print(AnsiColors.CLEAR);
  }

  /**
   * Interrompe l'esecuzione del programma per un certo numero di millisecondi.
   *
   * @param millisecondi Il numero di millisecondi per cui deve interrompere
   *                     l'esecuzione del programma.
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
