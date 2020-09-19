//package ro.cineseuita.national.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ro.cineseuita.cpv.entity.NationalCpvData;
//import ro.cineseuita.cpv.entity.components.CpvSimpleTreeNode;
//import ro.cineseuita.cpv.repository.NationalCpvDataRepository;
//
//import java.util.List;
//
//@Service
//public class NationalDataService {
//
//    private final NationalCpvDataRepository nationalCpvDataRepository;
//
//    @Autowired
//    public NationalDataService(NationalCpvDataRepository nationalCpvDataRepository) {
//        this.nationalCpvDataRepository = nationalCpvDataRepository;
//    }
//
//    public List<NationalCpvData> getNationalCpvData() {
//        return nationalCpvDataRepository.findByParentId(CpvSimpleTreeNode.ROOT);
//    }
//}
