import java.util.Random;
/*
ANSI Codes and their meaning
/033[%d;%dH , x, y means that cursor is now at (x,y) in the terminal
/033[2j means clear the screen
*/

public class Matrix implements commands{
    @Override
    //creates the matrix rain
    public void execute() throws InterruptedException{
        int width = 100;
        int height = 50;
        int len = 10;

        int yPos[] = new int[width];
        int speed[] = new int[width];
        int count[] = new int[width];

        Random rand = new Random();

        for(int i = 0; i < width; i++){
            yPos[i] = rand.nextInt(height);
            speed[i] = rand.nextInt(10);
            count[i] = 0;
        }

        System.out.print("\033[2J\033[H");
        System.out.flush();

        while(true){
            for(int i = 0; i < yPos.length; i++){
                int y = yPos[i];
                int x = i + 1;

                if(count[i] >= speed[i]){

                    //clean the trail
                    int clean = y - len;
                    if(clean >= 0 && clean <= height)
                        System.out.printf("\033[%d;%dH ", y, x);

                    //print green char
                    if(y >= 0 && y <= height){
                        System.out.printf("\033[%d;%dH", y, x);
                        System.out.printf("\033[32m%c", rand.nextInt(26) + 'a');
                    }

                    //print white char
                    x++;
                    if(y >= 0 && y <= height){
                        System.out.printf("\033[%d;%dH", y, x);
                        System.out.printf("\033[1;37m%c", rand.nextInt(26) + 'a');
                    }

                    //reset back to 0
                    if(y - len >= height)
                        y = 0;
                }
                else
                    count[i]++;
            }

            System.out.flush();
            Thread.sleep(20);
        }
    }
}
