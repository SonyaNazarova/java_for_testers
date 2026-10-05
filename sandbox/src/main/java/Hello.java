import java.io.File;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello? world");

        var configFail = new File("sandbox/build.gradle");
        System.out.println(configFail.getAbsolutePath());
        System.out.println(configFail.exists());
    }
}
