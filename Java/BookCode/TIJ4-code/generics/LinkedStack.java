//: generics/LinkedStack.java
// A stack implemented with an internal linked structure.

public class LinkedStack<T> {
  private static class Node<U> {
    U item;//是存储的实际对象，这里的item就是T？
    Node<U> next;//是指向下一个节点的对象
    Node() { item = null; next = null; }
    Node(U item, Node<U> next) {/*item和Node明显不是一种类型，怎么都能用U来表示呢？*/
      this.item = item;
      this.next = next;
    }
    boolean end() { return item == null && next == null; }
  }
  private Node<T> top = new Node<T>(); // End sentinel
  /*每次push时：
  * 1）新建一个节点；
  * 2）将当前压入的对象赋给新节点的item；
  * 3）将当前top赋给新节点的next。此举是为了pop做准备，也就是说next总是
  * 指向当前栈顶的下面一个节点；此时top也完成的它的使命；
  * 4）将top指向新建的节点。
  * */
  public void push(T item) {
    top = new Node<T>(item, top);/*这里学问大了，本来Node类声明的时候
    参数类型是U，但使用的时候声明Node<T>，就是说可以用T作为类型U？
    */
  }
  /*每次pop时：
  1）将当前top的item准备好
 */
  public T pop() {
    T result = top.item;
    if(!top.end())
      top = top.next;
    return result;
  }
  public static void main(String[] args) {
    LinkedStack<String> lss = new LinkedStack<String>();
    for(String s : "Phasers on stun!".split(" "))
      lss.push(s);
    String s;
    while((s = lss.pop()) != null)
      System.out.println(s);
  }
} /* Output:
stun!
on
Phasers
*///:~
