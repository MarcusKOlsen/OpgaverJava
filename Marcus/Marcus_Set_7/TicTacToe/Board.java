public class Board {
    private Player[] board;
    private Player nextPlayer;

    public Board() {
        this.board = new Player[9];
        this.nextPlayer = Player.X;
    }

    private Board(Board b) {
        Player[] new_temp = new Player[b.board.length];
        System.arraycopy(b.board, 0, new_temp, 0, b.board.length-1);
        this.board = new_temp;
        this.nextPlayer = b.nextPlayer;
    }


    public void print() {
        for(int i = 0; i < board.length; i++) {      
          if (board[i] != null) {
            System.out.print(board[i].name());
          } else {
            System.out.print(' ');
          }
          if (i % 3 < 2)
            System.out.print('|');
          else if (i < board.length - 1)
            System.out.println("\n-+-+-");
          else
            System.out.println(); 
        }
    }

    public boolean isFree (int square) {
        assert (square > 0 && square < 10);
        return (board[square-1] == null);
    }

    public Player nextPlayer() {
        return nextPlayer;
    }

    public boolean tied() {
        int free = 0;
        for(int i=0;i < board.length; i++)
          if (board[i] == null)
            free = free + 1; 
        return (free == 0) && !won();
    }

    public Board play (int square) {
        assert (square > 0 && square < 10);

        Board board_copy = new Board(this);

        board_copy.board[square-1] = board_copy.nextPlayer;
        if (board_copy.nextPlayer == Player.X) {
            board_copy.nextPlayer = Player.O;
        } else {
            board_copy.nextPlayer = Player.X;
        }

        return board_copy;

        // Return the clone
    }

    public boolean won() {
        Player player = (nextPlayer() == Player.X) ? Player.O : Player.X;
        boolean notWon = true;
        // check row and col wins
        int i = 0;
        while (notWon && i < 3) {
          notWon = !(wonRow(player, i) || wonCol(player, i));
          i = i + 1;
        }
        // check diagonal win (unless notWon is false)
        notWon = notWon && !wonDiagonal(player);
        // check anti-diagonal win  (unless notWon is false)
        notWon = notWon && !wonAntiDiagonal(player);
        return !notWon;
    }

    // auxiliary methods for won()
    private boolean wonRow(Player player, int row) {
        int i = 0;
        boolean won = true;
        while ( won && i < 3 ) {
            won = player == board[ row * 3 + i];
            i = i + 1;
        }
        return won;
    }

    private boolean wonCol(Player player, int col) {
        int i = 0;
        boolean won = true;
        while ( won && i < 3 ) {
            won = player == board[ i * 3 + col ];
            i = i + 1;
        }
        return won;
    }

    private boolean wonDiagonal(Player player) {
        int i = 0;
        boolean won = true;
        while ( won && i < 3 ) {
            won = player == board[ i * 3 + i];
            i = i + 1;
        }
        return won;
    }

    private boolean wonAntiDiagonal(Player player) {
        int i = 0;
        boolean won = true;
        while ( won && i < 3 ) {
            won = player == board[ i * 3 + 2 - i];
            i = i + 1;
        }
        return won;
    }
}
