package ro.cineseuita.data.essentials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
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
        supplierForDirectAcquisitionEssentials.setAddress(supplierDetails.getAddress().getAddress());
        supplierForDirectAcquisitionEssentials.setPhone(supplierDetails.getAddress().getPhone());
        supplierForDirectAcquisitionEssentials.setFax(supplierDetails.getAddress().getFax());
        supplierForDirectAcquisitionEssentials.setUrl(supplierDetails.getAddress().getWebsite());
        supplierForDirectAcquisitionEssentials.setCity(supplierDetails.getAddress().getCity());
        supplierForDirectAcquisitionEssentials.setCounty(supplierDetails.getAddress().getCounty());
        supplierForDirectAcquisitionEssentials.setPostalCode(supplierDetails.getAddress().getPostalCode());

        return supplierForDirectAcquisitionEssentials;
    }
}
