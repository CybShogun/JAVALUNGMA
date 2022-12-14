package PLAYER;

public class Progresses {

    private int id;
    private int playerId;
    private int resourceId;
    private int score;
    private int maxScore;

    public Progresses() {
        this.id = -1;
        this.playerId = -1;
        this.resourceId = -1;
        this.score = -1;
        this.maxScore = -1;
    }
    public Progresses(int id, int playerId, int resourceId, int score, int maxScore) {
        this.id = id;
        this.playerId = playerId;
        this.resourceId = resourceId;
        this.score = score;
        this.maxScore = maxScore;
    }
    public int getId() {
        return id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
