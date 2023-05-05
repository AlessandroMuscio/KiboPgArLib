package it.ayman.fp.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The <strong>Title</strong> class creates a title with ascii characters.
 *
 * @author Ayman Marpicati
 * @version 1.0
 */

public class Title {
    private final static int LINE_HEIGHT = 6;
    private final static String a = """
             █████╗\s
            ██╔══██╗
            ███████║
            ██╔══██║
            ██║  ██║
            ╚═╝  ╚═╝
            """;
    private final static String b = """
            ██████╗\s
            ██╔══██╗
            ██████╔╝
            ██╔══██╗
            ██████╔╝
            ╚═════╝\s
            """;
    private final static String c = """
             ██████╗
            ██╔════╝
            ██║    \s
            ██║    \s
            ╚██████╗
             ╚═════╝
            """;
    private final static String d = """
            ██████╗\s
            ██╔══██╗
            ██║  ██║
            ██║  ██║
            ██████╔╝
            ╚═════╝\s
            """;
    private final static String e = """
            ███████╗
            ██╔════╝
            █████╗ \s
            ██╔══╝ \s
            ███████╗
            ╚══════╝
            """;
    private final static String f = """
            ███████╗
            ██╔════╝
            █████╗ \s
            ██╔══╝ \s
            ██║    \s
            ╚═╝    \s
            """;
    private final static String g = """
             ██████╗\s
            ██╔════╝\s
            ██║  ███╗
            ██║   ██║
            ╚██████╔╝
             ╚═════╝\s
            """;
    private final static String h = """
            ██╗  ██╗
            ██║  ██║
            ███████║
            ██╔══██║
            ██║  ██║
            ╚═╝  ╚═╝
            """;
    private final static String i = """
            ██╗
            ██║
            ██║
            ██║
            ██║
            ╚═╝
            """;
    private final static String j = """
                 ██╗
                 ██║
                 ██║
            ██   ██║
            ╚█████╔╝
             ╚════╝\s
            """;
    private final static String k = """
            ██╗  ██╗
            ██║ ██╔╝
            █████╔╝\s
            ██╔═██╗\s
            ██║  ██╗
            ╚═╝  ╚═╝
            """;
    private final static String l = """
            ██╗    \s
            ██║    \s
            ██║    \s
            ██║    \s
            ███████╗
            ╚══════╝
            """;
    private final static String m = """
            ███╗   ███╗
            ████╗ ████║
            ██╔████╔██║
            ██║╚██╔╝██║
            ██║ ╚═╝ ██║
            ╚═╝     ╚═╝
            """;
    private final static String n = """
            ███╗   ██╗
            ████╗  ██║
            ██╔██╗ ██║
            ██║╚██╗██║
            ██║ ╚████║
            ╚═╝  ╚═══╝
            """;
    private final static String o = """
             ██████╗\s
            ██╔═══██╗
            ██║   ██║
            ██║   ██║
            ╚██████╔╝
             ╚═════╝\s
            """;
    private final static String p = """
            ██████╗\s
            ██╔══██╗
            ██████╔╝
            ██╔═══╝\s
            ██║    \s
            ╚═╝    \s
            """;
    private final static String q = """
             ██████╗\s
            ██╔═══██╗
            ██║   ██║
            ██║▄▄ ██║
            ╚██████╔╝
             ╚══▀▀═╝\s
            """;
    private final static String r = """
            ██████╗\s
            ██╔══██╗
            ██████╔╝
            ██╔══██╗
            ██║  ██║
            ╚═╝  ╚═╝
            """;
    private final static String s = """
            ███████╗
            ██╔════╝
            ███████╗
            ╚════██║
            ███████║
            ╚══════╝
            """;
    private final static String t = """
            ████████╗
            ╚══██╔══╝
               ██║  \s
               ██║  \s
               ██║  \s
               ╚═╝  \s
            """;
    private final static String u = """
            ██╗   ██╗
            ██║   ██║
            ██║   ██║
            ██║   ██║
            ╚██████╔╝
             ╚═════╝\s
            """;
    private final static String v = """
            ██╗   ██╗
            ██║   ██║
            ██║   ██║
            ╚██╗ ██╔╝
             ╚████╔╝\s
              ╚═══╝ \s
            """;
    private final static String w = """
            ██╗    ██╗
            ██║    ██║
            ██║ █╗ ██║
            ██║███╗██║
            ╚███╔███╔╝
             ╚══╝╚══╝\s
            """;
    private final static String x = """
            ██╗  ██╗
            ╚██╗██╔╝
             ╚███╔╝\s
             ██╔██╗\s
            ██╔╝ ██╗
            ╚═╝  ╚═╝
            """;
    private final static String y = """
            ██╗   ██╗
            ╚██╗ ██╔╝
             ╚████╔╝\s
              ╚██╔╝ \s
               ██║  \s
               ╚═╝  \s
            """;
    private final static String z = """
            ███████╗
            ╚══███╔╝
              ███╔╝\s
             ███╔╝ \s
            ███████╗
            ╚══════╝
            """;
    private final static String one = """
             ██╗
            ███║
            ╚██║
             ██║
             ██║
             ╚═╝
            """;
    private final static String two = """
            ██████╗\s
            ╚════██╗
             █████╔╝
            ██╔═══╝\s
            ███████╗
            ╚══════╝
            """;
    private final static String three = """
            ██████╗\s
            ╚════██╗
             █████╔╝
             ╚═══██╗
            ██████╔╝
            ╚═════╝\s
            """;
    private final static String four = """
            ██╗  ██╗
            ██║  ██║
            ███████║
            ╚════██║
                 ██║
                 ╚═╝
            """;
    private final static String five = """
            ███████╗
            ██╔════╝
            ███████╗
            ╚════██║
            ███████║
            ╚══════╝
            """;
    private final static String six = """
             ██████╗\s
            ██╔════╝\s
            ███████╗\s
            ██╔═══██╗
            ╚██████╔╝
             ╚═════╝\s
            """;
    private final static String seven = """
            ███████╗
            ╚════██║
                ██╔╝
               ██╔╝\s
               ██║ \s
               ╚═╝ \s
            """;
    private final static String eight = """
             █████╗\s
            ██╔══██╗
            ╚█████╔╝
            ██╔══██╗
            ╚█████╔╝
             ╚════╝\s
            """;
    private final static String nine = """
             █████╗\s
            ██╔══██╗
            ╚██████║
             ╚═══██║
             █████╔╝
             ╚════╝\s
            """;
    private final static String zero = """
             ██████╗\s
            ██╔═████╗
            ██║██╔██║
            ████╔╝██║
            ╚██████╔╝
             ╚═════╝\s
            """;

    private final static String space = """
            \s\s\s\s
            \s\s\s\s
            \s\s\s\s
            \s\s\s\s
            \s\s\s\s
            \s\s\s\s
            """;

    private final static List<String> alphabet = new ArrayList<>(Arrays.asList(
            zero, one, two, three, four, five, six, seven, eight, nine,
            a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
    ));

    /**
     * This method takes a sentence or name as an input and beautifies it with ascii art
     * so that it becomes a title for the program.
     * @param title il titolo che si vuole convertite in ascii
     * @return la stringa titolo in ascii
     */
    public static String convertTitle(String title) {
        String trimmedTitle = title.trim();
        char [] titleCharArray = trimmedTitle.toUpperCase().toCharArray();
        StringBuilder finalTitle = new StringBuilder();
        try {
            for (int i = 0; i <LINE_HEIGHT; i++) {
                for (char letter: titleCharArray) {
                    if (letter == ' ') {
                        char [] asciLetterArray = space.toCharArray();
                        int newLineCounter = 0;
                        int position = 0;

                        while (newLineCounter < i)
                            if (asciLetterArray[position++] == '\n')
                                newLineCounter++;

                        while (asciLetterArray[position] != '\n') {
                            finalTitle.append(asciLetterArray[position++]);
                        }
                    }

                    else if (letter >= 'A' && letter <= 'Z') {
                        char [] asciLetterArray = alphabet.get(letter - 'A' + 10).toCharArray();
                        int newLineCounter = 0;
                        int position = 0;

                        while (newLineCounter < i)
                            if (asciLetterArray[position++] == '\n')
                                newLineCounter++;

                        while (asciLetterArray[position] != '\n') {
                            finalTitle.append(asciLetterArray[position++]);
                        }
                    }

                    else if (letter >= '0' && letter <= '9') {
                        char [] asciLetterArray = alphabet.get(letter - '0').toCharArray();
                        int newLineCounter = 0;
                        int position = 0;

                        while (newLineCounter < i)
                            if (asciLetterArray[position++] == '\n')
                                newLineCounter++;

                        while (asciLetterArray[position] != '\n')
                            finalTitle.append(asciLetterArray[position++]);
                    }

                    else
                        throw new Exception();
                }
                finalTitle.append('\n');
            }
        } catch (Exception e) {
            System.out.println(AnsiColors.RED + "Attention!" + AnsiColors.RESET + "\n" +
                    "One of the title characters is not supported!");
        }
        return finalTitle.toString();
    }
}
