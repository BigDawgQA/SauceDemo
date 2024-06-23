package dockerPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class SetupDocker {

    @BeforeTest
    void startDocker() throws IOException, InterruptedException {

        Runtime.getRuntime().exec("cmd /c start startDockerGrid.bat");
        Thread.sleep(15000);
    }


    @AfterTest
    void stopDocker() throws IOException, InterruptedException {

        Runtime.getRuntime().exec("cmd /c start stopDockerGrid.bat");
        Thread.sleep(10000);
        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
    }


}
