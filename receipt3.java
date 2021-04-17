

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class receipt3 {

	public static void main(String[] args) {
																																					
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");																				//날짜의 서식을 지정하는 객체 생성
		Date d = new Date();																																										//현재시간을 받기 위해 객체를 생성
		DecimalFormat df = new DecimalFormat ("###,###,###");																											//서식을 지정(천단위 콤마)하는 객체 생성
	
		String [] K15_itemname = {"꼬북칩","꼬깔콘","도리토스","죠리퐁","오징어집","오감자","양파링","바나나킥","스윙칩","차카니",				//문자열 타입의 배열에 과제30개를 넣음
													"고래밥","뿌셔뿌셔","프링글스","홈런볼","웨하스","다이제","쿠크다스","롤리폴리","새콤달콤","빼빼로",			
													"포카칩","포스틱","자갈치","치토스","콘초코","콘치즈","새우깡","초코하임","오예스","쫄병스낵"};
		int [] K15_price = {1000, 1500, 2000, 2500, 3000, 4000, 4500, 1000, 1500, 2000, 																		//가격 배열에 각 과자의가격(단가)을 넣음
								2500, 3000, 3500, 4000, 1000, 1300, 1800, 2300, 2800, 1900,																				
								3300, 1000, 1300, 2300, 2500, 3000, 2700, 1400, 1500, 1000}; 
		int [] K15_num =  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1,  1, 2, 1, 1, 1, 1, 1};  												//각 과자의 수량을 배열에 넣음
		boolean [] K15_taxfree = {false, false, false, false, true, false, false, false, false, false,																//면제유무에 대해 배열에 넣어 true이면 면세
													false, false, false, false, true, false, false, false, false, false,
													false, false, false, false, true, false, false, false, false, false}; 
		int K15_total_num = 0;																																									//과자의 총수량을 저장할 변수
		for (int i = 0; i < K15_num.length; i++) {																																		//수량배열의 길이까지 반복문을 넣음
			K15_total_num = K15_total_num + K15_num[i];																														//과자의 총 수량을 연산해 저장
		}    //총수량
			
		int K15_total_price1 = 0;																																							    //각각의 수량을 포함한 금액을 넣을 변수															
		int K15_total_price2 = 0; 																																								//각각의 금액을 더한 것을 넣을 변수
		for (int i = 0; i < K15_price.length; i++) {																																		//금액배열의 길이까지 반복문을 넣어 돌림
			K15_total_price1 =  K15_price[i] * K15_num[i];																														//수량x가격으로 값을 저장
			K15_total_price2 = K15_total_price2 + K15_total_price1;   																									//총 금액합계
		}		
		int K15_rate = 10;																																											//세액을 저장하는 변수
		int K15_taxrate = K15_rate + (K15_rate * 10) / 100;																													// 세액을 저장하는 변수		
		int K15Tax = 0;																																												//각각의 부가세를 넣을 변수
		int K15_tax_sum = 0;																																										//총 부가세를 저장할 변수
		int K15_notax = 0;             																																								//각각의 면세값을 넣을 변수
		int K15_sum_notax = 0;																																									//총 면세 합계
		int K15_total_tax = 0;   																																									//총 과세 합계
		for (int i = 0; i < K15_taxfree.length; i++) {																																	//면세배열의 길이까지 반복문을 넣어 돌림
			if (K15_taxfree[i] == true) {																																						//면세배열의 인덱스가 true(면세)이면
				K15_notax = K15_price[i] * K15_num[i] ;																																//면세이므로 가격과 수량만 곱함
				K15_sum_notax = K15_sum_notax + K15_notax;    																												//총 면세물품													
			}
			else if (K15_taxfree[i] == false) {																																				//면세배열의 인덱스가 false(면세x)이면
				K15Tax = (K15_price[i] -  ((K15_rate * K15_price[i]) / K15_taxrate)) * K15_num[i];   															//각각의 부가세를 구하고 각 개수를 곱한다.
				K15_tax_sum = K15_tax_sum + K15Tax;	   																															//각각의 부가세를 더해 총 부가세		
			}
		}
		K15_total_tax =  K15_total_price2 - K15_tax_sum;   																													//총 과세 합계
		int K15_pay_money = K15_sum_notax + K15_total_tax + K15_tax_sum;																					//총 지불금액 = 면세금액 + 부가세 + 과세물품				
		System.out.printf("%50s\n", "이마트 죽전점 (031)838-1234");																										//이마트 죽전점을 출력
		System.out.printf("%15s %24s\n","emart",  "206-86-50913 강희석");																							//emart와 번호를 출력
		System.out.printf("%44s\n", "용인 수지구 포은대로 552");																												//위치 출력
		System.out.printf(" %s\n", "영수증 미지참시 교환 / 환불 불가");																											//교환 환불 안내 출력
		System.out.printf(" %s\n", "정상상품에 한함, 30일 이내(신선 7일)");																									//교환 환불 안내 출력
		System.out.printf(" %s\n", "*일부 브랜드매장 제외(매장 고지물참조)");																								//교환 환불 안내 출력
		System.out.printf(" %s\n", "교환 / 환불 구매점에서 가능(결제카드 지참)");																							//교환 환불 안내 출력
		System.out.println();																																										//줄띄움을 위해 출력
		System.out.printf(" %s%s   %15s\n", "[구 매]", sd.format(d), "POS:0011-9861");																			//현재 날짜와 시간을 출력
		System.out.printf("-------------------------------------------------------------\n");																						//줄띄움을 위해 출력
		System.out.printf("%13s %13s %13s %12s\n", "상  품  명", "단  가", "수  량", "금  액");																	//항목을 출력
		System.out.printf("-------------------------------------------------------------\n");																						//줄띄움을 위해 출력		
		for (int i = 0; i < K15_itemname.length; i++) {																																//0부터 과자배열의 길이까지 반복
			if (K15_itemname[i].length() > 3) {																																			//과자 하나하나의 길이가 3을 넘을 경우
					if (K15_taxfree[i] == true) {																																				//또 면세일경우
						System.out.printf("*%9s %13s %13s  %15s\n",																												//각 배열의 해당 품목앞에 *를 붙이고
								K15_itemname[i],df.format(K15_price[i]), K15_num[i],df.format(K15_price[i] * K15_num[i]));						//단가와 수량, 금액을 천단위 콤마찍어 출력
					} else {																																													//면세가 아닐경우
						System.out.printf("%11s %13s %13s  %15s\n",																												//각 배열의 해당품목과 
								K15_itemname[i],df.format(K15_price[i]), K15_num[i],df.format(K15_price[i] * K15_num[i]));						//단가와 수량, 금액을 천단위 콤마찍어 출력
					} 	
			} else {																																															//과자 하나하나의 길이가 3을 넘지 않을 경우
					if (K15_taxfree[i] == true) {																																				//또 면세일 경우
						System.out.printf("*%9s %15s %13s %16s\n",																												//각 배열의 해당 품목앞에 *를 붙이고
								K15_itemname[i],df.format(K15_price[i]), K15_num[i],df.format(K15_price[i] * K15_num[i]));						//단가와 수량, 금액을 천단위 콤마찍어 출력
					} else {																																													//면세가 아닐경우
						System.out.printf("%11s %15s %13s  %15s\n",																												//각 배열의 해당품목과 
								K15_itemname[i],df.format(K15_price[i]), K15_num[i],df.format(K15_price[i] * K15_num[i]));						//단가와 수량, 금액을 천단위 콤마찍어 출력
					}
			}
			if ((i + 1) % 5 ==0) {																														//5줄마다 줄을 출력하기 위해 0부터 시작하는 i에 5를 더해
				System.out.println("-------------------------------------------------------------");									//0으로 나누어떨어지면 줄을 출력
			}
		}
		
		System.out.println();																														//줄띄움을 위해 출력
		System.out.printf("%33s %27s\n", "총 품목 수량", df.format(K15_total_num));							//총 수량을 천단위로 콤마찍어 출력				
		System.out.printf(" %33s %24s\n", "(*)면 세  물  품", df.format(K15_sum_notax));						//면세물품을 천단위로 콤마찍어 출력
		System.out.printf(" %34s %24s\n", "과 세  물  품", df.format(K15_total_tax));								//과세물품을 천단위로 콤마찍어 출력
		System.out.printf("%37s %25s\n", "부    가    세", df.format(K15_tax_sum));								//총 부가세를 천단위로 콤마찍어 출력
		System.out.printf(" %40s %22s\n", "합           계  ", df.format(K15_pay_money));						//지불금액을 천단위로 콤마찍어 출력
		System.out.printf("%s%40s\n", "결  제  대  상  금  액", df.format(K15_pay_money));					//지불금액을 천단위로 콤마찍어 출력
		System.out.println("-------------------------------------------------------------");											//줄띄움을 위해 출력
		System.out.printf("%s %30s\n", "0012 KEB 하나", "54170**0484/35860658");							//카드와 카드번호를 출력
		System.out.printf("%s %42s\n", "카드결제(IC)", "일시불 / " + df.format(K15_pay_money));			//카드결제와 결제타입을 출력
		System.out.println("-------------------------------------------------------------");											//줄띄움을 위해 출력
		System.out.printf("%35s\n", "[신세계포인트 적립]");																		//신세계포인트 출력
		System.out.printf("%s\n", "변*원 고객님의 포인트 현황입니다.");														//포인트 현황을 출력
		System.out.printf("%s %25s%12s\n", "금회발생포인트", "9350**9995", "164");							//금회발생포인트 출력
		System.out.printf("%s%28s( %10s)\n", "누계(가용)포인트", df.format(5637),df.format(5473));		//누계가용포인트를 천단위로 콤마찍어 출력
		System.out.printf("%20s\n", "*신세계포인트 유효기간은 2년입니다.");												//포인트 안내사항 출력
		System.out.println("-------------------------------------------------------------");											//줄띄움위해 출력
		System.out.printf("%33s\n", "구매금액기준 무료주차시간 자동부여");													//주차안내사항 출력
		System.out.printf("%s :  %49s\n", "차량번호", "34저****");															//차량번호 출력
		System.out.printf("%s :  %43s\n", "입차시간", sd.format(d));														//입차시간 출력
		System.out.println("-------------------------------------------------------------");											//줄띄움위해 출력
		System.out.printf("%s  %39s\n", "캐셔:084599  양00", "1150");													//캐셔정보 출력
		System.out.printf("%41s\n","||||||||||||||||||||||||||||||||||||");									//바코드 출력
		System.out.printf("%39s\n", "20210303/00119861/00164980/31");											//바코드 번호 출력		
		}
	}
		
		
	


	

