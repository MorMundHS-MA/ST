package refactored;

import java.io.*;

public class LinesOfCodeRefactored {

    /**
     * Die Methode liefert die Anzahl "echter Programmzeilen" in einer
     * Java-Datei.
     * Eine echte Programmzeilee hier ist eine Zeile, auf die keiner der
     * folgenden Punkte zutrifft:
     * (1) Die Zeile ist leer oder nur beinhaltet nur Leerzeichen oder
     * Tabulatoren.
     * (2) Die Zeile beginnt nach eventuellen Leerzeichen mit einem
     * Zeilenkommentar, gekennzeichnet mit "//".
     * (3) Die Zeile beginnt mit einem Blockkommentar, gekennzeichnet mit "/*".
     * (4) In der Zeile endet ein Blockkommentar, gekennzeichnet mit "* /"
     * ohne Abstand dazwischen.
     * (5) Die Zeile ist Teil eines Blockkommentars.
     * Alle anderen Zeilen werden als Programmzeilen verstanden und sollen
     * gezählt werden.
     *
     * @param filename der Dateiname
     * @return die Anzahl echter Programmzeilen in der Datei filename
     */
    public static int countLines(String filename) throws IOException {
        // lokale Variablen
        int lineCounter = 0;
        int comment1, comment2, comment3;
        boolean isMultiLineComment = false;
        BufferedReader javaDatei = null;
        /*
         * ab hier wird die Datei analysiert
         */
        try {
            javaDatei = new BufferedReader(new FileReader(filename));
            while (javaDatei.ready()) {
                String currentLine = deleteSpaces(javaDatei.readLine());
                if (!currentLine.equals("")) {
                    comment1 = currentLine.indexOf("//");
                    comment2 = currentLine.indexOf("/*");
                    if (comment2 == 0) {
                        isMultiLineComment = true;
                    }
                    comment3 = currentLine.indexOf("*/");
                    if (comment3 == 0) {
                        isMultiLineComment = false;
                    }

                    if (comment1 != 0 && comment2 != 0 && comment3 != 0 && !isMultiLineComment) {
                        lineCounter++;
                    }
                }
            }
            javaDatei.close();
            return lineCounter;
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (javaDatei != null) {
                    javaDatei.close();
                }
            } catch (Exception e) {
                System.out.printf("Failed to close java file %s\n", e.getMessage());
            }
        }
    }

    /**
     * Entferne Leerzeichen und Tabs aus einem String.
     *
     * @param original Original String mit Leerzeichen und Tabs
     * @return Neuer String ohne Leerzeichen und Tabs
     */
    static String deleteSpaces(String original) {
        int counter = 0;
        String rest = "";
        if (original.length() == 0) {
            return "";
        }
        while (counter < original.length() && (original.charAt(counter) == '\t' || original.charAt(counter) == ' ')) {
            counter++;
        }
        while (counter < original.length()) {
            rest = rest + original.charAt(counter);
            counter++;
        }

        return rest;
    }
}
