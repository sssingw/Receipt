package practice;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class receipt2 {

	
	public static void main(String[] args) {										
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");					//��¥�� ������ �����ϴ� ��ü ����
		DecimalFormat df = new DecimalFormat("###,###,###");												//������ ����(õ���� �޸�)�ϴ� ��ü ����
		Date d = new Date();																											//����ð��� �ޱ� ���� ��ü�� ����
		String K15_itemname1 = "�޷γ�";																						//ù��° ��ǰ ���庯��
		String K15_itemcode1 = "1031615";																					//ù��° ��ǰ�� ��ȣ ���� ����
		int K15_price1 = 1000;																										//ù��° ��ǰ �ݾ�
		int K15_amount1 = 5;																											//ù��° ��ǰ ����
		
		String K15_itemname2 = "������";																						//�ι�° ��ǰ ���庯��
		String K15_itemcode2 = "11008152";																				//�ι�° ��ǰ�� ��ȣ ���� ����
		int K15_price2 = 2000;																										//�ι�° ��ǰ �ݾ�
		int K15_amount2 = 6;																											//�ι�° ��ǰ ����
		
		String K15_itemname3 = "������";																						//����° ��ǰ ���庯��
		String K15_itemcode3 = "1020800";																					//����° ��ǰ�� ��ȣ ���� ����
		int K15_price3 = 3000;																										//����° ��ǰ �ݾ�
		int K15_amount3 = 7;																											//����° ��ǰ ����
		
		String K15_itemname4 = "������";																						//�׹�° ��ǰ ���庯��
		String K15_itemcode4 = "1020888";																					//�׹�° ��ǰ�� ��ȣ ���� ����
		int K15_price4 = 1000;																										//�׹�° ��ǰ �ݾ�
		int K15_amount4 = 8;																											//�׹�° ��ǰ ����
		
		int rate = 10;																														//������ �����ϴ� ����
		int K15_taxrate = rate + (rate * 10) / 100;																		// ������ �����ϴ� ����
		int K15Tax = 0;																													//������ �ΰ����� �����ϴ� ����
		int tax_sum = 0;																													//�� �ΰ����� �����ϴ� ����
		int [] price = {1000,1000,2000,3000};																					//�װ��� ��ǰ�� ������ ���� �迭
		int [] amount = {5,6,7,8};																									//�װ��� ��ǰ�� ������ ���� �迭
		
		for (int i = 0; i < price.length; i++) {																					//���ݹ迭�� ���̱��� i�� 0���� �ְ� �ݺ�
			K15Tax = (price[i] -  ((rate * price[i]) / K15_taxrate)) * amount[i] ;								//�ΰ��� ���庯���� ���� ���� ����
			tax_sum = tax_sum + K15Tax;																						//������ �ΰ����� ���� �� �ΰ��� ���庯���� ����
		}		
		int K15_totaltax = (K15_price1 * K15_amount1) + (K15_price2 * K15_amount2)+
										(K15_price3 * K15_amount3) + (K15_price4 * K15_amount4) - tax_sum;   	//�����հ踦 ����(��ü �ܰ��հ� - �� �ΰ���) 
		
		//printf�� �̿��� ��� Ÿ�԰� ĭ����� ����
		System.out.printf("%30s%s%s\n", "\"","���ΰ���, ���̼�","\"");																					//���ΰ��� ���̼� ���
		System.out.printf("%s\n", "(��)�Ƽ����̼�_�д缭����");																								//�Ƽ����̼� ���
		System.out.printf("%s : %5s\n", "��ȭ", "031-702-6016");																							//��ȭ�� ��ȣ�� ���
		System.out.printf("%s : %5s\n", "����", "���� ������ ���μ�ȯ�� 2748 (���)");															//����� ��ġ�� ���
		System.out.printf("%s : %5s %s\n", "��ǥ", "������,��ȣ��", "213-81-52063");															//��ǥ�� ��ȣ�� ���
		System.out.printf("%s : %5s\n %s\n", "����", "��⵵ ������ �д籸 �д��53���� 11 (����","��)");								//����� ��ġ ���
		System.out.println("====================================");																		//�ٶ������ ���
		System.out.printf("%32s\n", "�Һ����߽ɰ濵(CCM) �������");																					//�Һ����߽ɰ濵 ���
		System.out.printf("%20s %3s %3s\n", "ISO 9001", "ǰ���濵�ý���", "�������");														//ǰ���濵���
		System.out.println("====================================");																		//�ٶ������ ���
		System.out.printf("%32s\n", "��ȯ/ȯ�� 14��(03��12��)�̳�,");																					//��ȯ�ȳ� ���
		System.out.printf(" %4s  %15s\n", "(����)������," ,"����ī�� ���� �� ���Ը��忡�� ����");												//�� �ȳ� ���
		System.out.printf("%33s\n", "���� / ���� �� �Ѽս� ��ȯ / ȯ�� �Ұ�");																			//��ȯ�Ұ� �ȳ� ���
		System.out.printf("%30s\n", "üũī�� ��� �� �ִ� 7�� �ҿ�");																						//üũī�� �ȳ����� ���
		System.out.println("====================================");																		//�ٶ������ ���
		System.out.printf("%s %33s\n", "[POS 1058231]", sd.format(d));																			//pos��ȣ�� ���� ��¥ �ð� ���
		System.out.println("====================================");																		//�ٶ�� ���� ���
		System.out.printf("%s %29s %10d %12s\n", 																											//ù��°�׸� ��������
					K15_itemname1, df.format(K15_price1), K15_amount1, df.format(K15_price1 * K15_amount1));			//�׸��̸��� �ܰ�, ����, ���� ���
		System.out.printf("[%s]\n",K15_itemcode1);																											//�׸��� ��ȣ ���
		System.out.printf("%s %29s %10d %11s\n", 																											//�ι�°�׸� ��������
					K15_itemname2, df.format(K15_price2), K15_amount2, df.format(K15_price2 * K15_amount2));			//�׸��̸��� �ܰ�, ���� ���� ���
		System.out.printf("[%s]\n",K15_itemcode2);																											//�׸��� ��ȣ ���
		System.out.printf("%s %29s %10d %11s\n", 																											//����°�׸� ��������
					K15_itemname3, df.format(K15_price3), K15_amount3, df.format(K15_price3 * K15_amount3));			//�׸��̸��� �ܰ�, ���� ���� ���
		System.out.printf("[%s]\n",K15_itemcode3);;																											//�׸��� ��ȣ ���
		System.out.printf("%s %29s %10d %12s\n",																												//�׹����׸� ��������
					K15_itemname4, df.format(K15_price4), K15_amount4, df.format(K15_price4 * K15_amount4));			//�׸��̸��� �ܰ�,���� ���� ���
		System.out.printf("[%s]\n",K15_itemcode4);																											//�׸��� ��ȣ ���
		System.out.printf("%35s %23s\n", "�����հ�", df.format(K15_totaltax));																	//�����հ�� ���� õ���� �޸�������
		System.out.printf("%37s %24s\n", "�ΰ���", df.format(tax_sum));																			//�ΰ����� ���� õ���� �޸���� ���
		System.out.println("------------------------------------------------------------");																		//�ٶ�� ���� ���
		System.out.printf("%s %54s\n", "�Ǹ��հ�", df.format(K15_totaltax + tax_sum));													//�Ǹ��հ�� �Ѱ����� �Ѻΰ����� �հ�
		System.out.println("====================================");																		//�ٶ�� ���� ���
		System.out.printf("%s %54s\n", "�ſ�ī��", df.format(K15_totaltax + tax_sum));													//��������� ������ ���
		System.out.println("------------------------------------------------------------");																						//�ٶ�� ���� ���
		System.out.printf("%s %33d**********\n", "�츮ī��",538720);																								//ī��� ī���ȣ ���
		System.out.printf("%s %d (%d)%19s%s\n", "���ι�ȣ", 77982843,0,"���αݾ�", df.format(K15_totaltax + tax_sum));			//���ι�ȣ�� ������ ���
		System.out.println("====================================");																						//�ٶ������ ���
		System.out.printf("%33s %s\n", sd.format(d), "�д缭����");																									//���糯¥�� �ð� ���
		System.out.printf("%s : %s\n", "��ǰ �� ��Ÿ ����", "1522-4400");																								//��ǰ���ǿ� ��ȣ ���
		System.out.printf("%s : %s\n", "����� �� �����̼� ���� ����", "1599-2211");																				//���ǿ� ��ȣ ���
		System.out.printf("%41s\n","|||||||||||||||||||||||||");																									//���ڵ� ���
		System.out.printf("%37s\n", "2112820610158231");																												//���ڵ� ��ȣ ���
		System.out.println("------------------------------------------------------------");																						//�ٶ�� ���� ���
		System.out.printf("%s\n", "* ���̼� ����� �� �Ǵ� Ȩ�������� �����ϼż�");																					//������ �ȳ����� ���
		System.out.printf("%2s\n", "ȸ������ �� �پ��� ������ ����������!*");																							//������ �ȳ����� ���
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
