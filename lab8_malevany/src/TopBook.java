public class TopBook {
    private int Number;
    private String Author;
    private String Name;
    private String Year;
    private int Vote;
    private int Score;

    public TopBook(int number, String author, String name, String year, int vote, int score) {
        this.Number = number;
        this.Author = author;
        this.Name = name;
        this.Year = year;
        this.Vote = vote;
        this.Score = score;
    }

    @Override
    public String toString() {
        return "TopBook{" +
                "Number=" + Number +
                ", Author'=" + Author + '\'' +
                ", Name='" + Name + '\'' +
                ", Year'=" + Year + '\'' +
                ", Vote=" + Vote +
                ", Score=" + Score +
                '}';
    }
}
