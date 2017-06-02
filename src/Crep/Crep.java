package Crep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crep {

    public static void main(String[] args) throws FileNotFoundException {
        Flags flags = new Flags(args);
        File file = new File(flags.getFileName());
        if (!file.exists() || file.isDirectory()) throw new FileNotFoundException();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Pattern rg = (flags.getFlagI()) ? Pattern.compile(flags.getWord(), Pattern.CASE_INSENSITIVE) : Pattern.compile(flags.getWord());
        List<String> matches = new ArrayList<>();
        try {
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = rg.matcher(line);
                boolean isMatch = matcher.find();
                if (flags.getFlagV() != isMatch)
                    matches.add(line);
                line = reader.readLine();
            }
        }
        catch (IOException E){
           E.printStackTrace();
        }
        matches.forEach(System.out::println);
    }

    public static List<String> ForTest(Pattern rg , BufferedReader reader , Flags flags){
        List<String> matches = new ArrayList<>();
        try {
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = rg.matcher(line);
                boolean isMatch = matcher.find();
                if (flags.getFlagV() != isMatch)
                    matches.add(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException E){
            E.printStackTrace();
        }
        return matches;
    }
}
