package receipt;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class receipt1 {

   public static void main(String[] args) {      
      
      int K15_iprice = 100;                                                                    // 총 지불금액 저장 변수
      int rate = 10;                                                                           //세액을 저장하는 변수
      int K15_taxrate = rate + (rate * 10) / 100;                                              // 세액을 저장하는 변수
      int K15_tax = K15_iprice - ((10 * K15_iprice) / K15_taxrate) ;                           //부과세를 저장하는 변수
      int K15_origin = (int)K15_iprice - K15_tax;                                              // 판매금액을 저장하는 변수   

      Date d = new Date();                                                                     //현재시간을 받기 위해 객체를 생성
      SimpleDateFormat sd = new SimpleDateFormat ("yyyy/MM/dd kk:mm:ss");                      //날짜의 서식을 지정하는 객체 생성
      DecimalFormat df = new DecimalFormat("###,###");                                         //서식을 지정(천단위 콤마)하는 객체 생성
      //Printf를 이용해 각각의 서식과 칸띄움을 지정한다.
      System.out.println("신용승인");                                                          //신용승인 출력
      System.out.printf("%s : %10s  %7s : %s\n", "단말기", "2N68665898","전표번호", "041218"); //단말기와 전표번호를 각각 출력
      System.out.printf("%s : %s\n", "가맹점", "한양김치찌개");                                //가맹점을 출력
      System.out.printf("%s : %18s\n", "주  소", "경기 성남시 분당구 황새울로351");            //주소와 해당 주소를 출력
      System.out.printf("번길 10 .1층\n");                                                     //주소와 해당 주소를 출력
      System.out.printf("%s : %2s\n", "대표자", "유창신");                                     //대표자를 출력
      System.out.printf("%s : %5s   %7s : %7s\n", "사업자", "752-53-00558", "TEL", "7055695"); //사업자와 전화번호를 출력
      System.out.println("-----------------------------------------");                         //줄띄움을 위해 출력 
      System.out.printf("%s%3s%32.10s 원\n","금", "액", df.format(K15_origin));                //판매금액을 천단위에 콤마를 찍어 출력
      System.out.printf("%s%32.10s 원\n","부가세", df.format(K15_tax));                        //부가세를 천단위에 콤마를 찍어 출력
      System.out.printf("%s%3s%32.10s 원\n","합", "계", df.format(K15_iprice));                //합계를 천단위에 콤마를 찍어 출력
      System.out.println("-----------------------------------------");                         //줄띄움을 위해 출력 
      System.out.println("우리카드");                                                          //우리카드 출력
      System.out.printf("%s : %10s  %3s\n", "카드번호", "5387-20**-****-4613(S)","일시불");    //카드번호와 지불타입을 출력
      System.out.printf("%s : %10s\n", "거래일시", sd.format(d));                              //현재날짜와 시간을 출력
      System.out.printf("%s : %7s\n", "승인번호", "70404427");                                 //승인번호를 출력
      System.out.printf("%s : %10s\n", "거래번호", "357734873739");                            //거래번호를 출력
      System.out.printf("%s : %5s  %8s : %s\n", "매입", "비씨카드사","가맹","720068568");      //매입과 가맹을 출력
      System.out.printf("%s : %5s\n", "알림", "EDC매출표");                                    //알림을 출력   
      System.out.printf("%s : %5s\n", "문의", "TEL)1544-4700");                                //문의와 번호를 출력
      System.out.println("-----------------------------------------");                         //줄띄움을 위해 출력 
      System.out.printf("%19s", "* 감사합니다 *\n");                                           //감사합니다 출력
      System.out.printf("%40s", "표준V2. 08_20200212\n");                                      //표준버전을 출력
   }

}