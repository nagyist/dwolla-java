package com.dwolla.java.sdk;

public class Consts {

    public static class Api {

        public static final String TOKEN = "oauth_token";
        public static final String CLIENT_ID = "client_id";
        public static final String CLIENT_SECRET = "client_secret";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String RANGE = "range";
        public static final String LIMIT = "limit";
        public static final String SEARCH = "search";
        public static final String TYPES = "types";
        public static final String FUNDING_ID = "funding_id";
        public static final String REQUEST_ID = "request_id";
        public static final String SINCE_DATE = "sinceDate";
        public static final String SKIP = "skip";
        public static final String GROUP_ID = "group_id";
        public static final String ACCOUNT_ID = "account_identifier";
        public static final String TRANSACTION_ID = "transaction_id";
        public static final String DESTINATION_ID = "destinationId";
        public static final String DESTINATION_TYPE = "destinationType";
        public static final String SEARCH_TERM = "searchTerm";

    }

    public static class UserType {

        public static final String DWOLLA = "Dwolla";
        public static final String PHONE = "Phone";
        public static final String EMAIL = "Email";

    }

    public static class UserContactType {

        public static final String DWOLLA = "Dwolla";

    }

    public static class TransactionType {

        public static final String MONEY_SENT = "money_sent";
        public static final String MONEY_RECEIVED = "money_received";
        public static final String DEPOSIT = "deposit";
        public static final String WITHDRAWAL = "withdrawal";
        public static final String FEE = "fee";

    }

    public static class FundingSource {

        public static final String BALANCE = "Balance";
        public static final String BANK = "Bank";

    }

}
