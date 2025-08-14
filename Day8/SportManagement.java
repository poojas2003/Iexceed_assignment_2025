import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// INTERFACE - For training functionality
interface Trainable {
    void train();
}

// ABSTRACT CLASS - Base for different sports
abstract class Sport {
    protected String sportName;

    public Sport(String sportName) {
        this.sportName = sportName;
    }

    public abstract void displayRules();
}

// PLAYER CLASS - Encapsulation & Data
class Player {
    private int id; // Unique ID
    private String name;
    private int age;
    private String position;
    private int matchesPlayed;
    private int runsScored;

    public Player(int id, String name, int age, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.matchesPlayed = 0;
        this.runsScored = 0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPosition() { return position; }
    public int getMatchesPlayed() { return matchesPlayed; }
    public int getRunsScored() { return runsScored; }

    public void setName(String name) { this.name = name.trim(); }
    public void setAge(int age) { this.age = age; }
    public void setPosition(String position) { this.position = position.trim(); }
    public void updateStats(int matches, int runs) {
        this.matchesPlayed += matches;
        this.runsScored += runs;
    }

    @Override
    public String toString() {
        double average = (matchesPlayed > 0) ? (double) runsScored / matchesPlayed : 0;
        return "#" + id + " - " + name + " (" + age + ", " + position + ") | Matches: " + matchesPlayed + ", Runs: " + runsScored + ", Avg: " + String.format("%.2f", average);
    }
}

// CRICKET CLASS - Inheritance from Sport
class Cricket extends Sport implements Trainable {
    public Cricket() {
        super("Cricket");
    }

    @Override
    public void displayRules() {
        System.out.println("Cricket Rules: Two teams, 11 players each, score runs to win.");
    }

    @Override
    public void train() {
        System.out.println("Training: Batting, Bowling, Fielding drills.");
    }
}

// PLAYER SERVICE - SRP & File I/O
class PlayerService {
    private List<Player> players = new ArrayList<>();
    private final String FILE_NAME = "players.txt";
    private AtomicInteger idCounter = new AtomicInteger(1);

    public PlayerService() {
        loadFromFile();
    }

    public void addPlayer(String name, int age, String position) {
        Player player = new Player(idCounter.getAndIncrement(), name, age, position);
        players.add(player);
        saveToFile();
    }

    public void updatePlayer(int id, String name, int age, String position) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == id) {
                Player updated = new Player(id, name, age, position);
                players.set(i, updated);
                saveToFile();
                return;
            }
        }
    }

    public void deletePlayer(int id) {
        players.removeIf(p -> p.getId() == id);
        saveToFile();
    }

    public void updateStats(int id, int matches, int runs) {
        for (Player p : players) {
            if (p.getId() == id) {
                p.updateStats(matches, runs);
                saveToFile();
                return;
            }
        }
    }

    public List<Player> listPlayers() {
        return players;
    }

    public Player getPlayerById(int id) {
        for (Player p : players) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Player p : players) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getAge() + "," + p.getPosition() + "," + p.getMatchesPlayed() + "," + p.getRunsScored());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int maxId = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    int id = Integer.parseInt(data[0]);
                    players.add(new Player(id, data[1], Integer.parseInt(data[2]), data[3]));
                    players.get(players.size() - 1).updateStats(Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                    if (id > maxId) maxId = id;
                }
            }
            idCounter.set(maxId + 1);
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}

// TASK CLASS - Player-specific
class Task {
    private String description;
    private boolean completed;
    private int playerId;

    public Task(String description, int playerId) {
        this.description = description.trim();
        this.completed = false;
        this.playerId = playerId;
    }

    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public int getPlayerId() { return playerId; }
    public void markCompleted() { completed = true; }

    @Override
    public String toString() {
        return (completed ? "[✔] " : "[ ] ") + description + " (Player ID: " + playerId + ")";
    }
}

// TASK SERVICE - Manages To-Do List with persistence
class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";

    public TaskService() {
        loadFromFile();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveToFile();
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            saveToFile();
        }
    }

    public List<Task> listTasks() {
        return tasks;
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                writer.write(t.getDescription() + "," + t.isCompleted() + "," + t.getPlayerId());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    Task task = new Task(data[0], Integer.parseInt(data[2]));
                    if (Boolean.parseBoolean(data[1])) task.markCompleted();
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}

// MAIN APPLICATION
public class SportManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlayerService playerService = new PlayerService();
        TaskService taskService = new TaskService();
        Cricket cricket = new Cricket();

        while (true) {
            System.out.println("\n🏆 National Sports League");
            System.out.println("1. Add Player");
            System.out.println("2. Update Player");
            System.out.println("3. Delete Player");
            System.out.println("4. List Players");
            System.out.println("5. Update Player Stats");
            System.out.println("6. Add Task for Player");
            System.out.println("7. View All Tasks");
            System.out.println("8. Complete Task");
            System.out.println("9. View Cricket Rules");
            System.out.println("10. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter position: ");
                    String position = sc.nextLine();
                    playerService.addPlayer(name, age, position);
                    break;
                case 2:
                    System.out.print("Enter Player ID to update: ");
                    int updId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new position: ");
                    String newPos = sc.nextLine();
                    playerService.updatePlayer(updId, newName, newAge, newPos);
                    break;
                case 3:
                    System.out.print("Enter Player ID to delete: ");
                    int delId = Integer.parseInt(sc.nextLine());
                    playerService.deletePlayer(delId);
                    break;
                case 4:
                    System.out.println("Players:");
                    for (Player p : playerService.listPlayers()) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    System.out.print("Enter Player ID to update stats: ");
                    int statId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter matches played to add: ");
                    int matches = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter runs scored to add: ");
                    int runs = Integer.parseInt(sc.nextLine());
                    playerService.updateStats(statId, matches, runs);
                    break;
                case 6:
                    System.out.print("Enter Player ID for task: ");
                    int taskPid = Integer.parseInt(sc.nextLine());
                    Player player = playerService.getPlayerById(taskPid);
                    if (player == null) {
                        System.out.println("Player not found.");
                        break;
                    }
                    System.out.print("Enter task description: ");
                    String taskDesc = sc.nextLine();
                    taskService.addTask(new Task(taskDesc, taskPid));
                    break;
                case 7:
                    System.out.println("Tasks:");
                    for (Task t : taskService.listTasks()) {
                        System.out.println(t);
                    }
                    break;
                case 8:
                    System.out.print("Enter task index to complete (0-based): ");
                    int idx = Integer.parseInt(sc.nextLine());
                    taskService.completeTask(idx);
                    break;
                case 9:
                    cricket.displayRules();
                    break;
                case 10:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}