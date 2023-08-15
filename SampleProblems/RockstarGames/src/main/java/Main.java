import java.util.*;

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObservers();
}

class RockstarGames implements Observable {
    public String releaseGame;
    private List<Observer> observers = new ArrayList<>();

    public void release(String releaseGame) {
        this.releaseGame = releaseGame;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("Notification for gamer: " + observer);
            observer.update(releaseGame);
        }
    }
}

interface Observer {
    public void update(String domain);
}

class Gamer implements Observer {
    private final String name;
    private Set<String> games = new HashSet<>();

    public Gamer(String name) {
        this.name = name;
    }

    @Override
    public void update(String name) {
        buyGame(name);
    }

    public void buyGame(String game) {
        System.out.println(name + " says : \"Oh, Rockstar releases new game " + game + "!\"");
        games.add(game);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String game = null;

        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose");
        Gamer peter = new Gamer("Peter Johnston");
        Gamer helen = new Gamer("Helen Jack");

        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);

        game = scanner.nextLine();
        rockstarGames.release(game);

        scanner.close();
    }
}