package ReKritiks.Dashboard.adapters;

public class Leaderboard_Call {
    private String name;
    private int votes;

    public Leaderboard_Call() {
    }

    public Leaderboard_Call(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
