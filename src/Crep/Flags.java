package Crep;

/**
 * Created by Кирилл on 24.05.2017.
 */
public class Flags {

    private boolean flagR;
    private boolean flagV;
    private boolean flagI;

    private String fileName;
    private String word;

    public Flags(String[] args){
        for (String arg: args) {
            switch (arg) {
                case "-v" :
                    if (flagI || flagR || word != null) throw new IllegalArgumentException();
                    flagV = true;
                    break;
                case "-i" :
                    if (flagR || word != null) throw new  IllegalArgumentException();
                    flagI = true;
                    break;
                case "-r":
                    if (word != null) throw new  IllegalArgumentException();
                    flagR = true;
                    break;
                default:
                    if ((flagR || fileName == null) && word == null) word = arg;
                    else fileName = arg;
            }
        }
    }

    public boolean getFlagR(){
        return flagR;
    }
    public boolean getFlagV(){
        return flagV;
    }
    public boolean getFlagI(){
        return flagI;
    }
    public String getWord(){
        return word;
    }
    public String getFileName(){
        return fileName;
    }
}
