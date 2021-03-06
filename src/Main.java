//    ______      __    __    __
//   / ____/___  / /_  / /_  / /__
//  / /   / __ \/ __ \/ __ \/ / _ \
// / /___/ /_/ / /_/ / /_/ / /  __/
// \____/\____/_.___/_.___/_/\___/

public class Main {

    public static void main(String[] args) throws ApplicationException, IntException {
        Board b = new Board();
        b.displayBoard();
        while(b.isGameOver()==false)
        {
            System.out.println("Turn P1");
            b.takeHumanInput(2);
            if(b.isGameOver()==false)
            {
                System.out.println("Turn IA");
                b.callMinimax(0, 1);
                b.placeAMove(b.returnBestMove(), 1);
                b.displayBoard();
            }
        }
        b.displayBoard();
        System.out.println("FINI");

    }
}
