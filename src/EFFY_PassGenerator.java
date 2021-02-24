import java.util.ArrayList;
import java.util.Random;

public class EFFY_PassGenerator {
    private int passLenght;
    private int passCount;
    private final String Combo = "0123456789AaBbCcDdEeFfGgHhJjKkIiLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    private final int index = 10;

    public EFFY_PassGenerator(int passCount, int passLenght){
        this.passCount = passCount;
        this.passLenght = passLenght;
    }

    public ArrayList GenerateDigit(){
        ArrayList<String> passwordList = new ArrayList<>(passCount);
        Random r = new Random();
        StringBuffer sb = new StringBuffer(passLenght);
        for (int i = 0; i < passCount; i++) {
            for (int k = 0; k < passLenght; k++) {
                sb.append(Combo.charAt(r.nextInt(index)));
            }
            checker(sb,passwordList);
        }
        return passwordList;
    }

    public ArrayList GenerateAlpha(){
        ArrayList<String> passwordList = new ArrayList<>(passCount);
        Random r = new Random();
        StringBuffer sb = new StringBuffer(passLenght);
        for (int i = 0; i < passCount; i++) {
            for (int k = 0; k < passLenght; k++) {
                sb.append(Combo.charAt((r.nextInt(Combo.length()-index))+index));
            }
            checker(sb,passwordList);
        }
        return passwordList;
    }

    public ArrayList GenerateMixed(){
        ArrayList<String> passwordList = new ArrayList<>(passCount);
        Random r = new Random();
        StringBuffer sb = new StringBuffer(passLenght);
        for (int i = 0; i < passCount; i++) {
            for (int k = 0; k < passLenght; k++) {
                sb.append(Combo.charAt(r.nextInt(Combo.length())));
            }
            checker(sb,passwordList);
        }
        return passwordList;
    }

    public ArrayList Generate(int type){
        switch (type) {
           case 0: return GenerateDigit();
           case 1: return GenerateAlpha();
           case 2: return GenerateMixed();
        }
        return null;
    }

   /* public void checkList(StringBuffer sb,ArrayList passwordList){
        if(!passwordList.contains(String.valueOf(sb))){
            passwordList.add(String.valueOf(sb));
            }
        sb.delete(0,sb.length());
    }*/


    public void checker(StringBuffer sb,ArrayList passwordList){
        if(passwordList.size()==0){
            passwordList.add(String.valueOf(sb));
        }
        for(int i=0;i<passwordList.size();i++){
            if((passwordList.get(i).equals(String.valueOf(sb)))){
                break;
            }
            else {
                passwordList.add(String.valueOf(sb));
                break;
            }
        }
        sb.delete(0,sb.length());
    }
}
