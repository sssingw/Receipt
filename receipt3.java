

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class receipt3 {

	public static void main(String[] args) {
																																					
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");																				//��¥�� ������ �����ϴ� ��ü ����
		Date d = new Date();																																										//����ð��� �ޱ� ���� ��ü�� ����
		DecimalFormat df = new DecimalFormat ("###,###,###");																											//������ ����(õ���� �޸�)�ϴ� ��ü ����
	
		String [] K15_itemname = {"����Ĩ","������","�����佺","�Ҹ���","��¡����","������","���ĸ�","�ٳ���ű","����Ĩ","��ī��",				//���ڿ� Ÿ���� �迭�� ����30���� ����
													"����","�ѼŻѼ�","�����۽�","Ȩ����","���Ͻ�","������","��ũ�ٽ�","�Ѹ�����","���޴���","������",			
													"��īĨ","����ƽ","�ڰ�ġ","ġ�佺","������","��ġ��","�����","��������","������","�̺�����"};
		int [] K15_price = {1000, 1500, 2000, 2500, 3000, 4000, 4500, 1000, 1500, 2000, 																		//���� �迭�� �� �����ǰ���(�ܰ�)�� ����
								2500, 3000, 3500, 4000, 1000, 1300, 1800, 2300, 2800, 1900,																				
								3300, 1000, 1300, 2300, 2500, 3000, 2700, 1400, 1500, 1000}; 
		int [] K15_num =  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1,  1, 2, 1, 1, 1, 1, 1};  												//�� ������ ������ �迭�� ����
		boolean [] K15_taxfree = {false, false, false, false, true, false, false, false, false, false,																//���������� ���� �迭�� �־� true�̸� �鼼
													false, false, false, false, true, false, false, false, false, false,
													false, false, false, false, true, false, false, false, false, false}; 
		int K15_total_num = 0;																																									//������ �Ѽ����� ������ ����
		for (int i = 0; i < K15_num.length; i++) {																																		//�����迭�� ���̱��� �ݺ����� ����
			K15_total_num = K15_total_num + K15_num[i];																														//������ �� ������ ������ ����
		}    //�Ѽ���
			
		int K15_total_price1 = 0;																																							    //������ ������ ������ �ݾ��� ���� ����															
		int K15_total_price2 = 0; 																																								//������ �ݾ��� ���� ���� ���� ����
		for (int i = 0; i < K15_price.length; i++) {																																		//�ݾ׹迭�� ���̱��� �ݺ����� �־� ����
			K15_total_price1 =  K15_price[i] * K15_num[i];																														//����x�������� ���� ����
			K15_total_price2 = K15_total_price2 + K15_total_price1;   																									//�� �ݾ��հ�
		}		
		int K15_rate = 10;																																											//������ �����ϴ� ����
		int K15_taxrate = K15_rate + (K15_rate * 10) / 100;																													// ������ �����ϴ� ����		
		int K15Tax = 0;																																												//������ �ΰ����� ���� ����
		int K15_tax_sum = 0;																																										//�� �ΰ����� ������ ����
		int K15_notax = 0;             																																								//������ �鼼���� ���� ����
		int K15_sum_notax = 0;																																									//�� �鼼 �հ�
		int K15_total_tax = 0;   																																									//�� ���� �հ�
		for (int i = 0; i < K15_taxfree.length; i++) {																																	//�鼼�迭�� ���̱��� �ݺ����� �־� ����
			if (K15_taxfree[i] == true) {																																						//�鼼�迭�� �ε����� true(�鼼)�̸�
				K15_notax = K15_price[i] * K15_num[i] ;																																//�鼼�̹Ƿ� ���ݰ� ������ ����
				K15_sum_notax = K15_sum_notax + K15_notax;    																												//�� �鼼��ǰ													
			}
			else if (K15_taxfree[i] == false) {																																				//�鼼�迭�� �ε����� false(�鼼x)�̸�
				K15Tax = (K15_price[i] -  ((K15_rate * K15_price[i]) / K15_taxrate)) * K15_num[i];   															//������ �ΰ����� ���ϰ� �� ������ ���Ѵ�.
				K15_tax_sum = K15_tax_sum + K15Tax;	   																															//������ �ΰ����� ���� �� �ΰ���		
			}
		}
		K15_total_tax =  K15_total_price2 - K15_tax_sum;   																													//�� ���� �հ�
		int K15_pay_money = K15_sum_notax + K15_total_tax + K15_tax_sum;																					//�� ���ұݾ� = �鼼�ݾ� + �ΰ��� + ������ǰ				
		System.out.printf("%50s\n", "�̸�Ʈ ������ (031)838-1234");																										//�̸�Ʈ �������� ���
		System.out.printf("%15s %24s\n","emart",  "206-86-50913 ����");																							//emart�� ��ȣ�� ���
		System.out.printf("%44s\n", "���� ������ ������� 552");																												//��ġ ���
		System.out.printf(" %s\n", "������ �������� ��ȯ / ȯ�� �Ұ�");																											//��ȯ ȯ�� �ȳ� ���
		System.out.printf(" %s\n", "�����ǰ�� ����, 30�� �̳�(�ż� 7��)");																									//��ȯ ȯ�� �ȳ� ���
		System.out.printf(" %s\n", "*�Ϻ� �귣����� ����(���� ����������)");																								//��ȯ ȯ�� �ȳ� ���
		System.out.printf(" %s\n", "��ȯ / ȯ�� ���������� ����(����ī�� ����)");																							//��ȯ ȯ�� �ȳ� ���
		System.out.println();																																										//�ٶ���� ���� ���
		System.out.printf(" %s%s   %15s\n", "[�� ��]", sd.format(d), "POS:0011-9861");																			//���� ��¥�� �ð��� ���
		System.out.printf("-------------------------------------------------------------\n");																						//�ٶ���� ���� ���
		System.out.printf("%13s %13s %13s %12s\n", "��  ǰ  ��", "��  ��", "��  ��", "��  ��");																	//�׸��� ���
		System.out.printf("-------------------------------------------------------------\n");																						//�ٶ���� ���� ���		
		for (int i = 0; i < K15_itemname.length; i++) {																																//0���� ���ڹ迭�� ���̱��� �ݺ�
			if (K15_itemname[i].length() > 3) {																																			//���� �ϳ��ϳ��� ���̰� 3�� ���� ���
					if (K15_taxfree[i] == true) {																																				//�� �鼼�ϰ��
						System.out.printf("*%9s %13s %13s  %15s\n",																												//�� �迭�� �ش� ǰ��տ� *�� ���̰�
								K15_itemname[i],df.format(K15_price[i]), K15_num[i],df.format(K15_price[i] * K15_num[i]));						//�ܰ��� ����, �ݾ��� õ���� �޸���� ���
					} else {																																													//�鼼�� �ƴҰ��
						System.out.printf("%11s %13s %13s  %15s\n",																												//�� �迭�� �ش�ǰ��� 
								K15_itemname[i],df.format(K15_price[i]), K15_num[i],df.format(K15_price[i] * K15_num[i]));						//�ܰ��� ����, �ݾ��� õ���� �޸���� ���
					} 	
			} else {																																															//���� �ϳ��ϳ��� ���̰� 3�� ���� ���� ���
					if (K15_taxfree[i] == true) {																																				//�� �鼼�� ���
						System.out.printf("*%9s %15s %13s %16s\n",																												//�� �迭�� �ش� ǰ��տ� *�� ���̰�
								K15_itemname[i],df.format(K15_price[i]), K15_num[i],df.format(K15_price[i] * K15_num[i]));						//�ܰ��� ����, �ݾ��� õ���� �޸���� ���
					} else {																																													//�鼼�� �ƴҰ��
						System.out.printf("%11s %15s %13s  %15s\n",																												//�� �迭�� �ش�ǰ��� 
								K15_itemname[i],df.format(K15_price[i]), K15_num[i],df.format(K15_price[i] * K15_num[i]));						//�ܰ��� ����, �ݾ��� õ���� �޸���� ���
					}
			}
			if ((i + 1) % 5 ==0) {																														//5�ٸ��� ���� ����ϱ� ���� 0���� �����ϴ� i�� 5�� ����
				System.out.println("-------------------------------------------------------------");									//0���� ����������� ���� ���
			}
		}
		
		System.out.println();																														//�ٶ���� ���� ���
		System.out.printf("%33s %27s\n", "�� ǰ�� ����", df.format(K15_total_num));							//�� ������ õ������ �޸���� ���				
		System.out.printf(" %33s %24s\n", "(*)�� ��  ��  ǰ", df.format(K15_sum_notax));						//�鼼��ǰ�� õ������ �޸���� ���
		System.out.printf(" %34s %24s\n", "�� ��  ��  ǰ", df.format(K15_total_tax));								//������ǰ�� õ������ �޸���� ���
		System.out.printf("%37s %25s\n", "��    ��    ��", df.format(K15_tax_sum));								//�� �ΰ����� õ������ �޸���� ���
		System.out.printf(" %40s %22s\n", "��           ��  ", df.format(K15_pay_money));						//���ұݾ��� õ������ �޸���� ���
		System.out.printf("%s%40s\n", "��  ��  ��  ��  ��  ��", df.format(K15_pay_money));					//���ұݾ��� õ������ �޸���� ���
		System.out.println("-------------------------------------------------------------");											//�ٶ���� ���� ���
		System.out.printf("%s %30s\n", "0012 KEB �ϳ�", "54170**0484/35860658");							//ī��� ī���ȣ�� ���
		System.out.printf("%s %42s\n", "ī�����(IC)", "�Ͻú� / " + df.format(K15_pay_money));			//ī������� ����Ÿ���� ���
		System.out.println("-------------------------------------------------------------");											//�ٶ���� ���� ���
		System.out.printf("%35s\n", "[�ż�������Ʈ ����]");																		//�ż�������Ʈ ���
		System.out.printf("%s\n", "��*�� ������ ����Ʈ ��Ȳ�Դϴ�.");														//����Ʈ ��Ȳ�� ���
		System.out.printf("%s %25s%12s\n", "��ȸ�߻�����Ʈ", "9350**9995", "164");							//��ȸ�߻�����Ʈ ���
		System.out.printf("%s%28s( %10s)\n", "����(����)����Ʈ", df.format(5637),df.format(5473));		//���谡������Ʈ�� õ������ �޸���� ���
		System.out.printf("%20s\n", "*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.");												//����Ʈ �ȳ����� ���
		System.out.println("-------------------------------------------------------------");											//�ٶ������ ���
		System.out.printf("%33s\n", "���űݾױ��� ���������ð� �ڵ��ο�");													//�����ȳ����� ���
		System.out.printf("%s :  %49s\n", "������ȣ", "34��****");															//������ȣ ���
		System.out.printf("%s :  %43s\n", "�����ð�", sd.format(d));														//�����ð� ���
		System.out.println("-------------------------------------------------------------");											//�ٶ������ ���
		System.out.printf("%s  %39s\n", "ĳ��:084599  ��00", "1150");													//ĳ������ ���
		System.out.printf("%41s\n","||||||||||||||||||||||||||||||||||||");									//���ڵ� ���
		System.out.printf("%39s\n", "20210303/00119861/00164980/31");											//���ڵ� ��ȣ ���		
		}
	}
		
		
	


	

