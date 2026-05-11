import java.util.HashMap;
import java.util.Random;
/*
ANSI Codes and their meaning
/033[%d;%dH , x, y means that cursor is now at (x,y) in the terminal
/033[2j means clear the screen
/033[?25l means hide curson
*/

public class Matrix implements commands{
    @Override
    //creates the matrix rain
    public void execute(String[] args) throws InterruptedException{

        String choices[] = {"5", "32m"};
        choices = flag(args);

        int width = 100;
        int height = 24;
        int len = 8;

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";

        int yPos[] = new int[width];
        int speed[] = new int[width];
        int count[] = new int[width];

        Random rand = new Random();

        for(int i = 0; i < width; i++){
            yPos[i] = rand.nextInt(height) + 1;
            speed[i] = rand.nextInt(Integer.parseInt(choices[0])) + 1;
            count[i] = 0;
        }

        //Clear + Hide cursor
        System.out.print("\033[2J\033[H");
        System.out.print("\033[25l");
        System.out.flush();

        while(true){
            for(int i = 0; i < yPos.length; i++){
                if(count[i] >= speed[i]){
                    int y = yPos[i];
                    int x = i + 1;

                    //erase
                    int clean = y - len;
                    if(clean > 0 && clean <= height)
                        System.out.printf("\033[%d;%dH ", clean, x);

                    //print green char
                    if(y > 0 && y <= height){
                        System.out.printf("\033[%d;%dH", y, x);
                        String color = "\033[0;" + choices[1] + "%c";
                        System.out.printf(color, chars.charAt(rand.nextInt(chars.length())));
                    }

                    int ny = y + 1;
                    //print white char
                    if(ny > 0 && ny <= height){
                        System.out.printf("\033[%d;%dH", ny, x);
                        System.out.printf("\033[1;37m%c", chars.charAt(rand.nextInt(chars.length())));
                    }

                    yPos[i]++;
                    count[i] = 0;

                    //reset back to 0
                    if(yPos[i] - len > height){
                        yPos[i] = 0;
                        speed[i] = rand.nextInt(5) + 1;
                    }

                    count[i] = 0;
                }
                else
                    count[i]++;
            }

            System.out.flush();
            Thread.sleep(20);
        }
    }

    //handles --speed and --color and both
    private String[] flag(String[] args){
        String ans[] = {"5", "32"};

        for(int i = 1; i < args.length; i++){
            char ch = args[i].charAt(2);

            if(Character.isDigit(ch))
                ans[0] = args[i].substring(2);
            else
                ans[1] = args[i].substring(2);
        }

        ans[1] = ttoc(ans[1]) + "m";

        return ans;
    }

    // --color to ANSI value
    private String ttoc(String str){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("black", 30);
        map.put("red", 31);
        map.put("green", 32);
        map.put("yellow", 33);
        map.put("blue", 34);
        map.put("magenta", 35);
        map.put("cyan", 36);

        return Integer.toString(map.getOrDefault(str, 32));
    }
}
