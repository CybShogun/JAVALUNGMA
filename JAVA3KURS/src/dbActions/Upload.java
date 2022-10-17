package dbActions;

import CONVERTERS.TestConnection;
import PLAYER.Currencies;
import PLAYER.Items;
import PLAYER.Player;
import PLAYER.Progresses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Upload {
    public static List<Player> upload(Data data) throws SQLException {

        Map<Integer, String> pn = new TreeMap<>();
        List<Player> players = new ArrayList<>();
        ResultSet set = TestConnection.getResultSet(Requests.selectPlayer(),data.getConnection());

        int count = 0;

        while (set.next()){
            pn.put(set.getInt("playerId"), set.getString("nickname"));
        }

        for (Integer key:pn.keySet()) {
            List<Currencies> lc = new ArrayList<>();
                set = TestConnection.getResultSet(Requests.selectCurrencies(Integer.toString(key)), data.getConnection());

            while (set.next()){
                Currencies c = new Currencies();
                c.setId(set.getInt("id"));
                c.setPlayerId(key);
                c.setResourceId(set.getInt("resourceId"));
                c.setName(set.getString("name"));
                c.setCount(set.getInt("count"));
                lc.add(c);
            }

            List<Items> li = new ArrayList<>();
            set = TestConnection.getResultSet(Requests.selectItems(Integer.toString(key)), data.getConnection());

            while (set.next()){
                Items i = new Items();
                i.setId(set.getInt("id"));
                i.setPlayerId(key);
                i.setResourceId(set.getInt("resourceId"));
                i.setCount(set.getInt("count"));
                i.setLevel(set.getInt("level"));
                li.add(i);
            }

            List<Progresses> lp = new ArrayList<>();
            set = TestConnection.getResultSet(Requests.selectProgresses(Integer.toString(key)), data.getConnection());

            while (set.next()){
                Progresses p = new Progresses();
                p.setId(set.getInt("id"));
                p.setPlayerId(key);
                p.setResourceId(set.getInt("resourceId"));
                p.setScore(set.getInt("score"));
                p.setMaxScore(set.getInt("maxScore"));
                lp.add(p);
            }
            Player p = new Player(key, pn.get(key), lp, lc, li);
            players.add(p);
            if(count <= 10){
                System.out.println(p.getPlayerId() + " " + p.getNickname());
                System.out.println("Currensies");
                for (Currencies c:p.getCurrencies()) {
                    System.out.println(c);
                }
                System.out.println();
                System.out.println("Items");
                for (Items c:p.getItems()) {
                    System.out.println(c);
                }
                System.out.println();
                System.out.println("Progresses");
                for (Progresses c:p.getProgresses()) {
                    System.out.println(c);
                }
                System.out.println();
                System.out.println();
            }

            count++;
        }


        return players;
    }
}
