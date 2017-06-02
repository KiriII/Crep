import static Crep.Crep.*;

import Crep.Flags;
import org.junit.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
public class CrepTest {
    @Test
    public void test() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            Pattern rg = Pattern.compile("yay", Pattern.CASE_INSENSITIVE);
            Flags flags = new Flags(new String[]{});
            assertEquals(Collections.emptyList() , ForTest(rg, reader, flags));
            reader.close();
            rg = Pattern.compile("ya");
            reader = new BufferedReader(new FileReader("text.txt"));
            assertEquals(Arrays.asList("sdnjfa3249sfa jasdfjn aer ya") , ForTest(rg , reader , flags));
            reader.close();
            rg = Pattern.compile("ya" , Pattern.CASE_INSENSITIVE); // проверка флага -i
            reader = new BufferedReader(new FileReader("text.txt"));
            assertEquals(Arrays.asList("sdnjfa3249sfa jasdfjn aer ya" , "CAPSOM YA hhh gfdfghkjl jgtedfhmm ") , ForTest(rg , reader , flags));
            reader.close();
            rg = Pattern.compile( "ya");
            reader = new BufferedReader(new FileReader("text.txt"));
            flags = new Flags(new String[]{"-v"}); // -v
            assertEquals(Arrays.asList("6876876shit fjsnkaa ask kgk;osg askg  " , "ansroasion5sdf uaoisf  sfiasfas jasdf" , "fjnsdfasdfia fjasdf afs sdoi " , "CAPSOM YA hhh gfdfghkjl jgtedfhmm ") ,
                    ForTest(rg , reader , flags));
            reader.close();
            rg = Pattern.compile( "[0-9]+");
            reader = new BufferedReader(new FileReader("text.txt"));
            flags = new Flags(new String[]{"-r"});
            assertEquals(Arrays.asList("6876876shit fjsnkaa ask kgk;osg askg  " , "sdnjfa3249sfa jasdfjn aer ya" , "ansroasion5sdf uaoisf  sfiasfas jasdf") ,
                    ForTest(rg , reader , flags));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }

}
