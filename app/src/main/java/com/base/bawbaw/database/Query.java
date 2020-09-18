/**
 * Baw Baw 2020
 *
 * @author Senarathna A.M.U.A.
 * IT19214030
 * Y2S2 4.
 * MAD
 *
 */

package com.base.bawbaw.database;

import android.provider.BaseColumns;

public final class Query {

    private Query() {}

    public static class BawBaw implements BaseColumns{

        /** constant for DATABASE name**/

        public static final String DATABASE_NAME = "BawBawDB";

        /***************************************************************/



        /** constant for TABLE names**/

        public static final String OWNER_TABLE = "owner";

        /***************************************************************/




        /** constant for table COLUMN names**/

        /**  constant Owner table COLUMNS **/
        public static final String OWNER_ID = "owner_id";
        public static final String OWNER_NAME = "name";
        public static final String OWNER_ADDRESS = "address";
        public static final String OWNER_AGE = "age";
        public static final String OWNER_MOBILE = "mobile";

        /***************************************************************/



        /** constant for CREATE table **/

        /** constant for CREATE Owner table **/
        public static final  String OWNER_TABLE_CREATE_QUERY = "CREATE TABLE " + Query.BawBaw.OWNER_TABLE + " " + "("
                + Query.BawBaw.OWNER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Query.BawBaw.OWNER_NAME + " TEXT,"
                + Query.BawBaw.OWNER_ADDRESS+ " TEXT,"
                + Query.BawBaw.OWNER_AGE + " TEXT,"
                + Query.BawBaw.OWNER_MOBILE + " TEXT "
                + ");";


        /***************************************************************/



        /** constant for DROP table **/

        /** constant for DROP Owner table **/
        public static final  String OWNER_TABLE_DROP_QUERY =  "DROP TABLE IF EXISTS "+ OWNER_TABLE;

        /***************************************************************/



        /** constant for SELECT ALL from table **/

        /** constant for SELECT ALL from Owner table **/
        public static final  String SELECT_ALL_OWNER_TABLE =  "SELECT * FROM " + OWNER_TABLE;

        /***************************************************************/























        /**  Constant for column indexes  **/


        /** Constant for column index 1 */
        public static final int COLUMN_ONE = 1;

        /** Constant for column index 2 */
        public static final int COLUMN_TWO = 2;

        /** Constant for column index 3 */
        public static final int COLUMN_THREE = 3;

        /** Constant for column index 4 */
        public static final int COLUMN_FOUR = 4;

        /** Constant for column index 5 */
        public static final int COLUMN_FIVE = 5;

        /** Constant for column index 6 */
        public static final int COLUMN_SIX = 6;

        /** Constant for column index 7 */
        public static final int COLUMN_SEVEN = 7;

        /** Constant for column index 8 */
        public static final int COLUMN_EIGHT = 8;

        /** Constant for column index 9 */
        public static final int COLUMN_NINE = 9;

        /** Constant for column index 10 */
        public static final int COLUMN_TEN = 10;

        /** Constant for column index 11 */
        public static final int COLUMN_ELEVEN = 11;

        /** Constant for column index 12 */
        public static final int COLUMN_TWELVE = 12;

        /** Constant for column index 13 */
        public static final int  COLUMN_THIRTEEN = 13;

        /***************************************************************/

















    }


















}
