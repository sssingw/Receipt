package receipt;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class receipt2 {

   
   public static void main(String[] args) throws UnsupportedEncodingException {                              
      SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd kk:mm:ss");               //��¥�� ������ �����ϴ� ��ü ����
      DecimalFormat df = new DecimalFormat("###,###,###");                             //������ ����(õ���� �޸�)�ϴ� ��ü ����
      Date d = new Date();                                                             //����ð��� �ޱ� ���� ��ü�� ����
      String K15_itemname[] = {"ǻ��� �����ܿ븶��ũ", "�����̵�ĸ���(������)", "�������� ���׸�����ũ(�˷�̴�)"};   //�׸� �迭                                                               //ù��° ��ǰ ���庯��                                                             
      int K15_price[] = {1000000, 100, 100}; 																				//���� �迭
      int K15_num[] = {1, 1, 1};																							//���� �迭
      String K15_itemcode[] = {"11008152","1020800","1020888"};   															//�ڵ� �迭                                                                          //ù��° ��ǰ ����
      
      int K15_taxprice = 0;       					//�������հ�
      int K15_freeprice = 0;     					//�鼼 ���հ�
      int K15_totalprice = 0;    				    //��ü �հ�
      int K15_netprice = 0;       					//���� ���ް�
      int K15_tax = 0;            					//�ΰ���
      
           
      //printf�� �̿��� ��� Ÿ�԰� ĭ����� ����
      System.out.println(             "            \"���ΰ���, ���̼�\""   );          //���ΰ��� ���̼� ���
      System.out.printf("%s\n", "(��)�Ƽ����̼�_�д缭����");                          //�Ƽ����̼� ���
      System.out.println("��ȭ:031-702-6016");                                         //��ȭ�� ��ȣ�� ���"
      System.out.println("����:���� ������ ���μ�ȯ�� 2748 (���)");                 //����� ��ġ�� ���
      System.out.println("��ǥ:������,��ȣ�� 213-81-52063");                           //��ǥ�� ��ȣ�� ���
      System.out.println("����:��⵵ ������ �д籸 �д��53���� 1"); 				   //���� ��ġ ���
      System.out.println("1 (������)"); 											   //���� ��ġ ���
      System.out.println("=========================================");                 //�ٶ������ ���
      System.out.printf("%23s\n", "�Һ����߽ɰ濵(CCM) �������");                     //�Һ����߽ɰ濵 ���
      System.out.printf("%12s %3s %3s\n", "ISO 9001", "ǰ���濵�ý���", "�������");   //ǰ���濵���
      System.out.println("=========================================");                 //�ٶ������ ���
      System.out.printf("%26s\n", "��ȯ/ȯ�� 14��(05��07��)�̳�,");                    //��ȯ�ȳ� ���
      System.out.println("(����)������, ����ī�� ���� �� ���Ը���");				   //��ȯ�ȳ� ���
      System.out.println("���� ����");                                    			   //��ȯ �ȳ� ���
      System.out.printf("%25s\n", "����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�");               //��ȯ�Ұ� �ȳ� ���
      System.out.printf("%23s\n", "üũī�� ��� �� �ִ� 7�� �ҿ�");                   //üũī�� �ȳ����� ���
      System.out.println("=========================================");                 //�ٶ������ ���
      System.out.printf("%s %27s\n", "[POS 1058231]", sd.format(d));                   //pos��ȣ�� ���� ��¥ �ð� ���
      System.out.println("=========================================");       
      
           
      for (int i = 0; i < K15_itemname.length; i++) {   								// ��ǰ ��� ��ü ���
         K15_taxprice += K15_price[i] * K15_num[i] ;   									// �������� �ջ�
         System.out.printf("%s%9.9s%3d%11.10s\n", K15_Bytes(K15_itemname[i], 18),   	// ��ǰ��(�ִ� ������� �ѱ�9��)
               df.format(K15_price[i]), K15_num[i],   									// ��ǰ ����, ��ǰ ����
               df.format(K15_price[i] * K15_num[i]));   								// ��ǰ �հ� ����
         System.out.println("["+K15_itemcode[i]+"]");									//���� �������� �ڵ� ���
      }                 		
      
     
      K15_netprice = K15_getNetPrice(K15_taxprice);         							//������ �޼ҵ忡 �־� ���ް����
      K15_tax = K15_taxprice - K15_netprice;            								//�ΰ���
         
      System.out.printf("%22s %14.10s\n", "�����հ�", df.format(K15_netprice));         //�����հ�� ���� õ���� �޸�������
      System.out.printf("%23s %14.9s\n", "�ΰ���", df.format(K15_tax));                 //�ΰ����� ���� õ���� �޸���� ���
      System.out.printf("-----------------------------------------\n");                 //�ٶ�� ���� ���
      System.out.printf("%s%33s\n", "�Ǹ��հ�", df.format(K15_netprice + K15_tax));     //�Ǹ��հ�� �Ѱ����� �Ѻΰ����� �հ�
      System.out.println("=========================================");                  //�ٶ�� ���� ���
      System.out.printf("%s%33s\n", "�ſ�ī��", df.format(K15_netprice + K15_tax));     //��������� ������ ���
      System.out.printf("-----------------------------------------\n");                 //�ٶ�� ���� ���
      System.out.printf("%s %22d**********\n", "�츮ī��",538720);                      //ī��� ī���ȣ ���
      System.out.printf("%s %d (%d)%5s %10.10s\n", "���ι�ȣ", 77982843,0,"���αݾ�"	 //���ι�ȣ�� ������ ���
    		  			, df.format(K15_netprice + K15_tax));        
      System.out.println("=========================================");                   //�ٶ������ ���
      System.out.printf("%25s %s\n", sd.format(d), "�д缭����");                        //���糯¥�� �ð� ���
      System.out.printf("%s : %s\n", "��ǰ �� ��Ÿ ����", "1522-4400");                  //��ǰ���ǿ� ��ȣ ���
      System.out.printf("%s : %s\n", "����� �� �����̼� ���� ����", "1599-2211");       //���ǿ� ��ȣ ���
      System.out.printf("%32s\n","|||||||||||||||||||||||||");                           //���ڵ� ���
      System.out.printf("%28s\n", "2112820610158231");                                   //���ڵ� ��ȣ ���
      System.out.printf("-----------------------------------------\n");                  //�ٶ�� ���� ���
      System.out.println("�� ���̼� ����� �� �Ǵ� Ȩ�������� ����");                    //������ �ȳ����� ���
      System.out.println("   �ϼż� ȸ������ �� �پ��� ������ ����");                    //������ �ȳ����� ���
      System.out.println("   ������! ��"); 
   }
     
      public static int K15_getNetPrice(int K15_iPrice) {            					 //���ް��� �޼ҵ�
         double K15_taxRate = 10.0 / 11.0;                         						 //�ΰ����� = 10%, �Һ��ڰ��� = * 10.0 / 11.0 
         double K15_netPrice = K15_iPrice * K15_taxRate;                 				 //���ް��� = �� ���� / (1 + �ΰ�����)
         return (int) K15_netPrice;                                 					 //������ ���ް��� ����
      }
    
      public static String K15_Bytes(String K15_inputString, int K15_stringWidth) throws UnsupportedEncodingException {
          for (int i = 0; i < K15_stringWidth; i++) {   								 //�� ���ڿ� ���� ����
             K15_inputString += " ";  													 //���� ���ڿ��� ���� �ʺ�ŭ ���� ����
          }
          int K15_widhtByte = 0;  														 //����Ʈ ���� ���γʺ�
          int K15_Index = 0;   															 //�߶� �ε���
          char K15_temp = ' ';   														 //���ڿ� �� �� ����
          for (int i = 0; i < K15_inputString.length(); i++) {                           //���ڿ� ��ü
             K15_temp = K15_inputString.charAt(i);                                       //�� ���ڸ� char�� �޾ƿ�
             if (Character.getType(K15_temp) == 5) {                                     //character type�� 5�� ��� �ѱ�
                K15_widhtByte += 2;                                                      //�ѱ� ���� �ʺ� 2 �߰�
             } else {                                                                    //�ѱ� �ƴ� ���
                K15_widhtByte += 1;                                                      //�ѱ� �� ���� �ʺ� 1 �߰�
             }
             K15_Index++;                                                    			 //�߶� �ε��� 1 �߰�
             if (K15_widhtByte > K15_stringWidth) {                                      //������ �ִ� �ʺ񺸴� Ŭ ��� 
                K15_Index --;                                                            //�ѱ��� �տ��� �ڸ� ��
                break;                                                                   //�۾� ����
             }
          }
          String K15_lastname = K15_inputString.substring(0, K15_Index);                 //������ �ε��� �ձ��� �ڸ���

          //���� �ʺ� üũ
          int K15_newWidth = K15_lastname.getBytes("EUC-KR").length;                     //�ѱ� 2����Ʈ�� ������ �ʺ� = ����Ʈ ����
          if (K15_newWidth < K15_stringWidth) {                                          //������ �ִ� �ʺ񺸴� ���� ���
             for (int i = 0; i < K15_stringWidth - K15_newWidth; i++) {                  //���� �ڸ� ��ŭ
                K15_lastname += " ";                                                     //���� �߰�
             }
          }
          return K15_lastname;                                                           //���ο� ��ǰ�̸� ��ȯ
       }
}

