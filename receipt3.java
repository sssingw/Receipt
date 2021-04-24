package receipt;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class receipt3 {

   public static void main(String[] args) throws UnsupportedEncodingException {
                                                                                                               
      SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd kk:mm");
      SimpleDateFormat sd1 = new SimpleDateFormat("yyyyMMdd");
      SimpleDateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");  //날짜의 서식을 지정하는 객체 생성
      Date d = new Date();      
         //현재시간을 받기 위해 객체를 생성
      DecimalFormat df = new DecimalFormat ("###,###,###,###,### ");                                                                                 //서식을 지정(천단위 콤마)하는 객체 생성
   
      String [] K15_itemname = {"피코크 파주장 단콩순두부","포스트아몬드오레오","농심새우깡 180g","양반더바삭한김20봉","뿌셔뿌셔뿌셔뿌셔뿌셔뿌셔","오감자오감자오감자오감자오감자","오리지널포테토칩오리지널포테토칩","바나나킥바나나킥바나나킥바나나킥","초코파이초코파이","허니버터칩허니버터칩",            //문자열 타입의 배열에 과제30개를 넣음
                                       "롯데허쉬스낵밀크165G","aaaa프리미엄식a","맛있는 감자칩","홈런볼","콘칩콘칩콘칩콘칩","농심신라면(50봉)","쿠크다스","롤리폴리","종가집 콩이가득두부","빼빼로빼빼로빼빼로",         
                                       "깐마늘(500g/봉)","곰표밀가루 1kg","촉촉한초코칩","방울토마토500g/팩","맘스크린지퍼백(소)","주방용위생","사각촘촘세탁망","쫄깃치자단무지 200g","오예스오예스오예스","쫄병스낵쫄병스낵쫄병스낵"};
      
      int [] K15_price = {1000000, 1000000, 1000000, 1000000, 1000000, 4000, 4500, 1000, 1500, 2000,                                                       //가격 배열에 각 과자의가격(단가)을 넣음
                        2500, 3000, 3500, 4000, 1000, 130000, 18000, 2300, 2800, 1900,                                                            
                        3300, 1000, 1300, 2300, 2500, 3000, 2700, 1400, 1500, 1000}; 
      int [] K15_num =  {10, 10, 10, 10, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1,  1, 2, 1, 1, 1, 1, 1};                                      //각 과자의 수량을 배열에 넣음
      boolean [] K15_taxfree = {true, false, false, false, false, true, false, false, true, false,                                                //면제유무에 대해 배열에 넣어 true이면 면세
            true, false, false, false, true, false, false, false, true, false,
            false, true, false, false, false, false, false, false, true, false}; 
     
         
      int K15_taxprice = 0;       //과세총합계
      int K15_freeprice = 0;      //면세 총합계
      int K15_totalprice = 0;      //전체 합계
      int K15_netprice = 0;         //과세 공급가
      int K15_tax = 0;            //부가세
                                                              //각각의 부가세를 더해 총 부가세      
         
      
//      K15_total_tax =  (K15_total_price2 / K15_taxrate) * K15_rate;                        //총 과세 합계
                                               //총 지불금액 = 면세금액 + 부가세 + 과세물품            
      System.out.printf("%35s\n", "이마트 죽전점 (031)838-1234");                                                                              //이마트 죽전점을 출력
      System.out.printf("%9s %20s\n","emart",  "206-86-50913 강희석");                                                                     //emart와 번호를 출력
      System.out.printf("%29s\n", "용인 수지구 포은대로 552");                                                                                    //위치 출력
      System.out.printf("%s\n", "영수증 미지참시 교환/환불 불가");                                                                                 //교환 환불 안내 출력
      System.out.printf("%s\n", "정상상품에 한함, 30일 이내(신선 7일)");                                                                           //교환 환불 안내 출력
      System.out.printf("%s\n", "※일부 브랜드매장 제외(매장 고지물참조)");                                                                        //교환 환불 안내 출력
      System.out.printf("%s\n", "교환/환불 구매점에서 가능(결제카드 지참)");                                                                     //교환 환불 안내 출력
      System.out.println();                                                                                                                              //줄띄움을 위해 출력
      System.out.printf("%s%s  %16s\n", "[구 매]", sd.format(d), "POS:0011-9861");             //현재 날짜와 시간을 출력
      System.out.printf("-----------------------------------------\n");                                                               //줄띄움을 위해 출력
      System.out.printf(" %6s%12s%5s%8s\n", "상 품 명", "단  가", "수량", "금  액");                                                   //항목을 출력
      System.out.printf("-----------------------------------------\n");      //줄띄움을 위해 출력      
      
      
      for (int i = 0; i < K15_itemname.length; i++) {   // 상품 목록 전체 출력
         if (K15_taxfree[i] == true) {     // 면세상품인 경우
            System.out.printf("*");   // 면세표시 출력
            K15_freeprice += K15_price[i] * K15_num[i] ;   // 면세가격 합산
         } else {               // 과세상품인 경우
            System.out.printf(" ");   // 공백 출력
            K15_taxprice += K15_price[i] * K15_num[i] ;   // 과세가격 합산
         }
         System.out.printf(" %s%11.10s%2d%13.11s\n", K15_Bytes(K15_itemname[i], 14),   // 상품명(최대 공백없이 한글9자)
               df.format(K15_price[i]), K15_num[i],    // 상품 가격, 상품 수량
               df.format(K15_price[i] * K15_num[i]));   // 상품 합계 가격
         if ((i + 1) % 5 == 0) {   // 상품 5개마다 구분선 출력
            System.out.printf("-----------------------------------------\n");
         }
      }
      int K15_pay_money = K15_freeprice + K15_taxprice;    //총 지불 금액
      K15_netprice = K15_getNetPrice(K15_taxprice);         //과세를 메소드에 넣어 공급가계산
      K15_tax = K15_taxprice - K15_netprice;            //부가세
      
      System.out.println();                                                            //줄띄움을 위해 출력
      System.out.printf("%22s %13s\n", "총 품목 수량", K15_itemname.length);                     //총 수량을 천단위로 콤마찍어 출력            
      System.out.printf("%23s %14.11s\n", "(*)면 세  물 품", df.format(K15_freeprice));                  //면세물품을 천단위로 콤마찍어 출력
      System.out.printf("%23s %14.11s\n", "과 세  물 품", df.format(K15_netprice));                        //과세물품을 천단위로 콤마찍어 출력
      System.out.printf("%24s %14.11s\n", "부   가   세", df.format(K15_tax));                        //총 부가세를 천단위로 콤마찍어 출력
      System.out.printf("   %24s %12.11s\n", "합        계  ", df.format(K15_pay_money));                  //지불금액을 천단위로 콤마찍어 출력
      System.out.printf("%s %24.11s\n", "결 제 대 상 금 액", df.format(K15_pay_money));              //지불금액을 천단위로 콤마찍어 출력
      System.out.println("-----------------------------------------");                                 //줄띄움을 위해 출력
      System.out.printf("%s %27s\n", "0012 KEB 하나", "54170**0484/35860658");                     //카드와 카드번호를 출력
      System.out.printf("%s %26s\n", "카드결제(IC)", "일시불 / " + df.format(K15_pay_money));         //카드결제와 결제타입을 출력
      System.out.println("-----------------------------------------");                                 //줄띄움을 위해 출력
      System.out.printf("%23s\n", "[신세계포인트 적립]");                                                      //신세계포인트 출력
      System.out.printf("%s\n", "홍*두 고객님의 포인트 현황입니다.");                                          //포인트 현황을 출력
      System.out.printf("%s%16s%11s\n", "금회발생포인트", "9350**9995", "164");                     //금회발생포인트 출력
      System.out.println("누계(가용)포인트         5,637(    5,473)");
      System.out.printf("%20s\n", "*신세계포인트 유효기간은 2년입니다.");                                    //포인트 안내사항 출력
      System.out.println("-----------------------------------------");                                    //줄띄움위해 출력
      System.out.printf("%22s\n", "구매금액기준 무료주차시간 자동부여");                                       //주차안내사항 출력
      System.out.printf("%s :  %28s\n", "차량번호", "34저****");                                             //차량번호 출력
      System.out.printf("%s :  %29s\n", "입차시간", sd2.format(d));                                          //입차시간 출력
      System.out.println("-----------------------------------------");                                 //줄띄움위해 출력
      System.out.printf("%s  %22s\n", "캐셔:084599  양00", "1150");                                       //캐셔정보 출력
      System.out.printf("%39s\n","||||||||||||||||||||||||||||||||||||");                           //바코드 출력
      System.out.printf("%15s/%s/%s/%s\n", sd1.format(d) ,"00119861", "00164980", "31");                                 //바코드 번호 출력      
}
   
         public static int K15_getNetPrice(int K15_iPrice) {             // 공급가액 메소드
            double K15_taxRate = 10.0 / 11.0;                         // 부가세율 10%, 부동소수점 오류 방지 -> 소비자가격 * 10.0 / 11.0 
            double K15_netPrice = K15_iPrice * K15_taxRate;                 // 공급가액 = 총 가격 / (1 + 부가세율)
            return (int) K15_netPrice;                                 // 정수값 공급가액 리턴
         }

   
         public static String K15_Bytes(String K15_inputString, int K15_stringWidth) throws UnsupportedEncodingException {
            for (int i = 0; i < K15_stringWidth; i++) {   //빈 문자열 오류 방지
               K15_inputString += " ";   // 기존 문자열에 설정 너비만큼 공백 더함
            }
            int K15_widhtByte = 0;   // 바이트 기준 가로너비
            int K15_Index = 0;   // 잘라낼 인덱스
            char K15_temp = ' ';   // 문자열 중 한 글자
            for (int i = 0; i < K15_inputString.length(); i++) {   // 문자열 전체
               K15_temp = K15_inputString.charAt(i);   // 한 글자를 char로 받아옴
               if (Character.getType(K15_temp) == 5) {   // character type이 5인 경우 한글
                  K15_widhtByte += 2;   // 한글 글자 너비 2 추가
               } else {   // 한글 아닌 경우
                  K15_widhtByte += 1;   // 한글 외 글자 너비 1 추가
               }
               K15_Index++;   // 잘라낼 인덱스 1 추가
               if (K15_widhtByte > K15_stringWidth) {   // 설정한 최대 너비보다 클 경우 
                  K15_Index --;   // 한글자 앞에서 자른 후
                  break;   // 작업 종료
               }
            }
            String K15_lastname = K15_inputString.substring(0, K15_Index);   // 지정한 인덱스 앞까지 자르기

       // 최종 너비 체크
            int K15_newWidth = K15_lastname.getBytes("EUC-KR").length;   // 한글 2바이트로 간주한 너비 = 바이트 길이
            if (K15_newWidth < K15_stringWidth) {   // 설정한 최대 너비보다 작은 경우
               for (int i = 0; i < K15_stringWidth - K15_newWidth; i++) {   // 남는 자리 만큼
                  K15_lastname += " ";   // 공백 추가
               }
            }
            return K15_lastname; // 새로운 상품이름 반환
         }
}