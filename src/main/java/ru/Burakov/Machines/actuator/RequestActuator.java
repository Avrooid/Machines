package ru.Burakov.Machines.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class RequestActuator {
    private final MeterRegistry meterRegistry;
    private final ConcurrentHashMap<String, Counter> countRequestsMap = new ConcurrentHashMap<>();

    public void getCount(String key) {
        Counter counter = countRequestsMap.computeIfAbsent(key, x -> {
            Counter newCounter = Counter.builder("requests_info.count")
                    .tag("endpoint", x)
                    .register(meterRegistry);
            newCounter.increment();
            return newCounter;
        });
        counter.increment();
    }
}
