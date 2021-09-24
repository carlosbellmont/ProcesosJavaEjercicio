import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {


    public static String apellidos = "de Tena Bellmont";

    public static void main(String[] args) {
        launchIpConfig();
    }


    /**
     *
     * @return Devuelve la IP del usuario. Ejemplo:
     * Direcci¢n IPv4. . . . . . . . . . . . . . : 1.1.1.1
     */
    public static String getIp4() {
        System.out.println(launchIpConfig().get(8));
        return launchIpConfig().get(8);
    }

    /**
     *
     * @return Devuelve la subred del usuario. Ejemplo: 1.1.1.1
     * M scara de subred . . . . . . . . . . . . : 1.1.1.1
     */
    public static String getSubred() {
        System.out.println(launchIpConfig().get(9));
        return launchIpConfig().get(9);
    }

    /**
     *
     * @return Devuelve la subred del usuario. Ejemplo: 1.1.1.1
     * Puerta de enlace predeterminada . . . . . : 1.1.1.1
     */
    public static String getPuertaEnlace() {
        System.out.println(launchIpConfig().get(10));
        return launchIpConfig().get(10);
    }

    private static ArrayList<String> launchIpConfig()  {
        ArrayList<String> out = new ArrayList<>();
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "ipconfig");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                //System.out.println(line);
                out.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}
