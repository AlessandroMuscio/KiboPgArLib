package it.unibs.fp.mylib;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class ServizioFile {
  private final static String MSG_NO_FILE = "ATTENZIONE: non trovo il file ";
  private final static String MSG_NO_LETTURA = "ATTENZIONE: problemi con la lettura del file ";
  private final static String MSG_NO_SCRITTURA = "ATTENZIONE: problemi con la scrittura del file ";
  private final static String MSG_NO_CHIUSURA = "ATTENZIONE: problemi con la chiusura del file ";

  public static Object caricaSingoloOggetto(File file) {
    Object letto = null;
    ObjectInputStream ingresso = null;

    try {
      ingresso = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

      letto = ingresso.readObject();

    } catch (FileNotFoundException excNotFound) {
      System.out.println(MSG_NO_FILE + file.getName());
    } catch (IOException excLettura) {
      System.out.println(MSG_NO_LETTURA + file.getName());
    } catch (ClassNotFoundException excLettura) {
      System.out.println(MSG_NO_LETTURA + file.getName());
    } finally {
      if (ingresso != null) {
        try {
          ingresso.close();
        } catch (IOException excChiusura) {
          System.out.println(MSG_NO_CHIUSURA + file.getName());
        }
      }
    } // finally

    return letto;

  } // metodo caricaSingoloOggetto

  public static void salvaSingoloOggetto(File file, Object daSalvare) {
    ObjectOutputStream uscita = null;

    try {
      uscita = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

      uscita.writeObject(daSalvare);

    } catch (IOException excScrittura) {
      System.out.println(MSG_NO_SCRITTURA + file.getName());
    }

    finally {
      if (uscita != null) {
        try {
          uscita.close();
        } catch (IOException excChiusura) {
          System.out.println(MSG_NO_CHIUSURA + file.getName());
        }
      }
    } // finally

  } // metodo salvaSingoloOggetto

}
