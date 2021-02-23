import java.util.ArrayList;
import java.util.Random;

public class EFFY_PassGenerator {
    private int passLenght;
    private int passCount;
    private final static String Combo = "0123456789AaBbCcDdEeFfGgHhJjKkIiLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    public EFFY_PassGenerator(int passCount, int passLenght){
        this.passCount = passCount;
        this.passLenght = passLenght;
    }

    public ArrayList GenerateDigit(){
        ArrayList<String> passwordList = new ArrayList<>(passCount);
        StringBuffer sb = new StringBuffer(passLenght);
        for (int i = 0; i < passCount; i++) {
            for (int k = 0; k < passLenght; k++) {
                sb.append(Combo.charAt((int)(10 * Math.random())));
            }
            if(!passwordList.contains(String.valueOf(sb))){
                passwordList.add(String.valueOf(sb));
                sb.delete(0,sb.length());
            }
            sb.delete(0,sb.length());
        }
        return passwordList;
    }

    public ArrayList GenerateAlpha(){
        ArrayList<String> passwordList = new ArrayList<>(passCount);
        StringBuffer sb = new StringBuffer(passLenght);
        for (int i = 0; i < passCount; i++) {
            for (int k = 0; k < passLenght; k++) {
                sb.append(Combo.substring(10).charAt((int)(Combo.substring(10).length()* Math.random())));
            }
            if(!passwordList.contains(String.valueOf(sb))){
                passwordList.add(String.valueOf(sb));
                sb.delete(0,sb.length());
            }
            sb.delete(0,sb.length());
        }
        return passwordList;
    }

    public ArrayList GenerateMixed(){
        ArrayList<String> passwordList = new ArrayList<>(passCount);
        StringBuffer sb = new StringBuffer(passLenght);
        for (int i = 0; i < passCount; i++) {
            for (int k = 0; k < passLenght; k++) {
                sb.append(Combo.charAt((int)(Combo.length() * Math.random())));
            }
            if(!passwordList.contains(String.valueOf(sb))){
                passwordList.add(String.valueOf(sb));
                sb.delete(0,sb.length());
            }
            sb.delete(0,sb.length());
        }
        return passwordList;
    }

    public ArrayList Generate(String type){
        if(type.equals(TypeGenerate.getAlpha())){
            return GenerateAlpha();
        }
        else if(type.equals(TypeGenerate.getDigit())){
            return GenerateDigit();
        }
        else
            return GenerateMixed();
    }

}
