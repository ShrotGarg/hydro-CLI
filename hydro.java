import java.util.HashMap;
public class hydro{
    public static void main(String[] args){
        HashMap<String, commands>  map = new HashMap<>();

        map.put("time", new displayTime());
        commands obj = map.get(args[0]);
        obj.execute();
    }
}