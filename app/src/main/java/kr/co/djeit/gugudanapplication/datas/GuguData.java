package kr.co.djeit.gugudanapplication.datas;

/**
 * Created by one on 2017-08-13.
 */

public class GuguData {
    private int dan;
    private int number;

    public GuguData() {
    }

    public GuguData(int dan, int number) {
        this.dan = dan;
        this.number = number;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
