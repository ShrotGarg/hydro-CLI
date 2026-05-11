import java.util.*;
public class displayTime implements commands{

    @Override
    //finds and then prints time
    public void execute(String[] args){
        Calendar obj = Calendar.getInstance();

        int hour = obj.get(Calendar.HOUR);
        int min = obj.get(Calendar.MINUTE);
        int sec = obj.get(Calendar.SECOND);

        int vals[] = {hour, -1, min, -1, sec};

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                int val = vals[j];

                if(val > -1 && val < 10){
                    print(0, i);
                    print(val, i);
                }
                else if(val == -1)
                    print(val, i);
                else{
                    print(val / 10, i);
                    print(val % 10, i);
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    //Array to print the actual time
    void print(int time, int i){
        String[] zero = {" __ ", "|  |", "|__|"};
        String[] one = {"    ", "   |", "   |"};
        String[] two = {" __ ", " __|", "|__ "};
        String[] three = {" __ ", " __|", " __|"};
        String[] four = {"    ", "|__|", "   |"};
        String[] five = {" __ ", "|__ ", " __|"};
        String[] six = {" __ ", "|__ ", "|__|"};
        String[] seven = {" __", "   |", "   |"};
        String[] eight = {" __ ", "|__|", "|__|"};
        String[] nine = {" __ ", "|__|", " __|"};
        String[] divider = {"   ", " : ", "   "};

        switch(time){
            case 0:
                System.out.print(zero[i]);
                break;
            case 1:
                System.out.print(one[i]);
                break;
            case 2:
                System.out.print(two[i]);
                break;
            case 3:
                System.out.print(three[i]);
                break;
            case 4:
                System.out.print(four[i]);
                break;
            case 5:
                System.out.print(five[i]);
                break;
            case 6:
                System.out.print(six[i]);
                break;
            case 7:
                System.out.print(seven[i]);
                break;
            case 8:
                System.out.print(eight[i]);
                break;
            case 9:
                System.out.print(nine[i]);
                break;
            default:
                System.out.print(divider[i]);
        }
    }
}