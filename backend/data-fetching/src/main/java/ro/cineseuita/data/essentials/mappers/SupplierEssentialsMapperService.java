package ro.cineseuita.data.essentials.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
import ro.cineseuita.data.supplier.entity.SupplierDetails;

@Service
public class SupplierEssentialsMapperService {

    @Autowired
    public SupplierEssentialsMapperService() {
    }

    public SupplierEssentials mapToSupplierEssentials(SupplierDetails supplierDetails) {
        SupplierEssentials supplierForDirectAcquisitionEssentials = new SupplierEssentials();
        supplierForDirectAcquisitionEssentials.set_id(supplierDetails.getId());
        supplierForDirectAcquisitionEssentials.setName(supplierDetails.getName());
        supplierForDirectAcquisitionEssentials.setCui(supplierDetails.getCui());
        supplierForDirectAcquisitionEssentials.setAddress(supplierDetails.getAddress());
        supplierForDirectAcquisitionEssentials.setLegalRepresentative(supplierDetails.getRegistration().getLegalRepresentative());
        return supplierForDirectAcquisitionEssentials;
    }
}
