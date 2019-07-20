package practise;
/**
 * 使用jstat和jmap分析（可以用Debugger-》memory查找替代）：
 将程序改为不停循环的可供调试的程序

 jps:与unix上的ps类似，用来显示本地的java进程，可以查看本地运行着几个java程序，并显示他们的进程号。
 jstat -gccause 158532 1000
 jmap -histo:live 155896 > e:\temp\jmap.txt
* */
import java.util.ArrayList;
import java.util.HashMap;

public class Runner {
    private HashMap<Integer, Resource> resources = new HashMap<Integer, Resource>();

    public Iterable<Resource> getResources() {
        return this.resources.values();
    }

    public Resource acquireResource(int id) {
        Resource w = this.resources.getOrDefault(id, null);
        if (w == null) {
            w = new Resource(id);
            this.resources.put(id, w);
        }

        return w;
    }

    public void releaseResource(int id) {
        Resource w = this.resources.getOrDefault(id, null);
        if (w == null)
            throw new IllegalArgumentException();

        w.dispose();
        //增加1：删除对象本身，但引用没有删除
        this.resources.remove(id);
    }

    public class Resource {
        private ArrayList<String> tasks = new ArrayList<String>();

        private int id;

        public int getId() {
            return this.id;
        }

        public Iterable<String> getTasks() {
            return this.tasks;
        }

        public Resource(int id) {
            this.id = id;
        }

        public void performTask(String task) {
            if (this.tasks == null)
                throw new IllegalStateException(this.getClass().getName());

            this.tasks.add(task);
        }

        public void dispose() {
//         增加2：如果去掉这句，没什么问题，可以不要
            this.tasks.removeAll(this.tasks);
            this.tasks = null;
        }
    }

    public static void main(String[] args) throws Exception{
        Runner d = new Runner();
        int temp1 = 1;
        int temp2 = 2;
        while(true) {

            d.acquireResource(temp1).performTask("Task11");
            d.acquireResource(temp2).performTask("Task21");
            System.out.println(String.join(", ", d.acquireResource(temp2).getTasks()));
//            d.releaseResource(temp1);
            d.releaseResource(temp2);
            d.acquireResource(temp1).performTask("Task12");
            System.out.println(String.join(", ", d.acquireResource(temp1).getTasks()));
            d.releaseResource(temp1);
            Thread.sleep(100);
            temp1 += 2;
            temp2 += 2;
        }
    }
}