package com.miprimerbot;

import com.miprimerbot.commands.responder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.security.auth.login.LoginException;

import static java.lang.Thread.sleep;

public class Main {
    /*Declaramos el JDA y el JDABuilder importados desde net.dv8tion,
     que es la dependencia que le dimos en el XML*/
    public static JDA JdaEjemplo;
    public static JDABuilder builderEjemplo;

    public static void main(String[] args) {
        /*Creamos un token por defecto y se lo asignamos a builderEjemplo*/
        builderEjemplo = JDABuilder.createDefault("MTAzMTY5OTYzNDA1MTA4ODQwNA.GA3Wu5.T2PRS_HRyYHTuGH4WZl-AjWAO2_OGHQeBv69iA")
                .addEventListeners(new responder());

        /*Le damos un estado al bot, en este caso INACTIVO y le damos una actividad (cualquiera)*/
        builderEjemplo.setStatus(OnlineStatus.IDLE).setActivity(Activity.competing("Esto es un ejemplo"));

        /*Ahora lo que hacemos es asignarle el builderEjemplo al JDA que tenemos, le
        añadimos la función build() y capturamos la excepción*/
        try {
            JdaEjemplo = builderEjemplo.build();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        /*sleep se usa para definir el tiempo que tarda el bot en agregar a todos los usuarios y servidores en su base
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /*getGuildByID (ID DEL SERVIDOR DE DISCORD)----upsertCommand(Nombre del comando, descripción del comando)
        JdaEjemplo.getGuildById("902856361526825000").upsertCommand("responder", "Responde a tu slash")
                .addOption(OptionType.STRING, "tipo", "Tipo de respuesta", true).queue();*/
    }
}