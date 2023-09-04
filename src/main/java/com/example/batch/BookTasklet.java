package com.example.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public class BookTasklet implements Tasklet {

    int counter = 0;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Execution tasklet");
        if (counter == 5) {
            counter = 0;
            return RepeatStatus.FINISHED;
        } else {
            counter++;
            return RepeatStatus.CONTINUABLE;
        }
    }
}
