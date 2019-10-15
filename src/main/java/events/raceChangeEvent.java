package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Random;

import java.util.concurrent.TimeUnit;

public class raceChangeEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

       // System.out.println("message");

        String[] parse = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getAsMention();



        if(parse.length==1){

            if(parse[0].equalsIgnoreCase("/clearRace")){
                event.getGuild().getController().removeRolesFromMember(event.getMember(),(event.getJDA().getRoleById(560983124654161933L)),
                        (event.getJDA().getRoleById(560983121756160004L)),
                        (event.getJDA().getRoleById(560983121080745995L)),
                        (event.getJDA().getRoleById(560983122490032128L)),
                        (event.getJDA().getRoleById(560983122942885889L)),
                        (event.getJDA().getRoleById(560983123668762634L)),
                        (event.getJDA().getRoleById(633131175551959070L)),
                        (event.getJDA().getRoleById(560983124243382273L))).complete();

            }






        }


        if(parse.length>=2) {





            if((parse[0].equalsIgnoreCase("/dice"))){

                int sides = Integer.parseInt(parse[1]);

                Random rand = new Random();
                int Res = rand.nextInt(sides)+1;
                if (sides<4){
                    event.getChannel().sendMessage(event.getMember().getUser().getAsMention()+" Somehow rolled a "+sides+" sided die, and the result was: "+Res).queue();
                } else {

                    event.getChannel().sendMessage(event.getMember().getUser().getAsMention() + " Rolled a " + sides + " sided die, and the result was: " + Res).queue();
                }
            }



            if((parse[0]).equalsIgnoreCase("/setrace"))
                event.getChannel().sendMessage(" Did you mean '/changeRace'?").queue();
        //unused except for personal RP server
            if ((parse[0]).equalsIgnoreCase("/changeRace")) {
                //System.out.println("changeRace detected");
                String race = parse[1];





                if(race.equalsIgnoreCase("human")||
                        (race.equalsIgnoreCase("nekojin"))||
                        (race.equalsIgnoreCase("ookamijin"))||
                        (race.equalsIgnoreCase("inujin"))||
                        (race.equalsIgnoreCase("werewolf"))||
                        (race.equalsIgnoreCase("vampire"))||
                        (race.equalsIgnoreCase("elf"))||
                        (race.equalsIgnoreCase("laruauri"))||
                        (race.equalsIgnoreCase("none"))){



                    System.out.println("raceExists");
                    long roleID=0l;
                    for(int i=0;i<2;i++) {


                        //event.getGuild().getController().removeRolesFromMember()
                        event.getGuild().getController().removeRolesFromMember(event.getMember(),(event.getJDA().getRoleById(560983124654161933L)),
                                (event.getJDA().getRoleById(560983121756160004L)),
                                (event.getJDA().getRoleById(560983121080745995L)),
                                (event.getJDA().getRoleById(560983122490032128L)),
                                (event.getJDA().getRoleById(560983122942885889L)),
                                (event.getJDA().getRoleById(560983123668762634L)),
                                (event.getJDA().getRoleById(633131175551959070L)),
                                (event.getJDA().getRoleById(560983124243382273L))).complete();
                            //System.out.println(i);


                        /*
                        event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getJDA().getRoleById((560983124654161933L))).complete();
                        event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getJDA().getRoleById((560983121756160004L))).complete();
                        event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getJDA().getRoleById((560983121080745995L))).complete();
                        event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getJDA().getRoleById((560983122490032128L))).complete();
                        event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getJDA().getRoleById((560983122942885889L))).complete();
                        event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getJDA().getRoleById((560983123668762634L))).complete();
                        event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getJDA().getRoleById((560983124243382273L))).complete();

                         */

                    }

                    if(race.equalsIgnoreCase("laruauri")) {
                        roleID = 633131175551959070L;
                    }

                    if(race.equalsIgnoreCase("human")) {
                        roleID = 560983124654161933L;
                    }
                    if(race.equalsIgnoreCase("nekojin")) {
                        roleID = 560983124243382273L;
                    }
                    if(race.equalsIgnoreCase("ookamijin")) {
                        //roleID = 560983123668762634L;
                        event.getChannel().sendMessage(race + " has not been released yet, thank you for your patience. (Your race has been set to human)").queue();
                        roleID = 560983124654161933L;
                    }
                    if(race.equalsIgnoreCase("inujin")) {
                        roleID = 560983122942885889L;
                    }
                    if(race.equalsIgnoreCase("werewolf")) {
                        //roleID = 560983122490032128L;
                        event.getChannel().sendMessage(race + " has not been released yet, thank you for your patience. (Your race has been set to human)").queue();
                        roleID = 560983124654161933L;
                    }
                    if(race.equalsIgnoreCase("vampire")) {
                        //roleID = 560983121756160004L;
                        event.getChannel().sendMessage(race + " has not been released yet, thank you for your patience. (Your race has been set to human)").queue();
                        roleID = 560983124654161933L;
                    }
                    if(race.equalsIgnoreCase("elf")) {
                        //roleID = 560983121080745995L;
                        event.getChannel().sendMessage(race + " has not been released yet, thank you for your patience. (Your race has been set to human)").queue();
                        roleID = 560983124654161933L;

                    }


                        //System.out.println(event.getMember() + ": " + race);
                        //event.getGuild().getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName(race, true)).queueAfter(5000, TimeUnit.MILLISECONDS);
                        event.getGuild().getController().addSingleRoleToMember(event.getMember(),event.getJDA().getRoleById(roleID)).queue();



                }else{
                    event.getChannel().sendMessage(race+" is not a valid race").queue();


                }


            }



        }








    }






    public String toString(String[] inputString){
        return ""+inputString;


    }


}
