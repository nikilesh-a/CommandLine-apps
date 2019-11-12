import java.util.Scanner;

class TTT{
    static int [][] board = new int[3][3];
    static int row = 3;
    static int column = 3;
    static boolean winnerFlag;
    public static void main(String [] args)  {
        Scanner scan = new Scanner(System.in);

        System.out.printf("\t***** Welcome to Tic Tac Toe *****\n\n");
        System.out.println("Player 1, enter your name");
        String name1 = scan.nextLine();
        System.out.printf("Okay, %s your id will be %d .\n",name1, 1);

        System.out.println();

        System.out.println("Player 2, enter your name");
        String name2 = scan.nextLine();
        System.out.printf("Okay, %s your id will be %d .\n\n",name2, 2);

        Player user1 = new Player(name1,1);
        Player user2 = new Player(name2, 2);

        printBoard(); //displaying board to user
        boolean flag = startGame(user1);

        while(!flag) {
                startGame(user2);
              flag =  startGame(user1);
        }
        if(winnerFlag)
        {
            System.out.println("Game over.");
        }
        else
        System.out.println("Game over. It's a draw match");
    }

    static boolean startGame(Player user) {

        int [] pos ;
        pos =readPosition(user); //reading user position choice
        user.row = pos[0];
        user.column = pos[1];

        setPosition(user); //setting user choice in board

        printBoard(); //displaying board to user

        return isGameOver(user);


    }

    static int[] readPosition(Player user)  { //for reading user input for placing the user id
        int rowIndex, columnIndex;
        Scanner scan = new Scanner(System.in);
        System.out.printf("Hey %s, choose your row and column to place the id :\n",user.name);
        rowIndex = scan.nextInt()  ;
        columnIndex = scan.nextInt();
        int [] a = {rowIndex, columnIndex};
        return a;
    }

     static private void setPosition(Player user){ // for setting the symbol at selected index position
       if(board[user.row][user.column] == 0)
            board[user.row][user.column] = user.id;
       else {
           System.out.println("That place is occupied");
           readPosition(user);
       }
     }


     static private void printBoard(){ // for printing current board status
         for(int i =0; i<row; i++){
             for(int j=0; j<column; j++){
                 System.out.print(board[i][j]+" ");
             }
             System.out.println();
         }
     }
     static private boolean isGameOver(Player user) { //checking whether game over
           winnerFlag =  isWinner(user); //calling iswinner fn to see any user wins the game
           if(! winnerFlag ) {
               for (int i = 0; i < row; i++) {
                   for (int j = 0; j < column; j++) {

                       if (board[i][j] == 0)
                           return false;
                       else {
                           continue;
                       }
                   }
               }
           }
           return true;
     }

     static boolean isWinner(Player user){ //checks whether the user has won the game 
        winnerFlag = false;
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++)
            {
                if(     board[0][0]==user.id && board[0][1]==user.id && board[0][2]==user.id || /* 1st row */
                        board[1][0]==user.id && board[1][1]==user.id && board[2][2]==user.id || /* 2nd row */
                        board[2][0]==user.id && board[2][1]==user.id && board[2][2]==user.id || /* 3rd row */

                        board[0][0]==user.id && board[1][0]==user.id && board[2][0]==user.id || /* 1st column */
                        board[0][1]==user.id && board[1][1]==user.id && board[2][1]==user.id || /* 2nd column */
                        board[0][2]==user.id && board[1][2]==user.id && board[2][2]==user.id || /* 3rd column */

                        board[0][0]==user.id && board[1][1]==user.id  && board[2][2]==user.id || /* positive slope */
                        board[0][2]==user.id && board[1][1]==user.id  && board[2][0]==user.id /* negative slope */
                )
                {
                    winnerFlag = true;
                    break ;
                }
            }
        }
        if(winnerFlag)
         System.out.printf("Hurray!, %s won the match \n",user.name);

        return winnerFlag;
     }
}

class Player extends TTT{
    int row;
    int column;
    int id ;
    String name;
    Player(String name, int id){
        this.id = id;
        this.name = name;
    }
}
