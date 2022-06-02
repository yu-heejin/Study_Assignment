package ddwucom.mobile.test14.exam02;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FoodDBManager {
    FoodDBHelper foodDBHelper = null;
    Cursor cursor = null;
    
    //_id를 기준으로 DB에서 food 삭제
    public boolean removeFood(long id) {
        //DB 삭제 작업 수행
        //helper객체를 생성해서 writerable객체를 얻어옴
        //FoodDBHelper foodDBHelper = new FoodDBHelper(this);
        SQLiteDatabase sqLiteDatabase = foodDBHelper.getWritableDatabase();

        String whereClause = FoodDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        //여기서는 바로 id 값을 받아서 사용함
        //get_id는 숫자를 반환하는 것인데, 문자 타입으로 값을 받고 있기 때문에 오류 -> 문자열로 변경!
        //이렇게 되면 =?와 결합하게 됨

        int result = sqLiteDatabase.delete(FoodDBHelper.TABLE_NAME, whereClause, whereArgs);
        //잘 삭제됐으면 1 이상의 값, 아니라면 0을 반환함 -> if 문 판단 가능

        foodDBHelper.close();

        if(result > 0) return true;
        else return false;
        //삭제가 잘 되면 true, 아니면 false
    }

    //_id 를 기준으로 food의 이름과 nation 변경
    public boolean modifyFood(Food food) {   //바뀐 내용을 가진 food를 매개변수로 받아옴
        //바꿀 때는 아이디와 바뀔 값들 모두를 알고 있어야함
        //그래서 food객체 형태로 받아야함
        //FoodDBHelper foodDBHelper = new FoodDBHelper(this);
        SQLiteDatabase sqLiteDatabase = foodDBHelper.getWritableDatabase();

        ContentValues row = new ContentValues();   //바꿀 내용을 저장하는 ContentValues
        row.put(FoodDBHelper.COL_FOOD, food.getFood());
        row.put(FoodDBHelper.COL_NATION, food.getNation());
        //바꿀 데이터를 삽입함(editText의 값을 삽입)

        String whereClause = FoodDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(food.get_id()) };
        //where절의 조건을 선언함

        int result = sqLiteDatabase.update(foodDBHelper.TABLE_NAME, row, whereClause, whereArgs);

        foodDBHelper.close();
        if(result > 0) return true;
        else return false;
    }
}
