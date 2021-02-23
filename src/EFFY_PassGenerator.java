import java.util.ArrayList;
import java.util.Random;

public class EFFY_PassGenerator {
    private int passLenght;
    private int passCount;
    private final static String Digit = "0123456789"; //тут думаю может поменять метод цифрого пароля аналогично останым? из строки
    private final static String Alpha = "AaBbCcDdEeFfGgHhJjKkIiLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    private final static String Combo = "AaBbCcDdEeFfGgHhJjKkIiLl0123456789MmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    public EFFY_PassGenerator(int passCount, int passLenght){
        this.passCount = passCount;
        this.passLenght = passLenght;
    }

    public ArrayList GenerateDigit(){
        ArrayList<String> passwordList = new ArrayList<>(passCount);
        StringBuffer sb = new StringBuffer(passLenght);
            for (int i = 0; i<passCount;i++) {
                for( int k = 0; k<passLenght;k++) {
                    sb.append(new Random().nextInt(10));
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
                sb.append(Alpha.charAt((int)(Alpha.length() * Math.random())));
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
