package ro.cineseuita.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.cineseuita.data.processing.ProcessingPipelineService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final ProcessingPipelineService processingPipelineService;

    @Autowired
    public CommandLineAppStartupRunner(ProcessingPipelineService processingPipelineService) {
        this.processingPipelineService = processingPipelineService;
    }

    @Override
    public void run(String... args) throws Exception {
        processingPipelineService.execute();
    }
}
