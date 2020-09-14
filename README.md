# seaplol [![CircleCI](https://circleci.com/gh/AlexBondor/seaplol/tree/master.svg?style=svg&circle-token=40b31486af1c48e56098343b0fb6ff1c446c1159)](https://circleci.com/gh/AlexBondor/seaplol/tree/master)


### 1. Installation

- be sure to have node >= 10.15.3
    - check by running _node -v_ 
    - install yarn >= 1.15.2 
    - install mongodb 3.4.5 (or above) and have it run as a service [(see here)](https://medium.com/stackfame/run-mongodb-as-a-service-in-windows-b0acd3a4b712#:~:text=To%20start%20MongoDB%2C%20run%20mongod,connections%20message%20in%20the%20console.)
        - in case you install a version higher than 4.2, the import/export tools needed for importing and exporting the db will be missing. You will need to install them separately from [here](https://www.mongodb.com/try/download/database-tools?tck=docs_databasetools)
        - make sure you add both mongo and tools directory (for >4.2) to the path
        - unpack the archive containing the database into the project folder /data-fetching/seaplol-db/seaplol (create the folders in case you don't already have them) and then run the import script in the data-fetching folder
        - you can find a (hopefully up to date) snapshot of the DB [here](https://drive.google.com/drive/folders/1HOEBgpnkDkK1NgMFR6lcXEH2gNmibirm?usp=sharing)
        - download the archive and make sure to put the archived .bson files in ..\seaplol\data-fetching\seaplol-db\seaplol
        - run the _import-db_ script from the data-fetching folder
- clone repository
- in the _frontend_ folder, run _yarn install_
    - to run frontend, simply: _yarn run serve_
    
---
### 2. Structure
- _data-fetching_ - crawler and data processor
     - deals with crawling SEAP platform
     - folder contains scripts for importing/exporting data in mongodb (see import-db/export-db)
        - these scripts use the seaplol-db folder to import/export data
        - in project root folder there should always be an up to date archive with the database - extract in the data-fetching/seaplol-db/seaplol folder and run import script if it is your first time 
     - ***CAREFUL*** with running full fetch commands in the data-fetching application, they take many days and trigger millions of requests...


- _app_ - the API
    - spring boot application
    - models should match tables created by the data-fetching app
    - stick to clean layer architecture
    
    
- _frontend_ - well, the frontend
    - simple VUE app
    - focus on crisp and clean data visualisation techniques (graphs, zoom-able data structures)
    
---

### 3. Understanding the model

There are 3 important entities:

a) Suppliers
- basically the privately owned companies who provide **goods** and **services** (very important distinction!) to the state owned entities, the "contracting authorities"
- suppliers are found in the "Suppliers" collection
- their most important fields are:
    - _id
    - fiscalNumber / numericFiscalNumber
    - entityName 


b) Contracting Authorities
- the state owned entities which basically are the money spenders in this whole thing
- the "institutions" or aptly named "Contracting Authorities" (henceforth CA) are regulated bodies which buy either goods or services from suppliers
- there are two types of acquisitions
    - direct acquisitions
        - for goods, up to a maximum of 100k EUR contract
        - for services, up to a maximum of 1kk (1 mililon EUR) per contract
        - how to differentiate between them? see the "Contracts" section
    - auction acquisitions
        - for very large contracts
        - much more regulated and more oversight on them
- CAs are found in the "ContractingAuthority" and "ContractingAuthorityDetails" collections
- their most important fields are:
    - _id
    - name
    - CUI
    - legal representative

    
c) Contracts
- contracts are the most important part of this application, by far
- they are the agreement between the CAs and Suppliers on what to buy, on which conditions and at what cost.
- they are of two types:
    - direct acquisition contracts
    - auction acquisition contracts
- **up to the moment of writing this, of interest are only DIRECT acquisitions** - subsequent versions of the application will also support auction acquisitions but they require more in depth analysis
- they can be found in the "directAcquisitionContract" and "directAcquisitionContractDetails" collections
- the "directAcquisitonContract" collection gets crawled by the SEAP platform in about 3-4 hours. the "directAcquisitionContractDetails" one need about 2 weeks of continuous crawling (around 1 week/year)
- they have a few very important fields which need to be understood before any more can be done:
    - closingValue: the value at which the contract was closed (should be used for averages and totals)
    - finalizationDate: the date on which it was concluded (should be used as "contract date")
    - uniqueIdentificationCode: self evident
    - directAcquisitionId (also _id): used to form direct links to the SEAP platform (e.g. http://e-licitatie.ro/pub/direct-acquisition/view/106901861 - see number after /view/)
    - directAcquisitionName: the title of the contract
    - **cpvCode:** the CPV code of the contract (see the list of codes [here](https://www.bipsolutions.com/news-and-resources/cpv-codes/) - more on this below)
    - supplierId: direct reference to the supplier collection
    - contractingAuthorityId: direct reference to the CA collection
    - **directAcquisitionItems:** - all the items which are to be bought through this contract
        - catalogItemPrice: the price of that item in the catalog
        - itemClosingPrice: the price at which the item was procured
        - itemQuantity: the number of such items procured
        - itemMeasurementUnit: the measurementUnit (see ItemMeasurement.java)
        - cpvCode: the cpv code of the item
    - **sysAcquisitonStateId:** the state of the acquisition
        - see DirectAcquisitionState.java for the enum
        - only "7" (Offer Accepted) should be considered for any calculations!
    - **sysAcquisitionContractTypeID:** the type of the contract
        - see [#19](https://github.com/AlexBondor/seaplol/issues/19)
        - mapped in _DirectAcquisitionType.java_
        - can be FURNIZARE, SERVICII, LUCRARI
        
    
 
---

### 4. Philosophy
- transparency and insight
    - sure, [SEAP](http://e-licitatie.ro/pub/direct-acquisitions/list/1) offers some degree of transparency, but not merely enough for gathering powerful insights on the way money is spent in Romania
    - the fact that we can't even easily know how much money, in total, an institution spends on one thing or another without mindlessly clicking through hundreds of contracts on that platform is an intentional choice, one we are trying to fix
    - deep insights and red flags can be gathered from aggregate data analysis of this publicly available data
- to the people, for the people 
    - Romanian citizens have the right to know what their money is buying and this should be made effortlessly and never cumbersome!
- ... but also for journalists
    - the platform should give journalists an easy way to quickly investigate and go through institution, supplier and contract data gathering (hopefully) powerful insights
    
TBC...

