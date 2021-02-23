public class Main {

    public static void main(String[] args) {
        EFFY_PassGenerator myPass = new EFFY_PassGenerator(20,5);
        //System.out.println(myPass.GenerateDigit());
        //System.out.println(myPass.GenerateAlpha());
        //System.out.println(myPass.GenerateMixed());
        System.out.println(myPass.Generate(TypeGenerate.Digit));
    }
}
