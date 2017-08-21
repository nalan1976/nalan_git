/*������һ�����׻��������ӣ���֤һ����ʵ����
 * 1�����಻�ܲ�׽������쳣
 * �����Ͽ��Ǹ���Annoyance��ʵ����������Sneeze�����ײ������󣡣���
 * 2�����⣬��������ʾ��instanceof��getClass�ľ����÷�
 */

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

class ExceptionTest3 {

    public static void main(String[] args) 
        throws Exception {
        try {
            try {
                throw new Sneeze();
            } 
            catch ( Annoyance a ) {//�����Ͽ��Ǹ���Annoyance��ʵ����������Sneeze�����ײ������󣡣���
                System.out.println("Caught Annoyance");
                Annoyance b = new Annoyance();
                System.out.println("" + (a instanceof Sneeze));//true
                System.out.println("" + (b instanceof Sneeze));//false
                System.out.println(a.getClass().getName());//Sneeze
                System.out.println(b.getClass().getName());//Annoyance
                throw a;
            }
            finally {
                System.out.println("Caught Annoyance finally");
            }
        } 
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}