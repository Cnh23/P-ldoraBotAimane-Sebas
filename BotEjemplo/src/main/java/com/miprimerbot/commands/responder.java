package com.miprimerbot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class responder extends ListenerAdapter {
    /* Creamos un evento para la interacción*/
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event){
        /*Si el nombre del evento es responder*/
        if(event.getName().equals("responder")){
            /*Y el tipo es embed entonces responderemos con un embed*/
            if(event.getOption("tipo").getAsString().equals("embed")){
                EmbedBuilder embed = new EmbedBuilder().setTitle("Titulo").setDescription("Desc").setColor(new Color(66, 236, 245));
                event.replyEmbeds(embed.build()).queue();
                /*Pero si el tipo es normal contestaremos con un mensaje "HOLA!"*/
            }else if(event.getOption("tipo").getAsString().equals("normal")){
                event.reply("HOLA!").queue();
            }
        }
    }
}
