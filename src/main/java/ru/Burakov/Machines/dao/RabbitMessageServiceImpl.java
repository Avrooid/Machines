package ru.Burakov.Machines.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RabbitMessageServiceImpl implements RabbitProducerService{
    private final RabbitTemplate rabbitTemplate;


    @Override
    public String send(String message) {
        var temp = (byte[])rabbitTemplate.convertSendAndReceiveAsType("testExchange", "testRoutingKey",
                message, new ParameterizedTypeReference<byte[]>() { });
        String response = new String(temp);
        log.info(response);
        return response;
    }
}
