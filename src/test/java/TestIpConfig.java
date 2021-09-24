import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestIpConfig {

    private static String ip4 = "";
    private static String subred = "";
    private static String puertaEnlace = "";

    private static Double nota = 0.0;

    @BeforeAll
    private static void launchIpConfig()  {
        ArrayList<String> out = new ArrayList<>();
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "ipconfig");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                out.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ip4 = out.get(8);
        subred = out.get(9);
        puertaEnlace = out.get(10);
    }

    @Test
    public void testIp4(){
        Assertions.assertEquals(Main.getIp4(), ip4);
        nota += 1/3.0;
    }

    @Test
    public void testPuertaEnlace(){
        Assertions.assertEquals(Main.getPuertaEnlace(), puertaEnlace);
        nota += 1/3.0;
    }

    @Test
    public void testSubred(){
        Assertions.assertEquals(Main.getSubred(), subred);
        nota += 1/3.0;
    }

    @AfterAll
    public static void onFinished() {
        System.out.println("La nota de " + Main.apellidos + " es un " + nota * 10);
        nota = 0.0;
    }
}
