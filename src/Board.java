//    ______      __    __    __
//   / ____/___  / /_  / /_  / /__
//  / /   / __ \/ __ \/ __ \/ / _ \
// / /___/ /_/ / /_/ / /_/ / /  __/
// \____/\____/_.___/_.___/_/\___/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.awt.Point;

class Board {
    
    private static int[][] board;

    //contient les configurations possibles à jouer à partir d’une configuration
    //remplie par la fonction minmax
    List<PointsAndScores> successeursScores;

    public Board() {

        //tableau de jeu
        board = new int[3][3];
    }

    //affiche le plateau de jeu
    public void displayBoard(){
        System.out.println(" ");
        for(int i = 0 ; i < board.length ; i++){
            
            System.out.print("|");      
            for(int j = 0 ; j < board.length; j++){   
                if(board[i][j]==1)
                {
                    System.out.print("X");
                }
                else if(board[i][j]==2)
                {
                    System.out.print("0");
                }
                else 
                {
                    System.out.print("_");
                }
                System.out.print("|"); 
                
            }

            System.out.println(" ");
        }
        System.out.println(" ");

    }

    //met dans le plateau à la case point, le symbole
    //pour le joueur : player=1 pour X, player=2 pour O
    public void placeAMove(Point point, int player) throws ApplicationException,IntException{
        
        int x=(int) point.getX();
        int y=(int) point.getY();

        if (board[x][y]==0)
        {
            if(player==1){
                board[x][y]=1;
            }
            else if(player==2) {
                board[x][y]=2;
            }
        }
        else{
            // System.out.println("");
            // System.out.println("");
            // System.out.println("");
            // System.out.println("This case is not empty !");
            // System.out.println("");
            // takeHumanInput(player);
        }
    }

    //Invite l’utilisateur de saisir au clavier
    //les coordonnées d’un point (i,j)
    //et place le mouvement sur le plateau pour le joueur passé en paramètre.
    void takeHumanInput(int player) throws ApplicationException, IntException
    {
        int x= 0;
        int y= 0;

        Scanner scanX = new Scanner(System.in);
        System.out.println("Please enter the coord X:");
        try{
            x = scanX.nextInt();
            if(x>-1 && x<3)
            {
                x=x;
            }
            else {
                throw new ApplicationException("e");
            }
        }   
        catch(InputMismatchException i){
            throw new IntException("e");
        }

        System.out.println("Please enter the coord Y:");
        try{
            y = scanX.nextInt();
            if(y>-1 && y<3)
            {
                y = y;
            }
            else {
                throw new ApplicationException("e");
            }
        }
        catch(InputMismatchException i){
            throw new IntException("e");
            
        }

        if (player==1)
        {
            Point tempPoint = new Point(x,y);
            placeAMove(tempPoint,1);
        }
        else if (player==2)
        {
            Point tempPoint = new Point(x,y);
            placeAMove(tempPoint,2);
        }
        else 
        {
            throw new ApplicationException("e");
        }

    }
    
    // retourne la liste des cases vides du plateau
    public List<Point> getAvailablePoints(){
        ArrayList<Point> LP = new ArrayList<Point>();
        for(int i = 0 ; i < board.length ; i++){ 
            for(int j = 0 ; j < board.length; j++){  
                if(board[i][j]==0){
                    Point tempPoint = new Point(i,j);
                    LP.add(tempPoint);
                }
            }
        }
        return LP;
    }

    // vérifie si X a fait l’une des 2 diagonales ou une ligne ou une colonne
    public boolean hasXWon()
    {
        boolean t= false;

        if (board[0][0]==1 && board[0][1]==1 && board[0][2]==1)
        {
            t=true;
        }
        if (board[1][0]==1 && board[1][1]==1 && board[1][2]==1)
        {
            t=true;
        }
        if (board[2][0]==1 && board[2][1]==1 && board[2][2]==1)
        {
            t=true;
        }
        if (board[0][0]==1 && board[1][0]==1 && board[2][0]==1)
        {
            t=true;
        }
        if (board[0][1]==1 && board[1][1]==1 && board[2][1]==1)
        {
            t=true;
        }
        if (board[0][2]==1 && board[1][2]==1 && board[2][2]==1)
        {
            t=true;
        }

        if (board[0][0]==1 && board[1][1]==1 && board[2][2]==1)
        {
            t=true;
        }
        if (board[0][2]==1 && board[1][1]==1 && board[2][0]==1)
        {
            t=true;
        }
        return t;
        
    }

    // // vérifie si O a fait l’une des 2 diagonales ou une ligne ou une colonne
    public boolean hasOWon()
    {
        boolean t= false;

        if (board[0][0]==2 && board[0][1]==2 && board[0][2]==2)
        {
            t=true;
        }
        if (board[1][0]==2 && board[1][1]==2 && board[1][2]==2)
        {
            t=true;
        }
        if (board[2][0]==2 && board[2][1]==2 && board[2][2]==2)
        {
            t=true;
        }
        if (board[0][0]==2 && board[1][0]==2 && board[2][0]==2)
        {
            t=true;
        }
        if (board[0][1]==2 && board[1][1]==2 && board[2][1]==2)
        {
            t=true;
        }
        if (board[0][2]==2 && board[1][2]==2 && board[2][2]==2)
        {
            t=true;
        }

        if (board[0][0]==2 && board[1][1]==2 && board[2][2]==2)
        {
            t=true;
        }
        if (board[0][2]==2 && board[1][1]==2 && board[2][0]==2)
        {
            t=true;
        }
        return t;
        
    }
    
    // vérifie si le jeu est fini (quelqu’un a gagné OU le tableau est plein (égalité))
    public boolean isGameOver(){
        
        return hasXWon() || hasOWon() || getAvailablePoints().size()==0;
    }

    //retourne le point avec le score le plus élevé de la liste des successeurs
    public Point returnBestMove()
    {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        
        for (int i = 0; i < successeursScores.size(); i++)
        {
            if (successeursScores.get(i).getScore()>max)
            {
                max=successeursScores.get(i).getScore();
                temp = i;
            }
        }
        return successeursScores.get(temp).getPoint();
    }

    //Permet d’appeler la fonction minmax après avoir initialisé la liste des successeurs.
    public void callMinimax(int depth, int turn){
        successeursScores = new ArrayList<PointsAndScores>();
        int res = minimax (depth, turn);
    }

    /** Fonction minmax recurssive à partir du niveau (depth)
    * pour n’importe quel joueur (turn).
    * turn=1 : joueur qui maximise; turn=2 : joueur qui minimise
    * @return le meilleur score */
    public int minimax(int depth, int turn)
    {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        List<Point> listPoint = getAvailablePoints();

        if (hasXWon())
        {
            return 1;
        }
        if (hasOWon())
        {
            return -1;
        }
        if (listPoint.isEmpty())
        {
            return 0;
        }   

        if (turn == 1 ) // X sélectionne le MAX des scores
        {
            for (Point p: listPoint)
            {
                try{
                    placeAMove(p, 1);
                    int currentScore = minimax(depth + 1 , 2);
                    if (max < currentScore) 
                        {
                            max = currentScore;
                        }
                    if (depth == 0) // on garde le premier "étage" de l’arbre du jeux
                    {
                        successeursScores.add(new PointsAndScores(currentScore, p));
                    }
                    board[p.x][p.y] = 0;
                }
                catch (Exception e)
                {
                }
            }
        }
        if (turn == 2 ) // O sélectionne le MIN des scores
        {
            for (Point p: listPoint)
            {
                try{
                    placeAMove(p, 2);
                    int currentScore = minimax(depth + 1 , 1);
                    if (min > currentScore) min = currentScore;
                    board[p.x][p.y] = 0;
                }
                catch (Exception e)
                {   
                }
            }
        }
        return turn == 1 ? max : min;
    }
}
