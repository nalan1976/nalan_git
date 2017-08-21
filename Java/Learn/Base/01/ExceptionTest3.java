/*本例用一个极易混淆的例子，反证一个事实即：
 * 1）子类不能捕捉父类的异常
 * 表面上看是父类Annoyance，实际上是子类Sneeze，极易产生困惑！！！
 * 2）另外，本例还演示了instanceof和getClass的经典用法
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
            catch ( Annoyance a ) {//表面上看是父类Annoyance，实际上是子类Sneeze，极易产生困惑！！！
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