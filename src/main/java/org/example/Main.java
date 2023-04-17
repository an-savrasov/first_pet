package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("5555");

        bot.setUpdatesListener(updates -> {
            for (int i = 0; i < updates.size(); i++) {
                Update update = updates.get(i);
                System.out.println(update.message().text());
                long chatId = update.message().chat().id();
                SendResponse response = bot.execute(new SendMessage(chatId, update.message().text()));
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });



    }
}