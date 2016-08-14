package com.quizzapp.quizzapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Quizz.db";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void clearData() {
        SQLiteDatabase db = this.getWritableDatabase();
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // per te shmangur demtimin e te dhenave e fshijme databazen nqs ekziston nga nje version i meparshem
        db.execSQL("DROP TABLE IF EXISTS perdorues");
        db.execSQL("DROP TABLE IF EXISTS pyetje");

        db.execSQL("CREATE TABLE perdorues ( id INTEGER PRIMARY KEY AUTOINCREMENT, emri text , password text ) ");
        db.execSQL("CREATE TABLE pyetje ( id INTEGER PRIMARY KEY AUTOINCREMENT, pyetja text  , pergj1 text, pergj2 text, pergj3 text, pergj4 text, sakte int ) ");

        // behet shtimi i administratorit
        Perdorues perdorues = new Perdorues();
        perdorues.setEmri("admin");
        perdorues.setPassword("admin");
        insert(db, perdorues);



        // shtojme disa pyetje ne menyre automatike
        Pyetje pyetje;

        pyetje = new Pyetje();
        pyetje.setPyetja("Cili prej pohimeve eshte I vertete per dizenjimin e nje sistemi?");
        pyetje.setPergjige1("Sa më shumë dizenjim të bëhet aq më i thjeshte është më pas kodimi");
        pyetje.setPergjige2("Niveli i detajimit gjatë fazës së dizenjimit nuk varet nga natyra e aplikimit dhe nga eksperiencat e mëparshme.");
        pyetje.setPergjige3("Aplikimet e sigurise kritike  nuk kërkojnë shumë detajim dhe shumë dokumentim formal.");
        pyetje.setPergjige4("Asnjera");
        pyetje.setPergjigjaEsakte(1);
        insert(db, pyetje);

        pyetje = new Pyetje();
        pyetje.setPyetja("Pattern Layered ( i shtresezuar)");
        pyetje.setPergjige1("avantazh i ketij pattern eshte kompleksiteti i sistemit dhe kostoja");
        pyetje.setPergjige2("Lidhjet duhet të jenë njëdrejtimore");
        pyetje.setPergjige3("Shtresat mund ta bëjnë sistemin shumë performant.");
        pyetje.setPergjige4("Nëse kemi një pattern të shtresëzuar A,B,C ai është i njëjti dizenjim me C,B,A");
        pyetje.setPergjigjaEsakte(2);
        insert(db,pyetje);


        pyetje = new Pyetje();
        pyetje.setPyetja("Cila prej alternativave të mëposhtme nuk është e saktë për Broker pattern.?");
        pyetje.setPergjige1("Pattern broker ndan përdoruesit e shërbimeve (klientët) nga siguruesit e shërbimeve( servers) nëpërmjet një shtrese të quajtur broker.");
        pyetje.setPergjige2("Broker mund të jetë një pikë e vetme dështimi.");
        pyetje.setPergjige3("mund të ketë bllokime apo vonesa në komunikim.");
        pyetje.setPergjige4("Klienti dhe serveri mund të lidhen me disa ndërmjetës ( broker), njëkohësisht");
        pyetje.setPergjigjaEsakte(4);
        insert(db,pyetje);


        pyetje = new Pyetje();
        pyetje.setPyetja("Cila prej alternativave është karakteristikë e Model-View-Controller Pattern");
        pyetje.setPergjige1("Komponentja e modelit mund të bashkëveprojë direkt me controller");
        pyetje.setPergjige2("Ndryshimet në një komponente mund të kenë ndikim të madh në komponentet e tjera.");
        pyetje.setPergjige3("Mund të ketë shumë view dhe controllers të lidhur me një model ");
        pyetje.setPergjige4("Duhet të ketë të shumten nje instancë të modelit, view, dhe controller.");
        pyetje.setPergjigjaEsakte(3);
        insert(db,pyetje);


        pyetje = new Pyetje();
        pyetje.setPyetja("Controller i pattern Model-View-Controller?");
        pyetje.setPergjige1("Përcakton sjelljen e aplikacionit ");
        pyetje.setPergjige2("Ekspozon funksionalitetin e aplikacionit");
        pyetje.setPergjige3("Enkapsulon gjendjen e aplikacionit");
        pyetje.setPergjige4("Njofton view për ndryshime.");
        pyetje.setPergjigjaEsakte(1);
        insert(db,pyetje);


        pyetje = new Pyetje();
        pyetje.setPyetja("Pattern Client-Server?");
        pyetje.setPergjige1("Mund të kemi kufizime për sa i përket numrit të lidhjeve midis serverave");
        pyetje.setPergjige2("Vendimet se ku të vendoset funksionaliteti janë të thjeshta dhe jo shumë të kushtueshme.");
        pyetje.setPergjige3("Rrjedha kompjuterike e sistemeve client-server është simetrike");
        pyetje.setPergjige4("Serverat nuk mund të replikohen për të suportuar shkallëzim dhe disponueshmëri.");
        pyetje.setPergjigjaEsakte(1);
        insert(db,pyetje);


        pyetje = new Pyetje();
        pyetje.setPyetja("Cila prej alternativave të mëposhtme nuk është karakteristikë e Peer-to-Peer Pattern");
        pyetje.setPergjige1("Përmirësimi në disponueshmëri.");
        pyetje.setPergjige2("Ngarkesa e çdo komponenteje peer që punon si server reduktohet.");
        pyetje.setPergjige3("Menaxhimi i sigurisë bëhet thjeshtë.");
        pyetje.setPergjige4("Menaxhimi i backup dhe recovery është më kompleks.");
        pyetje.setPergjigjaEsakte(3);
        insert(db,pyetje);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void insert(SQLiteDatabase db, Perdorues perdorues) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("emri",perdorues.getEmri());
        contentValues.put("password",perdorues.getPassword());

        db.insert("perdorues", null, contentValues);
    }

    public void insert(Pyetje pyetje) {
        SQLiteDatabase db = this.getReadableDatabase();
        insert(db,pyetje);
    }

    public void insert(SQLiteDatabase db, Pyetje pyetje) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("pyetja",pyetje.getPyetja());
        contentValues.put("pergj1",pyetje.getPergjige1());
        contentValues.put("pergj2",pyetje.getPergjige2());
        contentValues.put("pergj3",pyetje.getPergjige3());
        contentValues.put("pergj4",pyetje.getPergjige4());
        contentValues.put("sakte", pyetje.getPergjigjaEsakte());

        db.insert("pyetje", null, contentValues);
    }


    public Perdorues getPerdorues(String emri,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from perdorues where emri = \"" + emri + "\" and password = \"" + password +"\" ";
        Cursor res = db.rawQuery(query, null);

        while (res.moveToNext()) {
            try {
                Perdorues perdorues = new Perdorues(res);
                return perdorues;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean ndryshoPassword(String emri, String passVjeter, String passIri){
        SQLiteDatabase db = this.getReadableDatabase();
        Perdorues perdorues = getPerdorues(emri,passVjeter);

        // nqs perdoruesi nuk u gjet ose pass eshte i pavlefshem kthe false
        if (perdorues == null) {
            return false;
        }
        else{
            db.rawQuery("update perdorues set password = \"" + passIri +"\" where emri = \"" + emri + "\"", null );
            return true;
        }
    }

    public List<Pyetje> getPyetje() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from pyetje";
        Cursor res = db.rawQuery(query, null);
        ArrayList<Pyetje> pyetje = new ArrayList<Pyetje>();
        while (res.moveToNext()) {
            try {
                Pyetje tmp = new Pyetje(res);
                pyetje.add(tmp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pyetje;
    }


}