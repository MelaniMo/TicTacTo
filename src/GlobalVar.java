
public class GlobalVar {
    public static int player;
    public static int nPlay=1;
    public static char winner;

    public static char getcharPlayer(){
        if (player == 1)
            return 'X';
        else if (player == 2)
            return 'O';
        return 'X';
    }
    public static int getPlayer(char player){
        if (player == 'X')
            return 1;
        else if (player == 'O')
            return 2;
        return 1;
    }
}
