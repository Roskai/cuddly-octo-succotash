public class Serveur {

    public static boolean changeLampadaireState(int hour, int brightness, boolean presence) {

        boolean state; 

        if (hour >= 20 && hour < 23 || hour <7 && hour > 5 || (presence && (hour >=23 || hour <= 5))){
            state = true; 
        }else{
            state = false; 
        }
        return state; 
    }


}