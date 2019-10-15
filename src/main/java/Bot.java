import events.logEvent;
import events.raceChangeEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;


public class Bot {


    public static void main (String[] args) throws Exception{

        JDA jda = new JDABuilder("NTYxMDEyMDk1OTAzMDcyMjU3.XJ___A.UGiSVgz12p-v_wWchCtEF1ZVLms").build();


        System.out.println();
        jda.addEventListener(new logEvent()); //make sure to import the event "import events.eventName;"
        jda.addEventListener(new raceChangeEvent());





    }




}
