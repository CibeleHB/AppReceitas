package br.com.opet.tmm.appseriesopet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "receita";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String INGREDIENTES = "ingredientes";
    public static final String PREPARO = "preparo";
    public static final String SERVE = "serve";
    public static final String TEMPOPREPARO = "tempopreparo";
    public static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + INGREDIENTES + " text,"
                + PREPARO + " text,"
                + SERVE + " text,"
                + TEMPOPREPARO + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
