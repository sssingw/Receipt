package receipt;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class receipt1 {

   public static void main(String[] args) {      
      
      int K15_iprice = 100;                                                                    // �� ���ұݾ� ���� ����
      int rate = 10;                                                                           //������ �����ϴ� ����
      int K15_taxrate = rate + (rate * 10) / 100;                                              // ������ �����ϴ� ����
      int K15_tax = K15_iprice - ((10 * K15_iprice) / K15_taxrate) ;                           //�ΰ����� �����ϴ� ����
      int K15_origin = (int)K15_iprice - K15_tax;                                              // �Ǹűݾ��� �����ϴ� ����   

      Date d = new Date();                                                                     //����ð��� �ޱ� ���� ��ü�� ����
      SimpleDateFormat sd = new SimpleDateFormat ("yyyy/MM/dd kk:mm:ss");                      //��¥�� ������ �����ϴ� ��ü ����
      DecimalFormat df = new DecimalFormat("###,###");                                         //������ ����(õ���� �޸�)�ϴ� ��ü ����
      //Printf�� �̿��� ������ ���İ� ĭ����� �����Ѵ�.
      System.out.println("�ſ����");                                                          //�ſ���� ���
      System.out.printf("%s : %10s  %7s : %s\n", "�ܸ���", "2N68665898","��ǥ��ȣ", "041218"); //�ܸ���� ��ǥ��ȣ�� ���� ���
      System.out.printf("%s : %s\n", "������", "�Ѿ��ġ�");                                //�������� ���
      System.out.printf("%s : %18s\n", "��  ��", "��� ������ �д籸 Ȳ�����351");            //�ּҿ� �ش� �ּҸ� ���
      System.out.printf("���� 10 .1��\n");                                                     //�ּҿ� �ش� �ּҸ� ���
      System.out.printf("%s : %2s\n", "��ǥ��", "��â��");                                     //��ǥ�ڸ� ���
      System.out.printf("%s : %5s   %7s : %7s\n", "�����", "752-53-00558", "TEL", "7055695"); //����ڿ� ��ȭ��ȣ�� ���
      System.out.println("-----------------------------------------");                         //�ٶ���� ���� ��� 
      System.out.printf("%s%3s%32.10s ��\n","��", "��", df.format(K15_origin));                //�Ǹűݾ��� õ������ �޸��� ��� ���
      System.out.printf("%s%32.10s ��\n","�ΰ���", df.format(K15_tax));                        //�ΰ����� õ������ �޸��� ��� ���
      System.out.printf("%s%3s%32.10s ��\n","��", "��", df.format(K15_iprice));                //�հ踦 õ������ �޸��� ��� ���
      System.out.println("-----------------------------------------");                         //�ٶ���� ���� ��� 
      System.out.println("�츮ī��");                                                          //�츮ī�� ���
      System.out.printf("%s : %10s  %3s\n", "ī���ȣ", "5387-20**-****-4613(S)","�Ͻú�");    //ī���ȣ�� ����Ÿ���� ���
      System.out.printf("%s : %10s\n", "�ŷ��Ͻ�", sd.format(d));                              //���糯¥�� �ð��� ���
      System.out.printf("%s : %7s\n", "���ι�ȣ", "70404427");                                 //���ι�ȣ�� ���
      System.out.printf("%s : %10s\n", "�ŷ���ȣ", "357734873739");                            //�ŷ���ȣ�� ���
      System.out.printf("%s : %5s  %8s : %s\n", "����", "��ī���","����","720068568");      //���԰� ������ ���
      System.out.printf("%s : %5s\n", "�˸�", "EDC����ǥ");                                    //�˸��� ���   
      System.out.printf("%s : %5s\n", "����", "TEL)1544-4700");                                //���ǿ� ��ȣ�� ���
      System.out.println("-----------------------------------------");                         //�ٶ���� ���� ��� 
      System.out.printf("%19s", "* �����մϴ� *\n");                                           //�����մϴ� ���
      System.out.printf("%40s", "ǥ��V2. 08_20200212\n");                                      //ǥ�ع����� ���
   }

}