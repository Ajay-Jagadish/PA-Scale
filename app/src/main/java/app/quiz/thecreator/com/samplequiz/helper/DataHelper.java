package app.quiz.thecreator.com.samplequiz.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User2 on 21-09-2016.
 */
public class DataHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PAScale.db";

    public static final int DATABASE_VERSION = 1;


    public static final String PATIENT_MASTER = "Patient_Master";
    public static final String P_ID = "PatientId";
    public static final String P_NAME = "Name";
    public static final String P_AGE = "Age";
    public static final String P_GENDER = "Gender";
    public static final String P_YEAR = "Year";
    public static final String P_STROKE_PART = "StrokePart";

    public static final String PATIENT_DETAILS = "Patient_Details";
    public static final String PC_ID = "PatientId";
    public static final String PC_DATE = "Date";
    public static final String PC_TOTAL_MET = "TotalMETValue";

    public static final String PATIENT_CAT_DETAILS = "Patient_Category_Details";
    public static final String PCC_ID = "PatientId";
    public static final String PCC_CATID = "CatId";
    public static final String PCC_CAT_MET = "CatMETValue";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE " + PATIENT_MASTER + " (" +
                P_ID + " TEXT, " +
                P_NAME + " TEXT, " +
                P_AGE + " TEXT, " +
                P_GENDER + " TEXT, " +
                P_YEAR + " TEXT, " +
                P_STROKE_PART + " TEXT);"
        );

        db.execSQL(" CREATE TABLE " + PATIENT_DETAILS + " (" +
                PC_ID + " TEXT, " +
                PC_DATE + " TEXT, " +
                PC_TOTAL_MET + " TEXT);"
        );

        db.execSQL(" CREATE TABLE " + PATIENT_CAT_DETAILS + " (" +
                PCC_ID + " TEXT, " +
                PCC_CATID + " TEXT, " +
                PCC_CAT_MET + " TEXT);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int version_old, int current_version) {

    }

    public Cursor getPatientMaster() {
        SQLiteDatabase database = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + PATIENT_MASTER;
        return database.rawQuery(selectQuery, null);
    }

    public Cursor getPatientChild() {
        SQLiteDatabase database = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + PATIENT_DETAILS;
        return database.rawQuery(selectQuery, null);
    }

    public Cursor getPatientCategory() {
        SQLiteDatabase database = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + PATIENT_CAT_DETAILS;
        return database.rawQuery(selectQuery, null);
    }


    public String insertUserMaster(String userKey, String totalMetValue) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Str_Return_Value = null;
        long query_ret;
        try {
            ContentValues values = new ContentValues();
            values.put(PC_ID, userKey);
            values.put(PC_DATE, "11");
            values.put(PC_TOTAL_MET, totalMetValue);
            query_ret = db.insertWithOnConflict(PATIENT_DETAILS, null, values, SQLiteDatabase.CONFLICT_IGNORE);
            if (query_ret != -1) {
                Str_Return_Value = "success";
            } else {
                Str_Return_Value = "failure";
            }
        } catch (Exception e) {
        }
        db.close();
        return Str_Return_Value;
    }

    public void allQuestion() {

    }
   /* //update value databse in android
    public boolean updateAddress(String userKey, String primaryAddKey, String address1, String pinCode1, String secondaryKey,
                                 String address2, String pinCode2, String email, String isChecked, String flag, String temp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ADDRESS_USERKEY, userKey);
        contentValues.put(ADDRESS_PADDKEY, primaryAddKey);
        contentValues.put(ADDRESS_ADDRESS1, address1);
        contentValues.put(ADDRESS_PINCODE1, pinCode1);
        contentValues.put(ADDRESS_SADDKEY, secondaryKey);
        contentValues.put(ADDRESS_ADDRESS2, address2);
        contentValues.put(ADDRESS_PINCODE2, pinCode2);
        contentValues.put(ADDRESS_EMAIL, email);
        contentValues.put(ADDRESS_ISCHECKED, isChecked);
        contentValues.put(ADDRESS_FLAG, flag);
        contentValues.put(ADDRESS_TEMP, temp);
        db.update(ADDRESS_TABLE, contentValues, ADDRESS_USERKEY + "=?", new String[]{userKey});
        return true;
    }*/

    /*public void deleteUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + USER_TABLE);
    }

    public void deleteAddress() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + ADDRESS_TABLE);
    }

    public void deleteUserEdu() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + EDU_TABLE);
    }*/



  /*  public Cursor getUserDetails() {
        SQLiteDatabase database = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + USER_TABLE;
        return database.rawQuery(selectQuery, null);
    }

    public Cursor getAddressDetails() {
        SQLiteDatabase database = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + ADDRESS_TABLE;
        return database.rawQuery(selectQuery, null);
    }*/


   /* public String updateUserDetails(String newEmail, String userKey) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Str_Return_Value = null;
        String Update_Query = "Update User SET Email ='" + newEmail + "' WHERE UserKey ='" + userKey + "'";
        db.execSQL(Update_Query);
        db.close();
        return Str_Return_Value;
    }

    public String updateCardDetails(String templateId, int cardHolderKey) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Str_Return_Value = null;
        String Update_Query = "Update CardHolderDetails SET TemplateId ='" + templateId + "' WHERE CardHolderKey ='" + cardHolderKey + "'";
        db.execSQL(Update_Query);
        db.close();
        return Str_Return_Value;
    }*/

}















































/*  *//*Function to insert user details to database*//*
    public String insertUserDetails(String userKey, String mobileNo, String name, String emailId, String IsActive,
                                    String IsTandCAccepted, String TandCAcceptedDate, String isBlackListed,
                                    String BlackListReason, String Pincode, String Details) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Str_Return_Value = null;
        long query_ret;
        try {
            ContentValues values = new ContentValues();
            values.put(USER_USERKEY, userKey);
            values.put(USER_MOBILENO, mobileNo);
            values.put(USER_NAME, name);
            values.put(USER_EMAIL, emailId);
            values.put(USER_ISACTIVE, IsActive);
            values.put(USER_ISTCACCEPTED, IsTandCAccepted);
            values.put(USER_TCACCEPTEDDATE, TandCAcceptedDate);
            values.put(USER_ISBLACKLISTED, isBlackListed);
            values.put(USER_BLACKLISTREASON, BlackListReason);
            values.put(USER_PINCODE, Pincode);
            values.put(USER_DETAILS, Details);
            query_ret = db.insertWithOnConflict(USER_TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
            if (query_ret != -1) {
                Str_Return_Value = "success";
            } else {
                Str_Return_Value = "failure";
            }
        } catch (Exception e) {
        }
        db.close();
        return Str_Return_Value;
    }

    *//*Function to insert address details to database*//*
    public String insertAddressDetails(String userKey, String primaryAddKey, String address1, String pinCode1, String secondaryKey,
                                       String address2, String pinCode2, String email, String isChecked, String flag, String temp) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Str_Return_Value = null;
        long query_ret;
        try {
            ContentValues values = new ContentValues();
            values.put(ADDRESS_USERKEY, userKey);
            values.put(ADDRESS_PADDKEY, primaryAddKey);
            values.put(ADDRESS_ADDRESS1, address1);
            values.put(ADDRESS_PINCODE1, pinCode1);
            values.put(ADDRESS_SADDKEY, secondaryKey);
            values.put(ADDRESS_ADDRESS2, address2);
            values.put(ADDRESS_PINCODE2, pinCode2);
            values.put(ADDRESS_EMAIL, email);
            values.put(ADDRESS_ISCHECKED, isChecked);
            values.put(ADDRESS_FLAG, flag);
            values.put(ADDRESS_TEMP, temp);
            query_ret = db.insertWithOnConflict(ADDRESS_TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
            if (query_ret != -1) {
                Str_Return_Value = "success";
            } else {
                Str_Return_Value = "failure";
            }
        } catch (Exception e) {
        }
        db.close();
        return Str_Return_Value;
    }

    public String insertEduDetails(String userEduKey, String userKey, String eduKey, String eduShortName, String eduFullName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Str_Return_Value = null;
        long query_ret;
        try {
            ContentValues values = new ContentValues();
            values.put(EDU_USEREDUKEY, userEduKey);
            values.put(EDU_USERKEY, userKey);
            values.put(EDU_EDUKEY, eduKey);
            values.put(EDU_EDUSHORTNAME, eduShortName);
            values.put(EDU_EDUFULLNAME, eduFullName);
            query_ret = db.insertWithOnConflict(EDU_TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
            if (query_ret != -1) {
                Str_Return_Value = "success";
            } else {
                Str_Return_Value = "failure";
            }
        } catch (Exception e) {
        }
        db.close();
        return Str_Return_Value;
    }


    public String updateAddressDetails(String userKey, String primaryAddKey, String address1, String pinCode1, String secondaryKey,
                                       String address2, String pinCode2, String email, String isChecked) {
        SQLiteDatabase db = this.getWritableDatabase();
        String Str_Return_Value = null;
        String Update_Query = "Update " + ADDRESS_TABLE + " SET "
                + ADDRESS_PADDKEY + " ='" + primaryAddKey + " ,"
                + ADDRESS_ADDRESS1 + " ='" + address1 + " ,"
                + ADDRESS_PINCODE1 + " ='" + pinCode1 + " ,"
                + ADDRESS_SADDKEY + " ='" + secondaryKey + " ,"
                + ADDRESS_ADDRESS2 + " ='" + address2 + " ,"
                + ADDRESS_PINCODE2 + " ='" + pinCode2 + " ,"
                + ADDRESS_EMAIL + " ='" + email + " ,"
                + ADDRESS_ISCHECKED + " ='" + isChecked + " ,"
                + "' WHERE " + ADDRESS_USERKEY + "='" + userKey + "'";
        db.execSQL(Update_Query);
        db.close();
        return Str_Return_Value;
    }
*/