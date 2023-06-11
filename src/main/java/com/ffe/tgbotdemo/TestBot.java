package com.ffe.tgbotdemo;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TestBot extends TelegramLongPollingBot {
    protected TestBot(DefaultBotOptions options, String botToken) {
        super(options, botToken);
    }

    @SneakyThrows
    public static void main(String[] args) {
        TestBot testBot = new TestBot(new DefaultBotOptions(), "5985753187:AAGj9SMcggw87TcEriY6JLbkClWg0Zb9zg8");
//        testBot.execute(SendMessage.
//                builder()
//                .chatId("160856907")
//                .text("Hello World from Intellij")
//                .build());

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(testBot);
    }

    @Override
    public String getBotUsername() {
        return "@FootballForEveryoneBot";
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                execute(SendMessage
                        .builder()
                        .chatId(message
                                .getChatId())
                        .text("Hello World from Intellij-1")
                        .build());
            }
        }
    }
}
