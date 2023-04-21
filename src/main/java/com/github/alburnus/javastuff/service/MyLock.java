package com.github.alburnus.javastuff.service;

import com.github.alburnus.javastuff.entity.ModelEntity;
import com.github.alburnus.javastuff.entity.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockConfiguration;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.core.SimpleLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

@Slf4j
@Component
public class MyLock {

    private final LockProvider mongoLockProvider;
    private final ModelRepository modelRepository;

    public MyLock(LockProvider mongoLockProvider, ModelRepository modelRepository) {
        this.mongoLockProvider = mongoLockProvider;
        this.modelRepository = modelRepository;
    }

    @Scheduled(fixedDelay = 1000)
    public void test() {
        ModelEntity model = new ModelEntity();
        LockConfiguration myLock = new LockConfiguration(Instant.now(), "myLock", Duration.ofSeconds(60), Duration.ofSeconds(50));
        Optional<SimpleLock> lock = mongoLockProvider.lock(myLock);
        if(lock.isEmpty()) {
            log.debug("STOP");
            return;
        }

        modelRepository.save(model);
    }
}
