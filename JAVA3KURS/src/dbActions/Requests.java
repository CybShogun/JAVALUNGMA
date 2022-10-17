package dbActions;

import PLAYER.Currencies;
import PLAYER.Items;
import PLAYER.Progresses;

public class Requests {

    public static String drop(String tableName) {
        return "DROP TABLE "+tableName;
    }
    public static String insert_player(int playerId, String name) {
        return "INSERT playerbddada.players(playerId,nickname) VALUES(" + playerId + ",'" + name + "'" + ")";
    }
    public static String insert_currencies(Currencies c) {
        return "INSERT playerbddada.currencies(id,playerid,resourceId,name,count) VALUES(" + c.getId() + ", " + c.getPlayerId() + ", " + c.getResourceId() + ", '" + c.getName() + "', " + c.getCount() + ")";
    }
    public static String insert_progresses(Progresses p) {
        return "INSERT playerbddada.progresses(id,playerId,resourceId,score,maxScore) VALUES(" + p.getId() + ", " + p.getPlayerId() + ", " + p.getResourceId() + ", " + p.getScore() + ", " + p.getMaxScore() + ")";
    }
    public static String insert_items(Items i) {
        return "INSERT playerbddada.items(id,playerId,resourceId,count,level) VALUES(" + i.getId() + ", " + i.getPlayerId() + ", " + i.getResourceId() + ", " + i.getCount() + ", " + i.getLevel() + ")";
    }
    public static String create_currencies() {
        return "CREATE TABLE playerbddada.currencies (" +
                "  id int NOT NULL," +
                "  playerId int NOT NULL," +
                "  resourceId int NOT NULL," +
                "  name varchar(45) NOT NULL," +
                "  count int NOT NULL," +
                "  PRIMARY KEY (id)" +
                ") ";
    }
    public static String create_items() {
        return "CREATE TABLE playerbddada.items (" +
                "  id int NOT NULL," +
                "  playerId int NOT NULL," +
                "  resourceId int NOT NULL," +
                "  count int NOT NULL," +
                "  level int NOT NULL," +
                "  PRIMARY KEY (id)" +
                ")";
    }
    public static String create_progresses() {
        return "CREATE TABLE playerbddada.progresses (" +
                "  id int NOT NULL," +
                "  playerId int NOT NULL," +
                "  resourceId int NOT NULL," +
                "  score int NOT NULL," +
                "  maxScore int NOT NULL," +
                "  PRIMARY KEY (id)" +
                ")";
    }
    public static String create_player() {
        return "CREATE TABLE playerbddada.players (" +
                "  playerId int NOT NULL," +
                "  nickname varchar(45) NOT NULL," +
                "  PRIMARY KEY (playerId)" +
                ")";
    }
    public static String selectPlayer(){
        return "SELECT * FROM playerbddada.players";
    }
    public static String selectCurrencies(String val){
        return "SELECT * FROM playerbddada.currencies WHERE playerId=" + val;
    }
    public static String selectItems(String val) {
        return "SELECT * FROM playerbddada.items WHERE playerId=" + val;
    }
    public static String selectProgresses(String val) {
        return "SELECT * FROM playerbddada.progresses WHERE playerId=" + val;
    }
}
