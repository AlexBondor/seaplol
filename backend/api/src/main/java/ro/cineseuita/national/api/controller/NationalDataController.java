package ro.cineseuita.national.api.controller;//package ro.cineseuita.national.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.cineseuita.data.cpv.entity.NationalCpvData;
import ro.cineseuita.national.service.NationalDataService;

import java.util.List;

@RestController
@RequestMapping("/api/national")
public class NationalDataController {

    private final NationalDataService nationalDataService;

    @Autowired
    public NationalDataController(NationalDataService nationalDataService) {
        this.nationalDataService = nationalDataService;
    }

    @GetMapping
    public List<NationalCpvData> getRootCpvData() {
        return nationalDataService.getNationalCpvData();
    }
}
