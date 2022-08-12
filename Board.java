public class Board {
    
    private char board[][] ;
    char player1;
    char player2;

    Board(){}

    Board(char a,char b){
        board = new char[8][8];
        player1 = a;
        player2 = b;
        board[3][4] = b;
        board[4][3] = b;
        board[3][3] = a;
        board[4][4] = a;
    }

    //return 0 if valid move, -1 if invalid, 2 if game over 
	public int move(User player,User player2, int x, int y){
		
        char symbol = player.getColor();
        
        if(!isValid(x,y)){
            System.out.println("\n Invalid Move \n");
            return -1;
        }
        
        int count = 0;
        
        int a = x - 1;
        int b = y - 1;
        // Upper Left move
        while(a>=0 && b>=0){
            if(board[a][b]==symbol){
                a = x - 1;
                b = y - 1;

                while(a>=0 && b>=0){
                    if(board[a][b]==symbol || board[a][b]==0){
                        break;
                    }
                    else{
                        count++;
                        board[a][b] = symbol;
                    }
                    a--;
                    b--;
                }
                break;
            }
            if(board[a][b]==0){
                break;
            }
            a--;
            b--;
        }
        //Upper Move
        a = x-1;
        b = y;
        while(a>=0){
            if(board[a][b]==symbol){
                a = x-1;
                b = y;
                while(a>=0 && b>=0){
                    if(board[a][b]==symbol || board[a][b]==0){
                        break;
                    }
                    else{
                        count++;
                        board[a][b] = symbol;
                    }
                    a--;
                }
                break;
            }
            if(board[a][b]==0){
                break;
            }
            a--;
        }
        //Upper Right
        a = x - 1;
        b = y + 1;
        while(a>=0 && b<8){
            if(board[a][b]==symbol){
                a = x - 1;
                b = y + 1;
                while(a>=0 && b<8){
                    if(board[a][b]==symbol || board[a][b]==0){
                        break;
                    }
                    else{
                        count++;
                        board[a][b] = symbol;
                    }
                    a--;
                    b++;
                }
                break;
            }
            if(board[a][b]==0){
                break;
            }
            a--;
            b++;
        }
        //Right Move
        a = x ;
        b = y + 1;
        while(b<8){
            if(board[a][b]==symbol){
                a = x ;
                b = y + 1;
                while(b<8){
                    if(board[a][b]==symbol || board[a][b]==0){
                        break;
                    }
                    else{
                        count++;
                        board[a][b] = symbol;
                    }
                    b++;
                }
                break;
            }
            if(board[a][b]==0){
                break;
            }
            b++;
        }
        //Bottom Right
        a = x + 1;
        b = y + 1;
        while(a<8 && b<8){
            if(board[a][b]==symbol){
                a = x + 1;
                b = y + 1;
                while(a<8 && b<8){
                    if(board[a][b]==symbol || board[a][b]==0){
                        break;
                    }
                    else{
                        count++;
                        board[a][b] = symbol;
                    }
                    a++;
                    b++;
                }
                break;
            }
            if(board[a][b]==0){
                break;
            }
            a++;
            b++;
        }
        //Bottom Move
        a = x + 1;
        b = y;
        while(a<8){
            if(board[a][b]==symbol){
                a = x + 1;
                b = y;
                while(a<8){
                    if(board[a][b]==symbol || board[a][b]==0){
                        break;
                    }
                    else{
                        count++;
                        board[a][b] = symbol;
                    }
                    a++;
                }
                break;
            }
            if(board[a][b]==0){
                break;
            }
            a++;
        }
        //Bottom Left Move
        a = x + 1;
        b = y - 1;
        while(a<8 && b>=0){
            if(board[a][b]==symbol){
                a = x + 1;
                b = y - 1;
                while(a<8 && b>=0){
                    if(board[a][b]==symbol || board[a][b]==0){
                        break;
                    }
                    else{
                        count++;
                        board[a][b] = symbol;
                    }
                    a++;
                    b--;
                }
                break;
            }
            if(board[a][b]==0){
                break;
            }
            a++;
            b--;
        }
        //Left Move
        a = x ;
        b = y - 1;
        while(b>=0){
            if(board[a][b]==symbol){
                a = x ;
                b = y - 1;
                while(b>=0){
                    if(board[a][b]==symbol || board[a][b]==0){
                        break;
                    }
                    else{
                        count++;
                        board[a][b] = symbol;
                    }
                    b--;
                }
                break;
            }
            if(board[a][b]==0){
                break;
            }
            b--;
        }
        
        if(count>0){
            board[x][y] = symbol;
            printBoard();
            if(printPlayerScore(player,player2))
                return 0;
            else
                return 2;
        }        
        
        System.out.println("\n Invalid move! \n");
        return -1;
	}
    
    public boolean isValid(int x,int y){
        if(x<0 || y<0 || x>7 || y>7 || board[x][y]!=0)
            return false;
        return true;
    }
    
    public void printBoard(){
        System.out.println("---------------------------");

        System.out.print(" ");
        for(int i=0;i<8;i++){
            System.out.print(" "+i+" ");
        }

        System.out.println();

        for(int i=0;i<8;i++){
            System.out.print(i+"");
            for(int j=0;j<8;j++){
                if((int)board[i][j]!=0)
                    System.out.print(" " + board[i][j] + " " );
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    public boolean printPlayerScore(User curr,User second){
        int score1 = 0;
        int score2 = 0;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

                if(player1==board[i][j])
                    score1++;

                if(player2==board[i][j])
                    score2++;

            }
        }

        if(score1+score2==64){
            System.out.print("Game Over !!");
            if(score1>score2){
                System.out.println((player1==curr.getColor()?curr.getName():second.getName()+"'s Won the game with score "+score1));
            }
            else if(score2>score1){
                System.out.println((player2==curr.getColor()?curr.getName():second.getName()+"'s Won the game with score "+score2));
            }
            else{
                System.out.println("Game Draw !! Try another one");
            }

            return false;
        }
        else{
            System.out.println(curr.getName()+"'s score is "+((curr.getColor()==player1)?score1:score2));
            System.out.println(second.getName()+"'s score is "+((second.getColor()==player1)?score1:score2));
        }
        System.out.println();
        return true;
    }
}
