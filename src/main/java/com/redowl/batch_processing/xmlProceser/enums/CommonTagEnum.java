package com.redowl.batch_processing.xmlProceser.enums;

public enum CommonTagEnum implements TagEnum{

    //*************************************************Instruction*************************************************
    // if another scenario is needed,
    // first get a copy of CommonTagEnum and then change the boolean value according to the scenario
    // if  change anything other than boolean value please add all the enums that change
    // all the enums need to be same

    // after add new enum it need to be mentioned in the utils.enumTagVerifier class (in the switch case)
    //*************************************************Instruction*************************************************



    TRANSACTION("report.transaction", true),


    //*************************************************Involved Parties Tag Section*************************************************
    TRANSACTION_INVOLVED_PARTIES("report.transaction.involved_parties", false),


    //*************************************************From My Client Tag Section*************************************************
    T_FROM_MY_CLIENT("report.transaction.t_from_my_client", false),

    T_FROM_MY_CLIENT_FROM_FOREIGN_CURRENCY("report.transaction.t_from_my_client.from_foreign_currency", false),

    T_FROM_MY_CLIENT_T_CONDUCTOR("report.transaction.t_from_my_client.t_conductor", false),

    T_FROM_MY_CLIENT_FROM_ACCOUNT("report.transaction.t_from_my_client.from_account", false),

    T_FROM_MY_CLIENT_FROM_PERSON("report.transaction.t_from_my_client.from_person", false),

    T_FROM_MY_CLIENT_FROM_ENTITY("report.transaction.t_from_my_client.from_entity", false),




    //*************************************************From Tag Section*************************************************
    T_FROM("report.transaction.t_from", false),

    T_FROM_FROM_FOREIGN_CURRENCY("report.transaction.t_from.from_foreign_currency", false),

    T_FROM_T_CONDUCTOR("report.transaction.t_from.t_conductor", false),

    T_FROM_FROM_ACCOUNT("report.transaction.t_from.from_account", false),

    T_FROM_FROM_PERSON("report.transaction.t_from.from_person", false),

    T_FROM_FROM_ENTITY("report.transaction.t_from.from_entity", false),




    //*************************************************To My Client Tag Section*************************************************
    T_TO_MY_CLIENT("report.transaction.t_to_my_client", false),

    T_TO_MY_CLIENT_TO_FOREIGN_CURRENCY("report.transaction.t_to_my_client.to_foreign_currency", false),

    T_TO_MY_CLIENT_TO_ACCOUNT("report.transaction.t_to_my_client.to_account", false),

    T_TO_MY_CLIENT_TO_PERSON("report.transaction.t_to_my_client.to_person", false),

    T_TO_MY_CLIENT_TO_ENTITY("report.transaction.t_to_my_client.to_entity", false),





    //*************************************************To Tag Section*************************************************
    T_TO("report.transaction.t_to", false),

    T_TO_TO_FOREIGN_CURRENCY("report.transaction.t_to.to_foreign_currency", false),

    T_TO_TO_ACCOUNT("report.transaction.t_to.to_account", false),

    T_TO_TO_PERSON("report.transaction.t_to.to_person", false),

    T_TO_TO_ENTITY("report.transaction.t_to.to_entity", false),










    //*************************************************Entity Tag Section*************************************************
    ENTITY("entity", false),
    ENTITY_PHONES_PHONE("entity.phones.phone", false),
    ENTITY_ADDRESSES_ADDRESS("entity.addresses.address", false),
    ENTITY_DIRECTOR_ID("entity.director_id", false),


    ENTITY_MY_CLIENT("my_client.entity", false),
    ENTITY_MY_CLIENT_PHONES_PHONE("my_client.entity.phones.phone", false),
    ENTITY_MY_CLIENT_ADDRESSES_ADDRESS("my_client.entity.addresses.address", false),
    ENTITY_MY_CLIENT_DIRECTOR_ID("my_client.entity.director_id", false),



    //*************************************************Person Tag Section*************************************************
    PERSON("person", false),
    PERSON_PHONES_PHONE("person.phones.phone", false),
    PERSON_ADDRESSES_ADDRESS("person.addresses.address", false),
    PERSON_EMPLOYER_ADDRESS_ID("person.employer_address_id", false),
    PERSON_EMPLOYER_PHONE_ID("person.employer_phone_id", false),
    PERSON_IDENTIFICATION("person.identification", false),


    PERSON_MY_CLIENT("my_client.person", false),
    PERSON_MY_CLIENT_PHONES_PHONE("my_client.person.phones.phone", false),
    PERSON_MY_CLIENT_ADDRESSES_ADDRESS("my_client.person.addresses.address", false),
    PERSON_MY_CLIENT_EMPLOYER_ADDRESS_ID("my_client.person.employer_address_id", false),
    PERSON_MY_CLIENT_EMPLOYER_PHONE_ID("my_client.person.employer_phone_id", false),
    PERSON_MY_CLIENT_IDENTIFICATION("my_client.person.identification", false),



    //*************************************************Account Tag Section*************************************************
    ACCOUNT("account", false),
    ACCOUNT_T_ENTITY("account.t_entity", false),
    ACCOUNT_SIGNATORY("account.signatory", false),


    ACCOUNT_MY_CLIENT("my_client.account", false),
    ACCOUNT_MY_CLIENT_T_ENTITY("my_client.account.t_entity", false),
    ACCOUNT_MY_CLIENT_SIGNATORY("my_client.account.signatory", false);




    private final String tag;
    private final boolean repeatable;

    CommonTagEnum(String tag, boolean repeatable) {
        this.tag = tag;
        this.repeatable = repeatable;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public boolean isRepeatable() {
        return repeatable;
    }
}
