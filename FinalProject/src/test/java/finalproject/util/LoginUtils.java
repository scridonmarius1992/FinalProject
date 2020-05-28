package finalproject.util;

import finalproject.models.LoginAccountModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class LoginUtils {

    private static final String LOGIN_CREDENTIALS_FILE = "src/test/resources/login-credentials.json";

    public static LoginAccountModel getLoginCredentials() throws IOException, ParseException {
        JSONObject credentials = (JSONObject) new JSONParser().parse(new FileReader(LOGIN_CREDENTIALS_FILE));

        String username = (String) credentials.get("username");
        String password = (String) credentials.get("password");

        return new LoginAccountModel(username, password);
    }

    public static void changeLoginCredentials(LoginAccountModel loginAccountModel) throws IOException {
        JSONObject credentials = new JSONObject();
        credentials.put("username", loginAccountModel.getEmail());
        credentials.put("password", loginAccountModel.getPassword());

        final File file = new File(LOGIN_CREDENTIALS_FILE);
        FileWriter fw = new FileWriter(file, false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(credentials.toJSONString());
        bw.close();
        fw.close();
    }
}
