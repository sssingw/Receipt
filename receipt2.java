package receipt;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class receipt2 {

   
   public static void main(String[] args) throws UnsupportedEncodingException {                              
      SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd kk:mm:ss");               //날짜의 서식을 지정하는 객체 생성
      DecimalFormat df = new DecimalFormat("###,###,###");                             //서식을 지정(천단위 콤마)하는 객체 생성
      Date d = new Date();                                                             //현재시간을 받기 위해 객체를 생성
      String K15_itemname[] = {"퓨어에어 비말차단용마스크", "슬라이드식명찰(가로형)", "매직흡착 인테리어후크(알루미늄)"};   //항목 배열                                                               //첫번째 물품 저장변수                                                             
      int K15_price[] = {1000000, 100, 100}; 																				//가격 배열
      int K15_num[] = {1, 1, 1};																							//수량 배열
      String K15_itemcode[] = {"11008152","1020800","1020888"};   															//코드 배열                                                                          //첫번째 물품 개수
      
      int K15_taxprice = 0;       					//과세총합계
      int K15_freeprice = 0;     					//면세 총합계
      int K15_totalprice = 0;    				    //전체 합계
      int K15_netprice = 0;       					//과세 공급가
      int K15_tax = 0;            					//부가세
      
           
      //printf를 이용해 출력 타입과 칸띄움을 지정
      System.out.println(             "            \"국민가게, 다이소\""   );          //국민가게 다이소 출력
      System.out.printf("%s\n", "(주)아성다이소_분당서현점");                          //아성다이소 출력
      System.out.println("전화:031-702-6016");                                         //전화와 번호를 출력"
      System.out.println("본사:서울 강남구 남부순환로 2748 (도곡동)");                 //본사와 위치를 출력
      System.out.println("대표:박정부,신호섭 213-81-52063");                           //대표와 번호를 출력
      System.out.println("매장:경기도 성남시 분당구 분당로53번길 1"); 				   //매장 위치 출력
      System.out.println("1 (서현동)"); 											   //매장 위치 출력
      System.out.println("=========================================");                 //줄띄움위해 출력
      System.out.printf("%23s\n", "소비자중심경영(CCM) 인증기업");                     //소비자중심경영 출력
      System.out.printf("%12s %3s %3s\n", "ISO 9001", "품질경영시스템", "인증기업");   //품질경영출력
      System.out.println("=========================================");                 //줄띄움위해 출력
      System.out.printf("%26s\n", "교환/환불 14일(05월07일)이내,");                    //교환안내 출력
      System.out.println("(전자)영수증, 결제카드 지참 후 구입매장");				   //교환안내 출력
      System.out.println("에서 가능");                                    			   //교환 안내 출력
      System.out.printf("%25s\n", "포장/가격 택 훼손시 교환/환불 불가");               //교환불가 안내 출력
      System.out.printf("%23s\n", "체크카드 취소 시 최대 7일 소요");                   //체크카드 안내사항 출력
      System.out.println("=========================================");                 //줄띄움위해 출력
      System.out.printf("%s %27s\n", "[POS 1058231]", sd.format(d));                   //pos번호와 현재 날짜 시간 출력
      System.out.println("=========================================");       
      
           
      for (int i = 0; i < K15_itemname.length; i++) {   								// 상품 목록 전체 출력
         K15_taxprice += K15_price[i] * K15_num[i] ;   									// 과세가격 합산
         System.out.printf("%s%9.9s%3d%11.10s\n", K15_Bytes(K15_itemname[i], 18),   	// 상품명(최대 공백없이 한글9자)
               df.format(K15_price[i]), K15_num[i],   									// 상품 가격, 상품 수량
               df.format(K15_price[i] * K15_num[i]));   								// 상품 합계 가격
         System.out.println("["+K15_itemcode[i]+"]");									//한줄 간격으로 코드 출력
      }                 		
      
     
      K15_netprice = K15_getNetPrice(K15_taxprice);         							//과세를 메소드에 넣어 공급가계산
      K15_tax = K15_taxprice - K15_netprice;            								//부가세
         
      System.out.printf("%22s %14.10s\n", "과세합계", df.format(K15_netprice));         //과세합계와 값을 천단위 콤마찍어출력
      System.out.printf("%23s %14.9s\n", "부가세", df.format(K15_tax));                 //부가세와 값을 천단위 콤마찍어 출력
      System.out.printf("-----------------------------------------\n");                 //줄띄움 위해 출력
      System.out.printf("%s%33s\n", "판매합계", df.format(K15_netprice + K15_tax));     //판매합계는 총과세와 총부가세의 합계
      System.out.println("=========================================");                  //줄띄움 위해 출력
      System.out.printf("%s%33s\n", "신용카드", df.format(K15_netprice + K15_tax));     //결제내용과 결제값 출력
      System.out.printf("-----------------------------------------\n");                 //줄띄움 위해 출력
      System.out.printf("%s %22d**********\n", "우리카드",538720);                      //카드와 카드번호 출력
      System.out.printf("%s %d (%d)%5s %10.10s\n", "승인번호", 77982843,0,"승인금액"	 //승인번호와 결제값 출력
    		  			, df.format(K15_netprice + K15_tax));        
      System.out.println("=========================================");                   //줄띄움위해 출력
      System.out.printf("%25s %s\n", sd.format(d), "분당서현점");                        //현재날짜와 시간 출력
      System.out.printf("%s : %s\n", "상품 및 기타 문의", "1522-4400");                  //상품문의와 번호 출력
      System.out.printf("%s : %s\n", "멤버십 및 샵다이소 관련 문의", "1599-2211");       //문의와 번호 출력
      System.out.printf("%32s\n","|||||||||||||||||||||||||");                           //바코드 출력
      System.out.printf("%28s\n", "2112820610158231");                                   //바코드 번호 출력
      System.out.printf("-----------------------------------------\n");                  //줄띄움 위해 출력
      System.out.println("◈ 다이소 멤버십 앱 또는 홈페이지에 접속");                    //마지막 안내사항 출력
      System.out.println("   하셔서 회원가입 후 다양한 혜택을 누려");                    //마지막 안내사항 출력
      System.out.println("   보세요! ◈"); 
   }
     
      public static int K15_getNetPrice(int K15_iPrice) {            					 //공급가액 메소드
         double K15_taxRate = 10.0 / 11.0;                         						 //부가세율 = 10%, 소비자가격 = * 10.0 / 11.0 
         double K15_netPrice = K15_iPrice * K15_taxRate;                 				 //공급가액 = 총 가격 / (1 + 부가세율)
         return (int) K15_netPrice;                                 					 //정수값 공급가액 리턴
      }
    
      public static String K15_Bytes(String K15_inputString, int K15_stringWidth) throws UnsupportedEncodingException {
          for (int i = 0; i < K15_stringWidth; i++) {   								 //빈 문자열 오류 방지
             K15_inputString += " ";  													 //기존 문자열에 설정 너비만큼 공백 더함
          }
          int K15_widhtByte = 0;  														 //바이트 기준 가로너비
          int K15_Index = 0;   															 //잘라낼 인덱스
          char K15_temp = ' ';   														 //문자열 중 한 글자
          for (int i = 0; i < K15_inputString.length(); i++) {                           //문자열 전체
             K15_temp = K15_inputString.charAt(i);                                       //한 글자를 char로 받아옴
             if (Character.getType(K15_temp) == 5) {                                     //character type이 5인 경우 한글
                K15_widhtByte += 2;                                                      //한글 글자 너비 2 추가
             } else {                                                                    //한글 아닌 경우
                K15_widhtByte += 1;                                                      //한글 외 글자 너비 1 추가
             }
             K15_Index++;                                                    			 //잘라낼 인덱스 1 추가
             if (K15_widhtByte > K15_stringWidth) {                                      //설정한 최대 너비보다 클 경우 
                K15_Index --;                                                            //한글자 앞에서 자른 후
                break;                                                                   //작업 종료
             }
          }
          String K15_lastname = K15_inputString.substring(0, K15_Index);                 //지정한 인덱스 앞까지 자르기

          //최종 너비 체크
          int K15_newWidth = K15_lastname.getBytes("EUC-KR").length;                     //한글 2바이트로 간주한 너비 = 바이트 길이
          if (K15_newWidth < K15_stringWidth) {                                          //설정한 최대 너비보다 작은 경우
             for (int i = 0; i < K15_stringWidth - K15_newWidth; i++) {                  //남는 자리 만큼
                K15_lastname += " ";                                                     //공백 추가
             }
          }
          return K15_lastname;                                                           //새로운 상품이름 반환
       }
}

