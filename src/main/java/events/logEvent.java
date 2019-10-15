package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Arrays;




import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class logEvent extends ListenerAdapter{


    //onGuildMessageReceived means any message displayed on discord server
        public void onGuildMessageReceived(GuildMessageReceivedEvent event) { //listener

                //System.out.println(event.getMember());
           // if (!event.getGuild().getMember().equals(("U:Elate(188124971623514112"))) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String log = "";


                String[] messageSent = event.getMessage().getContentRaw().split(" ");
                String name = event.getMember().getUser().getName(); //allows for @pings
                String namePing = toString(event.getMember().getUser().getAsMention());//allows for @pings

                //if (messageSent[0].equalsIgnoreCase("Hi")) {
                if (!event.getMember().getUser().isBot()) {
                    System.out.println();
                    System.out.println((date));
                    System.out.println("User: " + event.getMember());
                    System.out.println(event.getMember().getUser().getAsTag());
                    System.out.println(event.getChannel());
                    System.out.println("Message: " + Arrays.toString(messageSent));
                    System.out.println("Message Id: " + event.getMessageId());
                    System.out.println();
                    //System.out.println(event.getGuild().getTextChannelById(560981301302394890l));
                    // event.getGuild().getTextChannelById(560981301302394890l).sendMessage("test");


                    log = (("```Date: " + date + "\nUser+Server: " + event.getMember()) +
                            "\nUser tag: " + event.getMember().getUser().getAsTag() +
                            "\nChannel: " + event.getChannel() +
                            "\nMessage: " + Arrays.toString(messageSent) +
                            "\nMessage Id: " + event.getMessageId() + "```");
                    //System.out.println(event.getGuild());


                    if (event.getGuild().equals(event.getJDA().getGuildById(560821452488704010l))) {
                        event.getGuild().getTextChannelById(560981301302394890l).sendMessage(log).queue();
                    }
                    if (event.getGuild().equals(event.getJDA().getGuildById(492153391829614594l))) {
                        event.getGuild().getTextChannelById(633136455476314122l).sendMessage(log).queue();

                        //LOCAL LOGGING
                        try{
                            PrintWriter FW= new PrintWriter (new FileWriter("C:\\Users\\IoCalisto\\Desktop\\java discord bot\\OUTPUT_LOGS\\LOG_NerdSquad.txt",true));
                            FW.write(toDelimString(messageSent));
                            FW.close();
                            //FW.close();

                        }catch(Exception e){System.out.println(e);}




                    event.getJDA().getGuildById(199018516060438530l).getTextChannelById(561743295718359040l).sendMessage(log).queue();


                    if (event.getGuild().equals(560821452488704010l)) {

                        //event.getJDA().getGuildById(199018516060438530l).getTextChannelById(561743295718359040l).sendMessage(log).queue();
                    }


                    //event.getJDA().getGuildById(199018516060438530l).getTextChannelById(561743295718359040l)


                }


            }

       // }






    }





        public String toDelimString(String[] inputArr){

            String outputStr="";

            for(int i=0; i<inputArr.length;i++){
                outputStr=(outputStr+(inputArr[i]+" "));
            }
            return outputStr;
        }

        public String toString(Object obj){
            return(""+obj);


        }



}
