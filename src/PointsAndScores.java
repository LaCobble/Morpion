import java.awt.Point;

public class PointsAndScores{

    private Point point;
    private int score;

    public PointsAndScores(int score, Point point){
        this.score=score;
        this.point=point;
    }

    public int getScore(){
        return score;
    }

    public Point getPoint(){
        return point;
    }
}
