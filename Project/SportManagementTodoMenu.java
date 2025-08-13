import java.util.*;

// INTERFACE
interface Trainable {
    void train();
}

// ABSTRACT CLASS
abstract class Sport {
    protected String sportName;

    public Sport(String sportName) {
        this.sportName = sportName;
    }

    public abstract void displayRules();
}

// TASK CLASS
class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public void markCompleted() { this.completed = true; }

    @Override
    public String toString() {
        return (completed ? "[✔] " : "[ ] ") + description;
    }
}

// TASK MANAGER
class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String desc) {
        tasks.add(new Task(desc));
    }

    public void markTaskDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

// PLAYER BASE CLASS
class Player implements Trainable {
    private String name;
    private int age;
    private String teamName;
    protected String position;
    private static int playerCount = 0;
    private TaskManager taskManager = new TaskManager();

    public Player(String name, int age, String teamName, String position) {
        this.name = name;
        this.age = age;
        this.teamName = teamName;
        this.position = position;
        playerCount++;
    }

    public static int getPlayerCount() { return playerCount; }
    public String getName() { return name; }
    public String getTeamName() { return teamName; }
    public TaskManager getTaskManager() { return taskManager; }

    public void displayInfo() {
        System.out.println("Player: " + name + " | Age: " + age + " | Team: " + teamName + " | Position: " + position);
    }

    @Override
    public void train() {
        System.out.println(name + " is training!");
    }
}

// CRICKET PLAYER
class CricketPlayer extends Player {
    private int runs;

    public CricketPlayer(String name, int age, String teamName, String position, int runs) {
        super(name, age, teamName, position);
        this.runs = runs;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Runs Scored: " + runs);
    }
}

// FOOTBALL PLAYER
class FootballPlayer extends Player {
    private int goals;

    public FootballPlayer(String name, int age, String teamName, String position, int goals) {
        super(name, age, teamName, position);
        this.goals = goals;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Goals Scored: " + goals);
    }
}

// FINAL CLASS FOR RULES
final class GameRules {
    public static final String CRICKET_RULE = "Cricket: Two innings per side.";
    public static final String FOOTBALL_RULE = "Football: 90 minutes match.";
}

// TEAM CLASS
class Team extends Sport {
    private String coachName;
    private List<Player> players = new ArrayList<>();

    public Team(String sportName, String coachName) {
        super(sportName);
        this.coachName = coachName;
    }

    public void addPlayer(Player p) {
        players.add(p);
        System.out.println("Player added: " + p.getName());
    }

    public List<Player> getPlayers() { return players; }

    public void displayPlayers() {
        System.out.println("=== " + sportName + " Team (Coach: " + coachName + ") ===");
        for (Player p : players) {
            p.displayInfo();
            System.out.println();
        }
    }

    @Override
    public void displayRules() {
        if (sportName.equalsIgnoreCase("Cricket"))
            System.out.println(GameRules.CRICKET_RULE);
        else if (sportName.equalsIgnoreCase("Football"))
            System.out.println(GameRules.FOOTBALL_RULE);
    }
}

// MAIN MENU APP
public class SportManagementTodoMenu {
    private static Scanner sc = new Scanner(System.in);
    private static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== SPORT MANAGEMENT MENU ====");
            System.out.println("1. Add Team");
            System.out.println("2. Add Player to Team");
            System.out.println("3. Assign Task to Player");
            System.out.println("4. View Player Tasks");
            System.out.println("5. Mark Player Task as Completed");
            System.out.println("6. View Teams & Players");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 :addTeam();
                case 2 :addPlayerToTeam();
                case 3 : assignTask();
                case 4 : viewPlayerTasks();
                case 5 : markTaskCompleted();
                case 6 : viewTeamsAndPlayers();
                case 7 : {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default : System.out.println("Invalid choice, try again!");
            }
        }
    }

    private static void addTeam() {
        System.out.print("Enter sport name (Cricket/Football): ");
        String sportName = sc.nextLine();
        System.out.print("Enter coach name: ");
        String coach = sc.nextLine();
        teams.add(new Team(sportName, coach));
        System.out.println("Team added successfully!");
    }

    private static void addPlayerToTeam() {
        Team team = selectTeam();
        if (team == null) return;

        System.out.print("Enter player name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter position: ");
        String position = sc.nextLine();

        if (team.sportName.equalsIgnoreCase("Cricket")) {
            System.out.print("Enter runs scored: ");
            int runs = sc.nextInt();
            sc.nextLine();
            team.addPlayer(new CricketPlayer(name, age, team.sportName, position, runs));
        } else if (team.sportName.equalsIgnoreCase("Football")) {
            System.out.print("Enter goals scored: ");
            int goals = sc.nextInt();
            sc.nextLine();
            team.addPlayer(new FootballPlayer(name, age, team.sportName, position, goals));
        } else {
            System.out.println("Invalid sport type.");
        }
    }

    private static void assignTask() {
        Player player = selectPlayer();
        if (player == null) return;

        System.out.print("Enter task description: ");
        String desc = sc.nextLine();
        player.getTaskManager().addTask(desc);
        System.out.println("Task assigned!");
    }

    private static void viewPlayerTasks() {
        Player player = selectPlayer();
        if (player == null) return;

        System.out.println(player.getName() + "'s Tasks:");
        player.getTaskManager().displayTasks();
    }

    private static void markTaskCompleted() {
        Player player = selectPlayer();
        if (player == null) return;

        player.getTaskManager().displayTasks();
        System.out.print("Enter task number to mark completed: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        player.getTaskManager().markTaskDone(index);
        System.out.println("Task marked as completed!");
    }

    private static void viewTeamsAndPlayers() {
        for (Team t : teams) {
            t.displayRules();
            t.displayPlayers();
        }
        System.out.println("Total Players in System: " + Player.getPlayerCount());
    }

    private static Team selectTeam() {
        if (teams.isEmpty()) {
            System.out.println("No teams available.");
            return null;
        }
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).sportName);
        }
        System.out.print("Select team: ");
        int choice = sc.nextInt() - 1;
        sc.nextLine();
        if (choice >= 0 && choice < teams.size()) {
            return teams.get(choice);
        }
        System.out.println("Invalid choice.");
        return null;
    }

    private static Player selectPlayer() {
        Team team = selectTeam();
        if (team == null || team.getPlayers().isEmpty()) {
            System.out.println("No players available.");
            return null;
        }
        List<Player> players = team.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).getName());
        }
        System.out.print("Select player: ");
        int choice = sc.nextInt() - 1;
        sc.nextLine();
        if (choice >= 0 && choice < players.size()) {
            return players.get(choice);
        }
        System.out.println("Invalid choice.");
        return null;
    }
}
