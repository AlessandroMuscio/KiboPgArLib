package it.unibs.fp.mylib;

/*
Questa classe rappresenta un menu testuale generico a piu' voci
Si suppone che la voce per uscire sia sempre associata alla scelta 0 
e sia presentata in fondo al menu

*/
public class MyMenu {
  final private static String CORNICE = "---------------------------------------------------";
  final private static String VOCE_USCITA = "\n0\tEsci\n";
  final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

  private String titolo;
  private String[] voci;

  public MyMenu(String titolo, String[] voci) {
    this.titolo = "\n" + titolo;
    this.voci = voci;
  }

  public int scegli() {
    stampaMenu();

    return InputDati.leggiInteroCompreso(RICHIESTA_INSERIMENTO, 0, voci.length);
  }

  public void stampaMenu() {
    System.out.println(CORNICE);
    System.out.println(titolo);
    System.out.println(CORNICE);

    for (int i = 0; i < voci.length; i++) {
      System.out.println((i + 1) + "\t" + voci[i]);
    }

    System.out.println(VOCE_USCITA);
  }

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

  public static void aspetta(int millisecondi) {
    try {
      Thread.sleep(millisecondi);
    } catch (InterruptedException e) {
      System.out.println("Thread is interrupted");
    }
  }

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
