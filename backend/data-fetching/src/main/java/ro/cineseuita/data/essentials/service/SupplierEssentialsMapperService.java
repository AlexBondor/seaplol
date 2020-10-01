package ro.cineseuita.data.essentials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
import ro.cineseuita.data.shared.entityComponents.Address;
import ro.cineseuita.data.supplier.entity.SupplierDetails;

@Service
public class SupplierEssentialsMapperService {

    @Autowired
    public SupplierEssentialsMapperService() {
    }

    public SupplierEssentials mapToSupplierWithContractsForDirectAcquisitionEssentials(SupplierDetails supplierDetails) {
        SupplierEssentials supplierForDirectAcquisitionEssentials = new SupplierEssentials();
        supplierForDirectAcquisitionEssentials.set_id(supplierDetails.getId());
        supplierForDirectAcquisitionEssentials.setName(supplierDetails.getName());
        supplierForDirectAcquisitionEssentials.setNumericFiscalNumber(supplierDetails.getCui());
        Address address = supplierDetails.getAddress();
        if (address != null) {
            supplierForDirectAcquisitionEssentials.setAddress(address.getAddress());
            supplierForDirectAcquisitionEssentials.setPhone(address.getPhone());
            supplierForDirectAcquisitionEssentials.setFax(address.getFax());
            supplierForDirectAcquisitionEssentials.setUrl(address.getWebsite());
            supplierForDirectAcquisitionEssentials.setCity(address.getCity());
            supplierForDirectAcquisitionEssentials.setCounty(address.getCounty());
            supplierForDirectAcquisitionEssentials.setPostalCode(address.getPostalCode());
        }
        return supplierForDirectAcquisitionEssentials;
    }
}
