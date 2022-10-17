import CONVERTERS.TestConnection;
import PLAYER.Player;
import dbActions.Data;
import dbActions.Requests;
import dbActions.Upload;
import dbActions.dbCommunication;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
        public static List<Player> getPlayers1(String fileName) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(new File(fileName));
            TypeReference<List<Player>> typeReference = new TypeReference<List<Player>>() {};

            List<Player> playerList = new ObjectMapper().readValue(new FileInputStream(new File(fileName)),new TypeReference<List<Player>>() {});

            return playerList;

        }

    public static void remove(Data d) {
        TestConnection.deleteTable(Requests.drop("playerbddada.players"), d.getConnection());
        TestConnection.deleteTable(Requests.drop("playerbddada.items"), d.getConnection());
        TestConnection.deleteTable(Requests.drop("playerbddada.currencies"), d.getConnection());
        TestConnection.deleteTable(Requests.drop("playerbddada.progresses"), d.getConnection());
    }

    public static void build(Data d) throws SQLException {
        TestConnection.createTable(Requests.create_player(), d.getConnection());
        TestConnection.createTable(Requests.create_items(), d.getConnection());
        TestConnection.createTable(Requests.create_currencies(), d.getConnection());
        TestConnection.createTable(Requests.create_progresses(), d.getConnection());
    }

        public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

            Data d = new Data();
            remove(d);
            build(d);
            List<Player> lst = getPlayers1("C:\\GOG Games\\JAVA3KURS\\src\\players.json");
            Map<Integer, String> Jopa = new TreeMap<>();
          dbCommunication.enter(lst, d.getConnection());
            Upload.upload(d);
        }
}