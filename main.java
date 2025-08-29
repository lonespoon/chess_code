import java.util.*;
import java.io.*;
class piece {
    String pieceType;
    String color;
    String x;
    int y;
    piece(String pieceType, String color, String x, int y) {
        this.pieceType=pieceType;
        this.color=color;
        this.x=x;
        this.y=y;
    }
}
public class main {
public static void main(String[] args) {
    List<piece> pieces = new ArrayList<>();
    try {
        File file=new File("./CS 3331 AdvOOP A1 Chess pieces file copy.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            piece piece = new piece(sc.next(), sc.next(), sc.next(), sc.nextInt());
            pieces.add(piece);
        }
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    System.out.println("What piece do you want to move?");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    for (piece p : pieces) {
        if (input.equals(p.pieceType)) {
            System.out.println("Where do you want to move it?");
            String move = sc.nextLine();
            p.x = move.substring(0, 1);
            p.y = Integer.parseInt(move.substring(1, 2));
            System.out.println("The " + p.color + " " + p.pieceType + " has been moved to " + p.x + p.y);
        }
    }
}
}