import java.util.*;

public class Main {
    static ArrayList<Integer> userP =new ArrayList<Integer>();
    static ArrayList<Integer> spuP =new ArrayList<Integer>();
    public static  void main(String[] args) {

//        ex-7
        int ch;
        double ar;

        int length, breadth, height, diagonal1, diagonal2;
        int side;
        int radius;
try{
    Scanner sc = new Scanner(System.in);

    System.out.println("1: Right Angle Triangle");
    System.out.println("2: Area of Equilateral Triangle");
    System.out.println("3: Area of Square");
    System.out.println("4: Area of Rectangle");
    System.out.println("5: Area of Circle");
    System.out.println("6: Area of Rhombus");
    System.out.println("7: Program termination");




    lp:
    while (true) {
        System.out.print("Make your choice: ");
        ch = sc.nextInt();

        switch (ch) {
            case 1:
                System.out.print("Enter the height of Right Angle Triangle \n");
                height = sc.nextInt();
                System.out.print("Enter the base of Right Angle Triangle \n");
                breadth = sc.nextInt();
                ar = (height * breadth) / 2;
                System.out.println("Area of the Right Angle Triangle is " + ar + "\n\n");
                break;
            case 2:
                System.out.print("Enter the side of an Equilateral Triangle \n");
                side = sc.nextInt();
                ar = (side * side * Math.sqrt(3)) / 4;
                System.out.println("Area of the Equilateral Triangle is " + ar + "\n\n");
                break;
            case 3:
                System.out.print("Enter the side of a Square \n");
                side = sc.nextInt();
                ar = side * side;
                System.out.println("Area of the Square is " + ar + "\n\n");
                break;
            case 4:
                System.out.print("Enter the length of a Rectangle \n");
                length = sc.nextInt();
                System.out.print("Enter the breadth of the Rectangle \n");
                breadth = sc.nextInt();
                ar = length * breadth;
                System.out.println("Area of the Rectangle is " + ar + "\n\n");
                break;
            case 5:
                System.out.print("Enter the radius of a Circle \n");
                radius = sc.nextInt();
                ar = radius * radius * 22 / 7;
                System.out.println("Area of the Circle is " + ar + "\n\n");
                break;
            case 6:
                System.out.print("Enter the first diagonal of a Rhombus \n");
                diagonal1 = sc.nextInt();
                System.out.print("Enter the second diagonal of the Rhombus \n");
                diagonal2 = sc.nextInt();
                ar = diagonal1 * diagonal2 * 1 / 2;
                System.out.println("Area of the Rhombus is " + ar + "\n\n");
                break;

          case 7:
            throw new RuntimeException("Invalid choice! Please make a valid choice. ");


        }
    }
}
 catch (InputMismatchException e){
    System.out.println("enter only number");
      }

catch (RuntimeException e) {
    System.out.println(e.getMessage());
}

// project
        char [][] gameBoard = {
                {' ','|',' ','|',' '},
                {'_','+','_','+','_'},
                {' ','|',' ','|',' '},
                {'_','+','_','+','_'},
                {' ','|',' ','|',' '}

        };

        printGame(gameBoard);
        try {
            while (true){
                Scanner scan= new Scanner(System.in);
                System.out.println("enter the number (1-9): ");
                int posP=  scan.nextInt();
                System.out.println(posP);
                while (userP.contains(posP)|| spuP.contains(userP)){
                    System.out.println("position taken ");
                    posP =  scan.nextInt();

                }
                place(gameBoard ,posP,"Player");
                String  result=  cheickWinner();
                if(result.length()>0) {
                    System.out.println(result);
                    break;
                }
                Random spuNumber= new Random();
                int posS= spuNumber.nextInt(9)+1;

                while (userP.contains(posS)|| spuP.contains(posS)){
                    posS= spuNumber.nextInt(9)+1;
                }
                place(gameBoard ,posS,"cpu");

                printGame(gameBoard);

                result=  cheickWinner();
                if(result.length()>0) {
                    System.out.println(result);
                    break;
                }
//
            }
        }catch ( Exception e){
            System.out.println(e.getMessage());
        }




        ////////////////////////end class/////////////////
    }

    public static  void printGame(char[][] gameBoard){
        for(char[]row :gameBoard){
            for (char c:row){
                System.out.print(c);
            }
            System.out.println();
        }

    }
    public static  void place (char[][] gameBoard, int position,String user){
        char symble= ' ';
        if (user.equals("Player")){
            symble='x';
            userP.add(position);
        } else if (user.equals("cpu")) {
            spuP.add(position);
            symble='o';
        }
        try{switch (position){
            case 1:
                gameBoard [0][0]= symble;
                break;
            case 2:
                gameBoard [0][2]= symble;
                break;
            case 3:
                gameBoard [0][4]= symble;
                break;
            case 4:
                gameBoard [2][0]= symble;
                break;
            case 5:
                gameBoard [2][2]= symble;
                break;
            case 6:
                gameBoard [2][4]= symble;
                break;
            case 7:
                gameBoard [4][0]= symble;
                break;
            case 8:
                gameBoard [4][2]= symble;
                break;
            case 9:
                gameBoard [4][4]= symble;
                break;
            default:
                break;

        }}
        catch ( Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static String cheickWinner(){
        List topRaw= Arrays.asList(1,2,3);
        List midRaw= Arrays.asList(4,5,6);
        List botRaw= Arrays.asList(7,8,9);
        List leftCal= Arrays.asList(1,4,7);
        List midCal= Arrays.asList(2,5,8);
        List rigCal= Arrays.asList(3,6,9);
        List cross1= Arrays.asList(1,5,9);
        List cross2= Arrays.asList(7,5,3);
        List<List> wining = new ArrayList<List>();
        wining.add(topRaw);
        wining.add(midRaw);
        wining.add(botRaw);
        wining.add(leftCal);
        wining.add(midCal);
        wining.add(rigCal);
        wining.add(cross1);
        wining.add(cross2);
        for(List l :wining){
            if(userP.containsAll(l)){
                return "you won ";
            } else if (spuP.contains(l)) {
                return "spu wins ";
            } else if (userP.size()+spuP.size()==9) {
                return "stop ";
            }
        }


        return "";
    }


}

