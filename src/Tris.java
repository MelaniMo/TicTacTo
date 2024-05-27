import javax.sound.midi.Soundbank;

public class Tris {
    private int player, win, nMoves;
    private int d1,d2;
    private int [][] gameBoard;
    private int[] rowVal;
    private int[] columnVal;
    private int r,c;
    private boolean end;
    private static final int Dim=3;
    private GlobalVar var;
    private Win w;

    public Tris(char first){
        if (first == 'X')
            player=1;
        else
            player=10;

        gameBoard=new int[Dim][Dim];
        rowVal=new int[Dim];
        columnVal=new int[Dim];
        newGame();
    }
    private void newGame(){
        win=0;
        nMoves=0;
        end=false;
        for(r=0; r<Dim; r++)
            for(c=0; c<Dim;c++)
                gameBoard[r][c]=0;
        for(int x=0; x<Dim; x++) {
            rowVal  [x]=0;
            columnVal[x]=0;
        }
        d1=0; d2=0;
    }

    public void play(int r, int c){
        System.out.println("Inizio turno");
        gameBoard[r][c]=player;
        rowVal[r]+=player;
        columnVal[c]+=player;
        if (r==c)
            d1+=player;
        if (r==Dim-c-1)
            d2+=player;

        changePla();
        nMoves++;
        if (nMoves == Dim*Dim)
            end=true;
        checkWin();
    }

    private void checkWin() {
        win=0;
        if (d1 == Dim*1) win=1;
        if (d2 == Dim*1) win=1;
        if (d1 == Dim*10) win=10;
        if (d2 == Dim*10) win=10;
        for(int x=0; x<Dim; x++) {
            if(rowVal[x]   == Dim*1 ) win=1;
            if(rowVal[x]   == Dim*10) win=10;
            if(columnVal[x] == Dim*1)  win=1;
            if(columnVal[x] == Dim*10) win=10;
        }
        if(win !=0){
            if (win == 1){
                var.winner='X';
            }
            else if (win == 10){
                var.winner='O';
            }
            var.nPlay++;
            end=true;
            w=new Win();
        }
    }

    private void changePla(){
        if (player == 1)
            player=10;
        else if (player == 10)
            player=1;
    }

    public String  getWin() {
        if (win == 1)
            return "'X' player wins!";
        else if (win == 10)
            return "'O' player wins!";

        return "It's a tie";
    }
}
