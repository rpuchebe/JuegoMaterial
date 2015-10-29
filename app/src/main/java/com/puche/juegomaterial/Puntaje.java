package com.puche.juegomaterial;

        import android.provider.BaseColumns;
/**
 * Created by Raimundo Puche on 19/10/2015.
 */
public class Puntaje {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String COMMA_SEP = ",";

    public static abstract class puntajeEntry implements BaseColumns{
        public static final String TABLE_NAME = "Puntaje";
        public static final String COLUMN_NAME_ENTRY_ID = "scoreId";
        public static final String COLUMN_NAME_FIRST_NAME = "name";
        public static final String COLUMN_SCORE = "score";

        public static final String SQL_CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_SCORE + INTEGER_TYPE +
                        " )";
    }

}
