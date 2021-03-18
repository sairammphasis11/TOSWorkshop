package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpStream {

    public static void main(String[] args) {

        List<ShareHolder> shList = new ArrayList<ShareHolder>();
        shList.add(new ShareHolder(11,"Sairam","2000"));
        shList.add(new ShareHolder(21,"Venkat","2000"));
        shList.add(new ShareHolder(31,"Sandeep","7656"));
//        System.out.println(shList.stream()
//                .collect(Collectors.toMap(ShareHolder->ShareHolder.getShId(),ShareHolder->ShareHolder)));
        System.out.println(shList.stream().
                collect(Collectors.groupingBy(shareholder -> shareholder.getAmt(),
                        Collectors.mapping(shareholder -> shareholder.getShName(),Collectors.toList()))));

    }

}
class ShareHolder{

    private int shId;
    private String shName;
    private String amt;

    @Override
    public String toString() {
        return "ShareHolder{" +
                "shId=" + shId +
                ", shName='" + shName + '\'' +
                ", amt='" + amt + '\'' +
                '}';
    }

    public int getShId() {
        return shId;
    }

    public void setShId(int shId) {
        this.shId = shId;
    }

    public String getShName() {
        return shName;
    }

    public void setShName(String shName) {
        this.shName = shName;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public ShareHolder(int shId, String shName, String amt) {
        this.shId = shId;
        this.shName = shName;
        this.amt = amt;
    }
}
