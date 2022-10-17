package dbActions;

import CONVERTERS.TestConnection;
import PLAYER.Currencies;
import PLAYER.Items;
import PLAYER.Player;
import PLAYER.Progresses;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class dbCommunication {
    public static void enter(List<Player> lst, Connection con) throws SQLException {
        int count=0;
        for (Player p: lst) {
            TestConnection.insertToDataBase(Requests.insert_player(p.getPlayerId(), p.getNickname()), con);
            for (Currencies c: p.getCurrencies()) {
                TestConnection.insertToDataBase(Requests.insert_currencies(c), con);
            }
            for (Items i: p.getItems()) {
                TestConnection.insertToDataBase(Requests.insert_items(i), con);
            }
            for (Progresses pr: p.getProgresses()) {
                TestConnection.insertToDataBase(Requests.insert_progresses(pr), con);
            }
            count++;
            if(count%100==0)
                System.out.println(count/100+"%");
        }
    }
}
