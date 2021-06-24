package ReKritiks.Dashboard.adapters;

public class Leaderboard_Contact {
    private String name;
    private int votes;

    public Leaderboard_Contact(){

    }

    public Leaderboard_Contact(String name, int votes) {
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
