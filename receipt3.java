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
      SimpleDateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");  //��¥�� ������ �����ϴ� ��ü ����
      Date d = new Date();      
         //����ð��� �ޱ� ���� ��ü�� ����
      DecimalFormat df = new DecimalFormat ("###,###,###,###,### ");                                                                                 //������ ����(õ���� �޸�)�ϴ� ��ü ����
   
      String [] K15_itemname = {"����ũ ������ ������κ�","����Ʈ�Ƹ�������","��ɻ���� 180g","��ݴ��ٻ��ѱ�20��","�ѼŻѼŻѼŻѼŻѼŻѼ�","�����ڿ����ڿ����ڿ����ڿ�����","��������������Ĩ��������������Ĩ","�ٳ���ű�ٳ���ű�ٳ���ű�ٳ���ű","����������������","��Ϲ���Ĩ��Ϲ���Ĩ",            //���ڿ� Ÿ���� �迭�� ����30���� ����
                                       "�Ե��㽬������ũ165G","aaaa�����̾���a","���ִ� ����Ĩ","Ȩ����","��Ĩ��Ĩ��Ĩ��Ĩ","��ɽŶ��(50��)","��ũ�ٽ�","�Ѹ�����","������ ���̰���κ�","�����λ����λ�����",         
                                       "�񸶴�(500g/��)","��ǥ�а��� 1kg","����������Ĩ","����丶��500g/��","����ũ�����۹�(��)","�ֹ������","�簢���μ�Ź��","�̱�ġ�ڴܹ��� 200g","������������������","�̺������̺������̺�����"};
      
      int [] K15_price = {1000000, 1000000, 1000000, 1000000, 1000000, 4000, 4500, 1000, 1500, 2000,                                                       //���� �迭�� �� �����ǰ���(�ܰ�)�� ����
                        2500, 3000, 3500, 4000, 1000, 130000, 18000, 2300, 2800, 1900,                                                            
                        3300, 1000, 1300, 2300, 2500, 3000, 2700, 1400, 1500, 1000}; 
      int [] K15_num =  {10, 10, 10, 10, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1,  1, 2, 1, 1, 1, 1, 1};                                      //�� ������ ������ �迭�� ����
      boolean [] K15_taxfree = {true, false, false, false, false, true, false, false, true, false,                                                //���������� ���� �迭�� �־� true�̸� �鼼
            true, false, false, false, true, false, false, false, true, false,
            false, true, false, false, false, false, false, false, true, false}; 
     
         
      int K15_taxprice = 0;       //�������հ�
      int K15_freeprice = 0;      //�鼼 ���հ�
      int K15_totalprice = 0;      //��ü �հ�
      int K15_netprice = 0;         //���� ���ް�
      int K15_tax = 0;            //�ΰ���
                                                              //������ �ΰ����� ���� �� �ΰ���      
         
      
//      K15_total_tax =  (K15_total_price2 / K15_taxrate) * K15_rate;                        //�� ���� �հ�
                                               //�� ���ұݾ� = �鼼�ݾ� + �ΰ��� + ������ǰ            
      System.out.printf("%35s\n", "�̸�Ʈ ������ (031)838-1234");                                                                              //�̸�Ʈ �������� ���
      System.out.printf("%9s %20s\n","emart",  "206-86-50913 ����");                                                                     //emart�� ��ȣ�� ���
      System.out.printf("%29s\n", "���� ������ ������� 552");                                                                                    //��ġ ���
      System.out.printf("%s\n", "������ �������� ��ȯ/ȯ�� �Ұ�");                                                                                 //��ȯ ȯ�� �ȳ� ���
      System.out.printf("%s\n", "�����ǰ�� ����, 30�� �̳�(�ż� 7��)");                                                                           //��ȯ ȯ�� �ȳ� ���
      System.out.printf("%s\n", "���Ϻ� �귣����� ����(���� ����������)");                                                                        //��ȯ ȯ�� �ȳ� ���
      System.out.printf("%s\n", "��ȯ/ȯ�� ���������� ����(����ī�� ����)");                                                                     //��ȯ ȯ�� �ȳ� ���
      System.out.println();                                                                                                                              //�ٶ���� ���� ���
      System.out.printf("%s%s  %16s\n", "[�� ��]", sd.format(d), "POS:0011-9861");             //���� ��¥�� �ð��� ���
      System.out.printf("-----------------------------------------\n");                                                               //�ٶ���� ���� ���
      System.out.printf(" %6s%12s%5s%8s\n", "�� ǰ ��", "��  ��", "����", "��  ��");                                                   //�׸��� ���
      System.out.printf("-----------------------------------------\n");      //�ٶ���� ���� ���      
      
      
      for (int i = 0; i < K15_itemname.length; i++) {   // ��ǰ ��� ��ü ���
         if (K15_taxfree[i] == true) {     // �鼼��ǰ�� ���
            System.out.printf("*");   // �鼼ǥ�� ���
            K15_freeprice += K15_price[i] * K15_num[i] ;   // �鼼���� �ջ�
         } else {               // ������ǰ�� ���
            System.out.printf(" ");   // ���� ���
            K15_taxprice += K15_price[i] * K15_num[i] ;   // �������� �ջ�
         }
         System.out.printf(" %s%11.10s%2d%13.11s\n", K15_Bytes(K15_itemname[i], 14),   // ��ǰ��(�ִ� ������� �ѱ�9��)
               df.format(K15_price[i]), K15_num[i],    // ��ǰ ����, ��ǰ ����
               df.format(K15_price[i] * K15_num[i]));   // ��ǰ �հ� ����
         if ((i + 1) % 5 == 0) {   // ��ǰ 5������ ���м� ���
            System.out.printf("-----------------------------------------\n");
         }
      }
      int K15_pay_money = K15_freeprice + K15_taxprice;    //�� ���� �ݾ�
      K15_netprice = K15_getNetPrice(K15_taxprice);         //������ �޼ҵ忡 �־� ���ް����
      K15_tax = K15_taxprice - K15_netprice;            //�ΰ���
      
      System.out.println();                                                            //�ٶ���� ���� ���
      System.out.printf("%22s %13s\n", "�� ǰ�� ����", K15_itemname.length);                     //�� ������ õ������ �޸���� ���            
      System.out.printf("%23s %14.11s\n", "(*)�� ��  �� ǰ", df.format(K15_freeprice));                  //�鼼��ǰ�� õ������ �޸���� ���
      System.out.printf("%23s %14.11s\n", "�� ��  �� ǰ", df.format(K15_netprice));                        //������ǰ�� õ������ �޸���� ���
      System.out.printf("%24s %14.11s\n", "��   ��   ��", df.format(K15_tax));                        //�� �ΰ����� õ������ �޸���� ���
      System.out.printf("   %24s %12.11s\n", "��        ��  ", df.format(K15_pay_money));                  //���ұݾ��� õ������ �޸���� ���
      System.out.printf("%s %24.11s\n", "�� �� �� �� �� ��", df.format(K15_pay_money));              //���ұݾ��� õ������ �޸���� ���
      System.out.println("-----------------------------------------");                                 //�ٶ���� ���� ���
      System.out.printf("%s %27s\n", "0012 KEB �ϳ�", "54170**0484/35860658");                     //ī��� ī���ȣ�� ���
      System.out.printf("%s %26s\n", "ī�����(IC)", "�Ͻú� / " + df.format(K15_pay_money));         //ī������� ����Ÿ���� ���
      System.out.println("-----------------------------------------");                                 //�ٶ���� ���� ���
      System.out.printf("%23s\n", "[�ż�������Ʈ ����]");                                                      //�ż�������Ʈ ���
      System.out.printf("%s\n", "ȫ*�� ������ ����Ʈ ��Ȳ�Դϴ�.");                                          //����Ʈ ��Ȳ�� ���
      System.out.printf("%s%16s%11s\n", "��ȸ�߻�����Ʈ", "9350**9995", "164");                     //��ȸ�߻�����Ʈ ���
      System.out.println("����(����)����Ʈ         5,637(    5,473)");
      System.out.printf("%20s\n", "*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.");                                    //����Ʈ �ȳ����� ���
      System.out.println("-----------------------------------------");                                    //�ٶ������ ���
      System.out.printf("%22s\n", "���űݾױ��� ���������ð� �ڵ��ο�");                                       //�����ȳ����� ���
      System.out.printf("%s :  %28s\n", "������ȣ", "34��****");                                             //������ȣ ���
      System.out.printf("%s :  %29s\n", "�����ð�", sd2.format(d));                                          //�����ð� ���
      System.out.println("-----------------------------------------");                                 //�ٶ������ ���
      System.out.printf("%s  %22s\n", "ĳ��:084599  ��00", "1150");                                       //ĳ������ ���
      System.out.printf("%39s\n","||||||||||||||||||||||||||||||||||||");                           //���ڵ� ���
      System.out.printf("%15s/%s/%s/%s\n", sd1.format(d) ,"00119861", "00164980", "31");                                 //���ڵ� ��ȣ ���      
}
   
         public static int K15_getNetPrice(int K15_iPrice) {             // ���ް��� �޼ҵ�
            double K15_taxRate = 10.0 / 11.0;                         // �ΰ����� 10%, �ε��Ҽ��� ���� ���� -> �Һ��ڰ��� * 10.0 / 11.0 
            double K15_netPrice = K15_iPrice * K15_taxRate;                 // ���ް��� = �� ���� / (1 + �ΰ�����)
            return (int) K15_netPrice;                                 // ������ ���ް��� ����
         }

   
         public static String K15_Bytes(String K15_inputString, int K15_stringWidth) throws UnsupportedEncodingException {
            for (int i = 0; i < K15_stringWidth; i++) {   //�� ���ڿ� ���� ����
               K15_inputString += " ";   // ���� ���ڿ��� ���� �ʺ�ŭ ���� ����
            }
            int K15_widhtByte = 0;   // ����Ʈ ���� ���γʺ�
            int K15_Index = 0;   // �߶� �ε���
            char K15_temp = ' ';   // ���ڿ� �� �� ����
            for (int i = 0; i < K15_inputString.length(); i++) {   // ���ڿ� ��ü
               K15_temp = K15_inputString.charAt(i);   // �� ���ڸ� char�� �޾ƿ�
               if (Character.getType(K15_temp) == 5) {   // character type�� 5�� ��� �ѱ�
                  K15_widhtByte += 2;   // �ѱ� ���� �ʺ� 2 �߰�
               } else {   // �ѱ� �ƴ� ���
                  K15_widhtByte += 1;   // �ѱ� �� ���� �ʺ� 1 �߰�
               }
               K15_Index++;   // �߶� �ε��� 1 �߰�
               if (K15_widhtByte > K15_stringWidth) {   // ������ �ִ� �ʺ񺸴� Ŭ ��� 
                  K15_Index --;   // �ѱ��� �տ��� �ڸ� ��
                  break;   // �۾� ����
               }
            }
            String K15_lastname = K15_inputString.substring(0, K15_Index);   // ������ �ε��� �ձ��� �ڸ���

       // ���� �ʺ� üũ
            int K15_newWidth = K15_lastname.getBytes("EUC-KR").length;   // �ѱ� 2����Ʈ�� ������ �ʺ� = ����Ʈ ����
            if (K15_newWidth < K15_stringWidth) {   // ������ �ִ� �ʺ񺸴� ���� ���
               for (int i = 0; i < K15_stringWidth - K15_newWidth; i++) {   // ���� �ڸ� ��ŭ
                  K15_lastname += " ";   // ���� �߰�
               }
            }
            return K15_lastname; // ���ο� ��ǰ�̸� ��ȯ
         }
}