import java.util.HashMap;
public class hydro{
    public static void main(String[] args) throws InterruptedException{
        HashMap<String, commands>  map = new HashMap<>();

        // cmd name, obj of the class
        map.put("time", new displayTime());
        map.put("matrix", new Matrix());

        commands obj = map.get(args[0]);
        obj.execute();
    }
}