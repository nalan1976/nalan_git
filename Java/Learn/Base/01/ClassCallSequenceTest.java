/*
����Ԫ�����˼̳���ĳ�ʼ��˳��
����������
1������AΪ���࣬BΪ����
2��2���о��о�̬�����Ǿ�̬���͹��캯��

�����´�����Խ���Ϊ��
��new�������ʱ��
1����ʼ��˳��Ϊ�����ྲ̬��->���ྲ̬��->����Ǿ�̬��->���๹�캯��->����Ǿ�̬��->���๹�캯��
2�����о�̬��ֻ��ʼ��1�Σ���������ÿ�δ���ʱ���ᰴ������˳�򱻳�ʼ��

 */
public class ClassCallSequenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A ab = new B();
        ab = new B();
	}

}
class A {

    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
        System.out.print(i);
    }
   private  final int i = 4;
}

class B extends A{

    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
        System.out.print(j);
    }
    private  final int j = 5;
}