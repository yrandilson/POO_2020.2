import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Controller controller = new Controller();
        while (true) {
            System.out.println("Type 'end'\n'SendTweet' - name - msg\n'addUser' - name\n'getUser' - name");
            System.out.println("'follow' - Name Follower - Name Following\n'Unfollow'- Name Follower - Name Following");
            System.out.println("'like' - name - idTw(int)\n'unread' - username\n'timeline' - name");
            String escolha = scan.nextLine();
            String[] brok = escolha.split(" ");

            try {
                if (brok[0].equalsIgnoreCase("end"))
                    break;

                else if (brok[0].equalsIgnoreCase("SendTweet")) {
                    StringBuilder solver = new StringBuilder();
                    for (int i = 2; i < brok.length; i++)
                        solver.append(brok[i]).append(" ");
                    controller.sendTweet(brok[1], solver.toString());
                }

                else if (brok[0].equalsIgnoreCase("addUser"))
                    controller.addUser(brok[1]);

                else if (brok[0].equalsIgnoreCase("getUser"))
                    controller.getUser(brok[1]);

                else if (brok[0].equalsIgnoreCase("follow"))
                    controller.follow(brok[1], brok[2]);

                else if (brok[0].equalsIgnoreCase("unfollow"))
                    controller.unfollow(brok[1], brok[2]);

                else if (brok[0].equalsIgnoreCase("like"))
                    controller.like(brok[1], Integer.parseInt(brok[2]));

                else if (brok[0].equalsIgnoreCase("unread"))
                    System.out.println(controller.unread(brok[1]));

                else if (brok[0].equalsIgnoreCase("timeline"))
                    System.out.println(controller.timeLine(brok[1]));

                else
                    System.out.println("Option invalidate");

            } catch (IndexOutOfBoundsException y) {
                System.out.println("Index invalido ai em alguma coisa");
            } catch (Exception z) {
                System.out.println(z.toString());
            }
        }
    }
}
