package lyricsrest

import com.google.gson.Gson

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement;

class DELETEController {

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

        String id = user.getId();



        // our SQL SELECT query.
        // if you only need a few columns, specify them by name instead of using "*"
        String query = " DELETE FROM users WHERE id = " + id ;

        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        st.executeUpdate(query);

    }
}
