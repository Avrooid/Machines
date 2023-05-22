package ru.Burakov.Machines.dao;

import ru.Burakov.Machines.models.messages.MessageModelRabbit;

public interface RabbitProducerService {
    String send(String message);
}
