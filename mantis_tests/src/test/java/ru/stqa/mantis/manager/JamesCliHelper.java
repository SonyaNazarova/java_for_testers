package ru.stqa.mantis.manager;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JamesCliHelper extends HelperBase {


    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addUser(String email, String password) {
        ProcessBuilder builder = new ProcessBuilder(
                "java", "-cp", "\"james-server-jpa-app.lib/*\"",
                "org.apache.james.cli.ServerCmd", "AddUser", email, password);
        builder.directory(new File(manager.property("james.workingDir")));
        builder.redirectErrorStream(true);
        try {
            Process process = builder.start();
            String output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            process.waitFor();
            System.out.println(output);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
