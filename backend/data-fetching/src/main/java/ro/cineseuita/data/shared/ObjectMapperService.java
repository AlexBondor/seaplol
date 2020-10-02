package ro.cineseuita.data.shared;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.auction.entity.AuctionAcquisitionContracts;
import ro.cineseuita.data.contract.auction.entity.detailed.AuctionAcquisitionContractDetails;
import ro.cineseuita.data.contract.auction.entity.detailed.AuctionAcquisitionLots;
import ro.cineseuita.data.contract.auction.entity.detailed.AuctionAcquisitionSubcontracts;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContract;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionContracts;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.contractingauthority.entity.components.ContractingAuthorities;
import ro.cineseuita.data.supplier.entity.SupplierDetails;
import ro.cineseuita.data.supplier.entity.SupplierOpenApiBalance;
import ro.cineseuita.data.supplier.entity.SupplierOpenApiDetails;
import ro.cineseuita.data.supplier.entity.components.Suppliers;

import java.io.IOException;

@Service
public class ObjectMapperService {

    private final ObjectMapper objectMapper;

    public ObjectMapperService() {
        objectMapper = new ObjectMapper();
    }

    public DirectAcquisitionContracts mapToDirectAcquisitionContracts(String content) throws IOException {
        return objectMapper.readValue(content, DirectAcquisitionContracts.class);
    }

    public DirectAcquisitionContract mapToDirectAcquisitionContract(String content) throws IOException {
        return objectMapper.readValue(content, DirectAcquisitionContract.class);
    }

    public SupplierDetails mapToSupplier(String content) throws IOException {
        return objectMapper.readValue(content, SupplierDetails.class);
    }

    public DirectAcquisitionContractDetails mapToDirectAcquisitionContractDetails(String content) {
        try {
            return objectMapper.readValue(content, DirectAcquisitionContractDetails.class);
        } catch (IOException e) {
            e.printStackTrace();
        } // streams won't work otherwise => can't throw exception
        return new DirectAcquisitionContractDetails();
    }

    public ContractingAuthorities mapToContractingAuthorities(String content) throws IOException {
        return objectMapper.readValue(content, ContractingAuthorities.class);
    }

    public ContractingAuthorityDetails mapToContractingAuthorityDetails(String content) throws IOException {
        return objectMapper.readValue(content, ContractingAuthorityDetails.class);
    }

    public AuctionAcquisitionContractDetails mapToAuctionAcquisitionContractDetails(String content) throws IOException {
        return objectMapper.readValue(content, AuctionAcquisitionContractDetails.class);
    }

    public AuctionAcquisitionSubcontracts mapToAuctionAcquisitionSubcontracts(String content) throws IOException {
        return objectMapper.readValue(content, AuctionAcquisitionSubcontracts.class);
    }

    public AuctionAcquisitionLots mapToAuctionAcquisitionLots(String content) throws IOException {
        return objectMapper.readValue(content, AuctionAcquisitionLots.class);
    }

    public AuctionAcquisitionContracts mapToAuctionAcquisitionContracts(String content) throws IOException {
        return objectMapper.readValue(content, AuctionAcquisitionContracts.class);
    }

    public Suppliers mapToSuppliers(String content) throws IOException {
        return objectMapper.readValue(content, Suppliers.class);
    }

    public SupplierOpenApiDetails mapToSupplierOpenApiDetails(String content) throws IOException {
        return objectMapper.readValue(content, SupplierOpenApiDetails.class);
    }

    public SupplierOpenApiBalance mapToSupplierOpenApiBalance(String content) throws IOException {
        return objectMapper.readValue(content, SupplierOpenApiBalance.class);
    }
}
