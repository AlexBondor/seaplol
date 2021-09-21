package ro.cineseuita.national.api.controller;//package ro.cineseuita.national.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.cineseuita.national.api.dto.CpvDataDto;
import ro.cineseuita.national.service.NationalDataService;

@RestController
@RequestMapping("/api/national")
public class NationalDataController {

  private final NationalDataService nationalDataService;

  @Autowired
  public NationalDataController(NationalDataService nationalDataService) {
    this.nationalDataService = nationalDataService;
  }

  @GetMapping
  public CpvDataDto getRootCpvData() {
    return nationalDataService.getNationalCpvData();
  }

  @GetMapping("/cpvChildrenOf/{cpvCode}")
  public CpvDataDto cpvChildrenOf(@PathVariable String cpvCode) {
    return nationalDataService.getCpvChildrenOf(cpvCode);
  }


}
