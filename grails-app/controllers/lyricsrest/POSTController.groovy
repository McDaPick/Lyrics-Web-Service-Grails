package lyricsrest

import com.google.gson.Gson

import java.sql.Statement;
import java.sql.Connection
import java.sql.DriverManager;

class POSTController {

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

        def username = user.username
        def password = user.password
        def song = user.song

        String query = "INSERT INTO users (username, pass, song) VALUES ('"  + username + "','" + password + "','" + song + "');" ;

        Statement st = conn.createStatement()

        st.executeUpdate(query);

        //user.save()

    }
}
