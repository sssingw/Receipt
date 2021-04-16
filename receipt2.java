package practice;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class receipt2 {

	
	public static void main(String[] args) {										
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");					//날짜의 서식을 지정하는 객체 생성
		DecimalFormat df = new DecimalFormat("###,###,###");												//서식을 지정(천단위 콤마)하는 객체 생성
		Date d = new Date();																											//현재시간을 받기 위해 객체를 생성
		String K15_itemname1 = "메로나";																						//첫번째 물품 저장변수
		String K15_itemcode1 = "1031615";																					//첫번째 물품의 번호 저장 변수
		int K15_price1 = 1000;																										//첫번째 물품 금액
		int K15_amount1 = 5;																											//첫번째 물품 개수
		
		String K15_itemname2 = "월드콘";																						//두번째 물품 저장변수
		String K15_itemcode2 = "11008152";																				//두번째 물품의 번호 저장 변수
		int K15_price2 = 2000;																										//두번째 물품 금액
		int K15_amount2 = 6;																											//두번째 물품 개수
		
		String K15_itemname3 = "빵빠레";																						//세번째 물품 저장변수
		String K15_itemcode3 = "1020800";																					//세번째 물품의 번호 저장 변수
		int K15_price3 = 3000;																										//세번째 물품 금액
		int K15_amount3 = 7;																											//세번째 물품 개수
		
		String K15_itemname4 = "빠삐코";																						//네번째 물품 저장변수
		String K15_itemcode4 = "1020888";																					//네번째 물품의 번호 저장 변수
		int K15_price4 = 1000;																										//네번째 물품 금액
		int K15_amount4 = 8;																											//네번째 물품 개수
		
		int rate = 10;																														//세액을 저장하는 변수
		int K15_taxrate = rate + (rate * 10) / 100;																		// 세액을 저장하는 변수
		int K15Tax = 0;																													//각각의 부가세를 저장하는 변수
		int tax_sum = 0;																													//총 부가세를 저장하는 변수
		int [] price = {1000,1000,2000,3000};																					//네가지 물품의 가격을 넣은 배열
		int [] amount = {5,6,7,8};																									//네가지 물품의 수량을 넣은 배열
		
		for (int i = 0; i < price.length; i++) {																					//가격배열의 길이까지 i에 0부터 넣고 반복
			K15Tax = (price[i] -  ((rate * price[i]) / K15_taxrate)) * amount[i] ;								//부가세 저장변수에 연산 값을 저장
			tax_sum = tax_sum + K15Tax;																						//각각의 부가세를 더해 총 부가세 저장변수에 저장
		}		
		int K15_totaltax = (K15_price1 * K15_amount1) + (K15_price2 * K15_amount2)+
										(K15_price3 * K15_amount3) + (K15_price4 * K15_amount4) - tax_sum;   	//과세합계를 저장(전체 단가합계 - 총 부가세) 
		
		//printf를 이용해 출력 타입과 칸띄움을 지정
		System.out.printf("%30s%s%s\n", "\"","국민가게, 다이소","\"");																					//국민가게 다이소 출력
		System.out.printf("%s\n", "(주)아성다이소_분당서현점");																								//아성다이소 출력
		System.out.printf("%s : %5s\n", "전화", "031-702-6016");																							//전화와 번호를 출력
		System.out.printf("%s : %5s\n", "본사", "서울 강남구 남부순환로 2748 (도곡동)");															//본사와 위치를 출력
		System.out.printf("%s : %5s %s\n", "대표", "박정부,신호섭", "213-81-52063");															//대표와 번호를 출력
		System.out.printf("%s : %5s\n %s\n", "매장", "경기도 성남시 분당구 분당로53번길 11 (서현","동)");								//매장과 위치 출력
		System.out.println("====================================");																		//줄띄움위해 출력
		System.out.printf("%32s\n", "소비자중심경영(CCM) 인증기업");																					//소비자중심경영 출력
		System.out.printf("%20s %3s %3s\n", "ISO 9001", "품질경영시스템", "인증기업");														//품질경영출력
		System.out.println("====================================");																		//줄띄움위해 출력
		System.out.printf("%32s\n", "교환/환불 14일(03월12일)이내,");																					//교환안내 출력
		System.out.printf(" %4s  %15s\n", "(전자)영수증," ,"결제카드 지참 후 구입매장에서 가능");												//상세 안내 출력
		System.out.printf("%33s\n", "포장 / 가격 택 훼손시 교환 / 환불 불가");																			//교환불가 안내 출력
		System.out.printf("%30s\n", "체크카드 취소 시 최대 7일 소요");																						//체크카드 안내사항 출력
		System.out.println("====================================");																		//줄띄움위해 출력
		System.out.printf("%s %33s\n", "[POS 1058231]", sd.format(d));																			//pos번호와 현재 날짜 시간 출력
		System.out.println("====================================");																		//줄띄움 위해 출력
		System.out.printf("%s %29s %10d %12s\n", 																											//첫번째항목 서식지정
					K15_itemname1, df.format(K15_price1), K15_amount1, df.format(K15_price1 * K15_amount1));			//항목이름과 단가, 수량, 가격 출력
		System.out.printf("[%s]\n",K15_itemcode1);																											//항목의 번호 출력
		System.out.printf("%s %29s %10d %11s\n", 																											//두번째항목 서식지정
					K15_itemname2, df.format(K15_price2), K15_amount2, df.format(K15_price2 * K15_amount2));			//항목이름과 단가, 수량 가격 출력
		System.out.printf("[%s]\n",K15_itemcode2);																											//항목의 번호 출력
		System.out.printf("%s %29s %10d %11s\n", 																											//세번째항목 서식지정
					K15_itemname3, df.format(K15_price3), K15_amount3, df.format(K15_price3 * K15_amount3));			//항목이름과 단가, 수량 가격 출력
		System.out.printf("[%s]\n",K15_itemcode3);;																											//항목의 번호 출력
		System.out.printf("%s %29s %10d %12s\n",																												//네번쨰항목 서식지정
					K15_itemname4, df.format(K15_price4), K15_amount4, df.format(K15_price4 * K15_amount4));			//항목이름과 단가,수량 가격 출력
		System.out.printf("[%s]\n",K15_itemcode4);																											//항목의 번호 출력
		System.out.printf("%35s %23s\n", "과세합계", df.format(K15_totaltax));																	//과세합계와 값을 천단위 콤마찍어출력
		System.out.printf("%37s %24s\n", "부가세", df.format(tax_sum));																			//부가세와 값을 천단위 콤마찍어 출력
		System.out.println("------------------------------------------------------------");																		//줄띄움 위해 출력
		System.out.printf("%s %54s\n", "판매합계", df.format(K15_totaltax + tax_sum));													//판매합계는 총과세와 총부가세의 합계
		System.out.println("====================================");																		//줄띄움 위해 출력
		System.out.printf("%s %54s\n", "신용카드", df.format(K15_totaltax + tax_sum));													//결제내용과 결제값 출력
		System.out.println("------------------------------------------------------------");																						//줄띄움 위해 출력
		System.out.printf("%s %33d**********\n", "우리카드",538720);																								//카드와 카드번호 출력
		System.out.printf("%s %d (%d)%19s%s\n", "승인번호", 77982843,0,"승인금액", df.format(K15_totaltax + tax_sum));			//승인번호와 결제값 출력
		System.out.println("====================================");																						//줄띄움위해 출력
		System.out.printf("%33s %s\n", sd.format(d), "분당서현점");																									//현재날짜와 시간 출력
		System.out.printf("%s : %s\n", "상품 및 기타 문의", "1522-4400");																								//상품문의와 번호 출력
		System.out.printf("%s : %s\n", "멤버십 및 샵다이소 관련 문의", "1599-2211");																				//문의와 번호 출력
		System.out.printf("%41s\n","|||||||||||||||||||||||||");																									//바코드 출력
		System.out.printf("%37s\n", "2112820610158231");																												//바코드 번호 출력
		System.out.println("------------------------------------------------------------");																						//줄띄움 위해 출력
		System.out.printf("%s\n", "* 다이소 멤버십 앱 또는 홈페이지에 접속하셔서");																					//마지막 안내사항 출력
		System.out.printf("%2s\n", "회원가입 후 다양한 혜택을 누려보세요!*");																							//마지막 안내사항 출력
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
