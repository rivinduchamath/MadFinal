package lk.sliit.mad.today.database;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntryUser implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_TYPE = "type";
    }

    /* Inner class that defines the table contents */
    public static class FeedEntryMessage implements BaseColumns {
        public static final String TABLE_NAME = "message";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SUBJECT = "subject";
        public static final String COLUMN_MESSAGE = "message";
    }
}