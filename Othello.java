import java.util.Scanner;

public class Othello {
    
    public static void main(String[] args){
        
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter player 1 name : ");
        String name1 = sc.nextLine();
        System.out.println("Enter player 1 sign : ");
        char sign1 = sc.nextLine().charAt(0);

        System.out.println("Enter player 2 name : ");
        String name2 = sc.nextLine();
        System.out.println("Enter player 2 sign : ");
        char sign2 = sc.nextLine().charAt(0);

        User user1 = new User(name1,sign1);
        User user2 = new User(name2,sign2);

        Board board = new Board(sign1,sign2);

        System.out.println("\nGame starts!!\n");

        boolean player = true;
        board.printBoard();

        while(true){
            if(player){
                System.out.println("\n"+ user1.getName()+" your Sign is "+user1.getColor());
                System.out.println("Enter x coordinate "+user1.getName()+" : ");
                int x = 0;
                int y = 0;

                try{
                    x = sc.nextInt();
                }catch(Exception e){
                    System.out.println("Invalid Input! Try Again");
                    continue;
                }
                finally{
                    sc.nextLine();
                }

                System.out.println("Enter y coordinate "+user1.getName()+" : ");

                try{
                    y = sc.nextInt();
                }catch(Exception e){
                    System.out.println("Invalid Input! Try Again");
                    continue;
                }
                finally{
                    sc.nextLine();
                }

                int curr = board.move(user1,user2,x,y);
                if(curr==-1){
                    System.out.println("Do you want to Pass (Y/N): ");
                    char pass = sc.next().charAt(0);
                    if(pass=='Y' || pass=='y')
                        player = false;
                    continue;
                }
                
                if(curr==2)
                    break;
                
                player = false;
            }
            else{
                System.out.println("\n"+ user2.getName()+" your Sign is "+user2.getColor());
                System.out.println("Enter x coordinate "+user2.getName()+" : ");
                int x = 0;
                int y = 0;
                try{
                    x = sc.nextInt();
                }catch(Exception e){
                    System.out.println("Invalid Input! Try Again");
                    continue;
                }
                finally{
                    sc.nextLine();
                }
                System.out.println("Enter y coordinate "+user2.getName()+" : ");
                try{
                    y = sc.nextInt();
                }catch(Exception e){
                    System.out.println("Invalid Input! Try Again");
                    continue;
                }
                finally{
                    sc.nextLine();
                }
                int curr = board.move(user2,user1,x,y);
                if(curr==-1){
                    System.out.println("Do you want to Pass (Y/N): ");
                    char pass = sc.next().charAt(0);
                    if(pass=='Y' || pass=='y')
                        player = false;
                    continue;
                }
                if(curr==2)
                    break;
                
                player = true;
            }
        }

    }
}
