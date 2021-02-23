import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class EFFY_PassGenerator {
    private static final String DIGITS = "0123456789";
    private int passLenght;
    private int passCount;

    public EFFY_PassGenerator(int passCount, int passLenght){
        this.passCount = passCount;
        this.passLenght = passLenght;
    }

    public ArrayList GenerateList(){
        ArrayList<String> passwordList = new ArrayList<>(passCount);
        Random r = new Random();
        StringBuffer sb = new StringBuffer();

            for (int i = 0; i<passCount;i++) {
                for( int k = 0; k<passLenght;k++) {
                    sb.append(String.valueOf(r.nextInt(9)));
                }
                if(passwordList.contains(String.valueOf(sb))){
                    sb.delete(0,sb.length());
                }
                else {
                    passwordList.add(String.valueOf(sb));
                }
                sb.delete(0,sb.length());
            }
        System.out.println("------------------" + passwordList.size());
        return passwordList;
    }
}
