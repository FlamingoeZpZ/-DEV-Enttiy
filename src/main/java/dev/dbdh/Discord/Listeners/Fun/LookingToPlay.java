package dev.dbdh.Discord.Listeners.Fun;

import dev.dbdh.Discord.Utilities.Color;
import dev.dbdh.Discord.Utilities.Data;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class LookingToPlay extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        Color color = new Color();
        Data data = new Data();
        EmbedBuilder eb = new EmbedBuilder();
        String[] xboxAliases = { "xbox", "xboxone", "xbone", "xb"};
        String[] ps4Aliases = {"playstation", "ps4", "ps", "playstation4"};
        String[] pcAliases = {"computer", "laptop", "desktop", "pc"};
        String[] mobileAliases = {"mobile", "phone", "tablet", "iphone", "android"};
        if(args[0].equalsIgnoreCase(data.getPrefix() + "match")){
            if(args.length < 2){
                eb.setDescription(event.getMember().getAsMention()  + " What platform are you looking for people to play with on?\n`XBOX | PS4 | PC | MOBILE`\n\n```\n" + data.getPrefix() + "match <platform> (voice channel)\n```\n\n```\n<> | REQUIRED\n () | OPTIONAL\n```");
                eb.setColor(color.errorRed);
                eb.setFooter("Entity Matchmaking Command Insufficient Arguments", data.getSelfAvatar(event));

                event.getChannel().sendMessage(eb.build()).queue((message) -> {
                    eb.clear();
                    message.delete().queueAfter(30, TimeUnit.SECONDS);
                });
            } else if(args.length == 2){
                if(Arrays.stream(xboxAliases).anyMatch(args[1]::equalsIgnoreCase)){
                    event.getChannel().sendMessage(event.getMember().getAsMention() + " is looking to play on Xbox " + event.getGuild().getRoleById("606527228074786851").getAsMention()).queue();
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("606527228074786851")).queue();
                } else if(Arrays.stream(ps4Aliases).anyMatch(args[1]::equalsIgnoreCase)){
                    event.getChannel().sendMessage(event.getMember().getAsMention() + " is looking to play on Playstation " + event.getGuild().getRoleById("606527283582468106").getAsMention()).queue();
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("606527283582468106")).queue();
                } else if(Arrays.stream(pcAliases).anyMatch(args[1]::equalsIgnoreCase)){
                    event.getChannel().sendMessage(event.getMember().getAsMention() + " is looking to play on PC " + event.getGuild().getRoleById("541091501908951041").getAsMention()).queue();
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("541091501908951041")).queue();
                } else if(Arrays.stream(mobileAliases).anyMatch(args[1]::equalsIgnoreCase)){
                    event.getChannel().sendMessage(event.getMember().getAsMention() + " is looking to play on Mobile " + event.getGuild().getRoleById("606531352690688035").getAsMention()).queue();
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("606531352690688035")).queue();
                } else if(args[1].equalsIgnoreCase("stop")){
                    event.getChannel().sendMessage("Stopped matchmaking").queue();
                    //XBOX
                    event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("606527228074786851")).queue();
                    //PS4
                    event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("606527283582468106")).queue();
                    //PC
                    event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("541091501908951041")).queue();
                    //Mobile
                    event.getGuild().removeRoleFromMember(event.getMember(),event.getGuild().getRoleById("606531352690688035") ).queue();

                }
            } else if(args.length == 3){
                String voiceChannel = Arrays.stream(args).skip(2).collect(Collectors.joining(" "));
                if(Arrays.stream(xboxAliases).anyMatch(args[1]::equalsIgnoreCase)){
                    event.getChannel().sendMessage(event.getMember().getAsMention() + " is looking to play on Xbox " + event.getGuild().getRoleById("606527228074786851").getAsMention() + "\nThey are in the voice channel " + event.getGuild().getVoiceChannelsByName(voiceChannel, true).get(0).getName()).queue();
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("606527228074786851")).queue();
                } else if(Arrays.stream(ps4Aliases).anyMatch(args[1]::equalsIgnoreCase)){
                    event.getChannel().sendMessage(event.getMember().getAsMention() + " is looking to play on Playstation " + event.getGuild().getRoleById("606527283582468106").getAsMention() + "\nThey are in the voice channel " + event.getGuild().getVoiceChannelsByName(voiceChannel, true).get(0).getName()).queue();
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("606527283582468106")).queue();
                } else if(Arrays.stream(pcAliases).anyMatch(args[1]::equalsIgnoreCase)){
                    event.getChannel().sendMessage(event.getMember().getAsMention() + " is looking to play on PC " + event.getGuild().getRoleById("541091501908951041").getAsMention() + "\nThey are in the voice channel " + event.getGuild().getVoiceChannelsByName(voiceChannel, true).get(0).getName()).queue();
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("541091501908951041")).queue();
                } else if(Arrays.stream(mobileAliases).anyMatch(args[1]::equalsIgnoreCase)){
                    event.getChannel().sendMessage(event.getMember().getAsMention() + " is looking to play on Mobile " + event.getGuild().getRoleById("606531352690688035").getAsMention() + "\nThey are in the voice channel " + event.getGuild().getVoiceChannelsByName(voiceChannel, true).get(0).getName()).queue();
                    event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("606531352690688035")).queue();
                } else if(args[1].equalsIgnoreCase("stop")){
                    event.getChannel().sendMessage("Stopped matchmaking").queue();
                    //XBOX
                    event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("606527228074786851")).queue();
                    //PS4
                    event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("606527283582468106")).queue();
                    //PC
                    event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById("541091501908951041")).queue();
                    //Mobile
                    event.getGuild().removeRoleFromMember(event.getMember(),event.getGuild().getRoleById("606531352690688035") ).queue();

                }
            }
        }
    }

}
