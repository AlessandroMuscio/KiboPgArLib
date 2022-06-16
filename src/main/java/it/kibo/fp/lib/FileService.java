package it.kibo.fp.lib;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The class <strong>FileService</strong> has useful methods to
 * serialize/deserialize objects adn save/load them to/from file.
 */
public final class FileService {
  private static final String RED_ATTENTION = AnsiColors.RED + "Attention!" + AnsiColors.RESET;
  private static final String FILE_NOT_FOUND_ERROR = RED_ATTENTION + "\nCan't find the file ";
  private static final String READING_ERROR = RED_ATTENTION + "\nProblem reading the file ";
  private static final String WRITING_ERROR = RED_ATTENTION + "\nProblem writing the file ";
  private static final String CLOSING_ERROR = RED_ATTENTION + "\nProblem closing the file ";

  private FileService() {
    throw new UnsupportedOperationException();
  }

  /**
   * Serialize whatever object is given, as long as implements
   * <code>Serializable</code>.
   * 
   * @param <T>    The generics used for the object to serialize that needs to
   *               implement <code>Serializable</code>.
   * @param file   The file where to save the serialized object.
   * @param toSave The object to serialize and save.
   */
  public static <T extends Serializable> void serializeObject(File file, T toSave) {
    ObjectOutputStream output = null;

    try {
      output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

      output.writeObject(toSave);
    } catch (IOException eWriting) {
      System.out.println(WRITING_ERROR + file.getName());
    } finally {
      if (output != null)
        try {
          output.close();
        } catch (IOException eClosing) {
          System.out.println(CLOSING_ERROR + file.getName());
        }
    }
  }

  /**
   * Deserialize whatever object is saved in the given file. The deserialized file
   * will be cast in the given class.
   * 
   * @param <T>         The generics used for the class of the object to
   *                    deserialize that needs to implement
   *                    <code>Serializable</code>.
   * @param file        The file where to find the serialized object.
   * @param objectClass The class to cast the serialized object in.
   * 
   * @return A <code><span>&#60;</span>T<span>&#62;</span> </code> representing
   *         the deserialized object.
   */
  public static <T extends Serializable> T deserializeObject(File file, Class<T> objectClass) {
    Object read = null;
    ObjectInputStream input = null;

    try {
      input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

      read = input.readObject();
    } catch (FileNotFoundException eNotFound) {
      System.out.println(FILE_NOT_FOUND_ERROR + file.getName());
    } catch (IOException | ClassNotFoundException eReading) {
      System.out.println(READING_ERROR + file.getName());
    } finally {
      if (input != null)
        try {
          input.close();
        } catch (IOException eClosing) {
          System.out.println(CLOSING_ERROR + file.getName());
        }
    }

    return objectClass.cast(read);
  }
}