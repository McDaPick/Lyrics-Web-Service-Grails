package lyricsrest

import com.google.gson.Gson

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

class PUTController {

    def index() {
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/accounts";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "pass");

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }



        String payload = buffer.toString().trim();
        Gson gson = new Gson();
        User user = gson.fromJson(payload, User.class);

        String id = user.id
        String password = user.password
        String column = user.column

        String query = " UPDATE users SET " + column + "='" + password + "' WHERE id = " + id + ";";

        Statement st = conn.createStatement();

        st.executeUpdate(query);
    }
}
