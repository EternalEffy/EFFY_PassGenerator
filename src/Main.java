public class Main {

    public static void main(String[] args) {
        EFFY_PassGenerator myPass = new EFFY_PassGenerator(11,3);
        System.out.println(myPass.Generate(TypeGenerate.Digit));
        System.out.println(myPass.Generate(TypeGenerate.Alpha));
        System.out.println(myPass.Generate(TypeGenerate.Mixed));
    }
}
